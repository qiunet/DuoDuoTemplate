package com.game.template.basic.id.global.entity;

import org.qiunet.data.core.support.db.Table;
import org.qiunet.data.core.support.db.Column;
import org.apache.ibatis.type.Alias;
import org.qiunet.data.cache.entity.CacheEntity;
/**
* , comment="全局id生成表"*
* 对象为自动创建 不要修改
*/
@Alias("GlobalIdBuilderDo")
@Table(name = "global_id_builder", comment="全局id生成表", defaultDb = true)
public class GlobalIdBuilderDo extends CacheEntity<Integer, GlobalIdBuilderBo> {
	@Column(comment = "类型", isKey = true)
	private int type;
	@Column(comment = "id值")
	private int idVal;

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

	public int getIdVal() {
		return idVal;
	}

	public void setIdVal(int idVal) {
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
