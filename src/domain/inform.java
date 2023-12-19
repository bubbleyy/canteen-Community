package domain;

import java.sql.Timestamp;

public class inform {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "inform{" +
                "id=" + id +
                ", st_id=" + st_id +
                ", title='" + title + '\'' +
                ", maintext='" + maintext + '\'' +
                ", fromwho='" + fromwho + '\'' +
                ", pictures='" + pictures + '\'' +
                ", type='" + type + '\'' +
                ", looknumber=" + looknumber +
                ", createtime=" + createtime +
                '}';
    }

    private int id;
    private int st_id;
    private  String title;
    private String maintext;
    private String fromwho;
    private String pictures;
    private String type;
    private int looknumber;
    private Timestamp createtime;
}
