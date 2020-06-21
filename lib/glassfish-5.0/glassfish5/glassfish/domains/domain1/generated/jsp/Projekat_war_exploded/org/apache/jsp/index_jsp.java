package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

import app.service.impl.AccountServiceImpl;
import app.util.HashPassword;
import app.service.impl.TransactionServiceImpl;
import app.entity.Transaction;
import app.service.impl.BankServiceImpl;
import app.entity.Bank;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
            out.write("\n");
            out.write("\n");
            out.write("\n");
            out.write("\n");
            out.write("\n");
            out.write("\n");
            out.write("<html>\n");
            out.write("<head>\n");
            out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
            out.write("    <link rel=\"stylesheet\" href=\"assets/css/index.css\">\n");
            out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\"\n");
            out.write("          integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
            out.write("    <script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\"\n");
            out.write("            integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\"\n");
            out.write("            crossorigin=\"anonymous\"></script>\n");
            out.write("    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"\n");
            out.write("            integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\"\n");
            out.write("            crossorigin=\"anonymous\"></script>\n");
            out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"\n");
            out.write("            integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\"\n");
            out.write("            crossorigin=\"anonymous\"></script>\n");
            out.write("    <title>$Title$</title>\n");
            out.write("</head>\n");
            out.write("<body>\n");
            out.write("<div>\n");
            out.write("    <div class=\"container login-container\">\n");
            out.write("        <div class=\"row\">\n");
            out.write("            <div class=\"col-sm \" style=\"padding: 0 !important;\">\n");
            out.write("                <div class=\"left-col\">\n");
            out.write("                    <div class=\"container\">\n");
            out.write("                        <h1 class=\"text-center\" style=\"color: #fff;padding-top: 25%\">Welcome</h1>\n");
            out.write("                        <h4 class=\"text-center\">Lorem Ipsum is simply dummy text of the printing and typesetting\n");
            out.write("                            industry.</h4>\n");
            out.write("                    </div>\n");
            out.write("                </div>\n");
            out.write("            </div>\n");
            out.write("            <div class=\"col-sm\" style=\"padding-top: 5em\">\n");
            out.write("                <div>\n");
            out.write("                    <form method=\"post\" action=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext) _jspx_page_context, null));
            out.write("/admin/login\">\n");
            out.write("                        <div class=\"form-group\">\n");
            out.write("                            <label for=\"exampleInputEmail1\">Username</label>\n");
            out.write("                            <input type=\"text\" name=\"username\" class=\"form-control\" id=\"exampleInputEmail1\"\n");
            out.write("                                   aria-describedby=\"emailHelp\">\n");
            out.write("                            <small id=\"emailHelp\" class=\"form-text text-muted\">We'll never share your email with anyone\n");
            out.write("                                else.</small>\n");
            out.write("                        </div>\n");
            out.write("                        <div class=\"form-group\">\n");
            out.write("                            <label for=\"exampleInputPassword1\">Password</label>\n");
            out.write("                            <input type=\"password\" name=\"password\" class=\"form-control\" id=\"exampleInputPassword1\">\n");
            out.write("                        </div>\n");
            out.write("                        <div class=\"form-group form-check\">\n");
            out.write("                            <input type=\"checkbox\" class=\"form-check-input\" id=\"exampleCheck1\">\n");
            out.write("                            <label class=\"form-check-label\" for=\"exampleCheck1\">Check me out</label>\n");
            out.write("                        </div>\n");
            out.write("                        <button type=\"submit\" class=\" login-btn\">Submit</button>\n");
            out.write("                    </form>\n");
            out.write("                </div>\n");
            out.write("            </div>\n");
            out.write("        </div>\n");
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
