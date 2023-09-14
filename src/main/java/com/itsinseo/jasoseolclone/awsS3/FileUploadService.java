package com.itsinseo.jasoseolclone.awsS3;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    String uploadFile(MultipartFile file);
}
