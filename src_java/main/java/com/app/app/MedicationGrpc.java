package com.app.app;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: scratch.proto")
public final class MedicationGrpc {

  private MedicationGrpc() {}

  public static final String SERVICE_NAME = "com.app.app.Medication";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.app.app.Empty,
      com.app.app.MedicationList> getSendMedicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendMedication",
      requestType = com.app.app.Empty.class,
      responseType = com.app.app.MedicationList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.app.app.Empty,
      com.app.app.MedicationList> getSendMedicationMethod() {
    io.grpc.MethodDescriptor<com.app.app.Empty, com.app.app.MedicationList> getSendMedicationMethod;
    if ((getSendMedicationMethod = MedicationGrpc.getSendMedicationMethod) == null) {
      synchronized (MedicationGrpc.class) {
        if ((getSendMedicationMethod = MedicationGrpc.getSendMedicationMethod) == null) {
          MedicationGrpc.getSendMedicationMethod = getSendMedicationMethod = 
              io.grpc.MethodDescriptor.<com.app.app.Empty, com.app.app.MedicationList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.app.app.Medication", "sendMedication"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.app.app.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.app.app.MedicationList.getDefaultInstance()))
                  .setSchemaDescriptor(new MedicationMethodDescriptorSupplier("sendMedication"))
                  .build();
          }
        }
     }
     return getSendMedicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.app.app.MedicationID,
      com.app.app.MedicationResponse> getMedicationTakenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "medicationTaken",
      requestType = com.app.app.MedicationID.class,
      responseType = com.app.app.MedicationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.app.app.MedicationID,
      com.app.app.MedicationResponse> getMedicationTakenMethod() {
    io.grpc.MethodDescriptor<com.app.app.MedicationID, com.app.app.MedicationResponse> getMedicationTakenMethod;
    if ((getMedicationTakenMethod = MedicationGrpc.getMedicationTakenMethod) == null) {
      synchronized (MedicationGrpc.class) {
        if ((getMedicationTakenMethod = MedicationGrpc.getMedicationTakenMethod) == null) {
          MedicationGrpc.getMedicationTakenMethod = getMedicationTakenMethod = 
              io.grpc.MethodDescriptor.<com.app.app.MedicationID, com.app.app.MedicationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.app.app.Medication", "medicationTaken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.app.app.MedicationID.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.app.app.MedicationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MedicationMethodDescriptorSupplier("medicationTaken"))
                  .build();
          }
        }
     }
     return getMedicationTakenMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MedicationStub newStub(io.grpc.Channel channel) {
    return new MedicationStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MedicationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MedicationBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MedicationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MedicationFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class MedicationImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sendMedication(com.app.app.Empty request,
        io.grpc.stub.StreamObserver<com.app.app.MedicationList> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMedicationMethod(), responseObserver);
    }

    /**
     */
    public void medicationTaken(com.app.app.MedicationID request,
        io.grpc.stub.StreamObserver<com.app.app.MedicationResponse> responseObserver) throws ParseException, UnsupportedEncodingException {
      asyncUnimplementedUnaryCall(getMedicationTakenMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMedicationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.app.app.Empty,
                com.app.app.MedicationList>(
                  this, METHODID_SEND_MEDICATION)))
          .addMethod(
            getMedicationTakenMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.app.app.MedicationID,
                com.app.app.MedicationResponse>(
                  this, METHODID_MEDICATION_TAKEN)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class MedicationStub extends io.grpc.stub.AbstractStub<MedicationStub> {
    private MedicationStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MedicationStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MedicationStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MedicationStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sendMedication(com.app.app.Empty request,
        io.grpc.stub.StreamObserver<com.app.app.MedicationList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendMedicationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void medicationTaken(com.app.app.MedicationID request,
        io.grpc.stub.StreamObserver<com.app.app.MedicationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMedicationTakenMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class MedicationBlockingStub extends io.grpc.stub.AbstractStub<MedicationBlockingStub> {
    private MedicationBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MedicationBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MedicationBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MedicationBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.app.app.MedicationList sendMedication(com.app.app.Empty request) {
      return blockingUnaryCall(
          getChannel(), getSendMedicationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.app.app.MedicationResponse medicationTaken(com.app.app.MedicationID request) {
      return blockingUnaryCall(
          getChannel(), getMedicationTakenMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class MedicationFutureStub extends io.grpc.stub.AbstractStub<MedicationFutureStub> {
    private MedicationFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MedicationFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MedicationFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MedicationFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.app.app.MedicationList> sendMedication(
        com.app.app.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getSendMedicationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.app.app.MedicationResponse> medicationTaken(
        com.app.app.MedicationID request) {
      return futureUnaryCall(
          getChannel().newCall(getMedicationTakenMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_MEDICATION = 0;
  private static final int METHODID_MEDICATION_TAKEN = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MedicationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MedicationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MEDICATION:
          serviceImpl.sendMedication((com.app.app.Empty) request,
              (io.grpc.stub.StreamObserver<com.app.app.MedicationList>) responseObserver);
          break;
        case METHODID_MEDICATION_TAKEN:
          try {
            serviceImpl.medicationTaken((MedicationID) request,
                (io.grpc.stub.StreamObserver<MedicationResponse>) responseObserver);
          } catch (ParseException | UnsupportedEncodingException e) {
            e.printStackTrace();
          }
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MedicationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MedicationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.app.app.MedicationProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Medication");
    }
  }

  private static final class MedicationFileDescriptorSupplier
      extends MedicationBaseDescriptorSupplier {
    MedicationFileDescriptorSupplier() {}
  }

  private static final class MedicationMethodDescriptorSupplier
      extends MedicationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MedicationMethodDescriptorSupplier(String methodName) {
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
      synchronized (MedicationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MedicationFileDescriptorSupplier())
              .addMethod(getSendMedicationMethod())
              .addMethod(getMedicationTakenMethod())
              .build();
        }
      }
    }
    return result;
  }
}
