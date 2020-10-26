package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author oono
 * @date 2020 10 24
 */
public class Order {

    private String orderId;
    private Date createTime;
    private BigDecimal price;
    private Integer Status = 0;//默认值为0，表示未发货；1表示已发货；2表示已签收
    private Integer userId;

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", price=" + price +
                ", Status=" + Status +
                ", userId=" + userId +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Order(String orderId, Date createTime, BigDecimal price, Integer status, Integer userId) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.price = price;
        Status = status;
        this.userId = userId;
    }

    public Order() {
    }
}
