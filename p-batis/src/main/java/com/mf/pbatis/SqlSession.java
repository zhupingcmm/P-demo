package com.mf.pbatis;

import java.util.List;

public interface SqlSession {
    <T>List<T> selectList(String statement);
}
