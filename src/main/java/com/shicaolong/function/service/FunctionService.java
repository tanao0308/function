package com.shicaolong.function.service;

import com.shicaolong.function.dao.FunctionDao;
import com.shicaolong.function.pojo.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionService {

    @Autowired
    private FunctionDao functionDao;

    public List<Function> getAllFunctions() {
        return functionDao.getAllFunctions();
    }

    public Function getFunctionById(Long id) {
        return functionDao.getFunctionById(id);
    }

    public Function getFunctionByTitle(String title) {
        return functionDao.getFunctionByTitle(title);
    }

    public Function createFunction(Function function) {
        functionDao.createFunction(function);
        return functionDao.getFunctionByTitle(function.getTitle());
    }
}
