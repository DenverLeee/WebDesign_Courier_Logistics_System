/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.49
 * Generated at: 2021-12-21 08:41:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/D:/Program/WorkSpace_Tomcat8.0/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/Courier_Logistics_Management_System/WEB-INF/lib/jstl-impl-1.2.2.jar!/META-INF/c.tld", Long.valueOf(1343791018000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-impl-1.2.2.jar", Long.valueOf(1639552662000L));
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>?????????</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/index.css\"/>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        let alert_msg = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${alert_msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("';\n");
      out.write("        if (alert_msg != null && alert_msg.trim() != '') {\n");
      out.write("            window.alert(alert_msg);\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<h1 style=\"text-align: center;font-size: 40px;padding-top:1px;font-weight: 700;color:#000000;text-shadow: 2px 3px #FFFFFF;\">????????????????????????</h1>\n");
      out.write("<form action=\"authLogin\" method=\"post\" onsubmit=\"return check()\">\n");
      out.write("    <input type=\"hidden\" name=\"forwardPage\" id=\"forwardPage\" value=\"userList\"/>\n");
      out.write("    <div class=\"login\">\n");
      out.write("        <div class=\"login-top\">\n");
      out.write("            <a href=\"#\" style=\"color:dodgerblue ;text-decoration: none;padding-left: 63px;\">??????</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a\n");
      out.write("                style=\"color: black;text-decoration: none;\" href=\"register.jsp\">??????</a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"login-center clearfix\">\n");
      out.write("            <div class=\"login-center-img\"><img src=\"img/name.png\"/></div>\n");
      out.write("            <div class=\"login-center-input\">\n");
      out.write("                <input type=\"text\" id=\"username\" name=\"username\"  placeholder=\"?????????????????????\" onfocus=\"this.placeholder=''\" onblur=\"this.placeholder='?????????????????????'\"/>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"login-center clearfix\">\n");
      out.write("            <div class=\"login-center-img\"><img src=\"img/password.png\"/></div>\n");
      out.write("            <div class=\"login-center-input\">\n");
      out.write("                <input type=\"password\" id=\"password\" name=\"password\"  placeholder=\"?????????????????????\" onfocus=\"this.placeholder=''\" onblur=\"this.placeholder='?????????????????????'\"/>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("\t\t\n");
      out.write("        <div class=\"login-center clearfix\">\n");
      out.write("            <div class=\"login-center-img\"><img src=\"img/password.png\"/></div>\n");
      out.write("            <div class=\"login-center-input\">\n");
      out.write("                <input type=\"text\" id=\"validationCode\" name=\"validationCode\"  style=\"font-size: 10px;width: 90px;margin-top: 0px;\" placeholder=\"??????????????????\"/>\n");
      out.write("                <img id=\"img_validation_code\" src=\"authValidationCode\" onclick=\"refresh()\" style=\"height: 30px;\"/>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("\t\t\n");
      out.write("        <button type=\"submit\" class=\"login-button\">??????</button>\n");
      out.write("    </div>\n");
      out.write("</form>\n");
      out.write("</body>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    //?????????????????????????????????return false?????????????????????\n");
      out.write("    function check() {\n");
      out.write("        //??????ID?????????\n");
      out.write("        var username = document.getElementById(\"username\").value;\n");
      out.write("        var password = document.getElementById(\"password\").value;\n");
      out.write("        if (username == \"\") {\n");
      out.write("            alert(\"?????????????????????\");\n");
      out.write("            return false;\n");
      out.write("        }\n");
      out.write("        if (password == \"\") {\n");
      out.write("            alert(\"??????????????????\");\n");
      out.write("            return false;\n");
      out.write("        }\n");
      out.write("        return true;\n");
      out.write("    }\n");
      out.write("    function refresh() {\n");
      out.write("        var img = document.getElementById(\"img_validation_code\")\n");
      out.write("        img.src = \"authValidationCode?r=\" + Math.random();\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("</html>\n");
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
