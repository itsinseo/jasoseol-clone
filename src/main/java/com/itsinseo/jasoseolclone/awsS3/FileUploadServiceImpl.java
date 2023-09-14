package com.itsinseo.jasoseolclone.awsS3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.itsinseo.jasoseolclone.common.FileException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileUploadServiceImpl implements FileUploadService {

    private final AmazonS3 amazonS3Client;
    private final FileUtil fileUtil;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Override
    public String uploadFile(MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();
            String fileName = fileUtil.generateFileNameWithUUID(originalFilename); // 호출 상위 메서드에서 null 체크 완료
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            metadata.setContentLength(file.getSize());
            amazonS3Client.putObject(bucket, fileName, file.getInputStream(), metadata);
            return amazonS3Client.getUrl(bucket, fileName).toString();
        } catch (IOException e) {
            throw new FileException("파일 업로드 오류입니다.");
        }
    }

}
