package com.game.server.basic.commondata.setting;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.commondata.enums._CDataType;
import org.qiunet.utils.common.functional.DSupplier1;

/***
 *
 * @author qiunet
 * 2020-05-15 22:58
 **/
abstract class BaseCommonDataSettingBuilder<T extends BaseCommonDataSettingBuilder> {

	private DSupplier1<PlayerActor, String> defaultVal;

	private _CDataType cDataType;

	private boolean dailyClean;

	BaseCommonDataSettingBuilder(_CDataType cDataType, DSupplier1<PlayerActor, String> defaultVal) {
		this.cDataType = cDataType;
		this.defaultVal = defaultVal;
	}

	public T setDailyClean(boolean dailyClean) {
		this.dailyClean = dailyClean;
		return (T) this;
	}

	public T setDefaultVal(DSupplier1<PlayerActor, String> defaultVal) {
		this.defaultVal = defaultVal;
		return (T)this;
	}

	public CommonDataSetting build(){
		CommonDataSetting setting = new CommonDataSetting(defaultVal, cDataType, dailyClean);
		this.build0(setting);
		return setting;
	}

	protected abstract void build0(CommonDataSetting setting);
}
