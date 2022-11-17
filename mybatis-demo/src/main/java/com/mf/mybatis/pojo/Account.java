package com.mf.mybatis.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
    private Long id;
    private Long uid;
    private Double money;
}
