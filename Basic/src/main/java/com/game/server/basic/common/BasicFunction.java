package com.game.server.basic.common;

import com.game.server.basic.common.cfg.resource.ResourceManager;
import org.qiunet.function.attr.enums.IAttrEnum;
import org.qiunet.function.base.IResourceCfg;
import org.qiunet.function.base.basic.IBasicFunction;

/***
 * 基础功能提供
 *
 * @author qiunet
 * 2021-01-06 15:54
 */
public class BasicFunction implements IBasicFunction {

	@Override
	public <Type extends Enum<Type> & IAttrEnum<Type>> Type parse(String attrName) {
		return null;
	}

	@Override
	public <T extends IResourceCfg> T getResById(int cfgId) {
		return ResourceManager.getInstance().getResourceCfg(cfgId);
	}
}
