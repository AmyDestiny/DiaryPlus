package com.gentlehu.diary.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtils {


    public static String saveFile(MultipartFile file,String filePath){
        if(file != null){
            String fileName = System.currentTimeMillis() + "." + getSuffixName(file.getOriginalFilename());
            File dir = new File(filePath);
            if(!dir.exists()){
                dir.mkdirs();
            }
            File temp = new File(filePath + File.separator + fileName);
            try {
                if(temp.createNewFile()){
                    file.transferTo(temp);
                    return fileName;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static String getSuffixName(String fileName){
        String[] split = fileName.split("\\.");
        return split[split.length - 1];
    }
}