package com.game.server.basic.activity.cfgs;

import com.game.server.basic.activity.cfgs.ActivityDataCfg;
import com.game.server.basic.activity.time.AbsoluteTimeStrategyHandler;
import com.game.server.basic.activity.time.CronTimeStrategyHandler;
import com.game.server.basic.activity.time.ITimeStrategyHandler;
import com.game.server.basic.activity.time.OpenServerDayTimeStrategyHandler;
import org.qiunet.utils.json.JsonUtil;

/***
 * 时间策略
 *
 * @author qiunet
 * 2021-01-25 16:10
 */
public enum TimeStrategy {
	/**
	 * 绝对时间
	 */
	ABSOLUTE {
		@Override
		public ITimeStrategyHandler convertToHandler(ActivityDataCfg cfg, String timeStrategyValue) {
			AbsoluteTimeStrategyHandler obj = JsonUtil.getGeneralObjWithField(timeStrategyValue, AbsoluteTimeStrategyHandler.class);
			((BaseTimeStrategyHandler) obj).init(cfg);
			return obj;
		}
	},
	/**
	 * 定时器
	 */
	CRON {
		@Override
		public ITimeStrategyHandler convertToHandler(ActivityDataCfg cfg, String timeStrategyValue) {
			CronTimeStrategyHandler obj = JsonUtil.getGeneralObjWithField(timeStrategyValue, CronTimeStrategyHandler.class);
			((BaseTimeStrategyHandler) obj).init(cfg);
			return obj;
		}
	},
	/**
	 * 开服天数
	 */
	OPEN_SERVER_DAY {
		@Override
		public ITimeStrategyHandler convertToHandler(ActivityDataCfg cfg, String timeStrategyValue) {
			OpenServerDayTimeStrategyHandler obj = JsonUtil.getGeneralObjWithField(timeStrategyValue, OpenServerDayTimeStrategyHandler.class);
			((BaseTimeStrategyHandler) obj).init(cfg);
			return obj;
		}
	},
	;

	/**
	 * 转换为 ITimeStrategyHandler
	 * @return
	 */
	public abstract ITimeStrategyHandler convertToHandler(ActivityDataCfg cfg, String timeStrategyValue);
}
