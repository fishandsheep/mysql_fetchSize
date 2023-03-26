# mysql_fetchSize
#### 测试 fetchSize 的影响
```xml
<mapper namespace="com.example.mysql_fetchSize.dao.MyDao">
    <select id="selectAll" resultType="java.util.Map" fetchSize="10">
        SELECT * FROM large_table
    </select>
</mapper>
```
1. 分别测试 `/all` 接口，观察 堆内存
2. 测试 `/stream` 接口 堆内存

#### 设置 `-Xmx70m -Xms70m` java启动参数

#### 测试结果 10w 条数据 无返回
| url         | 占用堆内存 | 最大堆内存 | 耗时  |
|-------------|-------|-------|-----|
| /all        | 250M  | 550M  | 15s |
| /fetch-10   | 130M  | 180M  | 53s |
| /fetch-100  | 150M  | 250M  | 18s |
| /fetch-1000 | 150M  | 250M  | 18s |
| /stream     | 75M   | 100M  | 14s |

#### 测试结果 10w 条数据 全返回 first
| url         | 占用堆内存     | 最大堆内存 | 耗时  |
|-------------|-----------|-------|-----|
| /all        | 225M~150M | 350M  | 24s |
| /fetch-10   | 200M      | 475M  | 23s |
| /stream     | 250M      | 480M  | 23s |

#### 测试结果 10w 条数据 全返回 CG second
| url         | 占用堆内存     | 最大堆内存 | 耗时  |
|-------------|-----------|-------|-----|
| /all        | 300M      | 475M  | 23s |
| /fetch-10   | 275M~150M | 475M  | 24s |
| /stream     | 160M      | 275M  | 23s |