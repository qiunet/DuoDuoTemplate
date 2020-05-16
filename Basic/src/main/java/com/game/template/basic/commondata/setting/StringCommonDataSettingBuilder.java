package com.game.template.basic.commondata.setting;

import com.game.template.basic.commondata.enums._CDataType;

/***
 *
 *
 * @author qiunet
 * 2020-05-15 18:57
 ***/
public final class StringCommonDataSettingBuilder extends BaseCommonDataSettingBuilder<StringCommonDataSettingBuilder> {

	StringCommonDataSettingBuilder() {
		super(_CDataType.STRING, p->"");
	}

	@Override
	protected void build0(CommonDataSetting setting) {

	}
}
