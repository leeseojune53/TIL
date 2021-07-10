package com.leeseojune.image.controller;

import com.leeseojune.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("file")MultipartFile file) throws IOException {
        imageService.upload(file);
    }

    @PostMapping(
            value = "/image",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public byte[] getImage(@RequestParam("file") MultipartFile file) throws IOException {
        return imageService.getImage(file);
    }

}
