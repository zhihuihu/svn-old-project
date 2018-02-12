/*package com.hxkj.photocms.intercept.session;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import com.hxkj.photocms.entity.SysUser;

*//** 
 * Project Name:photocms.server 
 * ClassName:RedisSessionUtils
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月14日 上午11:33:38 
 * @version  1.0 
 * @since    JDK 1.8      
 *//*
public class RedisSessionUtils {

	@Resource
	protected RedisTemplate<Serializable, Serializable> redisTemplate;
	
	public void saveUserRedis(SysUser sysUser){
		redisTemplate.execute(new RedisCallback<Object>() {

			@Override
			public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
				redisConnection.set(redisTemplate.getStringSerializer().serialize(sysUser.getSysUserCuid()),redisTemplate.getStringSerializer().serialize(sysUser.getSysUserRelName()));
				return null;
			}
			
		});
	}
	
	public SysUser getUserRedis(String cuid){
		return redisTemplate.execute(new RedisCallback<SysUser>() {
            @Override
            public SysUser doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] key = redisTemplate.getStringSerializer().serialize(cuid);
                if (connection.exists(key)) {
                    byte[] value = connection.get(key);
                    String name = redisTemplate.getStringSerializer().deserialize(value);
                    SysUser sysUser = new SysUser();
                    sysUser.setSysUserRelName(name);
                    sysUser.setSysUserCuid(cuid);
                    return sysUser;
                }
                return null;
            }
        });
	}
}
*/