package com.leeseojune.file_server.controller;

import com.leeseojune.file_server.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/file")
    @ResponseStatus(HttpStatus.CREATED)
    public int fileUpload(@RequestParam("file") MultipartFile file) {
        return fileService.upload(file);
    }

    @GetMapping(value = "/file", produces = "image/jpeg")
    public Resource get(@RequestParam("id") int id) throws IOException {
        return fileService.download(id);
    }

}
