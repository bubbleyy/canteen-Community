package domain;

import java.sql.Timestamp;

public class menu {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTw() {
        return tw;
    }

    public void setTw(String tw) {
        this.tw = tw;
    }

    public int getSt_id() {
        return st_id;
    }

    public void setSt_id(int st_id) {
        this.st_id = st_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getCuxiao() {
        return cuxiao;
    }

    public void setCuxiao(String cuxiao) {
        this.cuxiao = cuxiao;
    }

    public int getLooknumber() {
        return looknumber;
    }

    public void setLooknumber(int looknumber) {
        this.looknumber = looknumber;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime() {
        this.createtime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "menu{" +
                "id=" + id +
                ", tw='" + tw + '\'' +
                ", st_id=" + st_id +
                ", name='" + name + '\'' +
                ", pictures='" + pictures + '\'' +
                ", introduce='" + introduce + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", money='" + money + '\'' +
                ", cuxiao='" + cuxiao + '\'' +
                ", looknumber=" + looknumber +
                ", createtime=" + createtime +
                '}';
    }

    private int id;
    private  String tw;
    private int st_id;

    private String name;
    private String pictures;
    private String introduce;
    private String status;
    private String type;
    private String money;
    private String cuxiao;
    private int looknumber;
    private Timestamp createtime;
}
