package org.tfm.util;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//数据库工具类
public class DBUtil {
    private DBUtil() {
    }

    private static DataSource dataSource;


    // 静态加载资源
    static {

        PoolProperties p = new PoolProperties();
        p.setUrl("jdbc:mysql://localhost:3306/tfm");
        p.setDriverClassName("com.mysql.jdbc.Driver");
        p.setUsername("root");
        p.setPassword("1234");
        p.setDefaultAutoCommit(false);
        //p.setCommitOnReturn(true);
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setRemoveAbandonedTimeout(180);
        p.setTestOnBorrow(true);
        p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
                + "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        dataSource = new DataSource();
        dataSource.setPoolProperties(p);
        /*
        Connection con = null;
        try {
            con = dataSource.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from mysql.user");
            int cnt = 1;
            while (rs.next()) {
                System.out.println((cnt++) + ". Host:" + rs.getString("Host")
                        + " User:" + rs.getString("User") + " Password:"
                        + rs.getString("Password"));
            }
            rs.close();

            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null)
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        */
    }

    // 获取连接
    public static Connection getConn() throws SQLException {
        return dataSource.getConnection();
    }

    // 开启事务
    public static void beginTransaction() throws SQLException {
        Connection conn = getConn();
        conn.setAutoCommit(false);
    }

    // 提交事务
    public static void commit() throws SQLException {
            getConn().commit();
    }

    // 回滚事务
    public static void rollback() throws SQLException {
        getConn().rollback();
    }

    // 关闭连接
    public static void close(Connection conn, Statement stmt, ResultSet rs)
            throws SQLException {
        if (rs != null)
            rs.close();
        if (stmt != null)
            stmt.close();
        if (conn != null)
            conn.close();
    }

    public static void close(Statement stmt, ResultSet rs)
            throws SQLException {
        close(null, stmt, rs);
    }

    public static void close(Connection conn) throws SQLException {
        close(conn, null);
    }

    public static void close(Connection conn, Statement stmt)
            throws SQLException {
        close(conn, stmt, null);
    }

    public static void close() throws SQLException {
        System.out.println(dataSource.getCommitOnReturn());
        dataSource.close();

    }


}
