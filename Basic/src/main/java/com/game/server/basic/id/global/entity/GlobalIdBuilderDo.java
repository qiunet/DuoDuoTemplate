package com.game.server.basic.id.global.entity;

import org.apache.ibatis.type.Alias;
import org.qiunet.data.cache.entity.CacheEntity;
import org.qiunet.data.core.support.db.Column;
import org.qiunet.data.core.support.db.Table;
/**
* , comment="全局id生成表"*
* 对象为自动创建 不要修改
*/
@Alias("GlobalIdBuilderDo")
@Table(name = "global_id_builder", comment="全局id生成表")
public class GlobalIdBuilderDo extends CacheEntity<Integer, GlobalIdBuilderBo> {
	@Column(comment = "类型", isKey = true)
	private int type;
	@Column(comment = "id值")
	private long idVal;

	/**默认的构造函数**/
	public GlobalIdBuilderDo(){}
	public GlobalIdBuilderDo(int type){
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public long getIdVal() {
		return idVal;
	}

	public void setIdVal(long idVal) {
		this.idVal = idVal;
	}

	@Override
	public Integer key() {
		return type;
	}

	@Override
	public String keyFieldName() {
		return "type";
	}
}
