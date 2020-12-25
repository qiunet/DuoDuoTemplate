package com.game.server.basic.common.redis;

import org.qiunet.data.core.support.redis.BasePoolRedisUtil;
import org.qiunet.data.core.support.redis.IRedisCaller;
import org.qiunet.data.util.ServerConfig;
import redis.clients.jedis.JedisCommands;

/***
 *
 * @author qiunet
 * 2020-05-23 22:52
 **/
public class RedisDataUtil extends BasePoolRedisUtil {
	private static final RedisDataUtil instance = new RedisDataUtil();

	protected RedisDataUtil() {
		super(ServerConfig.getInstance(), "data");
	}

	public static RedisDataUtil getInstance() {
		return instance;
	}

	public static JedisCommands jedis(){
		return instance.returnJedis();
	}

	public static JedisCommands jedis(boolean log){
		return instance.returnJedis(log);
	}

	public static <T> T executorCommands(IRedisCaller<T> caller) {
		return instance.execCommands(caller);
	}
}
