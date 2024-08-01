package com.shicaolong.function.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("functions")
public class Function {
    @TableId
    private Long fid;
    private String title;
    private String content;
    private Timestamp createTime;
    private Timestamp  updateTime;
}
