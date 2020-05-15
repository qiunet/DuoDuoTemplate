package com.game.template.basic.commondata.entity;

import org.apache.ibatis.type.Alias;
import org.qiunet.data.cache.entity.CacheEntityList;
import org.qiunet.data.core.enums.ColumnJdbcType;
import org.qiunet.data.core.support.db.Column;
import org.qiunet.data.core.support.db.Table;
/**
* *
* 对象为自动创建 不要修改
*/
@Alias("CommonDataDo")
@Table(name = "common_data", defaultDb = true)
public class CommonDataDo extends CacheEntityList<Long, Integer, CommonDataBo> {
	@Column(comment = "玩家id", isKey = true)
	private long playerId;
	@Column(comment = "类型", isKey = true)
	private int type;
	@Column(comment = "最后的更新时间(秒)")
	private int updateTime;
	@Column(comment = "内容(可能json  数字 等等)", jdbcType = ColumnJdbcType.LONGTEXT)
	private String value;

	/**默认的构造函数**/
	public CommonDataDo(){}

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

	public int getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(int updateTime) {
		this.updateTime = updateTime;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
