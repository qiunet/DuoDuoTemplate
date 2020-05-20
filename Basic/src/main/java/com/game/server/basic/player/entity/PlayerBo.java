package com.game.server.basic.player.entity;

import org.qiunet.data.support.IEntityBo;

public class PlayerBo implements IEntityBo<PlayerDo>{
	private PlayerDo aDo;

	public PlayerBo (PlayerDo aDo) {
		this.aDo = aDo;
		this.deserialize();
	}

	public PlayerDo getDo(){
		return aDo;
	}

	@Override
	public void serialize() {

	}

	@Override
	public void deserialize() {

	}
}
