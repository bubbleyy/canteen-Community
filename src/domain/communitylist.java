package domain;

import domain.User;

import java.util.List;

public class communitylist {


    public domain.community getCommunity() {
        return community;
    }

    public void setCommunity(domain.community community) {
        this.community = community;
    }

    public List<String> getCommunitypictures() {
        return communitypictures;
    }

    public void setCommunitypictures(List<String> communitypictures) {
        this.communitypictures = communitypictures;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<domain.communitypinglun> getCommunitypinglun() {
        return communitypinglun;
    }

    public void setCommunitypinglun(List<domain.communitypinglun> communitypinglun) {
        this.communitypinglun = communitypinglun;
    }

    public List<List<String>> getCommunityitempictures() {
        return communityitempictures;
    }

    public void setCommunityitempictures(List<List<String>> communityitempictures) {
        this.communityitempictures = communityitempictures;
    }

    @Override
    public String toString() {
        return "communitylist{" +
                "community=" + community +
                ", communitypictures=" + communitypictures +
                ", user=" + user +
                ", communitypinglun=" + communitypinglun +
                ", communityitempictures=" + communityitempictures +
                '}';
    }

    private domain.community community;

    private List<String> communitypictures;
    private User user;
    private List<domain.communitypinglun > communitypinglun;

    private List<List<String> > communityitempictures;
}
