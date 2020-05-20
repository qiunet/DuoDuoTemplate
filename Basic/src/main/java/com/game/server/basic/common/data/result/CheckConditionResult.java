package com.game.server.basic.common.data.result;

/***
 *
 *
 * @author qiunet
 * 2020-05-14 16:57
 ***/
public enum CheckConditionResult {
	/**
	 * 成功
	 */
	SUCCESS,
	/**
	 * 物品数量不足
	 */
	ITEM_LACK,
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
