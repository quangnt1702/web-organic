<%-- 
    Document   : admin
    Created on : Sep 3, 2021, 1:52:41 PM
    Author     : ACER
--%>

<%@page import="quangnt.product.CategoryDTO"%>
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
                                <h2>Manage <b>Categories</b></h2>
                            </div>
                            <div class="col-sm-6">
                                <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Category</span></a>
                                <!--<a href="MainController?action=Logout" class="btn btn-warning"><span>Logout</span></a>-->						
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Name</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<CategoryDTO> list = (List<CategoryDTO>) request.getAttribute("LIST_CATEGORY");
                                int count = 0;
                                if (list != null) {
                                    if (!list.isEmpty()) {
                                        for (CategoryDTO category : list) {
                                            count++;

                            %>
                            <tr class="contentPage">
                                <td><%=count%></td>
                                <td><%=category.getCategoryName()%></td>
                                <td>    
                                    <a href="#editCategoryModal" class="edit-category" 
                                       data-name="<%=category.getCategoryName()%>"
                                       data-id="<%=category.getCategoryID()%>"
                                       data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                    <!--<a href="MainController?action=Delete&productID=<%=category.getCategoryID()%>" class="delete" ><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>-->
                                </td>

                            </tr>
                            <%                                        }
                                    }
                                }
                            %>

                        </tbody>
                    </table>
                    <div class="clearfix">
                        <div class="hint-text">Showing <b>8</b> out of <b><%=count%></b> entries</div>
                        <ul class="pagination">

                        </ul>
                    </div>
                </div>
            </div>        
        </div>
        <!-- Add Modal HTML -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="MainController" method="Post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Categories</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="modal-body" style="display: block;">
                                <div class="form-group">
                                    <label>Category Name</label>
                                    <input type="text" class="form-control" required name="categoryName">
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" name="action" value="Add Category">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Edit Modal HTML -->
        <div id="editCategoryModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="MainController" method="Post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Edit Categories</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body" style="display: block;">
                            <div class="form-group">
                                <label>Category Name</label>
                                <input type="text" class="form-control" required id="name" name="categoryName">
                            </div>
                            <input type="hidden" id="id" name="categoryID">
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-info"  name="action" value="Save Category">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="./js/app-ad.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.js" ></script>
        <!-- JS tạo nút bấm di chuyển trang start -->
        <script src="http://1892.yn.lt/blogger/JQuery/Pagging/js/jquery.twbsPagination.js" type="text/javascript"></script>
        <!-- JS tạo nút bấm di chuyển trang end -->
        <script type="text/javascript">
            $(function () {
                var pageSize = 8; // Hiển thị 5 sản phẩm trên 1 trang
                showPage = function (page) {
                    $(".contentPage").hide();
                    $(".contentPage").each(function (n) {
                        if (n >= pageSize * (page - 1) && n < pageSize * page)
                            $(this).show();
                    });
                }
                showPage(1);
                ///** Cần truyền giá trị vào đây **///
                var totalRows = <%=count%>; // Tổng số sản phẩm hiển thị
                var btnPage = 4; // Số nút bấm hiển thị di chuyển trang
                var iTotalPages = Math.ceil(totalRows / pageSize);

                var obj = $('.pagination').twbsPagination({
                    totalPages: iTotalPages,
                    visiblePages: btnPage,
                    onPageClick: function (event, page) {
                        console.info(page);
                        showPage(page);
                    }
                });
                console.info(obj.data());
            });
        </script>
    </body>
</html>