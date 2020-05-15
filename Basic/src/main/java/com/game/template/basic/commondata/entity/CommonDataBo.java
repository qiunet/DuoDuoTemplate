package com.game.template.basic.commondata.entity;

import org.qiunet.data.support.IEntityBo;

public class CommonDataBo implements IEntityBo<CommonDataDo>{
	private CommonDataDo aDo;

	public CommonDataBo (CommonDataDo aDo) {
		this.aDo = aDo;
		this.deserialize();
	}

	public CommonDataDo getDo(){
		return aDo;
	}

	@Override
	public void serialize() {

	}

	@Override
	public void deserialize() {

	}
}
