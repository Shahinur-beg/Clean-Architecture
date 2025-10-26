package com.example.payment.adapter.cache;

import org.springframework.stereotype.Component;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MockRedisCache {
    private final ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
    public void put(String key, Object value) { map.put(key, value); }
    public Object get(String key) { return map.get(key); }
    public void evict(String key) { map.remove(key); }
}
