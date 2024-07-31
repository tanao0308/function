package com.shicaolong.function.controller;

import com.shicaolong.function.pojo.Function;
import com.shicaolong.function.service.FunctionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 它结合了 @Controller 和 @ResponseBody 的功能
// @RestController 注解的类会被 Spring 识别为一个 Web 控制器，能够处理 HTTP 请求并返回响应。
// @RestController 注解默认将返回值序列化为 JSON 或 XML 格式，而不是视图名称。
@RestController
@RequestMapping("/functions")
@Slf4j
public class FunctionController {

    @Autowired
    private FunctionService functionService;

    // Get all functions
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Function> getAllFunctions() {
        return functionService.getAllFunctions();
    }

    // Get a function by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Function getFunctionById(@PathVariable("id") Long id) {
        log.info("id={}", id);
        log.info("function={}", functionService.getFunctionById(id));
        return functionService.getFunctionById(id);
    }

    // Get a function by title
    @RequestMapping(value = "/title/{title}", method = RequestMethod.GET)
    public Function getFunctionByTitle(@PathVariable("title") String title) {
        log.info("title={}", title);
        log.info("function={}", functionService.getFunctionByTitle(title));
        return functionService.getFunctionByTitle(title);
    }

    // Create a new function
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Function createFunction(@RequestBody Function function) {
        log.info("function={}", function);
        return functionService.createFunction(function);
    }

//    // Update a function
//    @PutMapping("/{id}")
//    public Function updateFunction(@PathVariable("id") Long id, @RequestBody Function function) {
//        return functionService.updateFunction(id, function);
//    }

//    // Delete a function
//    @DeleteMapping("/{id}")
//    public void deleteFunction(@PathVariable("id") Long id) {
//        functionService.deleteFunction(id);
//    }
}
