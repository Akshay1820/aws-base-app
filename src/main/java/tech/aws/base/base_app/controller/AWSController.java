package tech.aws.base.base_app.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tech.aws.base.base_app.service.AWSAppService;

import java.util.List;

@RestController
@RequestMapping("/api/tech")
@AllArgsConstructor
public class AWSController {
    
    private final AWSAppService awsAppService;

    @GetMapping("/")
    public ResponseEntity<String> demo(){
        return ResponseEntity.ok("Hello World");
    }


    @PostMapping("/add_file")
    public ResponseEntity<String> addFiles(MultipartFile file){
        awsAppService.addFiles(file);
        return ResponseEntity.ok("File Added Successfully");
    }

}
