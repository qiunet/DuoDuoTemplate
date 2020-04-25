package com.game.template.basic.id.global.entity;

import org.qiunet.data.support.IEntityBo;

import java.util.concurrent.atomic.AtomicInteger;

public class GlobalIdBuilderBo implements IEntityBo<GlobalIdBuilderDo>{
	private GlobalIdBuilderDo aDo;

	private AtomicInteger generator;

	public GlobalIdBuilderBo (GlobalIdBuilderDo aDo) {
		this.aDo = aDo;
		this.deserialize();
	}

	public GlobalIdBuilderDo getDo(){
		return aDo;
	}

	@Override
	public void serialize() {

	}

	public int generatorId(){
		int id = generator.incrementAndGet();
		aDo.setIdVal(id);
		this.update();
		return id;
	}

	@Override
	public void deserialize() {
		this.generator = new AtomicInteger(aDo.getIdVal());
	}
}
