package domain;

import java.sql.Timestamp;

public class communityprice {
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

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime() {
        this.createtime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "communityprice{" +
                "id=" + id +
                ", community_id=" + community_id +
                ", user_username='" + user_username + '\'' +
                ", createtime=" + createtime +
                '}';
    }

    private int id;
    private int community_id;
    private String user_username;

    private Timestamp createtime;
}
