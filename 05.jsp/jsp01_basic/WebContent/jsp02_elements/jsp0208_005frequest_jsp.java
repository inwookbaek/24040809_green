/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.96
 * Generated at: 2024-10-11 04:02:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp02_005felements;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class js0208_005frequest_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
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
      out.write("<!--  \r\n");
      out.write("	request(HttpServletRequest)기본객체\r\n");
      out.write("	\r\n");
      out.write("	request기본객체는 JSP페이지에서 가장 많이 사용되는 기본 객체로서 웹 브라우저의 요청과\r\n");
      out.write("	관련이 있다. 웹브라우저에 웹사이트의 주소를 입력하면, 웹브라우저는 해당 웹서버에 연결\r\n");
      out.write("	한 후 요청정보를 전송하는데 이 요청정보를 제공하는 것이 request기본객체이다.\r\n");
      out.write("	\r\n");
      out.write("	request기본객체가 제공하는 기능은\r\n");
      out.write("	\r\n");
      out.write("	1. 클라이언트(웹브라우저)와 관련된 정보\r\n");
      out.write("	2. 서버와 관련된 정보\r\n");
      out.write("	3. 클라이언트가 전송한 요청파라미터 정보\r\n");
      out.write("    4. 클라이언트가 전송한 요청헤더 정보\r\n");
      out.write("    5. 클라이언트가 전송한 쿠키 정보\r\n");
      out.write("    6. 속성처리\r\n");
      out.write("    \r\n");
      out.write("    request기본객체 메서드\r\n");
      out.write("    \r\n");
      out.write("    1. getRmoteAddr() : 웹서버에 연결한 클라이언트의 IP주소\r\n");
      out.write("    2. getContentLength() : 클라이언트가 요청한 정보의 길이\r\n");
      out.write("    3. getCharacterEncoding() : 클라이언트가 요청정보를 전송할 때 사용한 캐릭터셋정보\r\n");
      out.write("    4. getContentType() : 클라이언트가 요청정보를 전송할 때 사용한 컨텐츠(문서)타입정보\r\n");
      out.write("    5. getProtocol() : 클라이언트가 요청한 프로토콜 정보\r\n");
      out.write("    6. getMethod() : 웹브라우저가 정보를 전송할 때 사용한 전송방식\r\n");
      out.write("    7. getRequestURI() : 웹브라우저가 요청한 URL에서 경로를 구함\r\n");
      out.write("    8. getContextPath() : JSP페이지가 속한 웹어플리케이션의 컨텍스트정보\r\n");
      out.write("    9. getServerName() : 연결할 때 사용한 서버이름\r\n");
      out.write("   10. getServerPort() : 서버가 실행중인 포트번호 정보\r\n");
      out.write("   \r\n");
      out.write("    request기본객체의 요청파라미터관련 메서드\r\n");
      out.write("    \r\n");
      out.write("    1. getParameter(String name) : 이름(name)인 파라미터의 값, 없을 경우 null\r\n");
      out.write("    2. getParameterValues(String name) : 이름(name)인 모든 파라미터의 값을 배열로 리턴\r\n");
      out.write("    3. getParmeterNames() : 웹브라우저가 전송한 파라미터의 이름 목록정보를 리턴\r\n");
      out.write("    4. getParameterMap() : 웹브라우저가 전송한 파라미터의 맵을 리턴\r\n");
      out.write("\r\n");
      out.write("    request기본객체의 요청헤더정보관련 메서드\r\n");
      out.write("    \r\n");
      out.write("    HTTP프로토콜은 헤더정보에 부가적인 정보를 담고 있다. 예를 들어서 웹브라우저종류등과\r\n");
      out.write("    같은 정보를 담고 있다.\r\n");
      out.write("    \r\n");
      out.write("    1. getHeader(String name) : 지정한 이름의 헤더의 값 리턴\r\n");
      out.write("    2. getHeaders(String name) : 지정한 이름의 헤더목록을 리턴\r\n");
      out.write("    3. getHeaderName() : 모든 헤더의 이름을 리턴\r\n");
      out.write("    4. getIntHeader(String name) : 지정한 헤더의 값을 정수값으로 리턴\r\n");
      out.write("    5. getDateHeader(String name) : 지정한 헤더의 값을 시간 값으로 리턴\r\n");
      out.write("-->\r\n");

	String result = request.toString();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      out.print( result );
      out.write("\r\n");
      out.write("</body>\r\n");
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
