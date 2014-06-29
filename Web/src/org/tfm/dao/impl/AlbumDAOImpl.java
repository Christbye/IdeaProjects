package org.tfm.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.tfm.dao.AlbumDAO;
import org.tfm.entity.Album;

import java.sql.*;
import java.util.List;

/**
 * Created by christ on 14-6-18.
 * Make move.
 */
@Repository
public class AlbumDAOImpl implements AlbumDAO {
    //插入
    private static final String INSERT = "INSERT INTO " + TABLE
            + "(NAME,KIND) VALUES(?,?)";
    //查询所有
    private static final String FIND_ALL = "SELECT * FROM " + TABLE;
    //按照ID查询
    private static final String FIND_BY_ID = "SELECT * FROM " + TABLE + " WHERE ID=?";
    //按分类查找
    private static final String FIND_BY_KIND = "SELECT * FROM "+TABLE +" WHERE kind=?";
    //删除
    private static final String DELETE = "DELETE FROM " + TABLE + " WHERE id=?";
    //更新
    private static final String UPDATE = "UPDATE " + TABLE + " SET name=?,kind=? WHERE ID=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Album> findAll() {
        return jdbcTemplate.query(FIND_ALL,new AlbumRowMapper());
    }

    @Override
    public Album findById(int id) {
        Object[] args = new Object[]{id};
        return jdbcTemplate.queryForObject(FIND_BY_ID,args,new AlbumRowMapper());
    }

    @Override
    public List<Album> findByKind(int kind) {
        Object[] args = new Object[]{kind};
        return jdbcTemplate.query(FIND_BY_KIND,args,new AlbumRowMapper());
    }

    @Override
    public Album save(final Album album) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator(){
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement pStmt = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
                pStmt.setString(1,album.getName());
                pStmt.setInt(2,album.getKind());
                return pStmt;
            }
        },keyHolder);
        int id = keyHolder.getKey().intValue();
        album.setId(id);
        return album;
    }

    @Override
    public int delete(int id) {
        Object[] args = new Object[]{id};
        return jdbcTemplate.update(DELETE,args);
    }

    @Override
    public int update(Album album) {
        Object[] args = new Object[]{album.getName(),album.getKind(),album.getId()};
        return jdbcTemplate.update(UPDATE,args);
    }
    private class AlbumRowMapper implements RowMapper<Album>{

        @Override
        public Album mapRow(ResultSet resultSet, int i) throws SQLException {
            Album album = new Album();
            album.setId(resultSet.getInt("id"));
            album.setName(resultSet.getString("name"));
            album.setKind(resultSet.getInt("kind"));
            return album;
        }
    }
}
