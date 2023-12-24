package domain;

import java.sql.Timestamp;

public class stts {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSt_id() {
        return st_id;
    }

    public void setSt_id(int st_id) {
        this.st_id = st_id;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getMaintext() {
        return maintext;
    }

    public void setMaintext(String maintext) {
        this.maintext = maintext;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime() {
        this.createtime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "stts{" +
                "id=" + id +
                ", st_id=" + st_id +
                ", user_username='" + user_username + '\'' +
                ", maintext='" + maintext + '\'' +
                ", pictures='" + pictures + '\'' +
                ", status='" + status + '\'' +
                ", createtime=" + createtime +
                '}';
    }

    private int id;
    private int st_id;
    private String user_username;
    private String maintext;
    private String pictures;
    private String status;
    private Timestamp createtime;
}
