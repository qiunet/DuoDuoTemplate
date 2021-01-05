package com.game.server.basic.item;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.enums.OperationType;
import com.game.server.basic.common.enums.ResOperationType;
import com.game.server.basic.item.entity.ItemBo;
import com.game.server.basic.item.entity.ItemDo;
import com.game.server.basic.item.log.ItemLogEvent;
import com.google.common.base.Preconditions;
import org.qiunet.data.support.CacheDataListSupport;

import java.util.List;
import java.util.Map;

public enum ItemService {
	instance;
	private static final CacheDataListSupport<Long, Integer, ItemDo, ItemBo> dataSupport = new CacheDataListSupport<>(ItemDo.class, ItemBo::new);

	/***
	 * 获得一个 playerId -> ItemBo Map对象
	 * @param playerId 获取对象的主键
	 * @return ItemBo map对象
	 **/
	public Map<Integer, ItemBo> getItemBoMap(Long playerId) {
		return dataSupport.getBoMap(playerId);
	}
	/***
	* 获得一个 itemId -> ItemBo  的bo对象
	* @param playerId 获取对象的主键
	* @param itemId 获取对象的次主键
	* @return ItemBo bo对象
	**/
	public ItemBo getItemBo(Long playerId, Integer itemId) {
		return getItemBoMap(playerId).get(itemId);
	}

	public void addToPack(PlayerActor player, int resourceId, int num, OperationType type) {
		ItemBo itemBo = getItemBo(player.getPlayerId(), resourceId);
		if (itemBo == null) {
			ItemDo itemDo = new ItemDo(player.getPlayerId(), resourceId);
			itemDo.setCount(num);
			itemBo = itemDo.insert();
		}else {
			if (itemBo.getCount() + (long)num > Integer.MAX_VALUE) {
				itemBo.getDo().setCount(Integer.MAX_VALUE);
			}else {
				itemBo.getDo().setCount(itemBo.getCount() + num);
			}
			itemBo.update();
		}
		new ItemLogEvent(player, resourceId, num, itemBo.getCount(), type, ResOperationType.ADD).send();
	}

	/**
	 * 获得物品资源的数量
	 * @param player
	 * @param resourceId
	 * @return
	 */
	public int getItemCount(PlayerActor player, int resourceId) {
		ItemBo itemBo = getItemBo(player.getPlayerId(), resourceId);
		if (itemBo == null) {
			return 0;
		}
		return itemBo.getCount();
	}

	/**
	 * 从背包扣减物品
	 * @param player
	 * @param resourceId
	 * @param num
	 * @param operationType
	 */
	public void deductFromPack(PlayerActor player, int resourceId, int num, OperationType operationType) {
		ItemBo itemBo = getItemBo(player.getPlayerId(), resourceId);

		Preconditions.checkArgument(itemBo.getCount() >= num, "itemCount %s, num %s", itemBo.getCount(), num);
		itemBo.getDo().setCount(itemBo.getCount() - num);
		if (itemBo.getCount() <= 0) {
			itemBo.delete();
		}else {
			itemBo.update();
		}
		new ItemLogEvent(player, resourceId, num, itemBo.getCount(), operationType, ResOperationType.DEDUCT).send();
	}
}
