package com.mf.pbatis;

public class SqlSessionFactory {
    private Configuration configuration;

    public SqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    public SqlSession openSession() {
        return new SqlSessionImpl(configuration);
    }
}
