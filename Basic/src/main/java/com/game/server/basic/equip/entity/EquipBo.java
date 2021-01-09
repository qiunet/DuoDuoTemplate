package com.game.server.basic.equip.entity;

import org.qiunet.data.support.IEntityBo;
import org.qiunet.function.reward.IRealReward;

public class EquipBo implements IEntityBo<EquipDo>, IRealReward {
	private final EquipDo aDo;

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
	public int getCfgId() {
		return getDo().getEquipId();
	}
}
