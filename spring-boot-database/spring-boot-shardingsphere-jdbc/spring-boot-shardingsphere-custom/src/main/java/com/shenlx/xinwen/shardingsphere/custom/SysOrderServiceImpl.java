//package com.shenlx.xinwen.shardingsphere.custom;
//
//import com.shenlx.xinwen.shardingsphere.custom.mapper.SysOrderMapper;
//import com.shenlx.xinwen.shardingsphere.custom.utils.Convert;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * @author shenlx
// * @description
// * @date 2024/5/8 10:41
// */
//public class SysOrderServiceImpl {
//    @Autowired
//    private SysOrderMapper sysOrderMapper;
//
//    /**
//     * 查询订单信息
//     *
//     * @param orderId 订单信息主键
//     * @return 订单信息
//     */
//    @DataSource(DataSourceType.SHARDING)
//    public SysOrder selectSysOrderByOrderId(Long orderId)
//    {
//        return sysOrderMapper.selectSysOrderByOrderId(orderId);
//    }
//
//    /**
//     * 查询订单信息列表
//     *
//     * @param sysOrder 订单信息
//     * @return 订单信息
//     */
//    @DataSource(DataSourceType.SHARDING)
//    public List<SysOrder> selectSysOrderList(SysOrder sysOrder)
//    {
//        return sysOrderMapper.selectSysOrderList(sysOrder);
//    }
//
//    /**
//     * 新增订单信息
//     *
//     * @param sysOrder 订单信息
//     * @return 结果
//     */
//    @DataSource(DataSourceType.SHARDING)
//    public int insertSysOrder(SysOrder sysOrder)
//    {
//        return sysOrderMapper.insertSysOrder(sysOrder);
//    }
//
//    /**
//     * 修改订单信息
//     *
//     * @param sysOrder 订单信息
//     * @return 结果
//     */
//    @DataSource(DataSourceType.SHARDING)
//    public int updateSysOrder(SysOrder sysOrder)
//    {
//        return sysOrderMapper.updateSysOrder(sysOrder);
//    }
//
//    /**
//     * 批量删除订单信息
//     *
//     * @param orderIds 需要删除的订单信息主键
//     * @return 结果
//     */
//    @DataSource(DataSourceType.SHARDING)
//    public int deleteSysOrderByOrderIds(String orderIds)
//    {
//        return sysOrderMapper.deleteSysOrderByOrderIds(Convert.toStrArray(orderIds));
//    }
//
//    /**
//     * 删除订单信息信息
//     *
//     * @param orderId 订单信息主键
//     * @return 结果
//     */
//    @DataSource(DataSourceType.SHARDING)
//    public int deleteSysOrderByOrderId(Long orderId)
//    {
//        return sysOrderMapper.deleteSysOrderByOrderId(orderId);
//    }
//
//}
