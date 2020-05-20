package com.game.server.basic.common.log;

import org.qiunet.event.log.enums.RecordModel;
import org.qiunet.event.log.enums.base.IEventLogType;

/***
 * 日志类型
 *
 * @author qiunet
 * 2020-04-17 07:31
 **/
public enum  LogType implements IEventLogType {
	/**登录日志**/
	LOGIN,

	/**登出日志 */
	LOGOUT,

	/**物品日志*/
	ITEM,

	/**装备日志*/
	EQUIP,

	/**普通货币日志**/
	M1,

	/**人民币代币日志**/
	M2,
	/***
	 * 一般数据资源
	 */
	COMMON_DATA_RESOURCE,
	;

	@Override
	public String getLoggerName() {
		return name().toLowerCase();
	}

	@Override
	public RecordModel recordModel() {
		return RecordModel.LOCAL;
	}
}
