package dao.impl;

import dao.StListDao;
import domain.st;
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
}
