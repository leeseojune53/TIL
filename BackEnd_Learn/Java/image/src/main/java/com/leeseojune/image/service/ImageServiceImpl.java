package com.leeseojune.image.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService{

    private static String PATH = "C:/Users/sung0/Downloads/";

    @Override
    public void upload(MultipartFile file) throws IOException {
        file.transferTo(new File(PATH + file.getOriginalFilename()));
    }

    @Override
    public byte[] getImage(String path) throws IOException {

        File file = new File(PATH + path);

        BufferedImage inputImage = ImageIO.read(file);

        BufferedImage outputImage =
                new BufferedImage(300, 400, inputImage.getType());

        Graphics2D graphics2D = outputImage.createGraphics();
        graphics2D.drawImage(inputImage, 0, 0, 300, 400, null);
        graphics2D.dispose();
        outputImage.getGraphics().drawImage(ImageIO.read(file), 0, 0,300, 400, 10, 60, 500, 500, null);
    
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(outputImage, "png", baos);

        return baos.toByteArray();
    }
}
