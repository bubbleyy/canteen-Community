package domain.login;

public class loginadmin {
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

    public String getFaceimg() {
        return faceimg;
    }

    public void setFaceimg(String faceimg) {
        this.faceimg = faceimg;
    }

    @Override
    public String toString() {
        return "loginadmin{" +
                "username='" + username + '\'' +
                ", logintype='" + logintype + '\'' +
                ", faceimg='" + faceimg + '\'' +
                '}';
    }

    private String username;
    private String logintype;
    private String faceimg;
}
