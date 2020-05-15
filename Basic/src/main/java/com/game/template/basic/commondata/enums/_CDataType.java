package com.game.template.basic.commondata.enums;

import com.game.template.basic.commondata.entity.CommonDataBo;
import org.qiunet.utils.json.JsonUtil;
import org.qiunet.utils.string.StringUtil;

/***
 * 一个不需要给外面的枚举.
 *
 * @author qiunet
 * 2020-05-15 15:09
 ***/
public enum _CDataType {

	STRING {
		@Override
		public Object getVal(CommonDataBo commonDataBo) {
			String value = commonDataBo.getDo().getValue();
			return value;
		}

		@Override
		public void writeVal(CommonDataBo commonDataBo) {
			commonDataBo.getDo().setValue((String) commonDataBo.getObject());
		}

		@Override
		public boolean regexMatch(String initVal) {
			return true;
		}
	},

	INT {
		@Override
		public Object getVal(CommonDataBo commonDataBo) {
			String value = commonDataBo.getDo().getValue();
			return Integer.parseInt(value);
		}

		@Override
		public void writeVal(CommonDataBo commonDataBo) {
			commonDataBo.getDo().setValue(String.valueOf(commonDataBo.getObject()));
		}

		@Override
		public boolean regexMatch(String initVal) {
			return StringUtil.isNum(initVal);
		}
	},

	LONG {
		@Override
		public Object getVal(CommonDataBo commonDataBo) {
			String value = commonDataBo.getDo().getValue();
			return Long.parseLong(value);
		}

		@Override
		public void writeVal(CommonDataBo commonDataBo) {
			commonDataBo.getDo().setValue(String.valueOf(commonDataBo.getObject()));
		}

		@Override
		public boolean regexMatch(String initVal) {
			return StringUtil.isNum(initVal);
		}
	},

	JSON {
		@Override
		public Object getVal(CommonDataBo commonDataBo) {
			String value = commonDataBo.getDo().getValue();
			CommonDataObj commonDataObj = JsonUtil.getGeneralObject(value, commonDataBo.getCommonDataType().getSetting().getClazz());
			commonDataObj.setCommonDataBo(commonDataBo);
			return commonDataObj;
		}

		@Override
		public void writeVal(CommonDataBo commonDataBo) {
			commonDataBo.getDo().setValue(JsonUtil.toJsonString(commonDataBo.getObject()));
		}

		@Override
		public boolean regexMatch(String initVal) {
			return initVal.startsWith("{") && initVal.endsWith("}");
		}
	},
	;

	public abstract Object getVal(CommonDataBo commonDataBo);

	public abstract void writeVal(CommonDataBo commonDataBo);

	public abstract boolean regexMatch(String initVal);
}
