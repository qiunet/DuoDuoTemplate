package com.game.template.basic.player.entity;

import org.apache.ibatis.type.Alias;
import org.qiunet.data.cache.entity.CacheEntity;
import org.qiunet.data.core.support.db.Column;
import org.qiunet.data.core.support.db.Table;
/**
* *
* 对象为自动创建 不要修改
*/
@Alias("PlayerDo")
@Table(name = "player", defaultDb = true)
public class PlayerDo extends CacheEntity<Long, PlayerBo> {
	@Column(comment = "玩家id", isKey = true)
	private long playerId;
	@Column(comment = "玩家openId")
	private String openId;
	@Column(comment = "玩家名称")
	private String name;
	@Column(comment = "玩家经验")
	private long exp;
	@Column(comment = "玩家等级")
	private int level;
	@Column(comment = "玩家游戏货币")
	private long m1;
	@Column(comment = "玩家人民币代币")
	private long m2;

	/**默认的构造函数**/
	public PlayerDo(){}
	public PlayerDo(long playerId){
		this.playerId = playerId;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getExp() {
		return exp;
	}

	public void setExp(long exp) {
		this.exp = exp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public long getM1() {
		return m1;
	}

	public void setM1(long m1) {
		this.m1 = m1;
	}

	public long getM2() {
		return m2;
	}

	public void setM2(long m2) {
		this.m2 = m2;
	}

	@Override
	public Long key() {
		return playerId;
	}

	@Override
	public String keyFieldName() {
		return "playerId";
	}
}
