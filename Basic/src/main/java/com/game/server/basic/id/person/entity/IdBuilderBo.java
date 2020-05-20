package com.game.server.basic.id.person.entity;

import org.qiunet.data.support.IEntityBo;

import java.util.concurrent.atomic.AtomicInteger;

public class IdBuilderBo implements IEntityBo<IdBuilderDo>{
	private IdBuilderDo aDo;
	private AtomicInteger generator;

	public IdBuilderBo (IdBuilderDo aDo) {
		this.aDo = aDo;
		this.deserialize();
	}

	public IdBuilderDo getDo(){
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
