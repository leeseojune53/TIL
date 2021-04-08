package com.leeseojune.image.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    void upload(MultipartFile file) throws IOException;
    byte[] getImage(String path) throws IOException;
}
