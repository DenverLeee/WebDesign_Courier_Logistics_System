package com.demo.vo;

import java.io.Serializable;

public class Car implements Serializable {
    private Long id;//primary key
    private String carName;//car name
    private String carSiji;//car driver
    private String carPhone;//car phone
    private String carStatus;//car status
    private String carText;//car comment

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
