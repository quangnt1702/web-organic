<%-- 
    Document   : admin
    Created on : Sep 3, 2021, 1:52:41 PM
    Author     : ACER
--%>

<%@page import="quangnt.product.Category"%>
<%@page import="java.util.List"%>
<%@page import="quangnt.product.ProductDTO"%>
<%@page import="quangnt.product.ProductDAO"%>
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
        <script src="https://dl.dropboxusercontent.com/s/nvklmhq3kw4j9pq/jquerylasted.js?dl=0"></script>

    </head>
    <body>
        <div class="container-fluid">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Manage <b>Products</b></h2>
                            </div>
                            <div class="col-sm-6">
                                <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
                                <!--<a href="MainController?action=Logout" class="btn btn-warning"><span>Logout</span></a>-->						
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Category</th>
                                <th>Description</th>
                                <th>Status</th>
                                <th>Create Date</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ProductDAO dao = new ProductDAO();
                                List<ProductDTO> list = dao.getAllProduct();
                                int count = 0;
                                if (list != null) {
                                    if (!list.isEmpty()) {
                                        for (ProductDTO product : list) {
                                            count++;

                            %>
                            <tr>
                                <td><%=count%></td>
                                <td><%=product.getProductName()%></td>
                                <td>$<%=product.getProductPrice()%></td>
                                <td><%=product.getProductQuantity()%></td>
                                <td><%=product.getCategory()%></td>
                                <td><%=product.getDescription()%></td>
                                <td>  
                                    <%if (product.getStatus().equals("Active")) {
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
                                <td><%=product.getCreateDate().substring(0, 19)%></td>
                                <td>    
                                    <!--data-toggle="modal"-->
                                    <a href="#editEmployeeModal" class="edit" 
                                       data-id="<%= product.getProductID()%>" 
                                       data-name="<%=product.getProductName()%>"
                                       data-price="<%=product.getProductPrice()%>"
                                       data-image="<%=product.getImage()%>"
                                       data-quantity="<%=product.getProductQuantity()%>"
                                       data-category="<%=product.getCategory()%>"
                                       data-description="<%=product.getDescription()%>"
                                       data-status="<%=product.getStatus()%>"
                                       data-date="<%=product.getCreateDate()%>"
                                       data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                    <a href="MainController?action=Delete&productID=<%=product.getProductID()%>" class="delete" ><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
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
        <!-- Add Modal HTML -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="MainController" method="Post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="side-left">
                                <div class="form-group">
                                    <label>Product ID</label>
                                    <input type="text" class="form-control" required name="productID">
                                </div>
                                <div class="form-group">
                                    <label>Product Name</label>
                                    <input type="text" class="form-control" required name="productName">
                                </div>
                                <div class="form-group">
                                    <label>Price</label>
                                    <input type="number" class="form-control" required name="productPrice">
                                </div>
                                <div class="form-group">
                                    <label>Product Image</label>
                                    <input name="add" type="file" accept="image/*">
                                    <input id="link" type="text" class="form-control" name="image">
                                </div>
                            </div>
                            <div class="side-right">
                                <div class="form-group">
                                    <label>Quantity</label>
                                    <input type="number" class="form-control" required name="productQuantity">
                                </div>
                                <div class="form-group">
                                    <label>Category</label>
                                    <select name="category" class="form-control" >                                 
                                        <%
                                            List<Category> listCate = dao.getCategorys();
                                            if (listCate != null) {
                                                if (!listCate.isEmpty()) {
                                                    for (Category category : listCate) {

                                        %>
                                        <option value="<%=category.getCategoryName()%>"><%=category.getCategoryName()%></option>
                                        <%                                                }
                                                }
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Description</label>
                                    <textarea class="form-control" required name="description"></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" name="action" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Edit Modal HTML -->
        <div id="editEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="MainController" method="Post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Edit Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="side-left">
                                <!--<div class="form-group">-->
                                <!--<label>Product ID</label>-->
                                <input id="id" type="hidden" class="form-control"  readonly="" name="productID">
                                <!--</div>-->
                                <div class="form-group">
                                    <label>Product Name</label>
                                    <input id="name" type="text" class="form-control" required  name="productName">
                                </div>
                                <div class="form-group">
                                    <label>Price</label>
                                    <input id="price" type="number" class="form-control" required name="productPrice">
                                </div>
                                <div class="form-group">
                                    <label>Product Image</label>
                                    <input style="margin-bottom: 10px;" name="edit" type="file" accept="image/*">
                                    <input id="image" type="text" class="form-control" required name="image">
                                    <div class="p-image" style="border: 1px silver solid; margin: auto; margin-top: 5px; width: 70%;"><img style="width: 100%;" src="" id="image-product"></div>
                                </div>
                            </div> 
                            <div class="side-right">
                                <div class="form-group">
                                    <label>Quantity</label>
                                    <input id="quantity" type="number" class="form-control" required name="productQuantity">
                                </div>
                                <div class="form-group">
                                    <label>Category</label>
                                    <select name="category" class="form-control" >
                                        <option id="category"></option>
                                        <%
                                            if (listCate != null) {
                                                if (!listCate.isEmpty()) {
                                                    for (Category category : listCate) {

                                        %>
                                        <option value="<%=category.getCategoryName()%>"><%=category.getCategoryName()%></option>
                                        <%                                                }
                                                }
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Description</label>
                                    <textarea id="description" class="form-control" required name="description"></textarea>
                                </div>
                                <div class="form-group">
                                    <label>Status</label>
                                    <select name="status" class="form-control" >                                   
                                        <option  id="status"></option>
                                        <option  value="Inactive">Inactive</option>
                                        <option  value="Active">Active</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Create Date</label>
                                    <input id="date" class="form-control" readonly="" name="createDate">
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-info"  name="action" value="Save">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!--Delete Modal HTML -->
        <!--        <div id="deleteEmployeeModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="MainController">
                                <div class="modal-header">						
                                    <h4 class="modal-title">Delete Product</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">					
                                    <p>Are you sure you want to delete these Records?</p>
                                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                    <input type="submit" class="btn btn-danger" name="action" value="Delete">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>-->
        <script>
            $('document').ready(function () {
                $('input[name=add]').on('change', function () {
                    var $files = $(this).get(0).files;
                    if ($files.length) {
                        if ($files[0].size > $(this).data('max-size') * 1024) {
                            console.log('Vui lòng chọn file có dung lượng nhỏ hơn!');
                            return false;
                        }

                        console.log('Đang upload hình ảnh lên imgur...');
                        var apiUrl = 'https://api.imgur.com/3/image';
                        var apiKey = '7911328dd6c64c1';
                        var settings = {
                            async: false,
                            crossDomain: true,
                            processData: false,
                            contentType: false,
                            type: 'POST',
                            url: apiUrl,
                            headers: {
                                Authorization: 'Client-ID ' + apiKey,
                                Accept: 'application/json',
                            },
                            mimeType: 'multipart/form-data',
                        };
                        var formData = new FormData();
                        formData.append('image', $files[0]);
                        settings.data = formData;
                        $.ajax(settings).done(function (response) {
                            var obj = JSON.parse(response);
                            document.getElementById("link").value = obj.data.link;
                        });
                    }
                });
            });
            $('document').ready(function () {
                $('input[name=edit]').on('change', function () {
                    var $files = $(this).get(0).files;
                    if ($files.length) {
                        if ($files[0].size > $(this).data('max-size') * 1024) {
                            console.log('Vui lòng chọn file có dung lượng nhỏ hơn!');
                            return false;
                        }

                        console.log('Đang upload hình ảnh lên imgur...');
                        var apiUrl = 'https://api.imgur.com/3/image';
                        var apiKey = '7911328dd6c64c1';
                        var settings = {
                            async: false,
                            crossDomain: true,
                            processData: false,
                            contentType: false,
                            type: 'POST',
                            url: apiUrl,
                            headers: {
                                Authorization: 'Client-ID ' + apiKey,
                                Accept: 'application/json',
                            },
                            mimeType: 'multipart/form-data',
                        };
                        var formData = new FormData();
                        formData.append('image', $files[0]);
                        settings.data = formData;
                        $.ajax(settings).done(function (response) {
                            var obj = JSON.parse(response);
                            document.getElementById("image").value = obj.data.link;
                            document.getElementById("image").value = obj.data.link;
                            document.getElementById("image-product").src = obj.data.link;
                        });
                    }
                });
            });
        </script>
        <script src="./js/app-ad.js"></script>
    </body>
</html>