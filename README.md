# mysql_fetchSize
测试 fetchSize 的影响

```xml
<mapper namespace="com.example.mysql_fetchSize.dao.MyDao">
    <select id="selectAll" resultType="java.util.Map" fetchSize="10">
        SELECT * FROM large_table
    </select>
</mapper>
```
1. 分别测试 `/all` 接口，观察 堆内存
2. 测试 `/stream` 接口 堆内存
