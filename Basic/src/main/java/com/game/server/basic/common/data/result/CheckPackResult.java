package com.game.server.basic.common.data.result;

/***
 *
 *
 * @author qiunet
 * 2020-05-14 16:57
 ***/
public enum CheckPackResult {
	/**
	 * 成功
	 */
	SUCCESS,
	/**
	 * 背包空间不足
	 */
	PACK_SPACE_LACK,
	;

	/**
	 * 是否成功. 可以往下执行
	 * @return
	 */
	public boolean isSuccess(){
		return this == SUCCESS;
	}

	public boolean isFail(){
		return ! isSuccess();
	}
}
