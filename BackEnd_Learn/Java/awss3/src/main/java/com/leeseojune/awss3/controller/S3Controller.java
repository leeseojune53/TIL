package com.leeseojune.awss3.controller;

import com.leeseojune.awss3.dto.FileDTO;
import com.leeseojune.awss3.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

@RestController
@RequiredArgsConstructor
public class S3Controller {

    private final ImageService imageService;

    @PostMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file) throws IOException {
        imageService.upload(file);
    }

    @DeleteMapping("/remove")
    public void delete(@RequestBody FileDTO.FileName request){
        imageService.delete(request.getName());
    }

    @GetMapping("/object")
    public byte[] getObject(@RequestParam("filename") String fileName) throws IOException {
        return imageService.getObject(fileName);
    }

    @GetMapping("/url")
    public String getUrl(@RequestParam("filename") String fileName) throws MalformedURLException {
        return imageService.generateObjectUrl(fileName);
    }



}
