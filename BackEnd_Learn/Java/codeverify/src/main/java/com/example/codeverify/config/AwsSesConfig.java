package com.example.codeverify.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesAsyncClient;

@Configuration
public class AwsSesConfig {
    @Value("${aws.ses.credentials.access-key}")
    private String accessKey;

    @Value("${aws.ses.credentials.secret-key}")
    private String secretKey;

//    @Bean
//    public AmazonSimpleEmailServiceAsync amazonSimpleEmailService() {
//        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKey, secretKey);
//
//        return AmazonSimpleEmailServiceAsyncClient.asyncBuilder()
//                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
//                .withRegion(Regions.AP_NORTHEAST_2)
//                .build();
//    }

    @Bean
    public SesAsyncClient sesAsyncClient(){
        AwsCredentials credentials = new AwsCredentials() {
            @Override
            public String accessKeyId() {
                return accessKey;
            }

            @Override
            public String secretAccessKey() {
                return secretKey;
            }
        };
        return SesAsyncClient.builder()
                .credentialsProvider(()-> credentials)
                .region(Region.AP_NORTHEAST_2)
                .build();
    }


}
