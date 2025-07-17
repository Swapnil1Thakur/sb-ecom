package com.ecommerce.project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        //steps

        //1. file names of current / original file
        String originalFileName = file.getOriginalFilename();

        //2. generate a unique file name
        String randomId = UUID.randomUUID().toString();
        //eg -> //mat.jpg --> 1234 --> 1234.jpg
        String fileName = randomId.concat(originalFileName.substring(originalFileName.lastIndexOf('.')));
        String filePath = path + File.separator+ fileName;

        //3. check if the path exist and create
        File folder = new File(path);
        if(!folder.exists())
            folder.mkdir();

        //4. upload to server
        Files.copy(file.getInputStream(), Paths.get(filePath));

        //5. returning file name
        return fileName;

    }
}
