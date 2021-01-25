package com.game.server.basic.guild.entity;

import org.apache.ibatis.type.Alias;
import org.qiunet.data.redis.entity.RedisEntity;
import org.qiunet.data.core.support.db.Column;
import org.qiunet.data.core.support.db.Table;
/**
* *
* 对象为自动创建 不要修改
*/
@Alias("GuildDo")
@Table(name = "guild")
public class GuildDo extends RedisEntity<Long, GuildBo> {
	@Column(comment = "工会id", isKey = true)
	private long guildId;
	@Column(comment = "名称")
	private String name;
	@Column(comment = "等级")
	private int level;

	/**默认的构造函数**/
	public GuildDo(){}
	public GuildDo(long guildId){
		this.guildId = guildId;
	}

	public long getGuildId() {
		return guildId;
	}

	public void setGuildId(long guildId) {
		this.guildId = guildId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public Long key() {
		return guildId;
	}

	@Override
	public String keyFieldName() {
		return "guildId";
	}
}
