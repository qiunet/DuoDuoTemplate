package com.game.template.basic.id.global.entity;

import org.qiunet.data.support.IEntityBo;

public class ServerInfoBo implements IEntityBo<ServerInfoDo>{
	private ServerInfoDo aDo;

	public ServerInfoBo (ServerInfoDo aDo) {
		this.aDo = aDo;
		this.deserialize();
	}

	public ServerInfoDo getDo(){
		return aDo;
	}

	@Override
	public void serialize() {

	}

	@Override
	public void deserialize() {

	}
}
