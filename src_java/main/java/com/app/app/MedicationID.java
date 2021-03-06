// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: scratch.proto

package com.app.app;

/**
 * <pre>
 * The request message containing the user's name.
 * </pre>
 *
 * Protobuf type {@code com.app.app.MedicationID}
 */
public  final class MedicationID extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.app.app.MedicationID)
    MedicationIDOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MedicationID.newBuilder() to construct.
  private MedicationID(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MedicationID() {
    allMedication_ = "";
    totalMed_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private MedicationID(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            allMedication_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            totalMed_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.app.app.MedicationProto.internal_static_com_app_app_MedicationID_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.app.app.MedicationProto.internal_static_com_app_app_MedicationID_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.app.app.MedicationID.class, com.app.app.MedicationID.Builder.class);
  }

  public static final int ALLMEDICATION_FIELD_NUMBER = 1;
  private volatile java.lang.Object allMedication_;
  /**
   * <code>string allMedication = 1;</code>
   */
  public java.lang.String getAllMedication() {
    java.lang.Object ref = allMedication_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      allMedication_ = s;
      return s;
    }
  }
  /**
   * <code>string allMedication = 1;</code>
   */
  public com.google.protobuf.ByteString
      getAllMedicationBytes() {
    java.lang.Object ref = allMedication_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      allMedication_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TOTALMED_FIELD_NUMBER = 2;
  private volatile java.lang.Object totalMed_;
  /**
   * <code>string totalMed = 2;</code>
   */
  public java.lang.String getTotalMed() {
    java.lang.Object ref = totalMed_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      totalMed_ = s;
      return s;
    }
  }
  /**
   * <code>string totalMed = 2;</code>
   */
  public com.google.protobuf.ByteString
      getTotalMedBytes() {
    java.lang.Object ref = totalMed_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      totalMed_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getAllMedicationBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, allMedication_);
    }
    if (!getTotalMedBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, totalMed_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getAllMedicationBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, allMedication_);
    }
    if (!getTotalMedBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, totalMed_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.app.app.MedicationID)) {
      return super.equals(obj);
    }
    com.app.app.MedicationID other = (com.app.app.MedicationID) obj;

    boolean result = true;
    result = result && getAllMedication()
        .equals(other.getAllMedication());
    result = result && getTotalMed()
        .equals(other.getTotalMed());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ALLMEDICATION_FIELD_NUMBER;
    hash = (53 * hash) + getAllMedication().hashCode();
    hash = (37 * hash) + TOTALMED_FIELD_NUMBER;
    hash = (53 * hash) + getTotalMed().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.app.app.MedicationID parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.app.app.MedicationID parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.app.app.MedicationID parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.app.app.MedicationID parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.app.app.MedicationID parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.app.app.MedicationID parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.app.app.MedicationID parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.app.app.MedicationID parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.app.app.MedicationID parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.app.app.MedicationID parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.app.app.MedicationID parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.app.app.MedicationID parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.app.app.MedicationID prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * The request message containing the user's name.
   * </pre>
   *
   * Protobuf type {@code com.app.app.MedicationID}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.app.app.MedicationID)
      com.app.app.MedicationIDOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.app.app.MedicationProto.internal_static_com_app_app_MedicationID_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.app.app.MedicationProto.internal_static_com_app_app_MedicationID_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.app.app.MedicationID.class, com.app.app.MedicationID.Builder.class);
    }

    // Construct using com.app.app.MedicationID.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      allMedication_ = "";

      totalMed_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.app.app.MedicationProto.internal_static_com_app_app_MedicationID_descriptor;
    }

    @java.lang.Override
    public com.app.app.MedicationID getDefaultInstanceForType() {
      return com.app.app.MedicationID.getDefaultInstance();
    }

    @java.lang.Override
    public com.app.app.MedicationID build() {
      com.app.app.MedicationID result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.app.app.MedicationID buildPartial() {
      com.app.app.MedicationID result = new com.app.app.MedicationID(this);
      result.allMedication_ = allMedication_;
      result.totalMed_ = totalMed_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.app.app.MedicationID) {
        return mergeFrom((com.app.app.MedicationID)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.app.app.MedicationID other) {
      if (other == com.app.app.MedicationID.getDefaultInstance()) return this;
      if (!other.getAllMedication().isEmpty()) {
        allMedication_ = other.allMedication_;
        onChanged();
      }
      if (!other.getTotalMed().isEmpty()) {
        totalMed_ = other.totalMed_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.app.app.MedicationID parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.app.app.MedicationID) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object allMedication_ = "";
    /**
     * <code>string allMedication = 1;</code>
     */
    public java.lang.String getAllMedication() {
      java.lang.Object ref = allMedication_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        allMedication_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string allMedication = 1;</code>
     */
    public com.google.protobuf.ByteString
        getAllMedicationBytes() {
      java.lang.Object ref = allMedication_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        allMedication_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string allMedication = 1;</code>
     */
    public Builder setAllMedication(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      allMedication_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string allMedication = 1;</code>
     */
    public Builder clearAllMedication() {
      
      allMedication_ = getDefaultInstance().getAllMedication();
      onChanged();
      return this;
    }
    /**
     * <code>string allMedication = 1;</code>
     */
    public Builder setAllMedicationBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      allMedication_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object totalMed_ = "";
    /**
     * <code>string totalMed = 2;</code>
     */
    public java.lang.String getTotalMed() {
      java.lang.Object ref = totalMed_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        totalMed_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string totalMed = 2;</code>
     */
    public com.google.protobuf.ByteString
        getTotalMedBytes() {
      java.lang.Object ref = totalMed_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        totalMed_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string totalMed = 2;</code>
     */
    public Builder setTotalMed(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      totalMed_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string totalMed = 2;</code>
     */
    public Builder clearTotalMed() {
      
      totalMed_ = getDefaultInstance().getTotalMed();
      onChanged();
      return this;
    }
    /**
     * <code>string totalMed = 2;</code>
     */
    public Builder setTotalMedBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      totalMed_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.app.app.MedicationID)
  }

  // @@protoc_insertion_point(class_scope:com.app.app.MedicationID)
  private static final com.app.app.MedicationID DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.app.app.MedicationID();
  }

  public static com.app.app.MedicationID getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MedicationID>
      PARSER = new com.google.protobuf.AbstractParser<MedicationID>() {
    @java.lang.Override
    public MedicationID parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new MedicationID(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MedicationID> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MedicationID> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.app.app.MedicationID getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

