package com.game.template.basic.login;

import org.qiunet.data.support.CacheDataSupport;

import com.game.template.basic.login.entity.LoginBo;
import com.game.template.basic.login.entity.LoginDo;

public enum LoginService {
	instance;
	private static CacheDataSupport<String, LoginDo, LoginBo> dataSupport = new CacheDataSupport<>(LoginDo.class, LoginBo::new);
	/***
	* 获得一个 LoginBo 对象
	* @param openId 获取对象的主键
	* @return LoginBo 对象
	*/
	public LoginBo getLoginBo(String openId) {
		return dataSupport.getBo(openId);
	}
}
