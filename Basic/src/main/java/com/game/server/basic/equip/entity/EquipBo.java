package com.game.server.basic.equip.entity;

import com.game.server.basic.common.data.result.IRewardResult;
import com.game.server.basic.common.enums.ResourceType;
import org.qiunet.data.support.IEntityBo;

public class EquipBo implements IEntityBo<EquipDo>, IRewardResult {
	private EquipDo aDo;

	public EquipBo (EquipDo aDo) {
		this.aDo = aDo;
		this.deserialize();
	}

	public EquipDo getDo(){
		return aDo;
	}

	@Override
	public void serialize() {

	}

	@Override
	public void deserialize() {

	}

	@Override
	public ResourceType resourceType() {
		return ResourceType.EQUIP;
	}
}
