package quangnt.user;

/**
 *
 * @author ACER
 */
public class UserDTO {

    private String userID;
    private String password;
    private String userName;
    private String address;
    private String phoneNumber;
    private String roleID;
    private String statusID;

    public UserDTO(String userID, String password, String userName, String address, String phoneNumber, String roleID, String statusID) {
        this.userID = userID;
        this.password = password;
        this.userName = userName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.roleID = roleID;
        this.statusID = statusID;
    }

    public UserDTO() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

}
