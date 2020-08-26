package com.example.demo.controller;

import com.example.demo.been.Result;
import com.example.demo.service.FileService;
import com.example.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private FileService fileService;

    @PostMapping("uploadFileTxt")
    public Result<Map<String,Integer>> uploadFileTxt(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResultUtil.err("未获取到文件！");
        } else if ("txt".equals(file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4, file.getOriginalFilename().length()))) {
            return ResultUtil.err("请上传txt格式文件！");
        }
        try {
            Map<String, Integer> stringIntegerMap = fileService.saveDataPhoneTxt(file);
            return ResultUtil.succse(stringIntegerMap);
        }catch (Exception e){
            return ResultUtil.err(e.getMessage());
        }
    }
}
