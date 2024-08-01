package com.shicaolong.function.controller;

import com.shicaolong.function.pojo.User;
import com.shicaolong.function.service.UserService;
import com.shicaolong.function.util.EncryptionUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// 它结合了 @Controller 和 @ResponseBody 的功能
// @RestController 注解的类会被 Spring 识别为一个 Web 控制器，能够处理 HTTP 请求并返回响应。
// @RestController 注解默认将返回值序列化为 JSON 或 XML 格式，而不是视图名称。
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    // HttpServletResponse：这是一个Java Servlet API提供的对象，用于操作HTTP响应。通过它，你可以设置响应头、响应状态、cookie等。
    // 作用：这个参数允许你在方法中操作HTTP响应，例如添加cookie或设置响应状态码。
    public String login(@RequestBody User user, HttpServletResponse response) throws Exception {
        Optional<User> userOptional = userService.getByUsername(user.getUsername());
        if (userOptional.isPresent()) {
            User targetUser = userOptional.get();
            if (user.getPassword().equals(targetUser.getPassword())) {
                // 添加 cookie
                String encryptedUid = EncryptionUtils.encrypt(targetUser.getUid());
                Cookie cookie = new Cookie("userId", encryptedUid);
                cookie.setHttpOnly(true); // 防止XSS攻击
                cookie.setMaxAge(7 * 24 * 60 * 60); // 7天有效期
                cookie.setPath("/"); // 使cookie在整个应用程序中可用
                response.addCookie(cookie);
                return "Login successful!";
            } else {
                return "Invalid password";
            }
        }
        return "User not found";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestBody User user) {
        if (userService.getByUsername(user.getUsername()).isPresent()) {
            return "Username already exists";
        }
        userService.createUser(user);
        return "User registered successfully";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfile(HttpServletRequest request) throws Exception {
        // 从请求中获取 cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("userId".equals(cookie.getName())) {
                    String encryptedUid = cookie.getValue();
                    Long uid = EncryptionUtils.decrypt(encryptedUid); // 解密用户ID
                    Optional<User> userOptional = userService.getByUid(uid);
                    if (userOptional.isPresent()) {
                        return "username is " + userOptional.get().getUsername();
                    }
                    return "wrong cookie";
                }
            }
        }
        return "current user not exist";
    }
}
