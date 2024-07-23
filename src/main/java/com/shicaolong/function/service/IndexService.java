package com.shicaolong.function.service;

import com.shicaolong.function.dao.IndexDao;
import com.shicaolong.function.pojo.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {

    @Autowired
    private IndexDao indexDao;

    public List<Function> getAllFunction() {
        return indexDao.getAllFunction();
    }
}
