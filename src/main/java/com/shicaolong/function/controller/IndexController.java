package com.shicaolong.function.controller;

import com.shicaolong.function.pojo.Function;
import com.shicaolong.function.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @GetMapping("/")
    @ResponseBody
    public List<Function> getAllFunction() {
        // 返回所有文章的信息
        List<Function> functionList = indexService.getAllFunction();
        return functionList;
    }


}
