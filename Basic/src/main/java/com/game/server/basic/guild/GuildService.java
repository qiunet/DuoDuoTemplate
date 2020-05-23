package com.game.server.basic.guild;

import com.game.server.basic.guild.entity.GuildBo;
import com.game.server.basic.guild.entity.GuildDo;
import org.qiunet.data.support.RedisDataSupport;

public enum GuildService {
	instance;
	private static RedisDataSupport<Long, GuildDo, GuildBo> dataSupport = new RedisDataSupport<>(com.game.server.basic.common.redis.RedisDataUtil.getInstance(), GuildDo.class, GuildBo::new);
	/***
	* 获得一个 GuildBo 对象
	* @param guildId 获取对象的主键
	* @return GuildBo 对象
	*/
	public GuildBo getGuildBo(Long guildId) {
		return dataSupport.getBo(guildId);
	}
}
