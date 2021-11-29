<%-- 
    Document   : admin
    Created on : Sep 3, 2021, 1:52:41 PM
    Author     : ACER
--%>

<%@page import="quangnt.user.UserDTO"%>
<%@page import="quangnt.user.UserDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="referrer" content="no-referrer">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Administrator Page</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="./css/style-ad.css">
    </head>
    <body>
        <div class="container-fluid">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Manage <b>Users</b></h2>
                            </div>
                            <div class="col-sm-6">
                                <!--<a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>-->
                                <!--<a href="MainController?action=Logout" class="btn btn-warning"><span>Logout</span></a>-->						
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Address</th>
                                <th>Phone Number</th>
                                <th>Status</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                UserDAO dao = new UserDAO();
                                List<UserDTO> list = dao.getAllUsers();
                                int count = 0;
                                if (list != null) {
                                    if (!list.isEmpty()) {
                                        for (UserDTO user : list) {
                                            count++;
                                            if (user.getAddress() == null) {
                                                user.setAddress("N/A");
                                            }
                                            if (user.getPhoneNumber() == null) {
                                                user.setPhoneNumber("N/A");
                                            }
                            %>
                            <tr>
                                <td><%=count%></td>
                                <td><%=user.getUserID()%></td>
                                <td><%=user.getUserName()%></td>
                                <td><%=user.getAddress()%></td>
                                <td><%=user.getPhoneNumber()%></td>
                                <td>  
                                    <%if (user.getStatusID().equals("A")) {
                                    %>
                                    <span class="badge badge-success">Active</span>
                                    <%
                                    } else {
                                    %>
                                    <span class="badge badge-danger">Inactive</span>
                                    <%
                                        }
                                    %>
                                </td>
                                <td>    
                                    <!--data-toggle="modal"-->
                                    <!--<a href="#editEmployeeModal" class="edit" 
                                       data-id="<%= user.getUserID()%>" 
                                       data-name="<%=user.getUserName()%>"
                                       data-address="<%=user.getAddress()%>"
                                       data-phone="<%=user.getPhoneNumber()%>"
                                       data-status="<%=user.getStatusID()%>"
                                       data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>-->
                                    <%if (user.getStatusID().equals("A")) {
                                    %>
                                    <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Ban">&#xe612;</i></a>
                                    <%
                                    } else {
                                    %>
                                    <a href="MainController?action=Unban&userID=<%=user.getUserID()%>" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Unban">&#xe5d5;</i></a>
                                    <%
                                        }
                                    %>
                                </td>

                            </tr>
                            <%                                        }
                                    }
                                }
                            %>

                        </tbody>
                    </table>
                    <!--                    <div class="clearfix">
                                            <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                                            <ul class="pagination">
                                                <li class="page-item disabled"><a href="#">Previous</a></li>
                                                <li class="page-item"><a href="#" class="page-link">1</a></li>
                                                <li class="page-item"><a href="#" class="page-link">2</a></li>
                                                <li class="page-item active"><a href="#" class="page-link">3</a></li>
                                                <li class="page-item"><a href="#" class="page-link">4</a></li>
                                                <li class="page-item"><a href="#" class="page-link">5</a></li>
                                                <li class="page-item"><a href="#" class="page-link">Next</a></li>
                                            </ul>
                                        </div>-->
                </div>
            </div>        
        </div>
        <!--Delete Modal HTML -->
        <div id="deleteEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="MainController">
                        <div class="modal-header">						
                            <h4 class="modal-title">Ban User</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group" style="width: 100%;">
                                <label for="message-text" class="col-form-label">Reason ban:</label>
                                <textarea class="form-control" id="message-text"></textarea>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-danger" name="action" value="Delete">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="./js/app-ad.js"></script>
    </body>
</html>