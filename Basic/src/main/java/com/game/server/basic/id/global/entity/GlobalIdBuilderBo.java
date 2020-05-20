package com.game.server.basic.id.global.entity;

import org.qiunet.data.support.IEntityBo;

import java.util.concurrent.atomic.AtomicLong;

public class GlobalIdBuilderBo implements IEntityBo<GlobalIdBuilderDo>{
	private GlobalIdBuilderDo aDo;

	private AtomicLong generator;

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

	public long generatorId(){
		long id = generator.incrementAndGet();
		aDo.setIdVal(id);
		this.update();
		return id;
	}

	@Override
	public void deserialize() {
		this.generator = new AtomicLong(aDo.getIdVal());
	}
}
