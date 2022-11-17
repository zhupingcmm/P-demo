package com.mf.pbatis;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class Configuration {
    private String driver;
    private String url;
    private String username;
    private String password;


    private Map<String, SqlSource> sqlSourceMap = new HashMap<>();
}
