package com.shicaolong.function.dao;

import com.shicaolong.function.pojo.Function;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FunctionDao {

    public List<Function> getAllFunctions();

    public Function getFunctionById(Long id);

    public Function getFunctionByTitle(String title);

    public void createFunction(Function function);
}
