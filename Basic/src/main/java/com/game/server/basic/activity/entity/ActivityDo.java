package com.game.server.basic.activity.entity;

import org.apache.ibatis.type.Alias;
import org.qiunet.data.cache.entity.CacheEntity;
import org.qiunet.data.core.support.db.Column;
import org.qiunet.data.core.support.db.Table;
/**
* *
* 对象为自动创建 不要修改
*/
@Alias("ActivityDo")
@Table(name = "activity")
public class ActivityDo extends CacheEntity<Integer, ActivityBo> {
	@Column(comment = "活动配置id", isKey = true)
	private int activity_id;
	@Column(comment = "状态")
	private int status;
	@Column(comment = "开始时间.")
	private long start_dt;
	@Column(comment = "结束时间.")
	private long end_dt;
	@Column(comment = "开启次数")
	private int open_times;
	@Column(comment = "最后的结束时间. 用来判断是否可以重开活动")
	private long last_end_dt;

	/**默认的构造函数**/
	public ActivityDo(){}
	public ActivityDo(int activity_id){
		this.activity_id = activity_id;
	}

	public int getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(int activity_id) {
		this.activity_id = activity_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getStart_dt() {
		return start_dt;
	}

	public void setStart_dt(long start_dt) {
		this.start_dt = start_dt;
	}

	public long getEnd_dt() {
		return end_dt;
	}

	public void setEnd_dt(long end_dt) {
		this.end_dt = end_dt;
	}

	public int getOpen_times() {
		return open_times;
	}

	public void setOpen_times(int open_times) {
		this.open_times = open_times;
	}

	public long getLast_end_dt() {
		return last_end_dt;
	}

	public void setLast_end_dt(long last_end_dt) {
		this.last_end_dt = last_end_dt;
	}

	@Override
	public Integer key() {
		return activity_id;
	}

	@Override
	public String keyFieldName() {
		return "activity_id";
	}
}
