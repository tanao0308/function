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
        List<Function> result = functionService.getAllFunctions();
        log.info("result={}", result);
        return result;
    }

    // Get a function by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Function getFunctionById(@PathVariable("id") Long id) {
        Function result = functionService.getFunctionById(id);
        log.info("id={}, result={}", id, result);
        return result;
    }

    // Get a function by title
    @RequestMapping(value = "/title/{title}", method = RequestMethod.GET)
    public Function getFunctionByTitle(@PathVariable("title") String title) {
        Function result = functionService.getFunctionByTitle(title);
        log.info("title={}, result={}", title, result);
        return result;
    }

    // Create a new function
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Function createFunction(@RequestBody Function function) {
        Function result = functionService.createFunction(function);
        log.info("function={}, result={}", function, result);
        return result;
    }

    // Delete a function
    @DeleteMapping("/{id}")
    public boolean deleteFunction(@PathVariable("id") Long id) {
        boolean result = functionService.deleteFunction(id);
        log.info("id={}, result={}", id, result);
        return result;
    }
}
