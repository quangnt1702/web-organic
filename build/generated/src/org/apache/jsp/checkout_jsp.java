package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import quangnt.user.UserDTO;

public final class checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"zxx\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"description\" content=\"Ogani Template\">\n");
      out.write("        <meta name=\"keywords\" content=\"Ogani, unica, creative, html\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("        <title>Ogani | Template</title>\n");
      out.write("\n");
      out.write("        <!-- Google Font -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Css Styles -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/elegant-icons.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/nice-select.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/jquery-ui.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/slicknav.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <!-- Page Preloder -->\n");
      out.write("        <div id=\"preloder\">\n");
      out.write("            <div class=\"loader\"></div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Humberger Begin -->\n");
      out.write("        <div class=\"humberger__menu__overlay\"></div>\n");
      out.write("        <div class=\"humberger__menu__wrapper\">\n");
      out.write("            <div class=\"humberger__menu__logo\">\n");
      out.write("                <a href=\"#\"><img src=\"img/logo.png\" alt=\"\"></a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"humberger__menu__cart\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"#\"><i class=\"fa fa-heart\"></i> <span>1</span></a></li>\n");
      out.write("                    <li><a href=\"#\"><i class=\"fa fa-shopping-bag\"></i> <span>3</span></a></li>\n");
      out.write("                </ul>\n");
      out.write("                <div class=\"header__cart__price\">item: <span>$150.00</span></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"humberger__menu__widget\">\n");
      out.write("                <div class=\"header__top__right__language\">\n");
      out.write("                    <img src=\"img/language.png\" alt=\"\">\n");
      out.write("                    <div>English</div>\n");
      out.write("                    <span class=\"arrow_carrot-down\"></span>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"#\">Spanis</a></li>\n");
      out.write("                        <li><a href=\"#\">English</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"header__top__right__auth\">\n");
      out.write("                    <a href=\"#\"><i class=\"fa fa-user\"></i> Login</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <nav class=\"humberger__menu__nav mobile-menu\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"active\"><a href=\"./index.jsp\">Home</a></li>\n");
      out.write("                    <li><a href=\"./shop-grid.jsp\">Shop</a></li>\n");
      out.write("                    <li><a href=\"#\">Pages</a>\n");
      out.write("                        <ul class=\"header__menu__dropdown\">\n");
      out.write("                            <li><a href=\"./shop-details.jsp\">Shop Details</a></li>\n");
      out.write("                            <li><a href=\"./shoping-cart.jsp\">Shoping Cart</a></li>\n");
      out.write("                            <li><a href=\"./checkout.jsp\">Check Out</a></li>\n");
      out.write("                            <li><a href=\"./blog-details.html\">Blog Details</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a href=\"./blog.html\">Blog</a></li>\n");
      out.write("                    <li><a href=\"./contact.html\">Contact</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("            <div id=\"mobile-menu-wrap\"></div>\n");
      out.write("            <div class=\"header__top__right__social\">\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-linkedin\"></i></a>\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-pinterest-p\"></i></a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"humberger__menu__contact\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><i class=\"fa fa-envelope\"></i> quangnt1702@gmail.com</li>\n");
      out.write("                    <li>Free Shipping for all Order of $99</li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Humberger End -->\n");
      out.write("\n");
      out.write("        <!-- Header Section Begin -->\n");
      out.write("        <header class=\"header\">\n");
      out.write("            <div class=\"header__top\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-lg-6\">\n");
      out.write("                            <div class=\"header__top__left\">\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><i class=\"fa fa-envelope\"></i> quangnt1702@gmail.com</li>\n");
      out.write("                                    <li>Free Shipping for all Order of $99</li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-lg-6\">\n");
      out.write("                            <div class=\"header__top__right\">\n");
      out.write("                                <div class=\"header__top__right__social\">\n");
      out.write("                                    <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("                                    <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\n");
      out.write("                                    <a href=\"#\"><i class=\"fa fa-linkedin\"></i></a>\n");
      out.write("                                    <a href=\"#\"><i class=\"fa fa-pinterest-p\"></i></a>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"header__top__right__language\">\n");
      out.write("                                    <img src=\"img/language.png\" alt=\"\">\n");
      out.write("                                    <div>English</div>\n");
      out.write("                                    <span class=\"arrow_carrot-down\"></span>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"#\">Spanis</a></li>\n");
      out.write("                                        <li><a href=\"#\">English</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                                ");

                                   UserDTO userLogin = (UserDTO) session.getAttribute("USER_LOGIN");
                                   if (userLogin == null) {
                                
      out.write("\n");
      out.write("                                <div class=\"header__top__right__auth\">\n");
      out.write("                                    <a href=\"login.html\"><i class=\"fa fa-user\"></i> Login</a>\n");
      out.write("                                </div> \n");
      out.write("                                ");

                                } else {
                                
      out.write("\n");
      out.write("                                <div class=\"header__top__right__auth\">\n");
      out.write("                                    <a href=\"#\"><i class=\"fa fa-user\"></i>");
      out.print(userLogin.getUserName());
      out.write(" |</a>\n");
      out.write("                                </div> \n");
      out.write("                                <div class=\"header__top__right__auth\">\n");
      out.write("                                    <a href=\"MainController?action=Logout\"> Logout</a>\n");
      out.write("                                </div> \n");
      out.write("                                ");

                                    }
                                
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-3\">\n");
      out.write("                        <div class=\"header__logo\">\n");
      out.write("                            <a href=\"./index.jsp\"><img src=\"img/logo.png\" alt=\"\"></a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-6\">\n");
      out.write("                        <nav class=\"header__menu\">\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"./index.jsp\">Home</a></li>\n");
      out.write("                                <li class=\"active\"><a href=\"./shop-grid.jsp\">Shop</a></li>\n");
      out.write("                                <li><a href=\"#\">Pages</a>\n");
      out.write("                                    <ul class=\"header__menu__dropdown\">\n");
      out.write("                                        <li><a href=\"./shop-details.jsp\">Shop Details</a></li>\n");
      out.write("                                        <li><a href=\"./shoping-cart.jsp\">Shoping Cart</a></li>\n");
      out.write("                                        <li><a href=\"./checkout.jsp\">Check Out</a></li>\n");
      out.write("                                        <li><a href=\"./blog-details.html\">Blog Details</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"./blog.html\">Blog</a></li>\n");
      out.write("                                <li><a href=\"./contact.html\">Contact</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </nav>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-3\">\n");
      out.write("                        <div class=\"header__cart\">\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#\"><i class=\"fa fa-heart\"></i> <span>1</span></a></li>\n");
      out.write("                                <li><a href=\"#\"><i class=\"fa fa-shopping-bag\"></i> <span>3</span></a></li>\n");
      out.write("                            </ul>\n");
      out.write("                            <div class=\"header__cart__price\">item: <span>$150.00</span></div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"humberger__open\">\n");
      out.write("                    <i class=\"fa fa-bars\"></i>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <!-- Header Section End -->\n");
      out.write("\n");
      out.write("        <!-- Hero Section Begin -->\n");
      out.write("        <section class=\"hero hero-normal\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-3\">\n");
      out.write("                        <div class=\"hero__categories\">\n");
      out.write("                            <div class=\"hero__categories__all\">\n");
      out.write("                                <i class=\"fa fa-bars\"></i>\n");
      out.write("                                <span>All departments</span>\n");
      out.write("                            </div>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#\">Fresh Meat</a></li>\n");
      out.write("                                <li><a href=\"#\">Vegetables</a></li>\n");
      out.write("                                <li><a href=\"#\">Fruit & Nut Gifts</a></li>\n");
      out.write("                                <li><a href=\"#\">Fresh Berries</a></li>\n");
      out.write("                                <li><a href=\"#\">Ocean Foods</a></li>\n");
      out.write("                                <li><a href=\"#\">Butter & Eggs</a></li>\n");
      out.write("                                <li><a href=\"#\">Fastfood</a></li>\n");
      out.write("                                <li><a href=\"#\">Fresh Onion</a></li>\n");
      out.write("                                <li><a href=\"#\">Papayaya & Crisps</a></li>\n");
      out.write("                                <li><a href=\"#\">Oatmeal</a></li>\n");
      out.write("                                <li><a href=\"#\">Fresh Bananas</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-9\">\n");
      out.write("                        <div class=\"hero__search\">\n");
      out.write("                            <div class=\"hero__search__form\">\n");
      out.write("                                <form action=\"#\">\n");
      out.write("                                    <div class=\"hero__search__categories\">\n");
      out.write("                                        All Categories\n");
      out.write("                                        <span class=\"arrow_carrot-down\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                    <input type=\"text\" placeholder=\"What do yo u need?\">\n");
      out.write("                                    <button type=\"submit\" class=\"site-btn\">SEARCH</button>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"hero__search__phone\">\n");
      out.write("                                <div class=\"hero__search__phone__icon\">\n");
      out.write("                                    <i class=\"fa fa-phone\"></i>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"hero__search__phone__text\">\n");
      out.write("                                    <h5>+65 11.188.888</h5>\n");
      out.write("                                    <span>support 24/7 time</span>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <!-- Hero Section End -->\n");
      out.write("\n");
      out.write("        <!-- Breadcrumb Section Begin -->\n");
      out.write("        <section class=\"breadcrumb-section set-bg\" data-setbg=\"img/breadcrumb.jpg\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-12 text-center\">\n");
      out.write("                        <div class=\"breadcrumb__text\">\n");
      out.write("                            <h2>Checkout</h2>\n");
      out.write("                            <div class=\"breadcrumb__option\">\n");
      out.write("                                <a href=\"./index.jsp\">Home</a>\n");
      out.write("                                <span>Checkout</span>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <!-- Breadcrumb Section End -->\n");
      out.write("\n");
      out.write("        <!-- Checkout Section Begin -->\n");
      out.write("        <section class=\"checkout spad\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-12\">\n");
      out.write("                        <h6><span class=\"icon_tag_alt\"></span> Have a coupon? <a href=\"#\">Click here</a> to enter your code\n");
      out.write("                        </h6>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"checkout__form\">\n");
      out.write("                    <h4>Billing Details</h4>\n");
      out.write("                    <form action=\"#\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-lg-8 col-md-6\">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-lg-6\">\n");
      out.write("                                        <div class=\"checkout__input\">\n");
      out.write("                                            <p>Fist Name<span>*</span></p>\n");
      out.write("                                            <input type=\"text\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-lg-6\">\n");
      out.write("                                        <div class=\"checkout__input\">\n");
      out.write("                                            <p>Last Name<span>*</span></p>\n");
      out.write("                                            <input type=\"text\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"checkout__input\">\n");
      out.write("                                    <p>Country<span>*</span></p>\n");
      out.write("                                    <input type=\"text\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"checkout__input\">\n");
      out.write("                                    <p>Address<span>*</span></p>\n");
      out.write("                                    <input type=\"text\" placeholder=\"Street Address\" class=\"checkout__input__add\">\n");
      out.write("                                    <input type=\"text\" placeholder=\"Apartment, suite, unite ect (optinal)\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"checkout__input\">\n");
      out.write("                                    <p>Town/City<span>*</span></p>\n");
      out.write("                                    <input type=\"text\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"checkout__input\">\n");
      out.write("                                    <p>Country/State<span>*</span></p>\n");
      out.write("                                    <input type=\"text\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"checkout__input\">\n");
      out.write("                                    <p>Postcode / ZIP<span>*</span></p>\n");
      out.write("                                    <input type=\"text\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-lg-6\">\n");
      out.write("                                        <div class=\"checkout__input\">\n");
      out.write("                                            <p>Phone<span>*</span></p>\n");
      out.write("                                            <input type=\"text\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-lg-6\">\n");
      out.write("                                        <div class=\"checkout__input\">\n");
      out.write("                                            <p>Email<span>*</span></p>\n");
      out.write("                                            <input type=\"text\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"checkout__input__checkbox\">\n");
      out.write("                                    <label for=\"acc\">\n");
      out.write("                                        Create an account?\n");
      out.write("                                        <input type=\"checkbox\" id=\"acc\">\n");
      out.write("                                        <span class=\"checkmark\"></span>\n");
      out.write("                                    </label>\n");
      out.write("                                </div>\n");
      out.write("                                <p>Create an account by entering the information below. If you are a returning customer\n");
      out.write("                                    please login at the top of the page</p>\n");
      out.write("                                <div class=\"checkout__input\">\n");
      out.write("                                    <p>Account Password<span>*</span></p>\n");
      out.write("                                    <input type=\"text\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"checkout__input__checkbox\">\n");
      out.write("                                    <label for=\"diff-acc\">\n");
      out.write("                                        Ship to a different address?\n");
      out.write("                                        <input type=\"checkbox\" id=\"diff-acc\">\n");
      out.write("                                        <span class=\"checkmark\"></span>\n");
      out.write("                                    </label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"checkout__input\">\n");
      out.write("                                    <p>Order notes<span>*</span></p>\n");
      out.write("                                    <input type=\"text\"\n");
      out.write("                                           placeholder=\"Notes about your order, e.g. special notes for delivery.\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-4 col-md-6\">\n");
      out.write("                                <div class=\"checkout__order\">\n");
      out.write("                                    <h4>Your Order</h4>\n");
      out.write("                                    <div class=\"checkout__order__products\">Products <span>Total</span></div>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li>Vegetable’s Package <span>$75.99</span></li>\n");
      out.write("                                        <li>Fresh Vegetable <span>$151.99</span></li>\n");
      out.write("                                        <li>Organic Bananas <span>$53.99</span></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                    <div class=\"checkout__order__subtotal\">Subtotal <span>$750.99</span></div>\n");
      out.write("                                    <div class=\"checkout__order__total\">Total <span>$750.99</span></div>\n");
      out.write("                                    <div class=\"checkout__input__checkbox\">\n");
      out.write("                                        <label for=\"acc-or\">\n");
      out.write("                                            Create an account?\n");
      out.write("                                            <input type=\"checkbox\" id=\"acc-or\">\n");
      out.write("                                            <span class=\"checkmark\"></span>\n");
      out.write("                                        </label>\n");
      out.write("                                    </div>\n");
      out.write("                                    <p>Lorem ipsum dolor sit amet, consectetur adip elit, sed do eiusmod tempor incididunt\n");
      out.write("                                        ut labore et dolore magna aliqua.</p>\n");
      out.write("                                    <div class=\"checkout__input__checkbox\">\n");
      out.write("                                        <label for=\"payment\">\n");
      out.write("                                            Check Payment\n");
      out.write("                                            <input type=\"checkbox\" id=\"payment\">\n");
      out.write("                                            <span class=\"checkmark\"></span>\n");
      out.write("                                        </label>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"checkout__input__checkbox\">\n");
      out.write("                                        <label for=\"paypal\">\n");
      out.write("                                            Paypal\n");
      out.write("                                            <input type=\"checkbox\" id=\"paypal\">\n");
      out.write("                                            <span class=\"checkmark\"></span>\n");
      out.write("                                        </label>\n");
      out.write("                                    </div>\n");
      out.write("                                    <button type=\"submit\" class=\"site-btn\">PLACE ORDER</button>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <!-- Checkout Section End -->\n");
      out.write("\n");
      out.write("        <!-- Footer Section Begin -->\n");
      out.write("        <footer class=\"footer spad\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-3 col-md-6 col-sm-6\">\n");
      out.write("                        <div class=\"footer__about\">\n");
      out.write("                            <div class=\"footer__about__logo\">\n");
      out.write("                                <a href=\"./index.jsp\"><img src=\"img/logo.png\" alt=\"\"></a>\n");
      out.write("                            </div>\n");
      out.write("                            <ul>\n");
      out.write("                                <li>Address: 60-49 Road 11378 New York</li>\n");
      out.write("                                <li>Phone: +65 11.188.888</li>\n");
      out.write("                                <li>Email: quangnt1702@gmail.com</li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-4 col-md-6 col-sm-6 offset-lg-1\">\n");
      out.write("                        <div class=\"footer__widget\">\n");
      out.write("                            <h6>Useful Links</h6>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#\">About Us</a></li>\n");
      out.write("                                <li><a href=\"#\">About Our Shop</a></li>\n");
      out.write("                                <li><a href=\"#\">Secure Shopping</a></li>\n");
      out.write("                                <li><a href=\"#\">Delivery infomation</a></li>\n");
      out.write("                                <li><a href=\"#\">Privacy Policy</a></li>\n");
      out.write("                                <li><a href=\"#\">Our Sitemap</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#\">Who We Are</a></li>\n");
      out.write("                                <li><a href=\"#\">Our Services</a></li>\n");
      out.write("                                <li><a href=\"#\">Projects</a></li>\n");
      out.write("                                <li><a href=\"#\">Contact</a></li>\n");
      out.write("                                <li><a href=\"#\">Innovation</a></li>\n");
      out.write("                                <li><a href=\"#\">Testimonials</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-4 col-md-12\">\n");
      out.write("                        <div class=\"footer__widget\">\n");
      out.write("                            <h6>Join Our Newsletter Now</h6>\n");
      out.write("                            <p>Get E-mail updates about our latest shop and special offers.</p>\n");
      out.write("                            <form action=\"#\">\n");
      out.write("                                <input type=\"text\" placeholder=\"Enter your mail\">\n");
      out.write("                                <button type=\"submit\" class=\"site-btn\">Subscribe</button>\n");
      out.write("                            </form>\n");
      out.write("                            <div class=\"footer__widget__social\">\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-instagram\"></i></a>\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-pinterest\"></i></a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-12\">\n");
      out.write("                        <div class=\"footer__copyright\">\n");
      out.write("                            <div class=\"footer__copyright__text\"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\n");
      out.write("                                    Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class=\"fa fa-heart\" aria-hidden=\"true\"></i> by <a href=\"https://colorlib.com\" target=\"_blank\">Colorlib</a>\n");
      out.write("                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>\n");
      out.write("                            <div class=\"footer__copyright__payment\"><img src=\"img/payment-item.png\" alt=\"\"></div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("        <!-- Footer Section End -->\n");
      out.write("\n");
      out.write("        <!-- Js Plugins -->\n");
      out.write("        <script src=\"js/jquery-3.3.1.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.nice-select.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery-ui.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.slicknav.js\"></script>\n");
      out.write("        <script src=\"js/mixitup.min.js\"></script>\n");
      out.write("        <script src=\"js/owl.carousel.min.js\"></script>\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}