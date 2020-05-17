package xyz.zjr.me;


import java.sql.*;

/**
 * <p>
 * Description:
 * <p>
 *
 * @author zjr
 * @date 2020-05-16 10:55
 */
public class Executor {
    public <T>T query(String sql, Object params) {
        Connection connection = null;
        Statement stmt = null;
        Blog blog = new Blog();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "Jy@Nutrition@1.2");
            stmt=connection.createStatement();
            ResultSet rs = stmt.executeQuery(String.format(sql, params));
            while (rs.next()) {
                Integer bid = rs.getInt("id");
                String name = rs.getString("name");
                Integer authorId = rs.getInt("author_id");
                blog.setAuthorId(authorId);
                blog.setId(bid);
                blog.setName(name);
            }

            rs.close();
            stmt.close();
            connection.close();
            return (T) blog;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
