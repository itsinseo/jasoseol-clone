package com.itsinseo.jasoseolclone.awsS3;

import com.itsinseo.jasoseolclone.common.FileException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FileUtil {

    @Value("${bucket.original}")
    private String originalBucketUrl;

    @Value("${bucket.resized}")
    private String resizedBucketUrl;

    public String generateFileNameWithUUID(String originalFileName) {
        int extIndex = originalFileName.lastIndexOf(".");

        if (extIndex == -1) {
            throw new FileException("확장자가 없는 비정상적인 파일입니다.");
        }

        String rawFileName = originalFileName.substring(0, extIndex);
        String fileExt = originalFileName.substring(extIndex);

        UUID uuid = UUID.randomUUID();

        return rawFileName + "_" + uuid + fileExt;
    }

    public String convertFileNameToOriginalUrl(String fileName) {
        return originalBucketUrl + fileName;
    }

    public String convertFileNameToResizedUrl(String fileName) {
        return resizedBucketUrl + fileName;
    }
}
