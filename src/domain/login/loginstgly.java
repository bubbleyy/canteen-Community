package domain.login;

public class loginstgly {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLogintype() {
        return logintype;
    }

    public void setLogintype(String logintype) {
        this.logintype = logintype;
    }

    public int getSt_id() {
        return st_id;
    }

    public void setSt_id(int st_id) {
        this.st_id = st_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFaceimg() {
        return faceimg;
    }

    public void setFaceimg(String faceimg) {
        this.faceimg = faceimg;
    }

    @Override
    public String toString() {
        return "loginstgly{" +
                "username='" + username + '\'' +
                ", logintype='" + logintype + '\'' +
                ", st_id=" + st_id +
                ", status='" + status + '\'' +
                ", faceimg='" + faceimg + '\'' +
                '}';
    }

    private String username;
    private String logintype;
     private int st_id;
    private String status;
    private String faceimg;
}
