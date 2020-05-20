package com.game.server.basic.id.person;

import com.game.server.basic.id.person.entity.IdBuilderBo;
import com.game.server.basic.id.person.entity.IdBuilderDo;
import org.qiunet.data.support.CacheDataListSupport;

import java.util.Map;

public enum IdBuilderService {
	instance;
	private static CacheDataListSupport<Long, Integer, IdBuilderDo, IdBuilderBo> dataSupport = new CacheDataListSupport<>(IdBuilderDo.class, IdBuilderBo::new);

	/***
	 * 获得一个 playerId -> IdBuilderBo Map对象
	 * @param playerId 获取对象的主键
	 * @return IdBuilderBo map对象
	 **/
	public Map<Integer, IdBuilderBo> getIdBuilderBoMap(Long playerId) {
		return dataSupport.getBoMap(playerId);
	}
	/***
	* 获得一个 type -> IdBuilderBo  的bo对象
	* @param playerId 获取对象的主键
	* @param type 获取对象的次主键
	* @return IdBuilderBo bo对象
	**/
	public int getIdBuilderBo(Long playerId, Integer type) {
		IdBuilderBo bo = getIdBuilderBoMap(playerId).get(type);
		if (bo == null) {
			IdBuilderDo ado = new IdBuilderDo(playerId, type);
			bo = ado.insert();
		}
		return bo.generatorId();
	}
}
