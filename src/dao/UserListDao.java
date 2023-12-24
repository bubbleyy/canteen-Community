package dao;

import domain.User;
import domain.admin;
import domain.inform;
import domain.stgly;

import java.util.List;

public interface UserListDao {
    User findssyh(String username, String password);

    stgly findstgly(String username, String password);

    admin findadmin(String username, String password);

    User findisuser(String isusername);

    void addregisteruser(List<String> userinforms);

    String findmyzhpawwsord(String username);

    List<inform> findgg();

    inform findggdetail(int id);

    void updategglooknumber(inform gonggao);

    List<inform> findggsearch(String name);

    List<inform> findstgg(String stid);

}
