package com.shicaolong.function.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shicaolong.function.mapper.FunctionMapper;
import com.shicaolong.function.pojo.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionService {

    @Autowired
    private FunctionMapper functionMapper;

    public List<Function> getAllFunctions() {
        return functionMapper.selectList(null);
    }

    public Function getFunctionById(Long id) {
        return functionMapper.selectById(id);
    }

    public Function getFunctionByTitle(String title) {
        QueryWrapper<Function> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title", title);
        return functionMapper.selectList(queryWrapper).get(0);
    }

    public Function createFunction(Function function) {
        functionMapper.insert(function);
        return functionMapper.selectById(function.getFid());
    }

    public boolean deleteFunction(Long id) {
        return functionMapper.deleteById(id) > 0;
    }
}
