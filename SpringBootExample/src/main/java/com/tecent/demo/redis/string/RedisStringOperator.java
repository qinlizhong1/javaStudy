package com.tecent.demo.redis.string;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisStringOperator {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * 获取指定 key 的值
     *
     * @param key 键
     * @return 返回 key 的值
     */
    @RequestMapping("/get")
    public Object get(String key) {
        System.out.println("111111111");
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * set
     *
     * @param key 键， value 值
     * @return
     */
    @RequestMapping("/set")
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }
}
