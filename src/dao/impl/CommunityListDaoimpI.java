
package dao.impl;

import dao.CommunityListDao;
import domain.community;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class CommunityListDaoimpI implements CommunityListDao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<community> findallcommunities() {
        String sql = "select * from community ";
        List<community> community = template.query(sql,new BeanPropertyRowMapper<community>(community.class));
        return community;
    }
}
