package com.shicaolong.function.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Function {
    private Long fid;
    private String title;
    private String content;
    private Timestamp createTime;
    private Timestamp  updateTime;
}
