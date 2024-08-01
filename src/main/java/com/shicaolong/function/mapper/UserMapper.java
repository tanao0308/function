package com.shicaolong.function.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shicaolong.function.pojo.Function;
import com.shicaolong.function.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {}
