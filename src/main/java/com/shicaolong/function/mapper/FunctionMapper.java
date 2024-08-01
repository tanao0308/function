package com.shicaolong.function.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shicaolong.function.pojo.Function;
import org.apache.ibatis.annotations.Mapper;

// @Mapper 是 mybatis-plus 的注解，使用后无需再使用 @Repository
@Mapper
public interface FunctionMapper extends BaseMapper<Function> {}
