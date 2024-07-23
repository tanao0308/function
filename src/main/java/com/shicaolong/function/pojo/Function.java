package com.shicaolong.function.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Function {
    private Long fid;
    private String title;
    private String content;
    private Date createTime;
    private Date updateTime;
}
