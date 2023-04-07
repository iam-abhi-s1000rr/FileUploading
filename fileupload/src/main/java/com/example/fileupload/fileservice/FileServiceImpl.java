package com.example.fileupload.fileservice;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadImage(String path, MultipartFile multipartFile) throws IOException {

        //TODO
        //-1)FIleName
        String fileName= multipartFile.getOriginalFilename();

        //-2)FullPath
        String filePath=path+ File.separator+fileName;

        //-3)Create Folder if not created !
        File f=new File(filePath);

        //we are checking whether our file has a folder or not
        //if folder is not available then we are creating the folder
        if(!f.exists()){
            f.mkdir();// if folder not present new folder is created-->f.mkdir();
        }

        //-4) FIle copy & upload
        Files.copy(multipartFile.getInputStream(), Paths.get(filePath));

        return fileName;


    }
}
