package com.olol.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int randomInt = new Random().nextInt(3);

        MyDataInfo.MyMessage myMessage;
        if (0 == randomInt) {
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.PersonType).setPerson
                (MyDataInfo.Person.newBuilder().setName("fatu").setAge(20).setAddress("BeiJing").build()).build();
        } else if (1 == randomInt) {
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.DogType).setDog(
                MyDataInfo.Dog.newBuilder().setName("dog").setAge(2).build()).build();
        } else {
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.CatType).setCat(
                MyDataInfo.Cat.newBuilder().setName("cat").setCity("Shanghai").build()).build();
        }

        ctx.channel().writeAndFlush(myMessage);
    }
}
