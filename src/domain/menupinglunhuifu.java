package domain;

import java.sql.Timestamp;

public class menupinglunhuifu {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMenupl_id() {
        return menupl_id;
    }

    public void setMenupl_id(int menupl_id) {
        this.menupl_id = menupl_id;
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
        return "menupinglunhuifu{" +
                "id=" + id +
                ", menupl_id=" + menupl_id +
                ", maintext='" + maintext + '\'' +
                ", createtime=" + createtime +
                ", status='" + status + '\'' +
                '}';
    }

    private int id;
    private int menupl_id;
    private  String maintext;

    private Timestamp createtime;

    private String status;
}
