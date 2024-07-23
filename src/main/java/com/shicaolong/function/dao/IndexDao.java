package com.shicaolong.function.dao;

import com.shicaolong.function.pojo.Function;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexDao {
    public List<Function> getAllFunction();
}
