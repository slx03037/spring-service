package com.xinwen.grpc.common;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.0)",
    comments = "Source: book.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BookServiceGrpc {

  private BookServiceGrpc() {}

  public static final String SERVICE_NAME = "book.BookService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.xinwen.grpc.common.Book,
      com.google.protobuf.StringValue> getAddBookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addBook",
      requestType = com.xinwen.grpc.common.Book.class,
      responseType = com.google.protobuf.StringValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.xinwen.grpc.common.Book,
      com.google.protobuf.StringValue> getAddBookMethod() {
    io.grpc.MethodDescriptor<com.xinwen.grpc.common.Book, com.google.protobuf.StringValue> getAddBookMethod;
    if ((getAddBookMethod = BookServiceGrpc.getAddBookMethod) == null) {
      synchronized (BookServiceGrpc.class) {
        if ((getAddBookMethod = BookServiceGrpc.getAddBookMethod) == null) {
          BookServiceGrpc.getAddBookMethod = getAddBookMethod =
              io.grpc.MethodDescriptor.<com.xinwen.grpc.common.Book, com.google.protobuf.StringValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addBook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.xinwen.grpc.common.Book.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setSchemaDescriptor(new BookServiceMethodDescriptorSupplier("addBook"))
              .build();
        }
      }
    }
    return getAddBookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.xinwen.grpc.common.Book> getGetBookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getBook",
      requestType = com.google.protobuf.StringValue.class,
      responseType = com.xinwen.grpc.common.Book.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.xinwen.grpc.common.Book> getGetBookMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, com.xinwen.grpc.common.Book> getGetBookMethod;
    if ((getGetBookMethod = BookServiceGrpc.getGetBookMethod) == null) {
      synchronized (BookServiceGrpc.class) {
        if ((getGetBookMethod = BookServiceGrpc.getGetBookMethod) == null) {
          BookServiceGrpc.getGetBookMethod = getGetBookMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, com.xinwen.grpc.common.Book>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getBook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.xinwen.grpc.common.Book.getDefaultInstance()))
              .setSchemaDescriptor(new BookServiceMethodDescriptorSupplier("getBook"))
              .build();
        }
      }
    }
    return getGetBookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.xinwen.grpc.common.Book> getSearchBooksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "searchBooks",
      requestType = com.google.protobuf.StringValue.class,
      responseType = com.xinwen.grpc.common.Book.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.xinwen.grpc.common.Book> getSearchBooksMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, com.xinwen.grpc.common.Book> getSearchBooksMethod;
    if ((getSearchBooksMethod = BookServiceGrpc.getSearchBooksMethod) == null) {
      synchronized (BookServiceGrpc.class) {
        if ((getSearchBooksMethod = BookServiceGrpc.getSearchBooksMethod) == null) {
          BookServiceGrpc.getSearchBooksMethod = getSearchBooksMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, com.xinwen.grpc.common.Book>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "searchBooks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.xinwen.grpc.common.Book.getDefaultInstance()))
              .setSchemaDescriptor(new BookServiceMethodDescriptorSupplier("searchBooks"))
              .build();
        }
      }
    }
    return getSearchBooksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.xinwen.grpc.common.Book,
      com.google.protobuf.StringValue> getUpdateBooksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateBooks",
      requestType = com.xinwen.grpc.common.Book.class,
      responseType = com.google.protobuf.StringValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.xinwen.grpc.common.Book,
      com.google.protobuf.StringValue> getUpdateBooksMethod() {
    io.grpc.MethodDescriptor<com.xinwen.grpc.common.Book, com.google.protobuf.StringValue> getUpdateBooksMethod;
    if ((getUpdateBooksMethod = BookServiceGrpc.getUpdateBooksMethod) == null) {
      synchronized (BookServiceGrpc.class) {
        if ((getUpdateBooksMethod = BookServiceGrpc.getUpdateBooksMethod) == null) {
          BookServiceGrpc.getUpdateBooksMethod = getUpdateBooksMethod =
              io.grpc.MethodDescriptor.<com.xinwen.grpc.common.Book, com.google.protobuf.StringValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateBooks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.xinwen.grpc.common.Book.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setSchemaDescriptor(new BookServiceMethodDescriptorSupplier("updateBooks"))
              .build();
        }
      }
    }
    return getUpdateBooksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.xinwen.grpc.common.BookSet> getProcessBooksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "processBooks",
      requestType = com.google.protobuf.StringValue.class,
      responseType = com.xinwen.grpc.common.BookSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.xinwen.grpc.common.BookSet> getProcessBooksMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, com.xinwen.grpc.common.BookSet> getProcessBooksMethod;
    if ((getProcessBooksMethod = BookServiceGrpc.getProcessBooksMethod) == null) {
      synchronized (BookServiceGrpc.class) {
        if ((getProcessBooksMethod = BookServiceGrpc.getProcessBooksMethod) == null) {
          BookServiceGrpc.getProcessBooksMethod = getProcessBooksMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, com.xinwen.grpc.common.BookSet>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "processBooks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.xinwen.grpc.common.BookSet.getDefaultInstance()))
              .setSchemaDescriptor(new BookServiceMethodDescriptorSupplier("processBooks"))
              .build();
        }
      }
    }
    return getProcessBooksMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BookServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BookServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BookServiceStub>() {
        @java.lang.Override
        public BookServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BookServiceStub(channel, callOptions);
        }
      };
    return BookServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BookServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BookServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BookServiceBlockingStub>() {
        @java.lang.Override
        public BookServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BookServiceBlockingStub(channel, callOptions);
        }
      };
    return BookServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BookServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BookServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BookServiceFutureStub>() {
        @java.lang.Override
        public BookServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BookServiceFutureStub(channel, callOptions);
        }
      };
    return BookServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BookServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addBook(com.xinwen.grpc.common.Book request,
        io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddBookMethod(), responseObserver);
    }

    /**
     */
    public void getBook(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.xinwen.grpc.common.Book> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBookMethod(), responseObserver);
    }

    /**
     */
    public void searchBooks(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.xinwen.grpc.common.Book> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchBooksMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.xinwen.grpc.common.Book> updateBooks(
        io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getUpdateBooksMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> processBooks(
        io.grpc.stub.StreamObserver<com.xinwen.grpc.common.BookSet> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getProcessBooksMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddBookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.xinwen.grpc.common.Book,
                com.google.protobuf.StringValue>(
                  this, METHODID_ADD_BOOK)))
          .addMethod(
            getGetBookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.StringValue,
                com.xinwen.grpc.common.Book>(
                  this, METHODID_GET_BOOK)))
          .addMethod(
            getSearchBooksMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.StringValue,
                com.xinwen.grpc.common.Book>(
                  this, METHODID_SEARCH_BOOKS)))
          .addMethod(
            getUpdateBooksMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                com.xinwen.grpc.common.Book,
                com.google.protobuf.StringValue>(
                  this, METHODID_UPDATE_BOOKS)))
          .addMethod(
            getProcessBooksMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.google.protobuf.StringValue,
                com.xinwen.grpc.common.BookSet>(
                  this, METHODID_PROCESS_BOOKS)))
          .build();
    }
  }

  /**
   */
  public static final class BookServiceStub extends io.grpc.stub.AbstractAsyncStub<BookServiceStub> {
    private BookServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BookServiceStub(channel, callOptions);
    }

    /**
     */
    public void addBook(com.xinwen.grpc.common.Book request,
        io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddBookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBook(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.xinwen.grpc.common.Book> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchBooks(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.xinwen.grpc.common.Book> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSearchBooksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.xinwen.grpc.common.Book> updateBooks(
        io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getUpdateBooksMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> processBooks(
        io.grpc.stub.StreamObserver<com.xinwen.grpc.common.BookSet> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getProcessBooksMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class BookServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<BookServiceBlockingStub> {
    private BookServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BookServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.StringValue addBook(com.xinwen.grpc.common.Book request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddBookMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.xinwen.grpc.common.Book getBook(com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBookMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.xinwen.grpc.common.Book> searchBooks(
        com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSearchBooksMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BookServiceFutureStub extends io.grpc.stub.AbstractFutureStub<BookServiceFutureStub> {
    private BookServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BookServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.StringValue> addBook(
        com.xinwen.grpc.common.Book request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddBookMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.xinwen.grpc.common.Book> getBook(
        com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBookMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_BOOK = 0;
  private static final int METHODID_GET_BOOK = 1;
  private static final int METHODID_SEARCH_BOOKS = 2;
  private static final int METHODID_UPDATE_BOOKS = 3;
  private static final int METHODID_PROCESS_BOOKS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BookServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BookServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_BOOK:
          serviceImpl.addBook((com.xinwen.grpc.common.Book) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.StringValue>) responseObserver);
          break;
        case METHODID_GET_BOOK:
          serviceImpl.getBook((com.google.protobuf.StringValue) request,
              (io.grpc.stub.StreamObserver<com.xinwen.grpc.common.Book>) responseObserver);
          break;
        case METHODID_SEARCH_BOOKS:
          serviceImpl.searchBooks((com.google.protobuf.StringValue) request,
              (io.grpc.stub.StreamObserver<com.xinwen.grpc.common.Book>) responseObserver);
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
        case METHODID_UPDATE_BOOKS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.updateBooks(
              (io.grpc.stub.StreamObserver<com.google.protobuf.StringValue>) responseObserver);
        case METHODID_PROCESS_BOOKS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.processBooks(
              (io.grpc.stub.StreamObserver<com.xinwen.grpc.common.BookSet>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BookServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BookServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.xinwen.grpc.common.BookServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BookService");
    }
  }

  private static final class BookServiceFileDescriptorSupplier
      extends BookServiceBaseDescriptorSupplier {
    BookServiceFileDescriptorSupplier() {}
  }

  private static final class BookServiceMethodDescriptorSupplier
      extends BookServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BookServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BookServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BookServiceFileDescriptorSupplier())
              .addMethod(getAddBookMethod())
              .addMethod(getGetBookMethod())
              .addMethod(getSearchBooksMethod())
              .addMethod(getUpdateBooksMethod())
              .addMethod(getProcessBooksMethod())
              .build();
        }
      }
    }
    return result;
  }
}
