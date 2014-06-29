package org.tfm.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.tfm.dao.KindDAO;
import org.tfm.entity.Kind;

import java.sql.*;
import java.util.List;

/**
 * Created by christ on 14-6-16.
 * Make move.
 */
@Repository
public class KindDAOImpl implements KindDAO {
    //插入
    private static final String INSERT = "INSERT INTO " + TABLE
            + "(NAME,TYPE) VALUES(?,?)";
    //查询所有
    private static final String FIND_ALL = "SELECT * FROM " + TABLE;
    //按照ID查询
    private static final String FIND_BY_ID = "SELECT * FROM " + TABLE + " WHERE ID=?";
    //删除
    private static final String DELETE = "DELETE FROM " + TABLE + " WHERE id=?";
    //更新
    private static final String UPDATE = "UPDATE " + TABLE + " SET name=?,type=? WHERE ID=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;
//    @Resource(name = "jdbcTemplate")
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        System.out.println("jdbcTemplate");
//        this.jdbcTemplate = jdbcTemplate;
//        System.out.println(this.jdbcTemplate+"set");
//    }


    @Override
    public List<Kind> findAll() {
        //System.out.println(jdbcTemplate==null);
        return jdbcTemplate.query(FIND_ALL, new KindRowMapper());
    }

    @Override
    public Kind save(final Kind k) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator(){
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement pStmt = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
                pStmt.setString(1,k.getName());
                pStmt.setInt(2,k.getType());
                return pStmt;
            }
        },keyHolder);
        int id = keyHolder.getKey().intValue();
        k.setId(id);
        return k;
    }

    @Override
    public int delete(int id) {
        Object[] args = new Object[]{id};
        return jdbcTemplate.update(DELETE,args);
    }

    @Override
    public int update(Kind k) {
        Object[] args = new Object[]{k.getName(),k.getType(),k.getId()};
        return jdbcTemplate.update(UPDATE,args);
    }

    @Override
    public Kind findById(int id) {
        Object[] args = new Object[]{id};
        return jdbcTemplate.queryForObject(FIND_BY_ID,args,new KindRowMapper());
    }
//    private void pack(ResultSet rs,Kind k)throws SQLException{
//        k.setId(rs.getInt("id"));
//        k.setName(rs.getString("name"));
//        k.setType(rs.getInt("type"));
//    }
    private class KindRowMapper implements RowMapper<Kind> {

        @Override
        public Kind mapRow(ResultSet rs, int i) throws SQLException {
            Kind k = new Kind();
            k.setId(rs.getInt("id"));
            k.setName(rs.getString("name"));
            k.setType(rs.getInt("type"));
            return k;
        }
    }
}
