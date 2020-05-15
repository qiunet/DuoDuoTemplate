package com.game.template.basic.commondata.entity;

import com.game.template.basic.commondata.enums.CommonDataType;
import com.game.template.basic.commondata.enums._CDataType;
import org.qiunet.data.support.IEntityBo;
import org.qiunet.utils.date.DateUtil;


public class CommonDataBo implements IEntityBo<CommonDataDo>{
	private Object val;
	private CommonDataDo aDo;
	private _CDataType cDataType;
	private CommonDataType commonDataType;


	public CommonDataBo (CommonDataDo aDo) {
		this.aDo = aDo;
		this.deserialize();
	}

	public void setVal(Object val) {
		this.val = val;
	}

	public Object getObject() {
		if (this.val != null) {
			return this.val;
		}

		return this.val = cDataType.getVal(this);
	}

	public CommonDataDo getDo(){
		return aDo;
	}

	@Override
	public void serialize() {
		if (cDataType != null) {
			cDataType.writeVal(this);
		}
		aDo.setUpdateTime(DateUtil.currSeconds());
	}

	public CommonDataType getCommonDataType() {
		return commonDataType;
	}

	@Override
	public void deserialize() {
		this.commonDataType = CommonDataType.parse(aDo.getType());
		this.cDataType = _CDataType.valueOf(aDo.getCType());
		this.val = this.cDataType.getVal(this);
	}
}
