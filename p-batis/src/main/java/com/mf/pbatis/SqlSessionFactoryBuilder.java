package com.mf.pbatis;

import com.sun.org.apache.xerces.internal.parsers.SAXParser;
import lombok.val;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultElement;

import java.io.InputStream;
import java.util.List;

public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream inputStream){
        Configuration configuration = new Configuration();
        loadXmlConfig(inputStream, configuration);
        return new SqlSessionFactory(configuration);
    }

    private void loadXmlConfig(InputStream inputStream, Configuration configuration) {

        try {
            val document = new SAXReader().read(inputStream);
            List<Element> nodes = document.selectNodes("//property");
            for (Object node : nodes) {

                System.out.println(node);
                val name = ((DefaultElement) node).attribute("name").getValue();
                val value = ((DefaultElement) node).attribute("value").getValue();
                switch (name) {
                    case "driver":
                        configuration.setDriver(value);
                        break;
                    case "url":
                        configuration.setUrl(value);
                        break;
                    case "username":
                        configuration.setUsername(value);
                        break;
                    default:
                        configuration.setPassword(value);
                }

            }

            val mappers = document.selectNodes("//mapper");

            for (Object mapper : mappers) {
                System.out.println(mapper);
                val resource = ((DefaultElement) mapper).attribute("resource").getValue();
                loadSqlConfig(resource, configuration);
            }

        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

    }

    private void loadSqlConfig(String resource, Configuration configuration) {
        val stream = this.getClass().getClassLoader().getResourceAsStream(resource);
        try {
            val document = new SAXReader().read(stream);
            val selectNodes = document.selectNodes("//select");
            val namespace = document.getRootElement().attributeValue("namespace");
            for (Object node : selectNodes) {
                String id = ((DefaultElement) node).attributeValue("id");

                SqlSource sqlSource = SqlSource.builder()
                        .sql(((DefaultElement) node).getText().trim())
                        .resultType(((DefaultElement) node).attributeValue("resultType"))
                        .build();

                configuration.getSqlSourceMap().put(namespace + "." + id, sqlSource);
            }

        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }
}
