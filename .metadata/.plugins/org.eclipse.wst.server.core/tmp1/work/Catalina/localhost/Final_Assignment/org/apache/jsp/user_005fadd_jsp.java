/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.49
 * Generated at: 2021-12-30 05:12:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class user_005fadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("jar:file:/D:/Program/WorkSpace_Tomcat8.0/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/Final_Assignment/WEB-INF/lib/jstl-impl-1.2.2.jar!/META-INF/fn.tld", Long.valueOf(1343791018000L));
    _jspx_dependants.put("jar:file:/D:/Program/WorkSpace_Tomcat8.0/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/Final_Assignment/WEB-INF/lib/jstl-impl-1.2.2.jar!/META-INF/fmt.tld", Long.valueOf(1343791018000L));
    _jspx_dependants.put("jar:file:/D:/Program/WorkSpace_Tomcat8.0/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/Final_Assignment/WEB-INF/lib/jstl-impl-1.2.2.jar!/META-INF/c.tld", Long.valueOf(1343791018000L));
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\"/>\r\n");
      out.write("    <title>Add User</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/index.css\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\r\n");
      out.write("<div class=\"index-content\">\r\n");
      out.write("    <div class=\"index-content-operation\">\r\n");
      out.write("        <a class=\"info-detail\">Add User</a>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("    </div>\r\n");
      out.write("    <br>\r\n");
      out.write("    <form action=\"userAdd\" method=\"post\" onsubmit=\"return check()\">\r\n");
      out.write("        <table class=\"index-content-table-add\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td width=\"12%\">Username:</td><td><input class=\"index-content-table-td-add\" type=\"text\" id=\"username\" name=\"username\" value=\"\"/></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td width=\"12%\">Password:</td><td><input class=\"index-content-table-td-add\" type=\"text\" id=\"password\" name=\"password\" value=\"\"/></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td width=\"12%\">Name:</td><td><input class=\"index-content-table-td-add\" type=\"text\" id=\"realName\" name=\"realName\" value=\"\"/></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td width=\"12%\">Gender:</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                        <input name=\"userSex\" type=\"radio\" value=\"Male\" checked=\"checked\"/>&nbsp;&nbsp;&nbsp;Male&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                        <input name=\"userSex\" type=\"radio\" value=\"Female\"/>&nbsp;&nbsp;&nbsp;Female&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td width=\"12%\">Phone Number:</td><td><input class=\"index-content-table-td-add\" type=\"text\" id=\"userPhone\" name=\"userPhone\" value=\"\"/></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                    <td width=\"12%\">Notes:</td><td><textarea id=\"userText\" name=\"userText\" style=\"width: 60%; height: 100px;padding: 0px 17px;\" placeholder=\"Enter......\"></textarea></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td width=\"12%\">Types:</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                        <input name=\"userType\" type=\"radio\" value=\"Admin\" checked=\"checked\"/>&nbsp;&nbsp;&nbsp;Admin&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                        <input name=\"userType\" type=\"radio\" value=\"General users\"/>&nbsp;&nbsp;&nbsp;General users&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        &nbsp;&nbsp;&nbsp;<button type=\"submit\" class=\"btn btn-pill btn-grad btn-default btn-sm\">Submit</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type=\"button\" class=\"btn btn-pill btn-grad btn-info btn-sm\" onclick=\"javascript:history.back(-1);\">Cancel</button>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    function check() {\r\n");
      out.write("        if (document.getElementById(\"username\").value.trim().length == 0) {\r\n");
      out.write("            alert(\"Username cannot be empty!\");\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("        if (document.getElementById(\"password\").value.trim().length == 0) {\r\n");
      out.write("            alert(\"Password cannot be empty!\");\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("        if (document.getElementById(\"realName\").value.trim().length == 0) {\r\n");
      out.write("            alert(\"Name cannot be empty!\");\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("        if (document.getElementById(\"userPhone\").value.trim().length == 0) {\r\n");
      out.write("            alert(\"Phone cannot be empty!\");\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("        return true;\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
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
