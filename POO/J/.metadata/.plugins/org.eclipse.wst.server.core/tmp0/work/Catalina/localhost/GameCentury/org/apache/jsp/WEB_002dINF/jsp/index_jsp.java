/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M26
 * Generated at: 2017-12-15 16:41:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/jsp/common/footer.jsp", Long.valueOf(1512498085284L));
    _jspx_dependants.put("/WEB-INF/jsp/common/header.jsp", Long.valueOf(1513263994806L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>GameCentury | Home</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/common.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write("<div class=\"full\">\r\n");
      out.write("    <div class=\"enterprise-info\">\r\n");
      out.write("    \t<a href=\"./\">\r\n");
      out.write("    \t\t<img src=\"./img/logo-header.svg\">\r\n");
      out.write("    \t</a>\r\n");
      out.write("        <h1 class=\"title-enterprise\">GameCentury</h1>\r\n");
      out.write("        <span></span>\r\n");
      out.write("        <p>The most wanted game house at Latin America.</p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"menu\">\r\n");
      out.write("    \t<!-- <img src=\"./img/menu-icon-header.svg\" /> -->\r\n");
      out.write("        <ul>\r\n");
      out.write("            <a href-smooth=\"#home\">\r\n");
      out.write("                <li>Home</li>\r\n");
      out.write("            </a>\r\n");
      out.write("            <a href-smooth=\"#games\">\r\n");
      out.write("                <li>Games</li>\r\n");
      out.write("            </a>\r\n");
      out.write("            <a href-smooth=\"#about-us\">\r\n");
      out.write("                <li>About Us</li>\r\n");
      out.write("            </a>\r\n");
      out.write("            <a href-smooth=\"#find-us\">\r\n");
      out.write("                <li>Find Us</li>\r\n");
      out.write("            </a>\r\n");
      out.write("            <a href=\"redirect?page=login\">\r\n");
      out.write("                <li>\r\n");
      out.write("                \t");

                		String loginText = "Login";
                		HttpSession httpSession = request.getSession();
                		Object permission_1 = httpSession.getAttribute("permission-1");
                		if(permission_1 != null) {
                			if((Boolean)permission_1 == true)
                				loginText = "Logout";
                		}
                		out.print(loginText);
                	
      out.write("             \t\r\n");
      out.write("                </li>\r\n");
      out.write("            </a>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("\t<main>\r\n");
      out.write("\t\t<section id=\"home\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<img id=\"bf3-premium-logo\" src=\"img/bf3-premium-logo.png\" alt=\"Battlefield 3 Premium Logo\">\r\n");
      out.write("\t\t\t\t<img src=\"img/battlefield-chars.png\" alt=\"Battefield 3 Characters\">\r\n");
      out.write("\t\t\t\t<img src=\"img/battlefield-base.jpg\" alt=\"Battefield 3 Scene\">\r\n");
      out.write("\t\t\t\t<a href=\"redirect?page=buy-game&gameName=bf3-premium\">\r\n");
      out.write("\t\t\t\t\t<button id=\"button-buy\" >GET MY RESERVE</button>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<h1>Battle's heat is coming back!</h1>\r\n");
      out.write("\t\t\t\t<p>Bring your weapons to ground and air and be <span>lethal</span>!</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t\t<div class=\"section-divider\"></div>\r\n");
      out.write("\t\t<section id=\"games\">\r\n");
      out.write("\t\t\t<div class=\"top-games-selector land-message\">\r\n");
      out.write("\t\t\t\t<h2>Take a look at our options:</h2>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<a href=\"redirect?page=buy-game&gameName=cod-mw3\">\r\n");
      out.write("\t\t\t\t\t\t<li>Call of Duty: MW3</li>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"redirect?page=buy-game&gameName=bioshock-infinite\">\r\n");
      out.write("\t\t\t\t\t\t<li>Bioshock: Infinite</li>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"redirect?page=buy-game&gameName=gta-v\">\r\n");
      out.write("\t\t\t\t\t\t<li>Grand Theft Auto: V</li>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"redirect?page=buy-game&gameName=bfh\">\r\n");
      out.write("\t\t\t\t\t\t<li>Battlefield: Hardline</li>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"redirect?page=buy-game&gameName=nfs-mw\">\r\n");
      out.write("\t\t\t\t\t\t<li>Need for Speed: Most Wanted</li>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"redirect?page=buy-game&gameName=pu-battlegrounds\">\r\n");
      out.write("\t\t\t\t\t\t<li>Playerunknown's Battlegrounds</li>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t\t<div class=\"section-divider\"></div>\r\n");
      out.write("\t\t<section id=\"about-us\">\r\n");
      out.write("\t\t\t<div class=\"land-message\">\r\n");
      out.write("\t\t\t\t<h2>About Us</h2>\r\n");
      out.write("\t\t\t\t<p>The Company <span>GameCentury</span> was born at year 2000, when the new Century brought us new things to discover at many technology's areas, like mobile connections and digital games, we started our works being an intermediary at the sell operations of just opened game makers enterprises, but we switched our main operation from marketing area to the main seller of the greatest titles of nowadays, acting with <span>Rockstar Games</span>, <span>EA Games</span> and many others!</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t\t<div class=\"section-divider\"></div>\r\n");
      out.write("\t\t<section id=\"find-us\">\r\n");
      out.write("\t\t\t<div class=\"land-message\">\r\n");
      out.write("\t\t\t\t<h2>Find Us</h2>\r\n");
      out.write("\t\t\t\t<p>Our E-mail: <span>contact@gamecentury.play</span></p>\r\n");
      out.write("\t\t\t\t<p>Our Telephone: <span>800-698-4637</span></p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t</main>\r\n");
      out.write("\t");
      out.write("<div class=\"full\">\r\n");
      out.write("    <h6>All Rights Reserved, 2017</h6>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script src=\"./js/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("<script src=\"./js/main.js\"></script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
