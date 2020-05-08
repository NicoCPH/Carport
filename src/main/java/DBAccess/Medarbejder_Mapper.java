package DBAccess;

import FunctionLayer.Fejl_haendtering;
import FunctionLayer.Medarbejder;

import java.sql.*;


public class Medarbejder_Mapper {

    public static Medarbejder login(String email, String password) throws Fejl_haendtering {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT users_id, name FROM users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("users_id");
                String navn = rs.getString("first_name");
                Medarbejder user = new Medarbejder(navn, password, email);
                user.setId(id);
                return user;
            } else {
                throw new Fejl_haendtering("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new Fejl_haendtering(ex.getMessage());
        }
    }

    public static void createEmployee(Medarbejder medarbejder) throws Fejl_haendtering {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO users (navn, password, email) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, medarbejder.getNavn());
            ps.setString(2, medarbejder.getPassword());
            ps.setString(3, medarbejder.getEmail());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            medarbejder.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new Fejl_haendtering(ex.getMessage());
        }
    }



}
