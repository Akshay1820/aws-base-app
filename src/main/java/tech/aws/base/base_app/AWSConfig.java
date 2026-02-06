package tech.aws.base.base_app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import java.io.IOException;
import java.util.UUID;

@Configuration
public class AWSConfig {

    private static final Region REGION = Region.AP_SOUTH_1;

    @Value("${aws.bucket.name}")
    String bucketName;

    private static final String FOLDER = "upload/";


    @Bean
    public S3Client s3Client() {
        return S3Client.builder()
                .region(REGION)
                .build();
    }

    public void addFiles(MultipartFile file) {

        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(getKey(file))
                .build();

        try {
            s3Client().putObject(
                    putObjectRequest,
                    RequestBody.fromInputStream(file.getInputStream(), file.getSize())
            );
        } catch (IOException e) {
            System.out.println("Failed to upload file");
        }
    }

    private String getKey(MultipartFile file){
        return FOLDER + UUID.randomUUID() + "_" + file.getOriginalFilename();
    }

}

