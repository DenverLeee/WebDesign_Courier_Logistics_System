/*
注：
1 “数据库脚本.sql”运行方法：全选内容复制到MySQL查询命令行或Navicat里执行即可(脚本运行成功后，就可以删除掉了)
2 登录帐号见t_user表(默认：admin/123456，该帐号建议保留好不删除)
*/

-- DROP DATABASE IF EXISTS Final_Assignment;
CREATE DATABASE Final_Assignment CHARACTER SET utf8;
USE Final_Assignment;

-- DROP TABLE  `t_user`;
CREATE TABLE `t_user`(
    `id` bigint AUTO_INCREMENT PRIMARY KEY COMMENT '主键' ,
    `username` varchar(500) COMMENT '用户名' ,
    `password` varchar(500) COMMENT '密码' ,
    `real_name` varchar(500) COMMENT '姓名' ,
    `user_sex` varchar(500) COMMENT '性别:男/女' ,
    `user_phone` varchar(500) COMMENT '手机' ,
    `user_text` varchar(500) COMMENT '备注' ,
    `user_type` varchar(500) COMMENT '类型:管理员/普通用户' 
) COMMENT='用户' ;

-- DROP TABLE  `t_notice`;
CREATE TABLE `t_notice`(
    `id` bigint AUTO_INCREMENT PRIMARY KEY COMMENT '主键' ,
    `notice_name` varchar(500) COMMENT '标题' ,
    `notice_text` varchar(500) COMMENT '内容' ,
    `notice_type` varchar(500) COMMENT '类型' ,
    `create_date` varchar(500) COMMENT '创建时间' 
) COMMENT='公告' ;

-- DROP TABLE  `t_order`;
CREATE TABLE `t_order`(
    `id` bigint AUTO_INCREMENT PRIMARY KEY COMMENT '主键' ,
    `order_name` varchar(500) COMMENT '收件人' ,
    `order_phone` varchar(500) COMMENT '收件人手机' ,
    `order_address` varchar(500) COMMENT '收件地址' ,
    `order_jiren` varchar(500) COMMENT '寄件人' ,
    `order_jiphone` varchar(500) COMMENT '寄件人手机' ,
    `order_jiaddress` varchar(500) COMMENT '寄件人地址' ,
    `order_carno` varchar(500) COMMENT '车辆编号' ,
    `order_status` varchar(500) COMMENT '状态:已送达/配送中' ,
    `order_date` varchar(500) COMMENT '订单时间' ,
    `order_text` varchar(500) COMMENT '备注' 
) COMMENT='订单' ;

-- DROP TABLE  `t_car`;
CREATE TABLE `t_car`(
    `id` bigint AUTO_INCREMENT PRIMARY KEY COMMENT '主键' ,
    `car_name` varchar(500) COMMENT '车辆编号' ,
    `car_siji` varchar(500) COMMENT '司机姓名' ,
    `car_phone` varchar(500) COMMENT '司机手机' ,
    `car_status` varchar(500) COMMENT '车辆状态:在途/空闲' ,
    `car_text` varchar(500) COMMENT '备注' 
) COMMENT='车辆' ;

INSERT INTO `t_car` VALUES (1, 'c005', '张三', '13588888888', '在途', '油不够了，估计要掉链子');
INSERT INTO `t_order` VALUES (1, '小王', '13588888888', '上海南京西路88号', '小李', '13688888888', '北京长安街3号', 'c005', '配送中', '2025-10-03', '正在加速送货');
INSERT INTO `t_notice` VALUES (1, '系统上线了！', '你懂的！！！！', '资讯', '1970-08-21 01:01:01');
INSERT INTO `t_user` VALUES (1, 'admin', '123456', '老王', '女' , '13588888888', '是一个好人', '管理员');
INSERT INTO `t_user` VALUES (2, 'a', '123456', '王八', '男' , '13855555555', '5555', '普通用户');
SELECT * FROM `t_user`;
