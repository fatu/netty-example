package com.olol.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

import javax.xml.crypto.Data;

public class ProtoBufTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        DataInfo.Student student = DataInfo.Student.newBuilder().setName("fatu").setAge(20).setAddress("BeiJing").build();

        byte[] student2ByteArray = student.toByteArray();

        DataInfo.Student student2 = DataInfo.Student.parseFrom(student2ByteArray);

        System.out.println(student2);

    }
}
