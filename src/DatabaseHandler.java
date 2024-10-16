import javax.swing.*;
import java.sql.*;

public class DatabaseHandler {
    Connection conn;

    DatabaseHandler() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_db", "root", "");
            if (conn != null) {
                System.out.println("Database connected");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void createTable() {
        try {
            String qeury = "create table if not exists student(id int primary key unique auto_increment, name varchar(255), phone varchar(12), batch varchar(10));";
            Statement s = conn.createStatement();
            s.execute(qeury);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public int insertStudent(String name, String number, String batch) {

        PreparedStatement ps;
        try {
            String q = "insert into student(name, phone, batch)values(?,?,?);";
            ps = conn.prepareStatement(q);
            ps.setString(1, name);
            ps.setString(2, number);
            ps.setString(3, batch);
            return ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return 0;
    }

    public int getId(String adnanChota, String number, String batch) {
        PreparedStatement ps;
        try {
            String q = "select * from student where name=? and phone=? and batch=?";
            ps = conn.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, adnanChota);
            ps.setString(2, number);
            ps.setString(3, batch);

            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt("id");

        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return -1;
//        Statement s=null;
//        try
//        {
//            s = conn.createStatement();
//            ResultSet rs = s.executeQuery("select * from student");
//            while(rs.next()) {
//                System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3)+" : "+rs.getString(4));
//            }
//        }catch (SQLException e)
//        {
//            System.out.println();
//        }
//
//        return 0;
    }
    public void delete(int id)
    {
        PreparedStatement ps;
        try {
            String q = "delete from student where id=?";
            ps = conn.prepareStatement(q);
            ps.setInt(1, id);

            ps.execute();
            System.out.println("Data deleted");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(int id, String b)
    {
        PreparedStatement ps;
        try {
            String q = "update student set batch=? where id=?";
            ps = conn.prepareStatement(q);
            ps.setString(1, b);
            ps.setInt(2, id);
            ps.execute();
            System.out.println("Data updated");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
