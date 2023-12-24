package dao;

import domain.menu;
import domain.menupinglun;
import domain.menupinglunhuifu;

import java.util.List;

public interface MenuListDao {
    List<menu> findstcp(String stid);

    List<menu> findstpclike(int st_id, String name);

    List<menu> findstallcp(int st_id);

    void addstcp(menu menu);

    void updatestmenustatus(String menuid, String status);

    menu findonlymenu(String id);

    void updatestmenu(menu menu);

    void deletestmenu(String id);

    void updatestmenulooknumber(int i, int id);

    List<menupinglun> findmenupinglun(String id);

    menupinglun findusermenupinglun(String username, int id);

    void addmenupinglun(menupinglun menupinglun);

    List<menu> findcpinall(String menuname);

    menupinglun findonlymenupinglun(String id);

    List<menupinglunhuifu> findmenupinglunhuifu(int id);

    void updatemenupinglunhuifuyidu(String id);

    menupinglunhuifu findmenuonlypinglunhuifu(int id);

    void addmenupinglunhuifu(menupinglunhuifu menupinglunhuifu);

    List<menupinglun> findallmenupinglun();

    void updatemenupinglun(menupinglun menupinglun);

    void deletemenupinglun(String id);
}
