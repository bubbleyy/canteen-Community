package domain.pinglun;

import domain.User;
import domain.stpinglun;

//食堂评论展示
public class userpinglun {

    public domain.stpinglun getStpinglun() {
        return stpinglun;
    }

    public void setStpinglun(domain.stpinglun stpinglun) {
        this.stpinglun = stpinglun;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "userpinglun{" +
                "stpinglun=" + stpinglun +
                ", user=" + user +
                '}';
    }

    private  domain.stpinglun stpinglun;
    private User user;
}
