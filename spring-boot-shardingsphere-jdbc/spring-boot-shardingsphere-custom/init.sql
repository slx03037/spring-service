
create table sys_order
(
    order_id      bigint(20)      not null                   comment '订单ID',
    user_id       bigint(64)      not null                   comment '用户编号',
    status        char(1)         not null                   comment '状态（0交易成功 1交易失败）',
    order_no      varchar(64)     default null               comment '订单流水',
    primary key (order_id)
) engine=innodb comment = '订单信息表';

create table sys_order_0
(
    order_id      bigint(20)      not null                   comment '订单ID',
    user_id       bigint(64)      not null                   comment '用户编号',
    status        char(1)         not null                   comment '状态（0交易成功 1交易失败）',
    order_no      varchar(64)     default null               comment '订单流水',
    primary key (order_id)
) engine=innodb comment = '订单信息表';


create table sys_order_1
(
    order_id      bigint(20)      not null                   comment '订单ID',
    user_id       bigint(64)      not null                   comment '用户编号',
    status        char(1)         not null                   comment '状态（0交易成功 1交易失败）',
    order_no      varchar(64)     default null               comment '订单流水',
    primary key (order_id)
) engine=innodb comment = '订单信息表';
