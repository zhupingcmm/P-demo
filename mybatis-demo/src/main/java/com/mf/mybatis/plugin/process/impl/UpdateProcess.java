package com.mf.mybatis.plugin.process.impl;


import com.mf.mybatis.plugin.constants.Constants;
import com.mf.mybatis.plugin.process.AbstractProcess;
import lombok.val;
import org.apache.ibatis.mapping.MappedStatement;

import static com.mf.mybatis.plugin.constants.Constants.PARAMETER_INDEX;
import static com.mf.mybatis.plugin.constants.Constants.MAPPED_STATEMENT_INDEX;
public class UpdateProcess extends AbstractProcess {

    @Override
    public void handle(Object[] args) {
        final MappedStatement ms = (MappedStatement) args[MAPPED_STATEMENT_INDEX];
        final Object parameter = args[PARAMETER_INDEX];
        val boundSql = ms.getBoundSql(parameter);
        String sql;
        if (parameter == null) {
            sql = String.format("update sql: %s", boundSql.getSql());
        } else {
            sql = String.format( "update sql: %s , with parameter %s", boundSql.getSql(), parameter);
        }
        setLogContent(sql);
    }
}
