package com.tutormatching.dotommorow.util;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Component
//// 실제 서비스 시 사용
//@PropertySource("classpath:application-s3.properties")
// 테스트 시 사용
@PropertySource("classpath:application.properties")
@RequiredArgsConstructor
public class FileUploadUtil {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
    private final AmazonS3Client amazonS3Client;

    /**
     * @param file
     * @return fileName
     */
    // 파일 업로드
    public String uploadFile(MultipartFile file) {

        // 파일 이름 중복 방지를 위한 uuid 생성 및 파일 이름 생성
        String uuid = UUID.randomUUID().toString();
        String fileName = file.getOriginalFilename();
        fileName = uuid + "_" + fileName;

        // S3에 파일 업로드
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            metadata.setContentLength(file.getSize());
            amazonS3Client.putObject(bucket, fileName, file.getInputStream(), metadata);
            String fileUrl = getFullPath(fileName);
            log.info("upload file name: {}, url: {}", fileName, fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            log.warn("upload error: {}", e.getMessage());
        }

        return fileName;
    }

    // 파일 삭제
    public void deleteFile(String fileName) {
        boolean doesObjectExist = amazonS3Client.doesObjectExist(bucket, fileName);
        log.info("doesObjectExist: {}", doesObjectExist);
        if (doesObjectExist) {
            amazonS3Client.deleteObject(bucket, fileName);
            log.info("삭제 성공 upload file name: {}", fileName);
        } else {
            log.info("삭제 실패");
        }
    }

    // 파일 경로를 반환하는 함수
    public String getFullPath(String fileName) {
        return "https://" + bucket + ".s3.amazonaws.com/" + fileName;
    }
}


