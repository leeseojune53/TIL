package com.leeseojune.awss3.service;

import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import static com.leeseojune.awss3.service.AWS4SignerBase.ISO8601BasicFormat;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl extends AWS4Signer implements ImageService {

    private static final String SCHEME = "AWS4";

    private static final String ALGORITHM = "HMAC-SHA256";

    private static final Integer EXPIRES = 900;

    private final SimpleDateFormat dateTimeFormat = new SimpleDateFormat(ISO8601BasicFormat);
    private final SimpleDateFormat dateStampFormat = new SimpleDateFormat("yyyyMMdd");

    private final AmazonS3 s3;

    @Value("${aws.s3.accessKey}")
    private String accessKey;

    @Value("${aws.s3.secretKey}")
    private String secretKey;

    @Value("${aws.s3.bucket}")
    private String bucket;

    @Value("${aws.region.static}")
    private String region;

    @Override
    public String upload(MultipartFile file) throws IOException {
        String originFilename = file.getOriginalFilename();
        String ext = originFilename.substring(originFilename.lastIndexOf(".")+1);
        String randomName = UUID.randomUUID().toString();
        String fileName = randomName + "." + ext;

        s3.putObject(new PutObjectRequest(bucket, "images/" + fileName, file.getInputStream(), null)
                .withCannedAcl(CannedAccessControlList.AuthenticatedRead));

        return fileName;

    }

    @Override
    public String generateObjectUrl(String objectName) throws MalformedURLException {
        return null;
    }

    @Override
    public byte[] getObject(String fileName) throws IOException {
        S3Object object = s3.getObject(bucket, fileName);
        return IOUtils.toByteArray(object.getObjectContent());
    }

    @Override
    public void delete(String objectName) {
        s3.deleteObject(bucket, objectName);
    }
}
