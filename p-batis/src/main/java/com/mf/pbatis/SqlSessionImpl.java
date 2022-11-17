package com.mf.pbatis;

import lombok.val;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlSessionImpl implements SqlSession{

    private Configuration configuration;

    public SqlSessionImpl(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> List<T> selectList(String statement) {
        List<Object> list = new ArrayList<>();
        try {
            Class.forName(configuration.getDriver());
            val connection = DriverManager.getConnection(configuration.getUrl(), configuration.getUsername(), configuration.getPassword());
            val sqlSource = configuration.getSqlSourceMap().get(statement);
            val prepareStatement = connection.prepareStatement(sqlSource.getSql());
            val resultSet = prepareStatement.executeQuery();


            List<String> columnNames = new ArrayList<>();
            val metaData = resultSet.getMetaData();
            val columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }
            while (resultSet.next()) {
                val clazz = Class.forName(sqlSource.getResultType());
                val instance = clazz.getConstructor().newInstance();
                val methods = clazz.getDeclaredMethods();

                for (String columnName : columnNames) {
                    for (Method method : methods) {
                        if (method.getName().equalsIgnoreCase("set" + columnName)){
                            method.invoke(instance,resultSet.getObject(columnName));
                        }
                    }
                }

                list.add(instance);
            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return (List<T>) list;
    }
}
