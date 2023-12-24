package domain;

import java.sql.Timestamp;

public class stpinglunhuifu {


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStpl_id() {
        return stpl_id;
    }

    public void setStpl_id(int stpl_id) {
        this.stpl_id = stpl_id;
    }

    public String getMaintext() {
        return maintext;
    }

    public void setMaintext(String maintext) {
        this.maintext = maintext;
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
        return "stpinglunhuifu{" +
                "id=" + id +
                ", stpl_id=" + stpl_id +
                ", maintext='" + maintext + '\'' +
                ", createtime=" + createtime +
                ", status='" + status + '\'' +
                '}';
    }

    private int id;
    private int stpl_id;
    private String maintext;
    private Timestamp createtime;

    private String status;
}
