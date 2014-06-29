package org.tfm.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.tfm.dao.FileDAO;
import org.tfm.entity.FMFile;

import java.sql.*;
import java.util.List;
@Repository
public class FileDAOImpl implements FileDAO {

    //插入
    private static final String INSERT = "INSERT INTO " + TABLE
            + "(FILE,NAME,IMAGE,SOURCE,KIND,SECONDS,ALBUM)"
            + " VALUES(?,?,?,?,?,?,?)";
    //查询所有
    private static final String FIND_ALL = "SELECT * FROM " + TABLE;
    //按照ID查询
    private static final String FIND_BY_ID = "SELECT * FROM " + TABLE + " WHERE ID=?";
    //按照专辑查询
    private static final String FIND_BY_ALBUM = "SELECT * FROM " + TABLE + " WHERE album=?";
    //按照分类查询
    private static final String FIND_BY_KIND = "SELECT * FROM " + TABLE + " WHERE kind=?";
    //按列表删除
    private static final String DELETE_WITH_IDS = "DELETE FROM " + TABLE + " WHERE id IN (?)";
    //更新
    private static final String UPDATE = "UPDATE " + TABLE + " SET name=?,source=?,kind=?,album=?,upload_date=now()" +
            " WHERE id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public FMFile save(final FMFile fm){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        System.out.println("dao start");
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn)throws SQLException{
                PreparedStatement pStmt = conn.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
                pStmt.setString(1, fm.getFile());
                pStmt.setString(2, fm.getName());
                pStmt.setString(3, fm.getImage());
                pStmt.setString(4, fm.getSource());
                pStmt.setInt(5, fm.getKind());
                pStmt.setInt(6, fm.getSeconds());
                if (fm.getAlbum() == 0)
                    pStmt.setInt(7, Types.INTEGER);
                pStmt.setInt(7, fm.getAlbum());
                return pStmt;
            }
        },keyHolder);
        System.out.println("dao end");
        int id = keyHolder.getKey().intValue();
        fm.setId(id);
        return fm;
    }

    @Override
    public List<FMFile> findAll(){
        return jdbcTemplate.query(FIND_ALL,new FMRowMapper());
    }

    @Override
    public FMFile findById(int id){
        Object[] args = new Object[]{id};
        return jdbcTemplate.queryForObject(FIND_BY_ID, args, new FMRowMapper());
    }
    @Override
    public List<FMFile> findByKind(int kid){
        Object[] args = new Object[]{kid};
        return jdbcTemplate.query(FIND_BY_KIND,args,new FMRowMapper());
    }

    @Override
    public List<FMFile> findByAlbum(int album){
        Object[] args = new Object[]{album};
        return jdbcTemplate.query(FIND_BY_ALBUM,args,new FMRowMapper());
    }

    @Override
    public int delete(List<Integer> ids){
        if (ids == null || ids.size() == 0)
            return 0;
        String temp = ids.toString();
        temp = temp.replace("[", "").replace("]", "").trim();
        Object[] args = new Object[]{temp};
        return jdbcTemplate.update(DELETE_WITH_IDS,args);
    }

    @Override
    public int update(FMFile fm){
        Object[] args = new Object[]{fm.getName(),fm.getSource(), fm.getKind(), fm.getAlbum(), fm.getId()};
        return jdbcTemplate.update(UPDATE,args);
    }
    private class FMRowMapper implements RowMapper<FMFile>{

        @Override
        public FMFile mapRow(ResultSet rs, int i)throws SQLException{
            FMFile tmp = new FMFile();
            tmp.setId(rs.getInt("id"));
            tmp.setFile(rs.getString("file"));
            tmp.setName(rs.getString("name"));
            tmp.setImage(rs.getString("image"));
            tmp.setSource(rs.getString("source"));
            tmp.setKind(rs.getInt("kind"));
            tmp.setSeconds(rs.getInt("seconds"));
            tmp.setAlbum(rs.getInt("album"));
            tmp.setUploadDate(rs.getTimestamp("upload_date"));
            tmp.setHot(rs.getInt("hot"));
            return tmp;
        }
    }
/*
    private void pack(FMFile tmp, ResultSet rs){
        tmp.setId(rs.getInt("id"));
        tmp.setFile(rs.getString("file"));
        tmp.setName(rs.getString("name"));
        tmp.setImage(rs.getString("image"));
        tmp.setSource(rs.getString("source"));
        tmp.setKind(rs.getInt("kind"));
        tmp.setSeconds(rs.getInt("seconds"));
        tmp.setAlbum(rs.getInt("album"));
        tmp.setUploadDate(rs.getTimestamp("upload_date"));
        tmp.setHot(rs.getInt("hot"));
    }

     * DBUtil.beginTransaction(); try{ DBUtil.commit(); }catch(SQLException e){
	 * DBUtil.rollback(); throw e; }finally{ DBUtil.close(conn,pStmt,rs); }
	 */

}
