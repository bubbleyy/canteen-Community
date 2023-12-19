package domain.login;

public class loginuser {

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
        return "loginuser{" +
                "username='" + username + '\'' +
                ", logintype='" + logintype + '\'' +
                ", status='" + status + '\'' +
                ", faceimg='" + faceimg + '\'' +
                '}';
    }

    private String username;
    private String logintype;

    private String status;
    private String faceimg;


}
