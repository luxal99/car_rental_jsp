package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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
            out.write("<html>\n");
            out.write("<head>\n");
            out.write("    <title>$Title$</title>\n");
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
            out.write("</head>\n");
            out.write("<body>\n");
            out.write("<div class=\"header\">\n");
            out.write("    <nav class=\"navbar navbar-expand-lg \">\n");
            out.write("        <a class=\"navbar-brand\" href=\"#\">\n");
            out.write("            <img src=\"https://firebasestorage.googleapis.com/v0/b/soy-smile-249718.appspot.com/o/Avis-Logo.png?alt=media&token=3bad39c3-4e72-4de1-a4fa-c39dc175b7e7\" class=\"img-fluid\" width=\"100px\">\n");
            out.write("        </a>\n");
            out.write("        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
            out.write("            <span class=\"navbar-toggler-icon\"></span>\n");
            out.write("        </button>\n");
            out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n");
            out.write("            <ul class=\"navbar-nav\">\n");
            out.write("                <li class=\"nav-item active\">\n");
            out.write("                    <a class=\"nav-link\" href=\"#\">Home <span class=\"sr-only\">(current)</span></a>\n");
            out.write("                </li>\n");
            out.write("                <li class=\"nav-item\">\n");
            out.write("                    <a class=\"nav-link\" href=\"#\">Features</a>\n");
            out.write("                </li>\n");
            out.write("                <li class=\"nav-item\">\n");
            out.write("                    <a class=\"nav-link\" href=\"#\">Pricing</a>\n");
            out.write("                </li>\n");
            out.write("                <li class=\"nav-item\">\n");
            out.write("                    <a class=\"nav-link disabled\" href=\"#\" tabindex=\"-1\" aria-disabled=\"true\">Disabled</a>\n");
            out.write("                </li>\n");
            out.write("            </ul>\n");
            out.write("        </div>\n");
            out.write("    </nav>\n");
            out.write("    <div class=\"header-container\">\n");
            out.write("      <div class=\"text-center\">\n");
            out.write("          <h6>Lorem ipsum</h6>\n");
            out.write("          <h1 class=\"big-h1\">Amazing car rental agency</h1>\n");
            out.write("      </div>\n");
            out.write("        <div class=\"row header-row\">\n");
            out.write("            <div class=\"col\">\n");
            out.write("                <img src=\"https://firebasestorage.googleapis.com/v0/b/soy-smile-249718.appspot.com/o/PNGPIX-COM-White-Audi-TT-Clubsport-Turbo-Car-PNG-image.png?alt=media&token=d10aca0a-9ba1-4cb0-9168-433ec185eb1c\" alt=\"\" class=\"img-fluid\">\n");
            out.write("            </div>\n");
            out.write("            <div class=\"col\">\n");
            out.write("                <h1 class=\"header-h1\">Lorem Ipsum</h1>\n");
            out.write("                <h2 class=\"header-h2\">30% SALE</h2>\n");
            out.write("                <button class=\"red-btn\">MORE</button>\n");
            out.write("            </div>\n");
            out.write("        </div>\n");
            out.write("    </div>\n");
            out.write("    <div class=\"red-container\">\n");
            out.write("        <div class=\"row\">\n");
            out.write("            <div class=\"col\">\n");
            out.write("                <select class=\"form-control\">\n");
            out.write("                    <option>Default select</option>\n");
            out.write("                </select>\n");
            out.write("            </div>\n");
            out.write("            <div class=\"col\">\n");
            out.write("                <select class=\"form-control\">\n");
            out.write("                    <option>Default select</option>\n");
            out.write("                </select>\n");
            out.write("            </div>\n");
            out.write("            <div class=\"col\">\n");
            out.write("                <input type=\"date\" class=\"form-control\">\n");
            out.write("            </div>\n");
            out.write("            <div class=\"col\">\n");
            out.write("                <input type=\"date\" class=\"form-control\">\n");
            out.write("            </div>\n");
            out.write("            <div class=\"col\">\n");
            out.write("                <button class=\"reg-btn btn\">MORE</button>\n");
            out.write("            </div>\n");
            out.write("\n");
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
