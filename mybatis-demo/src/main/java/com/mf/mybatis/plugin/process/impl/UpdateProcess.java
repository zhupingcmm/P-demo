package com.mf.mybatis.plugin.process.impl;


import com.mf.mybatis.plugin.process.AbstractProcess;
import lombok.val;
import org.apache.ibatis.mapping.MappedStatement;

public class UpdateProcess extends AbstractProcess {

    private static final int MAPPED_STATEMENT_INDEX = 0;
    private static final int  PARAMETER_INDEX = 1;
    private Object[] args;

    public UpdateProcess(Object[] args) {
        this.args = args;
    }

    @Override
    public void handle() {
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
