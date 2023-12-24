package domain;

import java.sql.Timestamp;

public class communitypinglun {


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(int community_id) {
        this.community_id = community_id;
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

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime() {
        this.createtime = new Timestamp(System.currentTimeMillis());
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "communitypinglun{" +
                "id=" + id +
                ", community_id=" + community_id +
                ", user_username='" + user_username + '\'' +
                ", maintext='" + maintext + '\'' +
                ", pictures='" + pictures + '\'' +
                ", createtime=" + createtime +
                ", status='" + status + '\'' +
                '}';
    }

    private int id;
    private int community_id;
    private String user_username;
    private String maintext;
    private String pictures;
    private Timestamp createtime;

    private String status;
}
