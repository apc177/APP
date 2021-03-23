package mysql;

import javax.xml.crypto.Data;

public class express {
    private  int id;
    private String courier;//快递员的账号   快递员
    private String addressee;//收件人
    private String sender;//发件人
    private String waybill;//运单编号
    private String company;//快递公司
    private String telephone;//电话
    private String address;//地址
    private String picture;//图片
    private String delytime;//发货时间
    private String recetime;//收货时间
    private String remarks;//备注

    public express() {
    }

    @Override
    public String toString() {
        return "express{" +
                "id=" + id +
                ", courier='" + courier + '\'' +
                ", addressee='" + addressee + '\'' +
                ", sender='" + sender + '\'' +
                ", waybill='" + waybill + '\'' +
                ", company='" + company + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", picture='" + picture + '\'' +
                ", delytime='" + delytime + '\'' +
                ", recetime='" + recetime + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getWaybill() {
        return waybill;
    }

    public void setWaybill(String waybill) {
        this.waybill = waybill;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicture() {
        return picture;
    }

    public express(String addressee, String sender, String company, String telephone, String address, String picture, String delytime, String recetime, String remarks) {
        this.addressee = addressee;
        this.sender = sender;
        this.company = company;
        this.telephone = telephone;
        this.address = address;
        this.picture = picture;
        this.delytime = delytime;
        this.recetime = recetime;
        this.remarks = remarks;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDelytime() {
        return delytime;
    }

    public void setDelytime(String delytime) {
        this.delytime = delytime;
    }

    public String getRecetime() {
        return recetime;
    }

    public void setRecetime(String recetime) {
        this.recetime = recetime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
