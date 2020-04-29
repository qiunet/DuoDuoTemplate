package com.game.template.basic.id.global;

import com.game.template.basic.id.global.entity.GlobalIdBuilderBo;
import com.game.template.basic.id.global.entity.GlobalIdBuilderDo;
import com.google.common.collect.Maps;
import org.qiunet.data.support.CacheDataSupport;

import java.util.concurrent.ConcurrentMap;

public enum GlobalIdBuilderService {
	instance;
	private static CacheDataSupport<Integer, GlobalIdBuilderDo, GlobalIdBuilderBo> dataSupport = new CacheDataSupport<>(GlobalIdBuilderDo.class, GlobalIdBuilderBo::new);

	private ConcurrentMap<Integer, GlobalIdBuilderBo> boMaps = Maps.newConcurrentMap();
	/***
	* 获得一个 GlobalIdBuilderBo 对象
	* @param type 获取对象的主键
	* @return GlobalIdBuilderBo 对象
	*/
	public long getGlobalIdBuilderBo(int type) {
		GlobalIdBuilderBo bo = boMaps.computeIfAbsent(type, key -> {
			GlobalIdBuilderBo bo0 = dataSupport.getBo(type);
			if (bo0 == null) {
				GlobalIdBuilderDo aDo = new GlobalIdBuilderDo(type);
				bo0 = aDo.insert();
			}
			return bo0;
		});
		return bo.generatorId();
	}

}
