package com.game.server.basic.id.person.entity;

import org.apache.ibatis.type.Alias;
import org.qiunet.data.cache.entity.CacheEntityList;
import org.qiunet.data.core.support.db.Column;
import org.qiunet.data.core.support.db.Table;
/**
* , comment="个人相关的id生成表"*
* 对象为自动创建 不要修改
*/
@Alias("IdBuilderDo")
@Table(name = "id_builder", comment="个人相关的id生成表")
public class IdBuilderDo extends CacheEntityList<Long, Integer, IdBuilderBo> {
	@Column(comment = "玩家id", isKey = true)
	private long playerId;
	@Column(comment = "类型", isKey = true)
	private int type;
	@Column(comment = "当前的id值")
	private int idVal;

	/**默认的构造函数**/
	public IdBuilderDo(){}
	public IdBuilderDo(long playerId,int type){
		this.playerId = playerId;
		this.type = type;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getIdVal() {
		return idVal;
	}

	public void setIdVal(int idVal) {
		this.idVal = idVal;
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
		return type;
	}

	@Override
	public String subKeyFieldName() {
		return "type";
	}
}
