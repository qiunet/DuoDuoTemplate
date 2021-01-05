package com.game.server.basic.equip;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.enums.OperationType;
import com.game.server.basic.equip.entity.EquipBo;
import com.game.server.basic.equip.entity.EquipDo;
import com.game.server.basic.equip.log.EquipAddLogEvent;
import com.game.server.basic.equip.log.EquipDelLogEvent;
import com.game.server.basic.id.enums.IDType;
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

	public void addToPack(PlayerActor player, int resourceId, int num, OperationType type) {
		for (int i = 0; i < num; i++) {
			EquipDo equipDo = new EquipDo();
			equipDo.setId(IDType.EQUIP.generatorId(player.getPlayerId()));
			equipDo.setPlayerId(player.getPlayerId());
			equipDo.setGainTime(DateUtil.currSeconds());
			equipDo.setEquipId(resourceId);
			EquipBo equipBo = equipDo.insert();

			new EquipAddLogEvent(player, equipDo.getId(), resourceId, type).send();
		}
	}

	/**
	 * 删除单个装备
	 * @param player
	 * @param equip
	 * @param operationType
	 */
	public void deleteEquip(PlayerActor player, EquipBo equip, OperationType operationType) {
		equip.delete();

		new EquipDelLogEvent(player, equip.getDo().getId(), equip.getDo().getEquipId(), operationType).send();
	}

	/**
	 * 删除指定的装备列表
	 * @param player
	 * @param equipList
	 * @param operationType
	 */
	public void deleteEquips(PlayerActor player, List<EquipBo> equipList, OperationType operationType) {
		equipList.forEach(equip -> deleteEquip(player, equip, operationType));
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
