package domain.pinglun;

import domain.User;
import domain.menupinglun;

//菜品评论展示
public class usermenupinglun {
    public domain.menupinglun getMenupinglun() {
        return menupinglun;
    }

    public void setMenupinglun(domain.menupinglun menupinglun) {
        this.menupinglun = menupinglun;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "usermenupinglun{" +
                "menupinglun=" + menupinglun +
                ", user=" + user +
                '}';
    }

    private domain.menupinglun menupinglun;
    private User user;
}
