package com.example.demo.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class ParseService {

    /**
     * 解析txt文件流
     *
     * @param inputStream
     * @return
     */
    public List<String> parseTxt(InputStream inputStream) {
        try {
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader bd = new BufferedReader(isr);
            List<String> lists = new ArrayList<>();
            while (bd.readLine() != null) {
                lists.add(bd.readLine());
            }
            return lists;
        } catch (IOException e) {
            log.error("文件流解析异常！", e);
            return new ArrayList<>();
        }
    }
}
