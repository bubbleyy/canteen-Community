package dao.impl;

import dao.StListDao;
import domain.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class StListDaoimpI implements StListDao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<st> findallst() {
        String sql = "select * from st ";
        List<st> sts = template.query(sql,new BeanPropertyRowMapper<st>(st.class));
        return sts;
    }

    @Override
    public void addst(st st) {
        String sql = "insert into st values( null,? ,?, ? ,?,?,?,? )";

        template.update(sql,st.getName(),st.getPosition(),st.getPictures(),st.getIntroduce(),st.getYysj(),st.getLooknumber(),st.getCreatetime());

    }

    //    寻找食堂名称
    @Override
    public List<st> findshitangname(String stname) {
        String sql = "select * from st where name like ?";
        List<st> sts = template.query(sql,new BeanPropertyRowMapper<st>(st.class),'%'+stname+'%');
        return sts;
    }

    //    找到对应食堂管理人员
    @Override
    public List<stgly> findstrygl(String stid) {
        String sql = "select * from stgly where st_id = ?";
        List<stgly> stgly = template.query(sql,new BeanPropertyRowMapper<stgly>(stgly.class),Integer.parseInt(stid));
        return stgly;
    }

    //    设置管理员
    @Override
    public void addstgly(stgly stgly) {
        String sql = "insert into stgly values(? ,?, ? ,?,?)";

        template.update(sql,stgly.getUsername(),stgly.getPassword(),stgly.getFaceimg(),stgly.getSt_id(),stgly.getStatus());

    }

    //    设置管理员防止用户名重复
    @Override
    public stgly findstglyusername(String string) {
        try {
            String sql = "select * from stgly where username = ?  ";

//        调用query方法
            stgly stgly = template.queryForObject(sql,
                    new BeanPropertyRowMapper<stgly>(stgly.class),
                    string);


            return stgly;
        } catch (DataAccessException e) {

            return null;
        }
    }

    @Override
    public void deletest(String id) {
        String sql = "delete  from st where id = ?";

        template.update(sql,Integer.parseInt(id));

    }

    //    删除食堂管理员
    @Override
    public void deletestgly(String username) {
        String sql = "delete  from stgly where username = ?";

        template.update(sql,username);
    }

    @Override
    public void updatestglystatus(String username, String status) {
        String sql = "update stgly set status = ? where username = ?";

        template.update(sql,status,username);
    }

    @Override
    public void updatestgly(stgly stgly) {
        String sql = "update stgly set password = ? , faceimg = ?,st_id = ? ,status = ? where username = ?";

        template.update(sql,stgly.getPassword(),stgly.getFaceimg(),stgly.getSt_id(),stgly.getStatus(),stgly.getUsername());
    }

    @Override
    public st findonlyst(String stid) {
        try {
            String sql = "select * from st where id = ?  ";

            st st = template.queryForObject(sql,
                    new BeanPropertyRowMapper<st>(st.class),
                    Integer.parseInt(stid));


            return st;
        } catch (DataAccessException e) {

            return null;
        }
    }

    @Override
    public void updatest(st st) {
        String sql = "update st set name = ? , position = ?,pictures = ? ,introduce = ?  ,yysj = ? where id = ?";

        template.update(sql,st.getName(),st.getPosition(),st.getPictures(),st.getIntroduce(),st.getYysj(),st.getId());

    }

    //    查找食堂评论
    @Override
    public List<stpinglun> findstpinglun(String stid) {
        String sql = "select * from stpinglun where st_id = ?";
        List<stpinglun> stpinglun = template.query(sql,new BeanPropertyRowMapper<stpinglun>(stpinglun.class),Integer.parseInt(stid));
        return stpinglun;
    }

    @Override
    public void addstinform(inform inform) {
        String sql = "insert into inform values(null,? ,?, ? ,?,?,?,?,?)";

        template.update(sql,inform.getTitle(),inform.getMaintext(),inform.getFromwho(),inform.getCreatetime(),inform.getLooknumber(),inform.getPictures(),inform.getType(),inform.getSt_id());

    }

    @Override
    public void updatestlooknumber(int i, int id) {
        String sql = "update st set looknumber = ? where id = ?";

        template.update(sql,i,id);

    }

    @Override
    public void updatestinform(inform inform) {
        String sql = "update inform set title=? , maintext = ?,pictures = ?  , type = ? where id = ?";

        template.update(sql,inform.getTitle(),inform.getMaintext(),inform.getPictures(),inform.getType(),inform.getId());
    }

    @Override
    public void deletestinform(String id) {
        String sql = "delete  from inform where id = ?";

        template.update(sql,Integer.parseInt(id));
    }

    @Override
    public stpinglun finduserpinglun(String username,int id) {
        try {
            String sql = "select * from stpinglun where user_username = ? and st_id = ? ";

            stpinglun stpinglun = template.queryForObject(sql,
                    new BeanPropertyRowMapper<stpinglun>(stpinglun.class),
                    username,id);


            return stpinglun;
        } catch (DataAccessException e) {

            return null;
        }
    }

    @Override
    public void addstpinglun(stpinglun stpinglun) {
        String sql = "insert into stpinglun values(null,? ,?, ? ,?,?,?)";

        template.update(sql,stpinglun.getSt_id(),stpinglun.getMaintext(),stpinglun.getPritures(),stpinglun.getPf(),stpinglun.getUser_username(),stpinglun.getCreatetime());

    }

    @Override
    public List<stpinglun> findmystpinglun(String username) {
        String sql = "select * from stpinglun where user_username = ?";
        List<stpinglun> stpinglun = template.query(sql,new BeanPropertyRowMapper<stpinglun>(stpinglun.class),username);
        return stpinglun;
    }

    @Override
    public List<menupinglun> findmymenupinglun(String username) {
        String sql = "select * from menupinglun where user_username = ?";
        List<menupinglun> menupinglun = template.query(sql,new BeanPropertyRowMapper<menupinglun>(menupinglun.class),username);
        return menupinglun;
    }

    @Override
    public void addstts(stts stts) {
        String sql = "insert into stts values(null,? ,?, ? ,?,?)";

        template.update(sql,stts.getUser_username(),stts.getSt_id(),stts.getMaintext(),stts.getPictures(),stts.getCreatetime());

    }

    @Override
    public List<stts> findmysttousu(String username) {
        String sql = "select * from stts where user_username = ?";
        List<stts> stts = template.query(sql,new BeanPropertyRowMapper<stts>(stts.class),username);
        return stts;
    }

    @Override
    public stpinglun findonlystpinglun(String id) {
        try {
            String sql = "select * from stpinglun where id = ?  ";

            stpinglun stpinglun = template.queryForObject(sql,
                    new BeanPropertyRowMapper<stpinglun>(stpinglun.class),
                    id);


            return stpinglun;
        } catch (DataAccessException e) {

            return null;
        }
    }

    @Override
    public List<stpinglunhuifu> findstpinglunhuifu(int id) {
        String sql = "select * from stpinglunhuifu where stpl_id = ?";
        List<stpinglunhuifu> stpinglunhuifu = template.query(sql,new BeanPropertyRowMapper<stpinglunhuifu>(stpinglunhuifu.class),id);
        return stpinglunhuifu;
    }

    @Override
    public void updatestpinglunhuifuyidu(String id) {
        String sql = "update stpinglunhuifu set status = ? where id = ?";

        template.update(sql,"已读",Integer.parseInt(id));

    }

    @Override
    public stts findstts(String id) {

        try {
            String sql = "select * from stts where id = ?  ";

//        调用query方法
            stts stts = template.queryForObject(sql,
                    new BeanPropertyRowMapper<stts>(stts.class),
                    Integer.parseInt(id));


            return stts;
        } catch (DataAccessException e) {

            return null;
        }
    }

    @Override
    public List<sttshf> findsttshuifu(int id) {
        String sql = "select * from sttshf where stts_id = ?";
        List<sttshf> sttshf = template.query(sql,new BeanPropertyRowMapper<sttshf>(sttshf.class),id);
        return sttshf;
    }

    @Override
    public void updatesttshuifuyidu(String id) {
        String sql = "update sttshf set status = ? where id = ?";

        template.update(sql,"已读",Integer.parseInt(id));
    }

    @Override
    public stpinglunhuifu findonlystpinglunhuifu(int id) {
        try {
            String sql = "select * from stpinglunhuifu where stpl_id = ?  ";

            stpinglunhuifu stpinglunhuifu = template.queryForObject(sql,
                    new BeanPropertyRowMapper<stpinglunhuifu>(stpinglunhuifu.class),
                    id);


            return stpinglunhuifu;
        } catch (DataAccessException e) {

            return null;
        }
    }

    @Override
    public void addstpinglunhuifu(stpinglunhuifu stpinglunhuifu) {
        String sql = "insert into stpinglunhuifu values(null,? ,?, ? ,?)";

        template.update(sql,stpinglunhuifu.getStpl_id(),stpinglunhuifu.getMaintext(),stpinglunhuifu.getCreatetime(),stpinglunhuifu.getStatus());

    }

    @Override
    public List<stts> findsttsinstgly(String valueOf) {
        String sql = "select * from stts where st_id = ?";
        List<stts> stts = template.query(sql,new BeanPropertyRowMapper<stts>(stts.class),Integer.parseInt(valueOf));
        return stts;
    }

    @Override
    public sttshf findonlysttshf(int id) {
        try {
            String sql = "select * from sttshf where stts_id = ?  ";

            sttshf sttshf = template.queryForObject(sql,
                    new BeanPropertyRowMapper<sttshf>(sttshf.class),
                    id);


            return sttshf;
        } catch (DataAccessException e) {

            return null;
        }
    }

    @Override
    public void addsttshuifu(sttshf sttshf) {
        String sql = "insert into sttshf values(null,? ,?, ? ,?,?)";

        template.update(sql,sttshf.getStts_id(),sttshf.getMaintext(),sttshf.getFromwho(),sttshf.getCreatetime(),sttshf.getStatus());

    }

    @Override
    public List<stpinglun> findallstpinglun() {
        String sql = "select * from stpinglun";
        List<stpinglun> stpinglun = template.query(sql,new BeanPropertyRowMapper<stpinglun>(stpinglun.class));
        return stpinglun;
    }

    @Override
    public void deletestpinglun(String id) {
        String sql = "delete  from stpinglun where id = ?";

        template.update(sql,Integer.parseInt(id));
    }

    @Override
    public void updatestpinglun(stpinglun stpinglun) {
        String sql = "update stpinglun set pf = ? ,maintext = ? , pictures = ?  where id = ?";

        template.update(sql,stpinglun.getPf(),stpinglun.getMaintext(),stpinglun.getPritures(),stpinglun.getId());

    }

    @Override
    public void deletestinformfromst(String id) {
        String sql = "delete  from inform where st_id = ?";

        template.update(sql,Integer.parseInt(id));
    }

    @Override
    public void deletestpinglunfromst(String id) {
        String sql = "delete  from stpinglun where st_id = ?";

        template.update(sql,Integer.parseInt(id));
    }

    @Override
    public void deletesttsfromst(String id) {
        String sql = "delete  from stts where st_id = ?";

        template.update(sql,Integer.parseInt(id));
    }


}
