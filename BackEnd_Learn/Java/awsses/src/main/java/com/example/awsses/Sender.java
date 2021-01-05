package com.example.awsses;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class Sender {
    @Value("${aws.ses.credentials.access-key}")
    private String AWS_ACCESS_KEY_ID;

    @Value("${aws.ses.credentials.secret-key}")
    private String AWS_SECRET_KEY;


    public void send(SenderDto senderDto){
        try {
            log.info("Attempting to send an email through Amazon SES by using the AWS SDK for Java...");
            System.out.println(AWS_ACCESS_KEY_ID);
            BasicAWSCredentials awsCredentials = new BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
            //ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();

//            try {
//
//            } catch (Exception e) {
//                throw new AmazonClientException(
//                        "Cannot load the credentials from the credential profiles file. " +
//                                "Please make sure that your credentials file is at the correct " +
//                                "location (~/.aws/credentials), and is in valid format.",
//                        e);
//            }

            AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                    .withRegion("ap-northeast-2")
                    .build();

            // Send the email.
            client.sendEmail(senderDto.toSendRequestDto());
            log.info("Email sent!");

        } catch (Exception ex) {
            log.error("The email was not sent.");
            log.error("Error message: " + ex.getMessage());
            throw new AmazonClientException(
                    ex.getMessage(),
                    ex);
        }
    }
}
