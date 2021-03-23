package com.newedu.equipmentwarranty.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author jerry
 * @create 2020-02-28 06:26:40
 * @company 新开普电子股份有限公司
 */
public class MaintenanceInfoVO {
    //{"recetime":"","address":"6","addressee":"514","waybill":"1592294045668","courier":"111","sender":"513","company":"513","telephone":"4586586","id":14,"delytime":"2020-06-16 15:54:05","picture":"..//upload//1592294039237_7b4e59aac285c2028af528fd656b7daa_18505720_094503373000_2.jpg","remarks":"无"}
    private int id;
   private String address,addressee,waybill,courier,sender,company,telephone,delytime,picture,remarks;

    public MaintenanceInfoVO(int id, String address, String addressee, String waybill, String courier, String sender, String company, String telephone, String delytime, String picture, String remarks) {
        this.id = id;
        this.address = address;
        this.addressee = addressee;
        this.waybill = waybill;
        this.courier = courier;
        this.sender = sender;
        this.company = company;
        this.telephone = telephone;
        this.delytime = delytime;
        this.picture = picture;
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getWaybill() {
        return waybill;
    }

    public void setWaybill(String waybill) {
        this.waybill = waybill;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDelytime() {
        return delytime;
    }

    public void setDelytime(String delytime) {
        this.delytime = delytime;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
