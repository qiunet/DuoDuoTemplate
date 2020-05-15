package com.game.template.basic.commondata.setting;

import com.game.template.basic.commondata.enums._CDataType;

import java.util.function.Supplier;

/***
 *
 * @author qiunet
 * 2020-05-15 22:58
 **/
abstract class BaseCommonDataSettingBuilder<T extends BaseCommonDataSettingBuilder> {

	private Supplier<String> defaultVal;

	private _CDataType cDataType;

	private boolean dailyClean;

	BaseCommonDataSettingBuilder(_CDataType cDataType, Supplier<String> defaultVal) {
		this.cDataType = cDataType;
		this.defaultVal = defaultVal;
	}

	public T setDailyClean(boolean dailyClean) {
		this.dailyClean = dailyClean;
		return (T) this;
	}

	public T setDefaultVal(Supplier<String> defaultVal) {
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
