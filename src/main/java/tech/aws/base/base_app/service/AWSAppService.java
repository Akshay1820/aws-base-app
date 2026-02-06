package tech.aws.base.base_app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tech.aws.base.base_app.AWSConfig;

@Service
@AllArgsConstructor
public class AWSAppService {

    private final AWSConfig awsConfig;

    public void addFiles(MultipartFile file){
        awsConfig.addFiles(file);
    }

}
