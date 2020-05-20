package com.game.server.basic.equip.entity;

import org.apache.ibatis.type.Alias;
import org.qiunet.data.cache.entity.CacheEntityList;
import org.qiunet.data.core.support.db.Column;
import org.qiunet.data.core.support.db.Table;
/**
* *
* 对象为自动创建 不要修改
*/
@Alias("EquipDo")
@Table(name = "equip", defaultDb = true)
public class EquipDo extends CacheEntityList<Long, Integer, EquipBo> {
	@Column(comment = "玩家id", isKey = true)
	private long playerId;
	@Column(comment = "装备唯一id", isKey = true)
	private int id;
	@Column(comment = "装备配置id")
	private int equipId;
	@Column(comment = "装备位置 背包或那个系统")
	private int pos;
	@Column(comment = "装备获得时间")
	private long gainTime;

	/**默认的构造函数**/
	public EquipDo(){}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

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
	public Long key() {
		return playerId;
	}

	@Override
	public String keyFieldName() {
		return "playerId";
	}

	@Override
	public Integer subKey() {
		return id;
	}

	@Override
	public String subKeyFieldName() {
		return "id";
	}
}
