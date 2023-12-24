package domain;

import java.sql.Timestamp;

public class stpinglun {
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

    public String getMaintext() {
        return maintext;
    }

    public void setMaintext(String maintext) {
        this.maintext = maintext;
    }

    public String getPritures() {
        return pritures;
    }

    public void setPritures(String pritures) {
        this.pritures = pritures;
    }

    public String getPf() {
        return pf;
    }

    public void setPf(String pf) {
        this.pf = pf;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime() {
        this.createtime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "stpinglun{" +
                "id=" + id +
                ", st_id=" + st_id +
                ", maintext='" + maintext + '\'' +
                ", pritures='" + pritures + '\'' +
                ", pf='" + pf + '\'' +
                ", user_username='" + user_username + '\'' +
                ", createtime=" + createtime +
                '}';
    }

    private int id;
    private int st_id;
    private String maintext;
    private String pritures;
    private String pf;
    private String user_username;
    private Timestamp createtime;
}
