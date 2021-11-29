<%-- 
    Document   : index
    Created on : Sep 29, 2015, 7:23:18 PM
    Author     : xonv
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Tạo mới đơn hàng</title>
        <!-- Bootstrap core CSS -->
        <link href="/WebOrganic/assets/bootstrap.min.css" rel="stylesheet"/>
        <!-- Custom styles for this template -->
        <link href="/WebOrganic/assets/jumbotron-narrow.css" rel="stylesheet">      
        <script src="/WebOrganic/assets/jquery-1.11.3.min.js"></script>
    </head>

    <body>

        <div class="container">
            <div class="header clearfix">
                <h3 class="text-muted">VNPAY PAYMENT</h3>
            </div>
            <h3>Tạo mới đơn hàng</h3>
            <div class="table-responsive">
                <form action="/WebOrganic/vnpayajax" id="frmCreateOrder" method="post">        
                    <div class="form-group">
                        <label for="language">Loại hàng hóa </label>
                        <select name="ordertype" id="ordertype" class="form-control">
                            <option value="book">Sách</option>
                            <option value="billpayment">Thanh toán hóa đơn</option>
                            <option value="fashion">Thời trang</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="amount">Số tiền</label>
                        <input class="form-control" data-val="true" data-val-number="The field Amount must be a number." data-val-required="The Amount field is required." id="amount" max="100000000" min="1" name="amount" type="number" value="<%=request.getAttribute("TOTAL_CART")%>" readonly="" />
                    </div>
                    <div class="form-group">
                        <label for="OrderDescription">Nội dung thanh toán</label>
                        <textarea class="form-control" cols="20" id="vnp_OrderInfo" name="vnp_OrderInfo" rows="2">Thanh toan don hang </textarea>
                    </div>
                    <div class="form-group">
                        <label for="bankcode">Ngân hàng</label>
                        <select name="bankcode" id="bankcode" class="form-control">
                            <option value="">Không chọn </option>
                            <option value="NCB">  	Ngan hang NCB</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="language">Ngôn ngữ</label>
                        <select name="language" id="language" class="form-control">
                            <option value="vn">Tiếng Việt</option>
                            <option value="en">English</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-default">Thanh toán</button>
                </form>
            </div>
            <p>
                &nbsp;
            </p>
            <footer class="footer">
                <p>&copy; VNPAY 2015</p>
            </footer>
        </div>  
        <link href="https://pay.vnpay.vn/lib/vnpay/vnpay.css" rel="stylesheet" />
        <script src="https://pay.vnpay.vn/lib/vnpay/vnpay.min.js"></script>
        <script type="text/javascript">
            $("#frmCreateOrder").submit(function () {
                var postData = $("#frmCreateOrder").serialize();
                var submitUrl = $("#frmCreateOrder").attr("action");
                $.ajax({
                    type: "POST",
                    url: submitUrl,
                    data: postData,
                    dataType: 'JSON',
                    success: function (x) {
                        if (x.code === '00') {
                            if (window.vnpay) {
                                vnpay.open({width: 768, height: 600, url: x.data});
                            } else {
                                location.href = x.data;
                            }
                            return false;
                        } else {
                            alert(x.Message);
                        }
                    }
                });
                return false;
            });
        </script>       
    </body>
</html>
