package domain;

import java.sql.Timestamp;

public class community {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public String getMaintext() {
        return maintext;
    }

    public void setMaintext(String maintext) {
        this.maintext = maintext;
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

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "community{" +
                "id=" + id +
                ", user_username='" + user_username + '\'' +
                ", title='" + title + '\'' +
                ", pictures='" + pictures + '\'' +
                ", maintext='" + maintext + '\'' +
                ", looknumber=" + looknumber +
                ", createtime=" + createtime +
                '}';
    }

    private int id;
    private String user_username;
    private  String title;

    private String pictures;
    private String maintext;
    private int looknumber;
    private Timestamp createtime;
}
