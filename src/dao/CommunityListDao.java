package dao;

import domain.community;
import domain.communitypinglun;
import domain.communityprice;

import java.util.List;

public interface CommunityListDao {
    List<community> findallcommunities();

    List<communitypinglun> findcommunitypinglun(int id);

    void addcommunity(community community);

    community findonlycommunity(String id);

    void addcommunitypinglun(communitypinglun communitypinglun);

    communityprice findcommunityprice(String id, String username);


    void setprice(String id, String username);

    void deleteprice(String id, String username);

    List<community> findmycommunities(String username);

    List<community> findcommunitytitlelike(String title);

    void updatecommunity(community community);

    void deletecommunity(String id);

    List<communitypinglun> findallcommunitypinglun();

    List<communitypinglun> findcommunitypinglunlikemaintext(String maintext);

    communitypinglun findonlycommunitypinglun(String id);

    void updatecommunitypinglun(communitypinglun communitypinglun);

    void deletecommunitypinglun(String id);
}
