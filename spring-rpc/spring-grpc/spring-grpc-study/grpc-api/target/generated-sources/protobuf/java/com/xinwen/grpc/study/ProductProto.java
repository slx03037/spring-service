// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: product.proto

package com.xinwen.grpc.study;

public final class ProductProto {
  private ProductProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_product_Product_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_product_Product_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_product_ProductId_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_product_ProductId_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rproduct.proto\022\007product\"G\n\007Product\022\n\n\002i" +
      "d\030\001 \001(\t\022\014\n\004name\030\002 \001(\t\022\023\n\013description\030\003 \001" +
      "(\t\022\r\n\005price\030\004 \001(\002\"\032\n\tProductId\022\r\n\005value\030" +
      "\001 \001(\t2u\n\013ProductInfo\0222\n\naddProduct\022\020.pro" +
      "duct.Product\032\022.product.ProductId\0222\n\ngetP" +
      "roduct\022\022.product.ProductId\032\020.product.Pro" +
      "ductB\'\n\025com.xinwen.grpc.studyB\014ProductPr" +
      "otoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_product_Product_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_product_Product_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_product_Product_descriptor,
        new java.lang.String[] { "Id", "Name", "Description", "Price", });
    internal_static_product_ProductId_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_product_ProductId_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_product_ProductId_descriptor,
        new java.lang.String[] { "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
