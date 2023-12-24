package domain;

import java.sql.Timestamp;

public class st {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYysj() {
        return yysj;
    }

    public void setYysj(String yysj) {
        this.yysj = yysj;
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
        return "st{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", pictures='" + pictures + '\'' +
                ", introduce='" + introduce + '\'' +
                ", id=" + id +
                ", yysj='" + yysj + '\'' +
                ", looknumber=" + looknumber +
                ", createtime=" + createtime +
                '}';
    }

    private  String name;
    private String position;
    private String pictures;
    private String introduce;
    private int id;
    private String yysj;
    private int looknumber;
    private Timestamp createtime;
}
