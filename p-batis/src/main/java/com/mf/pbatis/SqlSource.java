package com.mf.pbatis;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SqlSource {
    private String sql;
    private String resultType;
}
