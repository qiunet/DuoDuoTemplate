package com.game.template.basic.equip;

import org.qiunet.data.support.CacheDataListSupport;
import java.util.Map;

import com.game.template.basic.equip.entity.EquipBo;
import com.game.template.basic.equip.entity.EquipDo;

public enum EquipService {
	instance;
	private static CacheDataListSupport<Integer, Integer, EquipDo, EquipBo> dataSupport = new CacheDataListSupport<>(EquipDo.class, EquipBo::new);

	/***
	 * 获得一个 id -> EquipBo Map对象
	 * @param id 获取对象的主键
	 * @return EquipBo map对象
	 **/
	public Map<Integer, EquipBo> getEquipBoMap(Integer id) {
		return dataSupport.getBoMap(id);
	}
	/***
	* 获得一个 equipId -> EquipBo  的bo对象
	* @param id 获取对象的主键
	* @param equipId 获取对象的次主键
	* @return EquipBo bo对象
	**/
	public EquipBo getEquipBo(Integer id, Integer equipId) {
		return getEquipBoMap(id).get(equipId);
	}
}
