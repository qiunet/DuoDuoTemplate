package com.game.server.basic.common.message;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.server.basic.common.contants.ProtocolId;
import org.qiunet.flash.handler.context.request.data.pb.IpbResponseData;
import org.qiunet.flash.handler.context.request.data.pb.PbResponse;

/***
 *
 *
 * @author qiunet
 * 2020-09-25 16:59
 */
@PbResponse(ProtocolId.System.HANDLER_NOT_FIND)
@ProtobufClass(description = "没有处理protocolID的Handler错误")
public class HandlerNotFoundResponse implements IpbResponseData {
}
