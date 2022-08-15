package com.example.test;

import redis.clients.jedis.Jedis;

public class TestPing {
    public static void main(String[] args) {
        //new Jedis对象
        Jedis jedis = new Jedis("192.168.227.128");
        //jedis所有的命令就是之前的指令
        System.out.println(jedis.ping());
    }
}
