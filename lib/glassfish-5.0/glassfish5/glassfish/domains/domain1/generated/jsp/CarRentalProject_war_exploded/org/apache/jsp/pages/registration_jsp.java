package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
            response.setHeader("X-Powered-By", "JSP/2.3");
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
            out.write("<html>\n");
            out.write("<head>\n");
            out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\"\n");
            out.write("          integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">\n");
            out.write("    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"\n");
            out.write("            integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\"\n");
            out.write("            crossorigin=\"anonymous\"></script>\n");
            out.write("    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"\n");
            out.write("            integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\"\n");
            out.write("            crossorigin=\"anonymous\"></script>\n");
            out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"\n");
            out.write("            integrity=\"sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI\"\n");
            out.write("            crossorigin=\"anonymous\"></script>\n");
            out.write("    <link rel=\"stylesheet\" href=\"assets/css/index.css\">\n");
            out.write("    <link rel=\"stylesheet\" href=\"../assets/css/login.css\">\n");
            out.write("    <title>Title</title>\n");
            out.write("</head>\n");
            out.write("<body>\n");
            out.write("<div class=\"login-header\">\n");
            out.write("    <div class=\"row text-center\">\n");
            out.write("        <div class=\"col-sm-4\"></div>\n");
            out.write("        <div class=\"col-sm login-col\">\n");
            out.write("            <form method=\"post\" action=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext) _jspx_page_context, null));
            out.write("/admin/registration\">\n");
            out.write("                <div class=\"form-group text-left\">\n");
            out.write("                    <label>Full name</label>\n");
            out.write("                    <input type=\"text\" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\"\n");
            out.write("                           placeholder=\"Full name\">\n");
            out.write("                </div>\n");
            out.write("                <div class=\"form-group text-left\">\n");
            out.write("                    <label>Username</label>\n");
            out.write("                    <input type=\"text\" class=\"form-control\" placeholder=\"Username\">\n");
            out.write("                </div>\n");
            out.write("                <div class=\"form-group text-left\">\n");
            out.write("                    <label>Password</label>\n");
            out.write("                    <input type=\"password\" class=\"form-control\" placeholder=\"Password\">\n");
            out.write("                </div>\n");
            out.write("                <button type=\"submit\" class=\"btn login-btn\">Register</button>\n");
            out.write("            </form>\n");
            out.write("        </div>\n");
            out.write("        <div class=\"col-sm-4\"></div>\n");
            out.write("\n");
            out.write("    </div>\n");
            out.write("</div>\n");
            out.write("</body>\n");
            out.write("</html>\n");
        } catch (Throwable t) {
            if (!(t instanceof SkipPageException)) {
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
