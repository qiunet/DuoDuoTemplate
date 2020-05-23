package com.game.server.basic.guild.entity;

import org.qiunet.data.support.IEntityBo;

public class GuildBo implements IEntityBo<GuildDo>{
	private GuildDo aDo;

	public GuildBo (GuildDo aDo) {
		this.aDo = aDo;
		this.deserialize();
	}

	public GuildDo getDo(){
		return aDo;
	}

	@Override
	public void serialize() {

	}

	@Override
	public void deserialize() {

	}
}
