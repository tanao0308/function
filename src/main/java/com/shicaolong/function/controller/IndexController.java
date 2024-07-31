package com.shicaolong.function.controller;

import com.shicaolong.function.pojo.Function;
import com.shicaolong.function.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private IndexService indexService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/log")
    // @ResponseBody 是 Spring 框架中的一个注解，用于将控制器方法的返回值直接写入 HTTP 响应体，而不是通过视图解析器进行处理。
    @ResponseBody
    public String logExample() {
        logger.info("This is an info message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");
        return "Logging example";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @GetMapping("/function")
    public String getAllFunction(Model model) {
        // 返回所有文章的信息
        List<Function> functionList = indexService.getAllFunction();
        List<String> contentList = new ArrayList<>();
        if (functionList != null) {
            for (Function element : functionList) {
                contentList.add(element.getContent());
            }
        }
        // 将列表添加到模型中，并命名为 contentList
        model.addAttribute("contentList", contentList);
        // 返回视图名 allFunction，视图解析器会查找 allFunction.html 模板文件。
        return "allFunction";
    }

    @GetMapping("/function/{title}")
    public String searchFunctionByTitle(@PathVariable("title") String title, Model model) {

//    @GetMapping("/function")
//    public String searchFunctionByTitle(@RequestParam("title") String title, Model model) {
        Function function = indexService.getFunctionByTitle(title);
        model.addAttribute("function", function);
        return "functionDetails"; // 返回的模板名，需要在 templates 目录下创建一个名为 functionDetails.html 的 Thymeleaf 模板文件
    }

}
