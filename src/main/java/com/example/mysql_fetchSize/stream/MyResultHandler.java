package com.example.mysql_fetchSize.stream;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.Map;

public class MyResultHandler implements ResultHandler<Map<String, Object>> {
    private int count = 0;

    @Override
    public void handleResult(ResultContext<? extends Map<String, Object>> resultContext) {
        Map<String, Object> resultMap = resultContext.getResultObject();
        // 处理结果集的代码
        Object id = resultMap.get("id");
        Object largeBlob = resultMap.get("large_blob");
        System.out.println(id + ":" + largeBlob);
        count++;
    }

    public int getCount() {
        return count;
    }
}