package com.example.demo.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Pattern;

@Service
@Log4j2
public class FileService {

    @Autowired
    private ParseService parseService;

    private static String YD = "^1(3[4-9]|4[7]|5[0-2,7-9]|7[2|8]|8[2-4,7-8]|9[8])\\d{8}$";
    private static String LT = "^1(3[3]|4[9]|5[3]|7[3|7]|8[0-1,9]|9[9])\\d{8}$";
    private static String DX = "^1(3[0-2]|4[5]|5[5-6]|6[6]|7[1|5|6]|8[5-6])\\d{8}$";


    /**
     * 保存手机号码文本数据
     *
     * @param file
     * @return
     */
    public Map<String, Integer> saveDataPhoneTxt(MultipartFile file) throws Exception{
        Map<String, Integer> map = new HashMap<>();
        int succse = 0;
        int rep = 0;
        int yd = 0;
        int dx = 0;
        int lt = 0;
        try {
            InputStream inputStream = file.getInputStream();
            List<String> strings = parseService.parseTxt(inputStream);
            /**
             * 转Set去重
             */
            Set<String> sets = new HashSet<>();
            for (String str : strings) {
                if (sets.contains(str)) {
                    rep++;
                } else if (str.matches(YD)) {
                    yd++;
                } else if (Pattern.matches(LT, str)) {
                    lt++;
                } else if (Pattern.matches(DX, str)) {
                    dx++;
                }
                sets.add(str);
            }

            /**
             * 插入返回条数为成功条数(省略数据库操作)
             */
            succse = sets.size();
            map.put("succse", succse);
            map.put("rep", rep);
            map.put("yd", yd);
            map.put("dx", dx);
            map.put("lt", lt);
        } catch (IOException e) {
            log.error("文件流获取异常！", e);
            throw new RuntimeException("saveDataPhoneTxt err!");
        }
        return map;
    }
}
