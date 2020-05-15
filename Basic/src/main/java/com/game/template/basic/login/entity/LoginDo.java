package com.game.template.basic.login.entity;

import org.apache.ibatis.type.Alias;
import org.qiunet.data.cache.entity.CacheEntity;
import org.qiunet.data.core.support.db.Column;
import org.qiunet.data.core.support.db.Table;
/**
* *
* 对象为自动创建 不要修改
*/
@Alias("LoginDo")
@Table(name = "login", defaultDb = true)
public class LoginDo extends CacheEntity<String, LoginBo> {
	@Column(comment = "玩家openId account", isKey = true)
	private String openId;
	@Column(comment = "玩家id")
	private long playerId;
	@Column(comment = "平台token")
	private String token;

	/**默认的构造函数**/
	public LoginDo(){}
	public LoginDo(String openId){
		this.openId = openId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String key() {
		return openId;
	}

	@Override
	public String keyFieldName() {
		return "openId";
	}
}
