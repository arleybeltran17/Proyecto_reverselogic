/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-11-29 00:02:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages.Empleado;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import model.Empleado.EmpleadoVo;
import model.Empleado.EmpleadoDao;

public final class ConsultarEmple_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("model.Empleado.EmpleadoDao");
    _jspx_imports_classes.add("model.Empleado.EmpleadoVo");
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
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
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
      response.setContentType("text/html; charset=utf-8");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"es\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath() );
      out.write("/css/cards.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath() );
      out.write("/css/usuario.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath() );
      out.write("/css/style.css\">\r\n");
      out.write("    <title>Listado De Empleados</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body >\r\n");
      out.write("    <div class=\"cont2\"></div>\r\n");
      out.write("        <div class=\"all\">\r\n");
      out.write("    <header>\r\n");
      out.write("        <img src=\"");
      out.print( request.getContextPath() );
      out.write("/img/logo-removebg-preview.png\" alt=\"Mi Imagen\">\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("    <div class=\"menu\">\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li class=\"submenu\">\r\n");
      out.write("                <a href=\"#\"><img class=\"imgbtn\" src=\"");
      out.print( request.getContextPath() );
      out.write("/img/usuario-de-perfil.png\" alt=\"Usuario\"></a>\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><a href=\"#\"><button>Perfil</button></a></li>\r\n");
      out.write("                        <li><a href=\"Empleado?enviar=empleado\"><button>Volver</button> </a></li>\r\n");
      out.write("                        <li><a href=\"index.jsp\"><button>Menu</button> </a></li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <form action=\"CerrarSesion\" method=\"post\">\r\n");
      out.write("                            <button type=\"submit\" class=\"btnSalir\">Salir</button>\r\n");
      out.write("                        </form> \r\n");
      out.write("                    </li>  \r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    </header>\r\n");
      out.write("    <br><br>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    ");
 List<EmpleadoVo> empleados = null;
        try {
            empleados = new EmpleadoDao().listarEmple();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    ");
 if (empleados != null && !empleados.isEmpty()) { 
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("                <div class=\"card__container\">\r\n");
      out.write("                    ");
 for (EmpleadoVo empleado : empleados) { 
      out.write("\r\n");
      out.write("                        <div class=\"card\">\r\n");
      out.write("                            <div class=\"card--img\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"card--info\">\r\n");
      out.write("                                <p class=\"card--subtittle\">TIPO DOCUMENTO</p>\r\n");
      out.write("                                <p id=\"Emple_Tipo_Doc_");
      out.print( empleado.getEmple_Id() );
      out.write("\" class=\"cardEmpleTipoDoc\" >");
      out.print( empleado.getEmple_Tipo_Doc() );
      out.write("</id></p>\r\n");
      out.write("                                 <br>\r\n");
      out.write("                                <p class=\"card--subtittle\">NUMERO DOCUMENTO</p>\r\n");
      out.write("                                <p id=\"Emple_Num_Doc_");
      out.print( empleado.getEmple_Id() );
      out.write("\" class=\"cardEmpleNumDoc\" >");
      out.print( empleado.getEmple_Num_Doc() );
      out.write("</p>\r\n");
      out.write("                                <br>\r\n");
      out.write("                                <p class=\"card--subtittle\">NOMBRE</p>\r\n");
      out.write("                                <p id=\"Emple_Nombre_");
      out.print( empleado.getEmple_Id() );
      out.write("\" class=\"cardEmpleNombre\" >");
      out.print( empleado.getEmple_Nombre() );
      out.write("</p>\r\n");
      out.write("                                <br>\r\n");
      out.write("                                <p class=\"card--subtittle\">APELLIDO</p>\r\n");
      out.write("                                <p id=\"Emple_Apellido_");
      out.print( empleado.getEmple_Id() );
      out.write("\" class=\"cardEmpleApellido\">");
      out.print( empleado.getEmple_Apellido() );
      out.write("</p>\r\n");
      out.write("                                <br>\r\n");
      out.write("                                <p class=\"card--subtittle\">CARGO</p>\r\n");
      out.write("                                <p id=\"Emple_Cargo_");
      out.print( empleado.getEmple_Id() );
      out.write("\" class=\"cardEmpleCargo\" >");
      out.print( empleado.getEmple_Cargo() );
      out.write(" </p>\r\n");
      out.write("                                <br>\r\n");
      out.write("                                <p class=\"card--subtittle\">DIRECCION</p>\r\n");
      out.write("                                <p id=\"Emple_Direccion_");
      out.print( empleado.getEmple_Id() );
      out.write("\" class=\"cardEmpleDireccion\">");
      out.print( empleado.getEmple_Direccion() );
      out.write(" </p>\r\n");
      out.write("                                <br>\r\n");
      out.write("                                <p class=\"card--subtittle\">CORREO</p>\r\n");
      out.write("                                <p id=\"Emple_Email_");
      out.print( empleado.getEmple_Id() );
      out.write("\" class=\"cardEmpleEmail\">");
      out.print( empleado.getEmple_Email() );
      out.write(" </p>\r\n");
      out.write("                                <br>\r\n");
      out.write("                                <form action=\"");
      out.print( request.getContextPath() );
      out.write("/Empleado\" method=\"post\">\r\n");
      out.write("                                    <input type=\"hidden\" name=\"enviar\" value=\"eliminarEmple\">\r\n");
      out.write("                                    <input type=\"hidden\" name=\"Emple_Id\" value=\"");
      out.print( empleado.getEmple_Id() );
      out.write("\">\r\n");
      out.write("                                    <button type=\"submit\" class=\"btn-delete\">Eliminar</button><br>\r\n");
      out.write("                                </form>\r\n");
      out.write("                                <br>\r\n");
      out.write("                            <button class=\"btncal\" data-emple-id=\"");
      out.print( empleado.getEmple_Id() );
      out.write("\">Actualizar</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            \r\n");
      out.write("                        </div>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("                ");
 } else { 
      out.write("\r\n");
      out.write("                    <div class=\"card\">\r\n");
      out.write("                        <p>No Se Encontraron Empleados.</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                ");
 } 
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    ");
 
Boolean mostrarModal = (Boolean) session.getAttribute("mostrarModalActualizacion");
if (mostrarModal != null && mostrarModal) {
    // Inicialmente, muestra la ventana modal
    session.setAttribute("mostrarModalActualizacion", false); // Para evitar que se muestre en futuras cargas

      out.write("\r\n");
      out.write("<div id=\"myModal1\" class=\"modal1\">\r\n");
      out.write("<div class=\"modal-content1\">\r\n");
      out.write("<span class=\"close1\">X</span>\r\n");
      out.write("\r\n");
      out.write("<h2>Actualizar Empleado</h2>\r\n");
      out.write("<br><br>\r\n");
      out.write("<form action=\"Empleado\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("    <br>\r\n");
      out.write("    <br>\r\n");
      out.write("    <div class=\"contlabel\">\r\n");
      out.write("        <input type=\"text\" name=\"Emple_Id\" id=\"Emple_Id\" >\r\n");
      out.write("        <label for=\"Emple_Id\"> ID Empleado</label>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <br>\r\n");
      out.write("    <br>\r\n");
      out.write("    <div class=\"contlabel\">\r\n");
      out.write("        <input type=\"text\" name=\"Emple_Tipo_Doc\" id=\"Emple_Tipo_Doc\">\r\n");
      out.write("        <label for=\"Emple_Tipo_Doc\"> Tipo De Documento</label>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <br>\r\n");
      out.write("    <br>\r\n");
      out.write("    <div class=\"contlabel1\">\r\n");
      out.write("        <input type=\"text\" name=\"Emple_Num_Doc\" id=\"Emple_Num_Doc\" >\r\n");
      out.write("        <label for=\"Emple_Num_Doc\"> Numero De Documento</label>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <br>\r\n");
      out.write("    <br>\r\n");
      out.write("    <div class=\"contlabel2\">\r\n");
      out.write("        <input type=\"text\" name=\"Emple_Nombre\" id=\"Emple_Nombre\" >\r\n");
      out.write("        <label for=\"Emple_Nombre\"> Nombre</label>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <br>\r\n");
      out.write("    <br>\r\n");
      out.write("    <div class=\"contlabel3\">\r\n");
      out.write("        <input type=\"text\" name=\"Emple_Apellido\" id=\"Emple_Apellido\"  >\r\n");
      out.write("        <label for=\"Emple_Apellido\"> Apellido</label>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <br>\r\n");
      out.write("    <br>\r\n");
      out.write("    <div class=\"contlabel4\">\r\n");
      out.write("        <input type=\"text\" name=\"Emple_Cargo\" id=\"Emple_Cargo\"  >\r\n");
      out.write("        <label for=\"Emple_Cargo\"> Cargo</label>\r\n");
      out.write("    </div>\r\n");
      out.write("     \r\n");
      out.write("    <br>\r\n");
      out.write("    <br>   \r\n");
      out.write("    <div class=\"contlabel5\">\r\n");
      out.write("        <input type=\"text\" name=\"Emple_Direccion\" id=\"Emple_Direccion\" >\r\n");
      out.write("        <label for=\"Emple_Direccion\"> Direccion</label>\r\n");
      out.write("    </div>\r\n");
      out.write("      \r\n");
      out.write("    <br>\r\n");
      out.write("    <br>  \r\n");
      out.write("    <div class=\"contlabel6\">\r\n");
      out.write("        <input type=\"text\" name=\"Emple_Email\" id=\"Emple_Email\" >\r\n");
      out.write("        <label for=\"Emple_Email\"> Email</label>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <br>\r\n");
      out.write("    <br> \r\n");
      out.write("\r\n");
      out.write("<button class=\"btncal\" name=\"enviar\" value=\"updateEmple\">Enviar</button>\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
 } 
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            <script type=\"text/javascript\" src=\"js/modal1.js\"></script>\r\n");
      out.write("            </body>\r\n");
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
