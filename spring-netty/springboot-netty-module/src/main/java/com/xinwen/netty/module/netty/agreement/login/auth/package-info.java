/**
 * @description
 * @author shenlx
 * @date 2024/4/1 15:42
 */
package com.xinwen.netty.module.netty.agreement.login.auth;

/**
 * 1.数据结构定义
 * 2.消息编解码
 * 1.握手和安全认证
 *    握手的发起是在客户端和服务端TCP链路建立通过激活时，握手消息的接入和安全认证在服务端处理
 * 2.心跳检测机制
 *  握手成功后，由客户端主动发送心跳消息，服务端接收到心跳消息之后，返回心跳应答消息，由于细条消息的目的是为了检测链路的可用性，因此不需要携带消息体
 */