package dao.impl;

import dao.MenuListDao;
import domain.menu;
import domain.menupinglun;
import domain.menupinglunhuifu;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class MenuListDaoimpI implements MenuListDao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<menu> findstcp(String stid) {
        String sql = "select * from menu where st_id = ? and status = ?";
        List<menu> menus = template.query(sql,new BeanPropertyRowMapper<menu>(menu.class),Integer.parseInt(stid),"正常");
        return menus;
    }

    @Override
    public List<menu> findstpclike(int st_id, String name) {
        String sql = "select * from menu where st_id = ? and name like ?";
        List<menu> menus = template.query(sql,new BeanPropertyRowMapper<menu>(menu.class),st_id,"%"+name+"%");
        return menus;
    }

    @Override
    public List<menu> findstallcp(int st_id) {
        String sql = "select * from menu where st_id = ? ";
        List<menu> menus = template.query(sql,new BeanPropertyRowMapper<menu>(menu.class),st_id);
        return menus;
    }

    @Override
    public void addstcp(menu menu) {
        String sql = "insert into menu values( null,? ,?, ? ,?,?,?,?,?,?,?,? )";

        template.update(sql,menu.getTw(),menu.getSt_id(),menu.getName(),menu.getPictures(),menu.getIntroduce(),menu.getLooknumber(),menu.getCreatetime(),menu.getStatus(),menu.getMoney(),menu.getCuxiao(),menu.getType());

    }

    @Override
    public void updatestmenustatus(String menuid, String status) {
        String sql = "update menu set status = ?  where id = ?";

        template.update(sql,status,Integer.parseInt(menuid));
    }

    @Override
    public menu findonlymenu(String id) {
        String sql = "select * from menu where id = ?";

        return template.queryForObject(sql,new BeanPropertyRowMapper<menu>(menu.class),Integer.parseInt(id));
    }

    @Override
    public void updatestmenu(menu menu) {
        String sql = "update menu set tw = ?, name = ? , pictures = ? ,introduce=? ,money = ? ,cuxiao = ? , type = ?   where id = ?";

        template.update(sql,menu.getTw(),menu.getName(),menu.getPictures(),menu.getIntroduce(),menu.getMoney(),menu.getCuxiao(),menu.getType(),menu.getId());
    }

    @Override
    public void deletestmenu(String id) {
        String sql = "delete  from menu where id = ?";

        template.update(sql,Integer.parseInt(id));
    }

    @Override
    public void updatestmenulooknumber(int i, int id) {
        String sql = "update menu set looknumber = ?  where id = ?";

        template.update(sql,i,id);
    }

    @Override
    public List<menupinglun> findmenupinglun(String id) {
        String sql = "select * from menupinglun where menu_id = ? ";
        List<menupinglun> menupinglun = template.query(sql,new BeanPropertyRowMapper<menupinglun>(menupinglun.class),Integer.parseInt(id));
        return menupinglun;
    }

    @Override
    public menupinglun findusermenupinglun(String username, int id) {

        try {
            String sql = "select * from menupinglun where user_username = ? and menu_id = ? ";

            menupinglun menupinglun = template.queryForObject(sql,
                    new BeanPropertyRowMapper<menupinglun>(menupinglun.class),
                    username,id);


            return menupinglun;
        } catch (DataAccessException e) {

            return null;
        }

    }

    @Override
    public void addmenupinglun(menupinglun menupinglun) {
        String sql = "insert into menupinglun values( null,? ,?, ? ,?,?,? )";

        template.update(sql,menupinglun.getMenu_id(),menupinglun.getMaintext(),menupinglun.getPictures(),menupinglun.getPf(),menupinglun.getUser_username(),menupinglun.getCreatetime());

    }

    @Override
    public List<menu> findcpinall(String menuname) {
        String sql = "select * from menu where  name like ?";
        List<menu> menus = template.query(sql,new BeanPropertyRowMapper<menu>(menu.class),"%"+menuname+"%");
        return menus;
    }

    @Override
    public menupinglun findonlymenupinglun(String id) {
        try {
            String sql = "select * from menupinglun where id = ?  ";

            menupinglun menupinglun = template.queryForObject(sql,
                    new BeanPropertyRowMapper<menupinglun>(menupinglun.class),
                    Integer.parseInt(id));


            return menupinglun;
        } catch (DataAccessException e) {

            return null;
        }
    }

    @Override
    public List<menupinglunhuifu> findmenupinglunhuifu(int id) {
        String sql = "select * from menupinglunhuifu where  menupl_id = ?";
        List<menupinglunhuifu> menupinglunhuifu = template.query(sql,new BeanPropertyRowMapper<menupinglunhuifu>(menupinglunhuifu.class),id);
        return menupinglunhuifu;
    }

    @Override
    public void updatemenupinglunhuifuyidu(String id) {
        String sql = "update menupinglunhuifu set status = ?  where id = ?";

        template.update(sql,"已读",Integer.parseInt(id));
    }

    @Override
    public menupinglunhuifu findmenuonlypinglunhuifu(int id) {

        try {
            String sql = "select * from menupinglunhuifu where menupl_id= ?";

            menupinglunhuifu menupinglunhuifu = template.queryForObject(sql,
                    new BeanPropertyRowMapper<menupinglunhuifu>(menupinglunhuifu.class),
                    id);


            return menupinglunhuifu;
        } catch (DataAccessException e) {

            return null;
        }
    }

    @Override
    public void addmenupinglunhuifu(menupinglunhuifu menupinglunhuifu) {
        String sql = "insert into menupinglunhuifu values( null,? ,?, ? ,?)";

        template.update(sql,menupinglunhuifu.getMenupl_id(),menupinglunhuifu.getMaintext(),menupinglunhuifu.getCreatetime(),menupinglunhuifu.getStatus());

    }

    @Override
    public List<menupinglun> findallmenupinglun() {
        String sql = "select * from menupinglun ";
        List<menupinglun> menupinglun = template.query(sql,new BeanPropertyRowMapper<menupinglun>(menupinglun.class));
        return menupinglun;
    }

    @Override
    public void updatemenupinglun(menupinglun menupinglun) {
        String sql = "update menupinglun set pf = ? ,maintext = ? , pictures = ?  where id = ?";

        template.update(sql,menupinglun.getPf(),menupinglun.getMaintext(),menupinglun.getPictures(),menupinglun.getId());
    }

    @Override
    public void deletemenupinglun(String id) {
        String sql = "delete  from menupinglun where id = ?";

        template.update(sql,Integer.parseInt(id));
    }


}
