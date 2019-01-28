package org.apache.rocketmq.wingle.netty.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * org.apache.rocketmq.wingle.netty.discard
 *
 * @author Wingle
 * @create 2018/12/14 8:20 PM
 **/
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("channel read");
        ((ByteBuf) msg).release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println("cause exception");
        cause.printStackTrace();
        ctx.close();
    }
}
