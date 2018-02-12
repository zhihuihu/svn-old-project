package com.hxkj.xhupubmed.core.utils;

import java.io.Serializable;


import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

/** 
 * Project Name:swagger 
 * ClassName:RedisUtils
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月4日 上午11:39:37 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class RedisUtils {

	@SuppressWarnings({ "unchecked"})
	private static RedisTemplate<Serializable, Serializable> redisTemplate = 
            (RedisTemplate<Serializable, Serializable>) SpringContextUtils
                    .getBean("redisTemplate");
	
	
	public static void save(final String key, Object value) {
		 
        final byte[] vbytes = SerializeUtil.serialize(value);
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.set(redisTemplate.getStringSerializer().serialize(key), vbytes);
                return null;
            }
        });
    }
	
	public static void save(final String key, Object value,long liveTime) {
		 
        final byte[] vbytes = SerializeUtil.serialize(value);
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.set(redisTemplate.getStringSerializer().serialize(key), vbytes);
                if(liveTime > 0){
                	connection.expire(redisTemplate.getStringSerializer().serialize(key), liveTime);
                }
                return null;
            }
        });
    }
	
	
	
	
    public static <T> T get(final String key, Class<T> elementType) {
        return redisTemplate.execute(new RedisCallback<T>() {
            @Override
            public T doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] keybytes = redisTemplate.getStringSerializer().serialize(key);
                if (connection.exists(keybytes)) {
                    byte[] valuebytes = connection.get(keybytes);
                    @SuppressWarnings("unchecked")
                    T value = (T) SerializeUtil.unserialize(valuebytes);
                    return value;
                }
                return null;
            }
        });
    }
    
    
    public static <T> T getAndUpdate(final String key, Class<T> elementType,long liveTime) {
    	T t;
        t = redisTemplate.execute(new RedisCallback<T>() {
            @Override
            public T doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] keybytes = redisTemplate.getStringSerializer().serialize(key);
                if (connection.exists(keybytes)) {
                    byte[] valuebytes = connection.get(keybytes);
                    @SuppressWarnings("unchecked")
                    T value = (T) SerializeUtil.unserialize(valuebytes);
                    return value;
                }
                return null;
            }
        });
        if( t != null){
        	updateLiveTime(key,liveTime);
        }
        return t;
    }
    
    
    public static void updateLiveTime(final String key,long liveTime) {
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                if(liveTime > 0){
                	connection.expire(redisTemplate.getStringSerializer().serialize(key), liveTime);
                }
                return null;
            }
        });
    }
	
}
