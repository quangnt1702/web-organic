package quangnt.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import quangnt.utils.DBUtil;

/**
 *
 * @author ACER
 */
public class UserDAO {
//    public static void main(String[] args) throws SQLException {
//        UserDAO dao=new UserDAO();
//        ArrayList<UserDTO> list= (ArrayList<UserDTO>) dao.getAllUsers();
//        System.out.println(list);
//    }
    public List<UserDTO> getAllUsers() throws SQLException {
         List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Select * from tblUsers";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String userName = rs.getString("userName");
                    String roleID = rs.getString("roleID");
                    String statusID = rs.getString("statusID");
                    String address = rs.getString("address");
                    String phoneNumber = rs.getString("phoneNumber");
                    list.add(new UserDTO(userID, "******", userName, address, phoneNumber, roleID, statusID));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = " Select userName,roleID,statusID from tblUsers where userID=? and password=? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String userName = rs.getString("userName");
                    String roleID = rs.getString("roleID");
                    String statusID = rs.getString("statusID");
                    user = new UserDTO(userID, "******", userName, "", "", roleID, statusID);
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }

    public boolean insertUserGG(UserDTO userGG) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "insert into tblUsers(userID,userName,roleID,statusID,password) values(?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userGG.getUserID());
                stm.setString(2, userGG.getUserName());
                stm.setString(3, userGG.getRoleID());
                stm.setString(4, userGG.getStatusID());
                stm.setString(5, userGG.getPassword());
                check = stm.executeUpdate() > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean checkDuplicate(UserDTO userGG) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "select userID from tblUsers where userID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userGG.getUserID());
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}
