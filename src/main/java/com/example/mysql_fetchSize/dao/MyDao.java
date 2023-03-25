package com.example.mysql_fetchSize.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.ResultHandler;

import java.util.List;
import java.util.Map;

@Mapper
public interface MyDao {
    List<Map<String, Object>> selectAll();

    void selectAll(ResultHandler<Map<String, Object>> resultHandler);
}
