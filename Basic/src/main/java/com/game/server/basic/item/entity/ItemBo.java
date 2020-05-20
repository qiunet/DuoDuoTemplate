package com.game.server.basic.item.entity;

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

	public int getItemId(){
		return getDo().getItemId();
	}

	public int getCount(){
		return getDo().getCount();
	}

	@Override
	public void serialize() {

	}

	@Override
	public void deserialize() {

	}
}
