package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import app.entity.Client;
import app.service.impl.ClientServiceImpl;
import app.util.HashPassword;
import app.entity.Account;
import app.service.impl.AccountServiceImpl;
import app.dto.TransactionDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public final class client_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Client panel</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"../assets/css/client.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\"\n");
      out.write("          integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"../assets/node_modules/font-awesome/css/font-awesome.min.css\">\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\"\n");
      out.write("            integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\"\n");
      out.write("            crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"\n");
      out.write("            integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\"\n");
      out.write("            crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"\n");
      out.write("            integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\"\n");
      out.write("            crossorigin=\"anonymous\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    ");


        Cookie[] cookies = request.getCookies();
        Cookie idCookie = new Cookie("id", "");

        boolean haveId = false;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("id")) {
                haveId = true;
                idCookie.setValue(cookie.getValue());
            }
        }

        if (!haveId) {
            response.sendRedirect(request.getContextPath());
        }

        ClientServiceImpl<Client> clientService = new ClientServiceImpl<Client>(Client.class);
        Client client = clientService.findById(Integer.valueOf(HashPassword.decrypt(idCookie.getValue())));

        request.setAttribute("clinet", client);


    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\" header-menu\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-sm text-left\" style=\"padding-top: .5em;padding-bottom: .5em\">\n");
      out.write("                <img src=\"https://firebasestorage.googleapis.com/v0/b/soy-smile-249718.appspot.com/o/1280px-Starling_Bank_Logo.svg.png?alt=media&token=260dc062-b7a4-432a-8c0c-bd4c5c542687\"\n");
      out.write("                     width=\"100px\" class=\"img-fluid\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm text-right\">\n");
      out.write("                <button type=\"button\" class=\"profile-btn\" data-toggle=\"modal\" data-target=\"#exampleModal\"><h4><i\n");
      out.write("                        class=\"fa fa-user\"></i> Profile</h4></button>\n");
      out.write("                <button type=\"button\" class=\"profile-btn\" data-toggle=\"modal\" data-target=\"#clientInfoModel\"><h4><i\n");
      out.write("                        class=\"fa fa-user\"></i> Client information</h4></button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"content-container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-sm-2 menu\">\n");
      out.write("                <div class=\"nav flex-column nav-pills\" id=\"v-pills-tab\" role=\"tablist\" aria-orientation=\"vertical\">\n");
      out.write("                    <a class=\"nav-link active\" id=\"v-pills-home-tab\" data-toggle=\"pill\" href=\"#v-pills-home\" role=\"tab\"\n");
      out.write("                       aria-controls=\"v-pills-home\" aria-selected=\"true\">Overview</a>\n");
      out.write("                    <a class=\"nav-link\" id=\"v-pills-profile-tab\" data-toggle=\"pill\" href=\"#v-pills-profile\" role=\"tab\"\n");
      out.write("                       aria-controls=\"v-pills-profile\" aria-selected=\"false\">Accounts</a>\n");
      out.write("                    <a class=\"nav-link\" id=\"v-pills-messages-tab\" data-toggle=\"pill\" href=\"#v-pills-messages\" role=\"tab\"\n");
      out.write("                       aria-controls=\"v-pills-messages\" aria-selected=\"false\">Transaction</a>\n");
      out.write("                    <a class=\"nav-link\" id=\"v-pills-settings-tab\" data-toggle=\"pill\" href=\"#v-pills-settings\" role=\"tab\"\n");
      out.write("                       aria-controls=\"v-pills-settings\" aria-selected=\"false\">Settings</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-1\"></div>\n");
      out.write("            <div class=\"col-sm-9\" style=\"max-height: 80vh;\n");
      out.write("    overflow: scroll;\n");
      out.write("    overflow-x: hidden;\">\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                ");

                    Account defaultAccount = new Account();
                    if (request.getParameter("changeAccount") == null) {
                        defaultAccount = client.getAccountList().get(0);

                        request.setAttribute("currentAccount", defaultAccount);
                    } else {
                        AccountServiceImpl accountService = new AccountServiceImpl(Account.class);
                        defaultAccount = accountService.findById(Integer.valueOf(request.getParameter("idAccount")));
                        request.setAttribute("currentAccount", defaultAccount);
                    }

                
      out.write("\n");
      out.write("\n");
      out.write("                ");


                    List<TransactionDTO> transactionDTOList = new ArrayList<TransactionDTO>();
                    for (int i = 0; i < defaultAccount.getAccountTransactionList().size(); i++) {
                        for (int j = 0; j < defaultAccount.getAccountTransactionList().get(j).getIdTransaction().getAccountTransactionList().size(); j++) {

                            TransactionDTO transactionDTO = new TransactionDTO();

                            if (defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdTypeTransaction().getTitle().equals("payout") &&
                                    defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount().getIdAccount() != defaultAccount.getIdAccount()
                            ) {

                                transactionDTO.setAccount(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount());
                                transactionDTO.setDate(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getDate());
                                transactionDTO.setAmount(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAmount());

                                transactionDTO.setTypeOfTransaction("payup");

                                if (defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount().getIdBank() != null) {
                                    transactionDTO.setSubject(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount().getIdBank().getTitle());

                                } else {
                                    transactionDTO.setSubject(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount().getIdClient().getName() + " " +
                                            defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount().getIdClient().getLastname());

                                }
                                transactionDTOList.add(transactionDTO);


                            } else if (defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdTypeTransaction().getTitle().equals("payup")
                                    && defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount().getIdAccount() != defaultAccount.getIdAccount()
                            ) {

                                transactionDTO.setAccount(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount());
                                transactionDTO.setDate(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getDate());
                                transactionDTO.setAmount(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAmount());

                                if (defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount().getIdBank() != null) {
                                    transactionDTO.setSubject(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount().getIdBank().getTitle());

                                } else {
                                    transactionDTO.setSubject(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount().getIdClient().getName() + " " +
                                            defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount().getIdClient().getLastname());

                                }

                                transactionDTO.setTypeOfTransaction("payout");
                                transactionDTOList.add(transactionDTO);
                            }


                        }

                    }
                
      out.write("\n");
      out.write("                <div class=\"client-info-div\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-4\">\n");
      out.write("                            <h4>Hello, <span>");
      out.print(client.getName());
      out.write("</span></h4>\n");
      out.write("                            <h4>Account number <span style=\"color: #7530FF\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentAccount.accountNumber}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span></h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-8 text-right\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col\">\n");
      out.write("                                    <h4>Your username <br> <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clinet.userList.get(0).username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span></h4>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col\">\n");
      out.write("                                    <h4>Your client id <br> <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clinet.idClient}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span></h4>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div style=\"height: 1px;background-color: #eee\"></div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"tab-content\" id=\"v-pills-tabContent\">\n");
      out.write("                    <div class=\"tab-pane fade show active\" id=\"v-pills-home\" role=\"tabpanel\"\n");
      out.write("                         aria-labelledby=\"v-pills-messages-tab\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("\n");
      out.write("                            <div class=\"col-4 account-col\">\n");
      out.write("\n");
      out.write("                                <h4>Balance </h4>\n");
      out.write("                                <h1 class=\"balance-h1\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentAccount.balance}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h1>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col  transaction-col\">\n");
      out.write("                                <table class=\"table text-right\">\n");
      out.write("                                    <thead>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th scope=\"col\">#</th>\n");
      out.write("                                        <th scope=\"col\">Account Number</th>\n");
      out.write("                                        <th scope=\"col\">Client</th>\n");
      out.write("                                        <th scope=\"col\">Client</th>\n");
      out.write("                                    </tr>\n");
      out.write("                                    </thead>\n");
      out.write("                                    <tbody>\n");
      out.write("\n");
      out.write("                                    ");
      out.write("\n");
      out.write("\n");
      out.write("                                    ");
for (int i = defaultAccount.getAccountTransactionList().size() - 1; i > defaultAccount.getAccountTransactionList().size() - 5; i--) { 
      out.write("\n");
      out.write("\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>");
      out.print( defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getIdTransaction() );
      out.write("\n");
      out.write("                                        </td>\n");
      out.write("                                        <td>");
      out.print( defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getDate() );
      out.write("\n");
      out.write("                                        </td>\n");
      out.write("                                        <td class=\"");
      out.print(defaultAccount.getAccountTransactionList().get(i).getIdTypeTransaction().getTitle());
      out.write('"');
      out.write('>');
      out.print( defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAmount() );
      out.write("\n");
      out.write("                                        </td>\n");
      out.write("                                        <td>");
      out.print( defaultAccount.getAccountTransactionList().get(i).getIdTypeTransaction().getTitle() );
      out.write("\n");
      out.write("                                        </td>\n");
      out.write("\n");
      out.write("                                    </tr>\n");
      out.write("                                    ");
 }
                                    
      out.write("\n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <h3 style=\"margin-left: 2em;margin-top: 2em\">Send money</h3>\n");
      out.write("                        <div class=\"row transfer-row\">\n");
      out.write("\n");
      out.write("                            <div style=\"height: 1px;background-color: #eee\"></div>\n");
      out.write("\n");
      out.write("                            <div class=\"col transfer-col\" style=\"margin-left: 2em;margin-right: 2em\">\n");
      out.write("                                <div style=\"padding: 1em 2em 2em 1em\">\n");
      out.write("                                    <h5>Current account <span\n");
      out.write("                                            style=\"font-weight: bold\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentAccount.accountNumber}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span></h5>\n");
      out.write("\n");
      out.write("                                    <form method=\"post\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/account\">\n");
      out.write("                                        <div class=\"input-group mb-3\">\n");
      out.write("                                            <div class=\"input-group-prepend\">\n");
      out.write("                                            <span style=\"background-color: #7530FF;color: #fff\" class=\"input-group-text\"\n");
      out.write("                                                  id=\"basic-addon1\"><i class=\"fa fa-address-card\"></i></span>\n");
      out.write("                                            </div>\n");
      out.write("                                            <input style=\"background-color: #eee;border: 1px solid #eee;border-radius: 5px;\"\n");
      out.write("                                                   type=\"text\" name=\"clientAccountNumber\" class=\"form-control\"\n");
      out.write("                                                   placeholder=\"Account number\"\n");
      out.write("                                                   aria-label=\"Username\" aria-describedby=\"basic-addon1\">\n");
      out.write("                                            <input type=\"hidden\" name=\"currentAccountNumber\"\n");
      out.write("                                                   value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentAccount.accountNumber}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"input-group mb-3\">\n");
      out.write("                                            <div class=\"input-group-prepend\">\n");
      out.write("                                            <span style=\"background-color: #7530FF;color: #fff\" class=\"input-group-text\"\n");
      out.write("                                                  id=\"basic-addon2\">$</span>\n");
      out.write("                                            </div>\n");
      out.write("                                            <input style=\"background-color: #eee;border: 1px solid #eee;border-radius: 5px;\"\n");
      out.write("                                                   type=\"text\" name=\"amount\" class=\"form-control\"\n");
      out.write("                                                   placeholder=\"Account number\"\n");
      out.write("                                                   aria-label=\"Username\" aria-describedby=\"basic-addon1\"><br>\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        <div>\n");
      out.write("                                            <button type=\"submit\" class=\"transfer-btn\">Send</button>\n");
      out.write("                                        </div>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col\"></div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"tab-pane fade\" id=\"v-pills-profile\" role=\"tabpanel\"\n");
      out.write("                         aria-labelledby=\"v-pills-messages-tab\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <table class=\"table text-right\">\n");
      out.write("                            <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th scope=\"col\">#</th>\n");
      out.write("                                <th scope=\"col\">Account Number</th>\n");
      out.write("                                <th scope=\"col\">Client</th>\n");
      out.write("                                <th scope=\"col\">Handle</th>\n");
      out.write("                            </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            ");
 for (Account account : client.getAccountList()) { 
      out.write("\n");
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print( account.getIdAccount() );
      out.write("\n");
      out.write("                                </td>\n");
      out.write("                                <td>");
      out.print( account.getAccountNumber() );
      out.write("\n");
      out.write("                                </td>\n");
      out.write("                                <td>");
      out.print( account.getBalance() );
      out.write("\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <form method=\"get\" action=\"client.jsp\">\n");
      out.write("                                        <button class=\"open-btn\" type=\"submit\" name=\"changeAccount\">Change account\n");
      out.write("                                        </button>\n");
      out.write("                                        <input type=\"hidden\" name=\"idAccount\" value=\"");
      out.print(account.getIdAccount());
      out.write("\"/>\n");
      out.write("                                    </form>\n");
      out.write("                                </td>\n");
      out.write("                                <td></td>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                            ");
 }
                            
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"tab-pane fade\" id=\"v-pills-messages\" role=\"tabpanel\"\n");
      out.write("                         aria-labelledby=\"v-pills-messages-tab\">\n");
      out.write("\n");
      out.write("                        <table class=\"table text-right\">\n");
      out.write("                            <thead>\n");
      out.write("                            <tr style=\"background-color: #eee\">\n");
      out.write("                                <th scope=\"col\">Date</th>\n");
      out.write("                                <th scope=\"col\">Amount</th>\n");
      out.write("                                <th scope=\"col\">User</th>\n");
      out.write("                                <th scope=\"col\">Account number</th>\n");
      out.write("                            </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            ");
 for (TransactionDTO transactionDTO : transactionDTOList) { 
      out.write("\n");
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print( transactionDTO.getDate() );
      out.write("\n");
      out.write("                                </td>\n");
      out.write("                                <td class=\"");
      out.print(transactionDTO.getTypeOfTransaction());
      out.write('"');
      out.write('>');
      out.print( transactionDTO.getAmount());
      out.write("\n");
      out.write("                                </td>\n");
      out.write("                                <td>");
      out.print(transactionDTO.getSubject());
      out.write("\n");
      out.write("                                </td>\n");
      out.write("                                <td>");
      out.print( transactionDTO.getAccount().getAccountNumber());
      out.write("\n");
      out.write("                                </td>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                            ");
 }
                            
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"tab-pane fade\" id=\"v-pills-settings\" role=\"tabpanel\"\n");
      out.write("                         aria-labelledby=\"v-pills-settings-tab\"></div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\"\n");
      out.write("         aria-hidden=\"true\">\n");
      out.write("        <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h5 class=\"modal-title\">User information</h5>\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                        <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/client/user\" method=\"post\">\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"exampleInputEmail1\">Username</label>\n");
      out.write("                            <input type=\"text\" name=\"username\" class=\"form-control\"\n");
      out.write("                                   value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clinet.userList.get(0).username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("                                   aria-describedby=\"emailHelp\" placeholder=\"Enter email\">\n");
      out.write("                            <small class=\"form-text text-muted\">We'll never share your email with anyone\n");
      out.write("                                else.</small>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"exampleInputPassword1\">Current password</label>\n");
      out.write("                            <input type=\"password\" name=\"password\" class=\"form-control\"\n");
      out.write("                                   placeholder=\"Password\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"exampleInputPassword1\">New password</label>\n");
      out.write("                            <input type=\"password\" name=\"newPassword\" class=\"form-control\"\n");
      out.write("                                   placeholder=\"Password\">\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\">Save changes</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"modal fade\" id=\"clientInfoModel\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\"\n");
      out.write("         aria-hidden=\"true\">\n");
      out.write("        <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h5 class=\"modal-title\" id=\"exampleModalLabel\">Client information</h5>\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                        <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <form method=\"post\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/client\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"exampleInputEmail1\">Telephone</label>\n");
      out.write("                            <input type=\"text\" name=\"telephone\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clinet.telephone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("                                   id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\" placeholder=\"Enter email\">\n");
      out.write("                            <small id=\"emailHelp\" class=\"form-text text-muted\">We'll never share your email with anyone\n");
      out.write("                                else.</small>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"exampleInputPassword1\">Email</label>\n");
      out.write("                            <input type=\"text\" name=\"email\" class=\"form-control\"\n");
      out.write("                                   placeholder=\"Password\">\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"exampleInputPassword1\">Email</label>\n");
      out.write("                            <input value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clinet.idClient}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" type=\"hidden\" name=\"idClient\" class=\"form-control\"\n");
      out.write("                                   id=\"exampleInputPassword1\" placeholder=\"Password\">\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\">Save changes</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
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
