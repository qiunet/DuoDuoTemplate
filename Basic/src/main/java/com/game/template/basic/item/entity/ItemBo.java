package com.game.template.basic.item.entity;

import org.qiunet.data.support.IEntityBo;

public class ItemBo implements IEntityBo<ItemDo>{
	private ItemDo aDo;

	public ItemBo (ItemDo aDo) {
		this.aDo = aDo;
		this.deserialize();
	}

	public ItemDo getDo(){
		return aDo;
	}

	@Override
	public void serialize() {

	}

	@Override
	public void deserialize() {

	}
}
