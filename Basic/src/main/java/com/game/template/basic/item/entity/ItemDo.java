package com.game.template.basic.item.entity;

import org.qiunet.data.core.support.db.Table;
import org.qiunet.data.core.support.db.Column;
import org.apache.ibatis.type.Alias;
import org.qiunet.data.cache.entity.CacheEntityList;
/**
* *
* 对象为自动创建 不要修改
*/
@Alias("ItemDo")
@Table(name = "item", defaultDb = true)
public class ItemDo extends CacheEntityList<Long, Integer, ItemBo> {
	@Column(comment = "玩家id", isKey = true)
	private long playerId;
	@Column(comment = "物品id", isKey = true)
	private int itemId;
	@Column(comment = "数量")
	private int count;

	/**默认的构造函数**/
	public ItemDo(){}
	public ItemDo(long playerId,int itemId){
		this.playerId = playerId;
		this.itemId = itemId;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public Long key() {
		return playerId;
	}

	@Override
	public String keyFieldName() {
		return "playerId";
	}

	@Override
	public Integer subKey() {
		return itemId;
	}

	@Override
	public String subKeyFieldName() {
		return "itemId";
	}
}
