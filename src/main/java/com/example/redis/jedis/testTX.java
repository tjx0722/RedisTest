package com.example.redis.jedis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class testTX {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.227.128", 6379);
        jedis.flushDB();

        JSONObject jb = new JSONObject();
        jb.put("name", "xiaotian");
        jb.put("age", 23);
        // 开启事务
        Transaction multi = jedis.multi();
        String jsonString = jb.toJSONString();
        try {
            multi.set("user1", jsonString);
            multi.set("user2", jsonString);
            // 执行事务
            multi.exec();
        } catch (Exception e) {
            // 放弃事务
            multi.discard();
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            // 关闭连接
            jedis.close();
        }

    }
}
