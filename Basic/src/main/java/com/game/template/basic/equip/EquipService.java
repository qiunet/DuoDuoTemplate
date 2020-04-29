package com.game.template.basic.equip;

import com.game.template.basic.common.actor.PlayerActor;
import com.game.template.basic.common.data.result.IRewardResult;
import com.game.template.basic.common.enums.OperationType;
import com.game.template.basic.equip.entity.EquipBo;
import com.game.template.basic.equip.entity.EquipDo;
import com.game.template.basic.id.enums.IDType;
import com.google.common.collect.Lists;
import org.qiunet.data.support.CacheDataListSupport;
import org.qiunet.utils.date.DateUtil;

import java.util.List;
import java.util.Map;

public enum EquipService {
	instance;
	private static CacheDataListSupport<Long, Integer, EquipDo, EquipBo> dataSupport = new CacheDataListSupport<>(EquipDo.class, EquipBo::new);

	/***
	 * 获得一个 id -> EquipBo Map对象
	 * @param playerId 获取对象的主键
	 * @return EquipBo map对象
	 **/
	public Map<Integer, EquipBo> getEquipBoMap(Long playerId) {
		return dataSupport.getBoMap(playerId);
	}
	/***
	* 获得一个 equipId -> EquipBo  的bo对象
	* @param playerId 获取对象的主键
	* @param id 获取对象的次主键
	* @return EquipBo bo对象
	**/
	public EquipBo getEquipBo(Long playerId, Integer id) {
		return getEquipBoMap(playerId).get(id);
	}

	public List<IRewardResult> addToPack(PlayerActor player, int resourceId, int num, OperationType type) {
		List<IRewardResult> list = Lists.newArrayListWithCapacity(num);
		for (int i = 0; i < num; i++) {
			EquipDo equipDo = new EquipDo();
			equipDo.setId(IDType.EQUIP.generatorId(player.getPlayerId()));
			equipDo.setPlayerId(player.getPlayerId());
			equipDo.setGainTime(DateUtil.currSeconds());
			equipDo.setEquipId(resourceId);
			EquipBo equipBo = equipDo.insert();
			list.add(equipBo);
		}
		//TODO 日志
		return list;
	}

	/**
	 * 删除单个装备
	 * @param player
	 * @param equip
	 * @param operationType
	 */
	public void deleteEquip(PlayerActor player, EquipBo equip, OperationType operationType) {

	}

	/**
	 * 删除指定的装备列表
	 * @param player
	 * @param equipList
	 * @param operationType
	 */
	public void deleteEquips(PlayerActor player, List<EquipBo> equipList, OperationType operationType) {

	}

	/**
	 * 通过resourceId 删除指定数量的装备
	 * @param player
	 * @param resourceId
	 * @param num
	 * @param operationType
	 */
	public void deductFromPack(PlayerActor player, int resourceId, int num, OperationType operationType) {
		// 删除装备一般是通过唯一id删除.
	}
}
