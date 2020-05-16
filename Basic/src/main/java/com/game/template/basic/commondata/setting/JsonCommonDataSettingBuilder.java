package com.game.template.basic.commondata.setting;

import com.game.template.basic.commondata.enums.CommonDataObj;
import com.game.template.basic.commondata.enums._CDataType;

/***
 *
 *
 * @author qiunet
 * 2020-05-15 18:57
 ***/
public final class JsonCommonDataSettingBuilder extends BaseCommonDataSettingBuilder<JsonCommonDataSettingBuilder> {

	private Class<? extends CommonDataObj> clazz;

	 JsonCommonDataSettingBuilder(Class<? extends CommonDataObj> clazz) {
		super(_CDataType.JSON, p->"{}");
		this.clazz = clazz;
	}

	@Override
	protected void build0(CommonDataSetting setting) {
		setting.clazz = clazz;
	}
}
