package domain;

import java.sql.Timestamp;

public class menupinglun {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
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

    public String getPf() {
        return pf;
    }

    public void setPf(String pf) {
        this.pf = pf;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime() {
        this.createtime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "menupinglun{" +
                "id=" + id +
                ", menu_id=" + menu_id +
                ", user_username='" + user_username + '\'' +
                ", maintext='" + maintext + '\'' +
                ", pictures='" + pictures + '\'' +
                ", pf='" + pf + '\'' +
                ", createtime=" + createtime +
                '}';
    }

    private int id;
    private int menu_id;
    private String user_username;
    private  String maintext;

    private String pictures;
    private String pf;

    private Timestamp createtime;
}
