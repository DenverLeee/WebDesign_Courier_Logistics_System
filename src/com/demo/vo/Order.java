package com.demo.vo;

import java.io.Serializable;

public class Order implements Serializable {
    private Long id;//primary key
    private String orderName;//receiver_name
    private String orderPhone;//receiver_phone
    private String orderAddress;//receiver address
    private String orderJiren;//sender
    private String orderJiphone;//sender_phone
    private String orderJiaddress;//sender_address
    private String orderCarno;//car no.
    private String orderStatus;//order status
    private String orderDate;//order time/date
    private String orderText;//comment

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
