package com.leeseojune.awss3.service;

import com.amazonaws.auth.AWS4Signer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

public class ImageServiceImpl extends AWS4Signer implements ImageService {
    @Override
    public String upload(MultipartFile file) throws IOException {
        return null;
    }

    @Override
    public String generateObjectUrl(String objectName) throws MalformedURLException {
        return null;
    }

    @Override
    public byte[] getObject(String fileName) throws IOException {
        return new byte[0];
    }

    @Override
    public void delete(String objectName) {

    }
}
