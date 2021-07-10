package com.leeseojune.image.service;

import net.coobird.thumbnailator.Thumbnails;
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
    public byte[] getImage(MultipartFile file) throws IOException {

        BufferedImage in = ImageIO.read(file.getInputStream());

        BufferedImage outputImage = cropImage(in);

        BufferedImage newImage = new BufferedImage(
                in.getWidth(), in.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = newImage.createGraphics();
        g.drawImage(in, 0, 0, null);
        g.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(outputImage, "png", baos);

        return baos.toByteArray();
    }

    private BufferedImage cropImage(BufferedImage image) {
        return image.getSubimage(image.getWidth()/2, image.getHeight()/2, 300, 400);
    }
}
