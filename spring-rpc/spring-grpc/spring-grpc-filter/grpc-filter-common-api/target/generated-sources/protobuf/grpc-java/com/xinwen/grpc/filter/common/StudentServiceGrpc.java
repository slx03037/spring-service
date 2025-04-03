package com.xinwen.grpc.filter.common;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 *我们定义的跨平台方法都写在service中，我们定义两个方法addStudent标识添加一位学生，参数是一个Student对象，返回值则是刚刚添加成功的学生ID
 *getStudent标识根据ID查询一个商品，参数是一个学生ID，饭返回值则是查询到商品对象，这里的定义相当于一个接口，将来我们要在java代码中实现这个接口
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.0)",
    comments = "Source: student.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StudentServiceGrpc {

  private StudentServiceGrpc() {}

  public static final String SERVICE_NAME = "student.StudentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.xinwen.grpc.filter.common.Student,
      com.xinwen.grpc.filter.common.StudentId> getAddStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addStudent",
      requestType = com.xinwen.grpc.filter.common.Student.class,
      responseType = com.xinwen.grpc.filter.common.StudentId.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.xinwen.grpc.filter.common.Student,
      com.xinwen.grpc.filter.common.StudentId> getAddStudentMethod() {
    io.grpc.MethodDescriptor<com.xinwen.grpc.filter.common.Student, com.xinwen.grpc.filter.common.StudentId> getAddStudentMethod;
    if ((getAddStudentMethod = StudentServiceGrpc.getAddStudentMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getAddStudentMethod = StudentServiceGrpc.getAddStudentMethod) == null) {
          StudentServiceGrpc.getAddStudentMethod = getAddStudentMethod =
              io.grpc.MethodDescriptor.<com.xinwen.grpc.filter.common.Student, com.xinwen.grpc.filter.common.StudentId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.xinwen.grpc.filter.common.Student.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.xinwen.grpc.filter.common.StudentId.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("addStudent"))
              .build();
        }
      }
    }
    return getAddStudentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.xinwen.grpc.filter.common.Student,
      com.xinwen.grpc.filter.common.Student> getGetStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getStudent",
      requestType = com.xinwen.grpc.filter.common.Student.class,
      responseType = com.xinwen.grpc.filter.common.Student.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.xinwen.grpc.filter.common.Student,
      com.xinwen.grpc.filter.common.Student> getGetStudentMethod() {
    io.grpc.MethodDescriptor<com.xinwen.grpc.filter.common.Student, com.xinwen.grpc.filter.common.Student> getGetStudentMethod;
    if ((getGetStudentMethod = StudentServiceGrpc.getGetStudentMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStudentMethod = StudentServiceGrpc.getGetStudentMethod) == null) {
          StudentServiceGrpc.getGetStudentMethod = getGetStudentMethod =
              io.grpc.MethodDescriptor.<com.xinwen.grpc.filter.common.Student, com.xinwen.grpc.filter.common.Student>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.xinwen.grpc.filter.common.Student.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.xinwen.grpc.filter.common.Student.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("getStudent"))
              .build();
        }
      }
    }
    return getGetStudentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.xinwen.grpc.filter.common.Student> getSearchBooksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "searchBooks",
      requestType = com.google.protobuf.StringValue.class,
      responseType = com.xinwen.grpc.filter.common.Student.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.xinwen.grpc.filter.common.Student> getSearchBooksMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, com.xinwen.grpc.filter.common.Student> getSearchBooksMethod;
    if ((getSearchBooksMethod = StudentServiceGrpc.getSearchBooksMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getSearchBooksMethod = StudentServiceGrpc.getSearchBooksMethod) == null) {
          StudentServiceGrpc.getSearchBooksMethod = getSearchBooksMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, com.xinwen.grpc.filter.common.Student>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "searchBooks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.xinwen.grpc.filter.common.Student.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("searchBooks"))
              .build();
        }
      }
    }
    return getSearchBooksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.xinwen.grpc.filter.common.Student,
      com.google.protobuf.StringValue> getUpdateStudentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateStudents",
      requestType = com.xinwen.grpc.filter.common.Student.class,
      responseType = com.google.protobuf.StringValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.xinwen.grpc.filter.common.Student,
      com.google.protobuf.StringValue> getUpdateStudentsMethod() {
    io.grpc.MethodDescriptor<com.xinwen.grpc.filter.common.Student, com.google.protobuf.StringValue> getUpdateStudentsMethod;
    if ((getUpdateStudentsMethod = StudentServiceGrpc.getUpdateStudentsMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getUpdateStudentsMethod = StudentServiceGrpc.getUpdateStudentsMethod) == null) {
          StudentServiceGrpc.getUpdateStudentsMethod = getUpdateStudentsMethod =
              io.grpc.MethodDescriptor.<com.xinwen.grpc.filter.common.Student, com.google.protobuf.StringValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateStudents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.xinwen.grpc.filter.common.Student.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("updateStudents"))
              .build();
        }
      }
    }
    return getUpdateStudentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.xinwen.grpc.filter.common.StudentSet> getProcessStudentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "processStudents",
      requestType = com.google.protobuf.StringValue.class,
      responseType = com.xinwen.grpc.filter.common.StudentSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.xinwen.grpc.filter.common.StudentSet> getProcessStudentsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, com.xinwen.grpc.filter.common.StudentSet> getProcessStudentsMethod;
    if ((getProcessStudentsMethod = StudentServiceGrpc.getProcessStudentsMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getProcessStudentsMethod = StudentServiceGrpc.getProcessStudentsMethod) == null) {
          StudentServiceGrpc.getProcessStudentsMethod = getProcessStudentsMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, com.xinwen.grpc.filter.common.StudentSet>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "processStudents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.xinwen.grpc.filter.common.StudentSet.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("processStudents"))
              .build();
        }
      }
    }
    return getProcessStudentsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StudentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceStub>() {
        @java.lang.Override
        public StudentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceStub(channel, callOptions);
        }
      };
    return StudentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StudentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceBlockingStub>() {
        @java.lang.Override
        public StudentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceBlockingStub(channel, callOptions);
        }
      };
    return StudentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StudentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceFutureStub>() {
        @java.lang.Override
        public StudentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceFutureStub(channel, callOptions);
        }
      };
    return StudentServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *我们定义的跨平台方法都写在service中，我们定义两个方法addStudent标识添加一位学生，参数是一个Student对象，返回值则是刚刚添加成功的学生ID
   *getStudent标识根据ID查询一个商品，参数是一个学生ID，饭返回值则是查询到商品对象，这里的定义相当于一个接口，将来我们要在java代码中实现这个接口
   * </pre>
   */
  public static abstract class StudentServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addStudent(com.xinwen.grpc.filter.common.Student request,
        io.grpc.stub.StreamObserver<com.xinwen.grpc.filter.common.StudentId> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddStudentMethod(), responseObserver);
    }

    /**
     */
    public void getStudent(com.xinwen.grpc.filter.common.Student request,
        io.grpc.stub.StreamObserver<com.xinwen.grpc.filter.common.Student> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetStudentMethod(), responseObserver);
    }

    /**
     */
    public void searchBooks(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.xinwen.grpc.filter.common.Student> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchBooksMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.xinwen.grpc.filter.common.Student> updateStudents(
        io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getUpdateStudentsMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> processStudents(
        io.grpc.stub.StreamObserver<com.xinwen.grpc.filter.common.StudentSet> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getProcessStudentsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddStudentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.xinwen.grpc.filter.common.Student,
                com.xinwen.grpc.filter.common.StudentId>(
                  this, METHODID_ADD_STUDENT)))
          .addMethod(
            getGetStudentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.xinwen.grpc.filter.common.Student,
                com.xinwen.grpc.filter.common.Student>(
                  this, METHODID_GET_STUDENT)))
          .addMethod(
            getSearchBooksMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.StringValue,
                com.xinwen.grpc.filter.common.Student>(
                  this, METHODID_SEARCH_BOOKS)))
          .addMethod(
            getUpdateStudentsMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                com.xinwen.grpc.filter.common.Student,
                com.google.protobuf.StringValue>(
                  this, METHODID_UPDATE_STUDENTS)))
          .addMethod(
            getProcessStudentsMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.google.protobuf.StringValue,
                com.xinwen.grpc.filter.common.StudentSet>(
                  this, METHODID_PROCESS_STUDENTS)))
          .build();
    }
  }

  /**
   * <pre>
   *我们定义的跨平台方法都写在service中，我们定义两个方法addStudent标识添加一位学生，参数是一个Student对象，返回值则是刚刚添加成功的学生ID
   *getStudent标识根据ID查询一个商品，参数是一个学生ID，饭返回值则是查询到商品对象，这里的定义相当于一个接口，将来我们要在java代码中实现这个接口
   * </pre>
   */
  public static final class StudentServiceStub extends io.grpc.stub.AbstractAsyncStub<StudentServiceStub> {
    private StudentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceStub(channel, callOptions);
    }

    /**
     */
    public void addStudent(com.xinwen.grpc.filter.common.Student request,
        io.grpc.stub.StreamObserver<com.xinwen.grpc.filter.common.StudentId> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddStudentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStudent(com.xinwen.grpc.filter.common.Student request,
        io.grpc.stub.StreamObserver<com.xinwen.grpc.filter.common.Student> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStudentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchBooks(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.xinwen.grpc.filter.common.Student> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSearchBooksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.xinwen.grpc.filter.common.Student> updateStudents(
        io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getUpdateStudentsMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> processStudents(
        io.grpc.stub.StreamObserver<com.xinwen.grpc.filter.common.StudentSet> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getProcessStudentsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *我们定义的跨平台方法都写在service中，我们定义两个方法addStudent标识添加一位学生，参数是一个Student对象，返回值则是刚刚添加成功的学生ID
   *getStudent标识根据ID查询一个商品，参数是一个学生ID，饭返回值则是查询到商品对象，这里的定义相当于一个接口，将来我们要在java代码中实现这个接口
   * </pre>
   */
  public static final class StudentServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<StudentServiceBlockingStub> {
    private StudentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.xinwen.grpc.filter.common.StudentId addStudent(com.xinwen.grpc.filter.common.Student request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddStudentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.xinwen.grpc.filter.common.Student getStudent(com.xinwen.grpc.filter.common.Student request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStudentMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.xinwen.grpc.filter.common.Student> searchBooks(
        com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSearchBooksMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *我们定义的跨平台方法都写在service中，我们定义两个方法addStudent标识添加一位学生，参数是一个Student对象，返回值则是刚刚添加成功的学生ID
   *getStudent标识根据ID查询一个商品，参数是一个学生ID，饭返回值则是查询到商品对象，这里的定义相当于一个接口，将来我们要在java代码中实现这个接口
   * </pre>
   */
  public static final class StudentServiceFutureStub extends io.grpc.stub.AbstractFutureStub<StudentServiceFutureStub> {
    private StudentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.xinwen.grpc.filter.common.StudentId> addStudent(
        com.xinwen.grpc.filter.common.Student request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddStudentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.xinwen.grpc.filter.common.Student> getStudent(
        com.xinwen.grpc.filter.common.Student request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStudentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_STUDENT = 0;
  private static final int METHODID_GET_STUDENT = 1;
  private static final int METHODID_SEARCH_BOOKS = 2;
  private static final int METHODID_UPDATE_STUDENTS = 3;
  private static final int METHODID_PROCESS_STUDENTS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StudentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StudentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_STUDENT:
          serviceImpl.addStudent((com.xinwen.grpc.filter.common.Student) request,
              (io.grpc.stub.StreamObserver<com.xinwen.grpc.filter.common.StudentId>) responseObserver);
          break;
        case METHODID_GET_STUDENT:
          serviceImpl.getStudent((com.xinwen.grpc.filter.common.Student) request,
              (io.grpc.stub.StreamObserver<com.xinwen.grpc.filter.common.Student>) responseObserver);
          break;
        case METHODID_SEARCH_BOOKS:
          serviceImpl.searchBooks((com.google.protobuf.StringValue) request,
              (io.grpc.stub.StreamObserver<com.xinwen.grpc.filter.common.Student>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPDATE_STUDENTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.updateStudents(
              (io.grpc.stub.StreamObserver<com.google.protobuf.StringValue>) responseObserver);
        case METHODID_PROCESS_STUDENTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.processStudents(
              (io.grpc.stub.StreamObserver<com.xinwen.grpc.filter.common.StudentSet>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StudentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.xinwen.grpc.filter.common.StudentOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StudentService");
    }
  }

  private static final class StudentServiceFileDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier {
    StudentServiceFileDescriptorSupplier() {}
  }

  private static final class StudentServiceMethodDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StudentServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StudentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StudentServiceFileDescriptorSupplier())
              .addMethod(getAddStudentMethod())
              .addMethod(getGetStudentMethod())
              .addMethod(getSearchBooksMethod())
              .addMethod(getUpdateStudentsMethod())
              .addMethod(getProcessStudentsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
