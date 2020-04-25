package com.game.template.basic.item;

import org.qiunet.data.support.CacheDataListSupport;
import java.util.Map;

import com.game.template.basic.item.entity.ItemBo;
import com.game.template.basic.item.entity.ItemDo;

public enum ItemService {
	instance;
	private static CacheDataListSupport<Long, Integer, ItemDo, ItemBo> dataSupport = new CacheDataListSupport<>(ItemDo.class, ItemBo::new);

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
}
