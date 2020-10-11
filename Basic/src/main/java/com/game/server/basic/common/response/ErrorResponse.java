package com.game.server.basic.common.response;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.server.basic.common.contants.ProtocolId;
import org.qiunet.flash.handler.context.request.data.pb.IpbResponseData;
import org.qiunet.flash.handler.context.request.data.pb.PbResponse;

/***
 *
 * @author qiunet
 * 2020-09-26 11:20
 **/
@ProtobufClass(description = "业务逻辑错误下行")
@PbResponse(ProtocolId.Login.PROTOCOL_ERROR)
public class ErrorResponse implements IpbResponseData {
	@Protobuf(description = "状态码")
	private int status;
	@Protobuf(description = "描述")
	private String desc;

	public static ErrorResponse valueOf(int status, String desc) {
		ErrorResponse response = new ErrorResponse();
		response.status = status;
		response.desc = desc;
		return response;
	}

	public int getStatus() {
		return status;
	}

	public String getDesc() {
		return desc;
	}
}
