package com.game.template.basic.equip.entity;

import org.qiunet.data.core.support.db.Table;
import org.qiunet.data.core.support.db.Column;
import org.apache.ibatis.type.Alias;
import org.qiunet.data.cache.entity.CacheEntityList;
/**
* *
* 对象为自动创建 不要修改
*/
@Alias("EquipDo")
@Table(name = "equip", defaultDb = true)
public class EquipDo extends CacheEntityList<Integer, Integer, EquipBo> {
	@Column(comment = "装备唯一id", isKey = true)
	private int id;
	@Column(comment = "装备配置id", isKey = true)
	private int equipId;
	@Column(comment = "玩家id")
	private long playerId;
	@Column(comment = "装备位置 背包或那个系统")
	private int pos;
	@Column(comment = "装备获得时间")
	private long gainTime;

	/**默认的构造函数**/
	public EquipDo(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEquipId() {
		return equipId;
	}

	public void setEquipId(int equipId) {
		this.equipId = equipId;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public long getGainTime() {
		return gainTime;
	}

	public void setGainTime(long gainTime) {
		this.gainTime = gainTime;
	}

	@Override
	public Integer key() {
		return id;
	}

	@Override
	public String keyFieldName() {
		return "id";
	}

	@Override
	public Integer subKey() {
		return equipId;
	}

	@Override
	public String subKeyFieldName() {
		return "equipId";
	}
}
