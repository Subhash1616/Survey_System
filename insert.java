import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insert {

    public insert(Data d) throws SQLException {
        Connection c = connection.createConnection();
        System.out.println("Inserted Successfully1");
        String q = "insert into surveySystem(Name,Phone,Email,Address,Sex,Occupation) values(?,?,?,?,?,?)";
        PreparedStatement ps = c.prepareStatement(q);
        ps.setString(1,d.getName());
        ps.setString(2,d.getPhone());
        ps.setString(3,d.getEmail());
        ps.setString(4,d.getAddress());
        ps.setString(5,d.getSex());
        ps.setString(6,d.getOccupation());
        ps.executeUpdate();
        System.out.println("Inserted Successfully");
        c.close();
    }
}
