package com.demo.vo;

import java.io.Serializable;

/**
 * 订单（t_order表对应的Java实体类）
 */
public class Order implements Serializable {
    private Long id;//主键
    private String orderName;//收件人
    private String orderPhone;//收件人手机
    private String orderAddress;//收件地址
    private String orderJiren;//寄件人
    private String orderJiphone;//寄件人手机
    private String orderJiaddress;//寄件人地址
    private String orderCarno;//车辆编号
    private String orderStatus;//状态:已送达/配送中
    private String orderDate;//订单时间
    private String orderText;//备注

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }
    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }
    public String getOrderJiren() {
        return orderJiren;
    }

    public void setOrderJiren(String orderJiren) {
        this.orderJiren = orderJiren;
    }
    public String getOrderJiphone() {
        return orderJiphone;
    }

    public void setOrderJiphone(String orderJiphone) {
        this.orderJiphone = orderJiphone;
    }
    public String getOrderJiaddress() {
        return orderJiaddress;
    }

    public void setOrderJiaddress(String orderJiaddress) {
        this.orderJiaddress = orderJiaddress;
    }
    public String getOrderCarno() {
        return orderCarno;
    }

    public void setOrderCarno(String orderCarno) {
        this.orderCarno = orderCarno;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public String getOrderText() {
        return orderText;
    }

    public void setOrderText(String orderText) {
        this.orderText = orderText;
    }
}
