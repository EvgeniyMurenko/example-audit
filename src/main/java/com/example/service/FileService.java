package com.example.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

@Slf4j
@Service
public class FileService {

    public String realFromFile(String fileName) {

        File file = null;
        try {
            file = ResourceUtils.getFile(String.format("classpath:static/%s", fileName));
            String json = FileUtils.readFileToString(file, "UTF-8");
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
