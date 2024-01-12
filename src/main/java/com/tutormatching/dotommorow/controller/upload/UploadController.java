package com.tutormatching.dotommorow.controller.upload;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.tutormatching.dotommorow.dto.user.UserDto;
import com.tutormatching.dotommorow.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UploadController {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3Client amazonS3Client;
    private final UserService userService;


    @PostMapping("/user/profile/upload")
    public String uploadImageFile(@RequestParam("file")MultipartFile file, @RequestParam("userId") String userId) {
        UserDto userDto = userService.findById(userId);

        try {
            String uuid = UUID.randomUUID().toString();
            String fileName = file.getOriginalFilename();
            fileName = uuid + "_" + fileName;

            String fileUrl = "https://" + bucket + ".s3.amazonaws.com" + fileName;
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            metadata.setContentLength(file.getSize());
            amazonS3Client.putObject(bucket, fileName, file.getInputStream(), metadata);
            log.info("upload file name: {}, url: {}", fileName, fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            log.warn("upload error: {}", e.getMessage());
        }

        return "redirect:/";
    }

    @DeleteMapping("/user/profile/upload/{fileName}")
    public String uploadImageFile(@PathVariable("fileName") String fileName) {

        String fileUrl = "https://" + bucket + ".s3.amazonaws.com/" + fileName;
        boolean doesObjectExist = amazonS3Client.doesObjectExist(bucket, fileName);
        log.info("doesObjectExist: {}", doesObjectExist);
        if (doesObjectExist) {
            amazonS3Client.deleteObject(bucket, fileUrl);
            log.info("삭제 성공 upload file name: {}, url: {}", fileName, fileUrl);
        } else {
            log.info("삭제 실패");
        }

        return "redirect:/";
    }
}
