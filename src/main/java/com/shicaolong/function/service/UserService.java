package com.shicaolong.function.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shicaolong.function.mapper.FunctionMapper;
import com.shicaolong.function.mapper.UserMapper;
import com.shicaolong.function.pojo.Function;
import com.shicaolong.function.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Optional<User> getByUid(Long uid) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", uid);
        List<User> result = userMapper.selectList(queryWrapper);
        if(result.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(result.get(0));
        }
    }

    public Optional<User> getByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<User> result = userMapper.selectList(queryWrapper);
        if(result.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(result.get(0));
        }
    }

    public void createUser(User user) {
        userMapper.insert(user);
    }
}
