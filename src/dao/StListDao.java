package dao;

import domain.*;

import java.util.List;

public interface StListDao {
    List<st> findallst();

    void addst(st st);

    List<st> findshitangname(String stname);

    List<stgly> findstrygl(String stid);

    void addstgly(stgly stgly);

    stgly findstglyusername(String string);

    void deletest(String id);

    void deletestgly(String username);

    void updatestglystatus(String username, String status);

    void updatestgly(stgly stgly);

    st findonlyst(String stid);

    void updatest(st st);

    List<stpinglun> findstpinglun(String stid);

    void addstinform(inform inform);

    void updatestlooknumber(int i, int id);

    void updatestinform(inform inform);

    void deletestinform(String id);

    stpinglun finduserpinglun(String username , int id);

    void addstpinglun(stpinglun stpinglun);

    List<stpinglun> findmystpinglun(String username);

    List<menupinglun> findmymenupinglun(String username);

    void addstts(stts stts);

    List<stts> findmysttousu(String username);

    stpinglun findonlystpinglun(String id);


    List<stpinglunhuifu> findstpinglunhuifu(int id);

    void updatestpinglunhuifuyidu(String id);

    stts findstts(String id);

    List<sttshf> findsttshuifu(int id);

    void updatesttshuifuyidu(String id);

    stpinglunhuifu findonlystpinglunhuifu(int id);

    void addstpinglunhuifu(stpinglunhuifu stpinglunhuifu);

    List<stts> findsttsinstgly(String valueOf);

    sttshf findonlysttshf(int id);

    void addsttshuifu(sttshf sttshf);

    List<stpinglun> findallstpinglun();

    void deletestpinglun(String id);

    void updatestpinglun(stpinglun stpinglun);
}
