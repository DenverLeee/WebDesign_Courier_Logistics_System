package com.demo.vo;

import java.io.Serializable;

/**
 * 车辆（t_car表对应的Java实体类）
 */
public class Car implements Serializable {
    private Long id;//主键
    private String carName;//车辆编号
    private String carSiji;//司机姓名
    private String carPhone;//司机手机
    private String carStatus;//车辆状态:在途/空闲
    private String carText;//备注

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
    public String getCarSiji() {
        return carSiji;
    }

    public void setCarSiji(String carSiji) {
        this.carSiji = carSiji;
    }
    public String getCarPhone() {
        return carPhone;
    }

    public void setCarPhone(String carPhone) {
        this.carPhone = carPhone;
    }
    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }
    public String getCarText() {
        return carText;
    }

    public void setCarText(String carText) {
        this.carText = carText;
    }
}
