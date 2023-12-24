package dao.impl;

import dao.CommunityListDao;
import domain.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.util.List;

public class CommunityListDaoimpI implements CommunityListDao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<community> findallcommunities() {
        String sql = "select * from community ";
        List<community> community = template.query(sql,new BeanPropertyRowMapper<community>(community.class));

        return community;
    }

    @Override
    public List<communitypinglun> findcommunitypinglun(int id) {
        String sql = "select * from communitypinglun where community_id = ? ";
        List<communitypinglun> communitypinglun = template.query(sql,new BeanPropertyRowMapper<communitypinglun>(communitypinglun.class),id);

        return communitypinglun;
    }

    @Override
    public void addcommunity(community community) {
        String sql = "insert into community values( null,? ,?, ? ,?,?,?)";

        template.update(sql,community.getTitle(),community.getPictures(),community.getMaintext(),community.getCreatetime(),community.getLooknumber(),community.getUser_username());

    }

    @Override
    public community findonlycommunity(String id) {
        try {
            String sql = "select * from community where id= ?";

            community community = template.queryForObject(sql,
                    new BeanPropertyRowMapper<community>(community.class),
                    Integer.parseInt(id));


            return community;
        } catch (DataAccessException e) {

            return null;
        }
    }

    @Override
    public void addcommunitypinglun(communitypinglun communitypinglun) {
        String sql = "insert into communitypinglun (id,community_id, maintext, pictures, user_username, status,createtime)  values( ?,? ,?, ? ,?,?,?)";

        template.update(sql,communitypinglun.getId(),communitypinglun.getCommunity_id(),communitypinglun.getMaintext(),communitypinglun.getPictures(),communitypinglun.getUser_username(),communitypinglun.getStatus(),communitypinglun.getCreatetime());

    }

    @Override
    public communityprice findcommunityprice(String id, String username) {
        try {
            String sql = "select * from communityprice where community_id= ? and user_username = ? ";

            communityprice communityprice = template.queryForObject(sql,
                    new BeanPropertyRowMapper<communityprice>(communityprice.class),
                    Integer.parseInt(id),username);


            return communityprice;
        } catch (DataAccessException e) {

            return null;
        }
    }

    @Override
    public void setprice(String id, String username) {
        String sql = "insert into communityprice  values(null, ?,? ,?)";

        template.update(sql,id,username,new Timestamp(System.currentTimeMillis()));

    }

    @Override
    public void deleteprice(String id, String username) {
        String sql = "delete  from communityprice where community_id = ? and user_username=?";

        template.update(sql,Integer.parseInt(id),username);
    }

    @Override
    public List<community> findmycommunities(String username) {
        String sql = "select * from community where user_username = ?";
        List<community> community = template.query(sql,new BeanPropertyRowMapper<community>(community.class),username);

        return community;
    }

    @Override
    public List<community> findcommunitytitlelike(String title) {
        String sql = "select * from community where title Like ?";
        List<community> community = template.query(sql,new BeanPropertyRowMapper<community>(community.class),'%'+title+'%');

        return community;
    }

    @Override
    public void updatecommunity(community community) {
        String sql = "update community set title = ? , pictures = ? ,maintext = ?  where id = ?";

        template.update(sql,community.getTitle(),community.getPictures(),community.getMaintext(),community.getId());
    }

    @Override
    public void deletecommunity(String id) {
        String sql = "delete  from community where id = ? ";

        template.update(sql,Integer.parseInt(id));
    }

    @Override
    public List<communitypinglun> findallcommunitypinglun() {
        String sql = "select * from communitypinglun ";
        List<communitypinglun> communitypinglun = template.query(sql,new BeanPropertyRowMapper<communitypinglun>(communitypinglun.class));

        return communitypinglun;
    }

    @Override
    public List<communitypinglun> findcommunitypinglunlikemaintext(String maintext) {
        String sql = "select * from communitypinglun where maintext like ?";
        List<communitypinglun> communitypinglun = template.query(sql,new BeanPropertyRowMapper<communitypinglun>(communitypinglun.class),'%'+maintext + '%');

        return communitypinglun;
    }

    @Override
    public communitypinglun findonlycommunitypinglun(String id) {
        try {
            String sql = "select * from communitypinglun where id = ? ";

            communitypinglun communitypinglun = template.queryForObject(sql,
                    new BeanPropertyRowMapper<communitypinglun>(communitypinglun.class),
                    Integer.parseInt(id));


            return communitypinglun;
        } catch (DataAccessException e) {

            return null;
        }
    }

    @Override
    public void updatecommunitypinglun(communitypinglun communitypinglun) {
        String sql = "update communitypinglun set pictures = ? ,maintext = ?  where id = ?";

        template.update(sql,communitypinglun.getPictures(),communitypinglun.getMaintext(),communitypinglun.getId());

    }

    @Override
    public void deletecommunitypinglun(String id) {
        String sql = "delete  from communitypinglun where id = ? ";

        template.update(sql,Integer.parseInt(id));
    }


}
