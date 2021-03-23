package com.newedu.equipmentwarranty.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author jerry
 * @create 2020-02-25 11:28:49
 * @company 新开普电子股份有限公司
 */
public class EquipmentInfo {
    private int id;
    private String equipmentSN;
    private String equipmentName;
    private String equipmentType;
    private String responsiblePerson;
    private String remark;
    private String del;

    // fastjson 日期格式化
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public EquipmentInfo() {
    }

    public EquipmentInfo(String equipmentSN, String equipmentName, String equipmentType, String responsiblePerson, String remark, String del, Date createTime, Date updateTime) {
        this.equipmentSN = equipmentSN;
        this.equipmentName = equipmentName;
        this.equipmentType = equipmentType;
        this.responsiblePerson = responsiblePerson;
        this.remark = remark;
        this.del = del;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public EquipmentInfo(String equipmentSN, String equipmentName, String equipmentType, String responsiblePerson, String remark) {
        this.equipmentSN = equipmentSN;
        this.equipmentName = equipmentName;
        this.equipmentType = equipmentType;
        this.responsiblePerson = responsiblePerson;
        this.remark = remark;
    }

    public EquipmentInfo(int id, String equipmentSN, String equipmentName, String equipmentType, String responsiblePerson, String remark) {
        this.id = id;
        this.equipmentSN = equipmentSN;
        this.equipmentName = equipmentName;
        this.equipmentType = equipmentType;
        this.responsiblePerson = responsiblePerson;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipmentSN() {
        return equipmentSN;
    }

    public void setEquipmentSN(String equipmentSN) {
        this.equipmentSN = equipmentSN;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "EquipmentInfo{" +
                "id=" + id +
                ", equipmentSN='" + equipmentSN + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentType='" + equipmentType + '\'' +
                ", responsiblePerson='" + responsiblePerson + '\'' +
                ", remark='" + remark + '\'' +
                ", del='" + del + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
