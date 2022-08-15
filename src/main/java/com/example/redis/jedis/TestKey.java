package com.example.redis.jedis;

import redis.clients.jedis.Jedis;

public class TestKey {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.227.128", 6379);
        System.out.println(jedis.flushDB());
        System.out.println(jedis.exists("name"));
        System.out.println(jedis.set("name","tianjiaxin"));
        System.out.println(jedis.set("age","26"));
        System.out.println(jedis.get("name"));
        System.out.println(jedis.keys("*"));
        System.out.println(jedis.type("age"));
        System.out.println(jedis.randomKey());
        System.out.println(jedis.strlen("name"));

        System.out.println(jedis.setnx("name","ttt"));
        System.out.println(jedis.expire("age",30));

    }
}
