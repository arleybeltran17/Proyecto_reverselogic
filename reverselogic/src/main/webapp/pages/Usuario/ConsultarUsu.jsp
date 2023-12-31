<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/cards.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/usuario.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
    <title>Listado De Usuarios</title>
</head>
<body>
    <div class="cont2"></div>
        <div class="all">
    <header>
        <img src="img/logo-removebg-preview.png">
        
    <div class="menu">
        <ul>
            <li class="submenu">
                <a href="#"><img class="imgbtn" src="img/usuario-de-perfil.png" ></a>
                <ul>
                    <li><a href="#"><button>Perfil</button></a></li>
                        <li><a href="Usuario?enviar=usuario"><button>Volver</button> </a></li>
                        <li><a href="index.jsp"><button>Menu</button> </a></li>
                    <li>
                        <form action="CerrarSesion" method="post">
                            <button type="submit" class="btnSalir">Salir</button>
                        </form> 
                    </li>  
                </ul>
            </li>
        </ul>
    </div>
    

    </header>
    
    <%@ page import="model.Usuario.UsuarioVo" %>
    <%@ page import="model.Usuario.UsuarioDao" %>

    <%-- Obtener la lista de usuarios desde la base de datos --%>
    <% List<UsuarioVo> usuarios = null;
        try {
            usuarios= new UsuarioDao().listarUsu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>

    <%-- Verificar si hay usuarios y mostrarlos --%>
    <% if (usuarios != null && !usuarios.isEmpty()) { %>
            <%-- Recorrer la lista de productos y mostrar sus detalles --%>
                <div class="card__container">
                    <% for (UsuarioVo usuario : usuarios) { %>
                        <div class="card">
                            <div class="card--img">
                            </div>
                            <div class="card--info">
                                <p class="card--subtittle">NOMBRE USUARIO</p>
                                <p id="Usu_Nombre_<%= usuario.getUsu_Id() %>" class="cardUsuNombre"><%= usuario.getUsu_Nombre() %></id=></p>
                                 <p class="card--subtittle">ROL</p>
                                <p id="Usu_Rol_<%= usuario.getUsu_Id() %>" class="cardUsuRol"><%= usuario.getUsu_Rol() %></p>
                                <p class="card--subtittle">CONTRASEÑA</p>
                                <p id="Usu_Contraseña_<%= usuario.getUsu_Id() %>" class="cardUsuContraseña"><%= usuario.getUsu_Password() %></p>
                                <p class="card--subtittle">EMPLE ID</p>
                                <p id="Emple_Id_<%= usuario.getUsu_Id() %>" class="cardEmpleId"><%= usuario.getEmple_Id() %></p>

                                <form action="Usuario" method="post">
                                    <input type="hidden" name="enviar" value="eliminarUsu">
                                    <input type="hidden" name="Usu_Id" value="<%= usuario.getUsu_Id() %>">
                                    <button type="submit" class="btn-delete">Eliminar</button>
                                </form>
                            <button class="btncal" data-usu-id="<%= usuario.getUsu_Id() %>">Actualizar</button>
                            </div>
                            
                        </div>
                    <% } %>
                <% } else { %>
                    <div class="card">
                        <p>No Se Encontraron Usuarios.</p>
                    </div>
                <% } %>
            </div>
        </div>
    </div>
            </body>
            <% 
            Boolean mostrarModal = (Boolean) session.getAttribute("mostrarModalActualizacion");
            if (mostrarModal != null && mostrarModal) {
                // Inicialmente, muestra la ventana modal
                session.setAttribute("mostrarModalActualizacion", false); // Para evitar que se muestre en futuras cargas
            %>
            <div id="myModal1" class="modal1">
            <div class="modal-content1">
            <span class="close1">X</span>
    
            <h2>Actualizar Usuarios</h2>
            <form action="Usuario" method="post">
        
                <div class="contlabel">
                    <label for="Usu_Id"> ID Usuario</label>
                    <input type="text" name="Usu_Id" id="Usu_Id"  placeholder="Ingrese El Id Del Cliente">
                </div>
                
                <div class="contlabel1">
                    <label for="Usu_Nombre"> Nombre Usuario</label>
                    <input type="text" name="Usu_Nombre" id="Usu_Nombre" placeholder="Ingrese El Tipo De Documento">
                </div>

                
        <div class="contlabel2">
            <label for="Usu_Rol"> Rol De Usuario</label>
            <input type="text" name="Usu_Rol" id="Usu_Rol"  placeholder="Ingrese El Numero De Documento">
        </div>
            
        <div class="contlabel3">
            <label for="Usu_Password"> Contraseña De Usuario</label>
            <input type="text" name="Usu_Password" id="Usu_Password"  placeholder="Ingrese El Nombre Del Cliente">
        </div>
        <div class="contlabel4">
            <label for="Emple_Id"> Id De Empleado</label>
            <input type="text" name="Emple_Id" id="Emple_Id"  placeholder="Ingrese El Apellido Del Cliente">
        </div>
            <button class="btncal" name="enviar" value="updateUsu">Enviar</button>
        
            </form>
            </div>
            </div>
            <% } %>

            <script type="text/javascript" src="js/modal4.js"></script>
            </body>
</html>