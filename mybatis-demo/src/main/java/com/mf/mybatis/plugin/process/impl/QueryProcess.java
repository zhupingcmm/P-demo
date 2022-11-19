package com.mf.mybatis.plugin.process.impl;

import com.mf.mybatis.plugin.process.AbstractProcess;
import lombok.val;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.RowBounds;

public class QueryProcess extends AbstractProcess {
    static int MAPPED_STATEMENT_INDEX = 0;
    static int PARAMETER_INDEX = 1;
    static int ROW_BOUNDS_INDEX = 2;
    private Object [] args;

    public QueryProcess(Object[] args) {
        this.args = args;
    }


    public void handle() {
        final MappedStatement ms = (MappedStatement) args[MAPPED_STATEMENT_INDEX];
        final Object parameter = args[PARAMETER_INDEX];
        final RowBounds rowBounds = (RowBounds) args[ROW_BOUNDS_INDEX];
        val boundSql = ms.getBoundSql(parameter);
        val limit = rowBounds.getLimit();
        val offset = rowBounds.getOffset();
        String sql;
        if (parameter == null) {
            sql = String.format( "select sql: %s ", boundSql.getSql());
            if (limit != Integer.MAX_VALUE) {
                sql = String.format( "select sql: %s, limit: %s, offset %s", boundSql.getSql(), limit, offset);
            }
        } else {
            sql = String.format( "select sql: %s , with parameter %s", boundSql.getSql(), parameter);
            if (limit != Integer.MAX_VALUE) {
                sql = String.format( "select sql: %s , with parameter %s, limit: %s, offset %s", boundSql.getSql(), parameter, limit, offset);
            }
        }

        setLogContent(sql);
    }
}
