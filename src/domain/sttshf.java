package domain;

import java.sql.Timestamp;

public class sttshf {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStts_id() {
        return stts_id;
    }

    public void setStts_id(int stts_id) {
        this.stts_id = stts_id;
    }

    public String getMaintext() {
        return maintext;
    }

    public void setMaintext(String maintext) {
        this.maintext = maintext;
    }

    public String getFromwho() {
        return fromwho;
    }

    public void setFromwho(String fromwho) {
        this.fromwho = fromwho;
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
        return "sttshf{" +
                "id=" + id +
                ", stts_id=" + stts_id +
                ", maintext='" + maintext + '\'' +
                ", fromwho='" + fromwho + '\'' +
                ", createtime=" + createtime +
                ", status='" + status + '\'' +
                '}';
    }

    private int id;
    private int stts_id;
    private String maintext;
    private String fromwho;
    private Timestamp createtime;

    private String status;
}
