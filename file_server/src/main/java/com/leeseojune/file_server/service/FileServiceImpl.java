package com.leeseojune.file_server.service;

import com.leeseojune.file_server.entity.Information;
import com.leeseojune.file_server.entity.InformationRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService{

    private final InformationRepository informationRepository;

    private final String PATH = "C:/image/";

    @Override
    public int upload(MultipartFile file) {
        try{
            file.transferTo(new File(PATH + file.getOriginalFilename()));
            Information information = informationRepository.save(
                    Information.builder()
                    .path(PATH + file.getOriginalFilename())
                    .build()
            );
            return information.getId();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("upload Error.");
        }
        return -1;

    }

    @Override
    public Resource download(int id) throws IOException {
        Information information = informationRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        Resource resource = new UrlResource("file:" + information.getPath());
        return resource;
//        InputStream in = getClass().getResourceAsStream(information.getPath());
//        System.out.println(in.toString());
////        return IOUtils.toByteArray(in);
//        return new FileSystemResource(information.getPath());
    }
}
