package dao.impl;

import dao.UserListDao;
import domain.User;
import domain.admin;
import domain.inform;
import domain.stgly;
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

//        调用query方法
                User user = template.queryForObject(sql,
                        new BeanPropertyRowMapper<User>(User.class),
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

//        调用query方法
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

//        调用query方法
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

//        调用query方法
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

//        调用query方法
            // 调用queryForObject方法并指定返回类型为String.class
            String password = template.queryForObject(sql, String.class, username);



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


    //    @Override
//    public List<Order> findorderstj(String username) {
//        String sql = "select * from orderfrom where username = ?";
//        List<Order> orders = template.query(sql,new BeanPropertyRowMapper<Order>(Order.class),username);
//        return orders;
//    }

//    @Override
//    public void upuser(User user) {
//        String sql = "update user set password = ?  , name = ? , phone = ? , status = ? where id = ?";
//
//        template.update(sql,user.getPassword(),user.getName(),user.getPhone(),user.getStatus(),user.getId());
//    }

//    @Override
//    public List<User> findtjuser() {
//        String sql = "select * from user";
//        List<User> users = template.query(sql,new BeanPropertyRowMapper<User>(User.class));
//
//        return users;
//    }


//
//    @Override
//    public User findszuser(String id) {
//        String sql = "select * from user where id = ?";
//
//        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),Integer.parseInt(id));
//    }
//
//    @Override
//    public void upuser2(User user) {
//        String sql = "update user set password = ?  , name = ? , phone = ? , status = ? ,wisdom = ? where id = ?";
//
//        template.update(sql,user.getPassword(),user.getName(),user.getPhone(),user.getStatus(),user.getWisdom(),user.getId());
//
//    }
//
//    @Override
//    public User findmyphone(String username) {
//        String sql = "select * from user where username = ?";
//
//        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username);
//    }
//
//    @Override
//    public Order findusername(String ordernumber) {
//        String sql = "select * from orderfrom where ordernumber = ?";
//
//        return template.queryForObject(sql,new BeanPropertyRowMapper<Order>(Order.class),ordernumber);
//    }

//    @Override
//    public void adduser(User user) {
//        String sql = "insert into user values(null , ? ,?,?,?,?,? )";
//
//        template.update(sql,user.getUsername(),user.getPassword(),user.getWisdom(),user.getName(),user.getPhone(),user.getStatus());
//    }
}
