package com.game.template.basic.id.global.entity;

import org.apache.ibatis.type.Alias;
import org.qiunet.data.cache.entity.CacheEntity;
import org.qiunet.data.core.support.db.Column;
import org.qiunet.data.core.support.db.Table;
/**
* , comment="存储服务器相关的信息.比如开服时间等"*
* 对象为自动创建 不要修改
*/
@Alias("ServerInfoDo")
@Table(name = "server_info", comment="存储服务器相关的信息.比如开服时间等", defaultDb = true)
public class ServerInfoDo extends CacheEntity<String, ServerInfoBo> {
	@Column(comment = "类型", isKey = true)
	private String type;
	@Column(comment = "值")
	private String data;

	/**默认的构造函数**/
	public ServerInfoDo(){}
	public ServerInfoDo(String type){
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String key() {
		return type;
	}

	@Override
	public String keyFieldName() {
		return "type";
	}
}
