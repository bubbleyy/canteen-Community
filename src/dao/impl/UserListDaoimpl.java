package dao.impl;

import dao.UserListDao;
import domain.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class UserListDaoimpl implements UserListDao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findssyh(String username, String password) {

        try {
            String sql = "select * from user where username = ? and password = ? ";

            domain.User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(domain.User.class),
                    username,password);


            return user;
        } catch (DataAccessException e) {

            return null;
        }

    }

    @Override
    public stgly findstgly(String username, String password) {
        try {
            String sql = "select * from stgly where username = ? and password = ? ";

            stgly stgly = template.queryForObject(sql,
                    new BeanPropertyRowMapper<stgly>(stgly.class),
                    username,password);


            return stgly;
        } catch (DataAccessException e) {

            return null;
        }
    }

    @Override
    public admin findadmin(String username, String password) {
        try {
            String sql = "select * from admin where username = ? and password = ? ";

            admin admin = template.queryForObject(sql,
                    new BeanPropertyRowMapper<admin>(admin.class),
                    username,password);


            return admin;
        } catch (DataAccessException e) {

            return null;
        }
    }

    //    注册用户判断是否有存在的用户名
    @Override
    public User findisuser(String isusername) {
        try {
            String sql = "select * from user where username = ?  ";

            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    isusername);


            return user;
        } catch (DataAccessException e) {

            return null;
        }
    }

    @Override
    public void addregisteruser(List<String> userinforms) {
        String sql = "insert into user values( ? ,?,?,? )";

        template.update(sql,userinforms.get(0),userinforms.get(1),userinforms.get(2),"正常");

    }

    @Override
    public String findmyzhpawwsord(String username) {

        try {
            String sql = "select password from user where username = ?  ";

            String password = template.queryForObject(sql,
                    new BeanPropertyRowMapper<String>(String.class),
                    username);


            return password;
        } catch (DataAccessException e) {

            return null;
        }

    }

    @Override
    public List<inform> findgg() {
        String sql = "select * from inform ";
        List<inform> informs = template.query(sql,new BeanPropertyRowMapper<inform>(inform.class));
        return informs;
    }

    @Override
    public inform findggdetail(int id) {
        String sql = "select * from inform where id = ?";

        return template.queryForObject(sql,new BeanPropertyRowMapper<inform>(inform.class),id);
    }

    @Override
    public void updategglooknumber(inform gonggao) {
        String sql = "update inform set looknumber = ?  where id = ?";

        template.update(sql,gonggao.getLooknumber()+1,gonggao.getId());
    }

    @Override
    public List<inform> findggsearch(String name) {
        String sql = "select * from inform where title LIKE ?";
        List<inform> informs = template.query(sql,new BeanPropertyRowMapper<inform>(inform.class),'%'+name+'%');
        return informs;
    }

    @Override
    public List<inform> findstgg(String stid) {
        String sql = "select * from inform where st_id = ? ";
        List<inform> inform = template.query(sql,new BeanPropertyRowMapper<inform>(inform.class),Integer.parseInt(stid));
        return inform;
    }


}
