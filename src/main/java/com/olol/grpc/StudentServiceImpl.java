package com.olol.grpc;

import com.olol.proto.*;
import io.grpc.stub.StreamObserver;

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {
    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("received client info: " + request.getUsername());

        responseObserver.onNext(MyResponse.newBuilder().setRealname("haha").build());
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("received client info: " + request.getAge());

        responseObserver.onNext(StudentResponse.newBuilder().setName("zhangsan").setAge(20).setCity("Beijing").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("lisi").setAge(30).setCity("Shanghai").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("wangwu").setAge(40).setCity("tianjing").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("zhaoliu").setAge(50).setCity("chengdu").build());
    }
}
