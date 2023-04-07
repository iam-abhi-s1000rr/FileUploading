package com.example.fileupload.fileservice;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    public String uploadImage(String path, MultipartFile multipartFile) throws IOException;
}
