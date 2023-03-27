package com.example.mysql_fetchSize.controller;

import com.example.mysql_fetchSize.dao.MyDao;
import com.example.mysql_fetchSize.stream.MyResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MyController {

    @Autowired
    MyDao myDao;

    @GetMapping("/all")
    public int getAll() {
        List<Map<String, Object>> maps = myDao.selectAll();
        for (Map<String, Object> map : maps) {
            Object id = map.get("id");
            Object largeBlob = map.get("large_blob");
            System.out.println(id + ":" + largeBlob);
        }
        return maps.size();
    }

    @GetMapping("/fetch")
    public int getAllFetch() {
        List<Map<String, Object>> maps = myDao.selectAllByFetch();
        for (Map<String, Object> map : maps) {
            Object id = map.get("id");
            Object largeBlob = map.get("large_blob");
            System.out.println(id + ":" + largeBlob);
        }
        return maps.size();
    }


    @GetMapping("/stream")
    public int stream() {
        MyResultHandler resultHandler = new MyResultHandler();
        myDao.selectAll(resultHandler);
        int count = resultHandler.getCount();
        return count;
//        return resultHandler.getRes();
    }

}
