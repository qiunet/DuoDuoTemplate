package com.game.template.basic.commondata;

import com.game.template.basic.commondata.entity.CommonDataBo;
import com.game.template.basic.commondata.entity.CommonDataDo;
import org.qiunet.data.support.CacheDataListSupport;

import java.util.Map;

public enum CommonDataService {
	instance;
	private static CacheDataListSupport<Long, Integer, CommonDataDo, CommonDataBo> dataSupport = new CacheDataListSupport<>(CommonDataDo.class, CommonDataBo::new);

	/***
	 * 获得一个 playerId -> CommonDataBo Map对象
	 * @param playerId 获取对象的主键
	 * @return CommonDataBo map对象
	 **/
	public Map<Integer, CommonDataBo> getCommonDataBoMap(Long playerId) {
		return dataSupport.getBoMap(playerId);
	}
	/***
	* 获得一个 type -> CommonDataBo  的bo对象
	* @param playerId 获取对象的主键
	* @param type 获取对象的次主键
	* @return CommonDataBo bo对象
	**/
	public CommonDataBo getCommonDataBo(Long playerId, Integer type) {
		return getCommonDataBoMap(playerId).get(type);
	}
}
