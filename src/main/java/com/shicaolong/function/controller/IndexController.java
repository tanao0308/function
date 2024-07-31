package com.shicaolong.function.controller;

import com.shicaolong.function.pojo.Function;
import com.shicaolong.function.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @GetMapping("/")
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

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    /*
    使用例：
    浏览器输入 http://localhost:8080/result?title=Function%20A
     */
    // 用于将 HTTP GET 请求映射到处理方法 searchFunctionByTitle 上。
    @GetMapping("/result")
    // @RequestParam("title") String title：这是方法参数，用于接收来自请求的 title 参数。Spring MVC 会将请求参数 title 的值赋给这个变量。
    // Model model：这是一个 Spring MVC 提供的接口，用于在控制器中传递数据到视图。
    public String searchFunctionByTitle(@RequestParam("title") String title, Model model) {
        Function function = indexService.getFunctionByTitle(title);
        model.addAttribute("function", function);
        return "functionDetails"; // 返回的模板名，需要在 templates 目录下创建一个名为 functionDetails.html 的 Thymeleaf 模板文件
    }

}
