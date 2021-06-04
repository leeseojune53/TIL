package com.leeseojune.file_server.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface FileService {
    int upload(MultipartFile file);
    Resource download(int id) throws IOException;
}
