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
    <title>Listado De Clientes</title>
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
                    <li><a href="Cliente?enviar=cliente"><button>Volver</button> </a></li>
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
    
    <%@ page import="model.Cliente.ClienteVo" %>
    <%@ page import="model.Cliente.ClienteDao" %>

    <%-- Obtener la lista de usuarios desde la base de datos --%>
    <% List<ClienteVo> clientes = null;
        try {
            clientes = new ClienteDao().listarClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>

    <%-- Verificar si hay usuarios y mostrarlos --%>
    <% if (clientes != null && !clientes.isEmpty()) { %>
            <%-- Recorrer la lista de productos y mostrar sus detalles --%>
                <div class="card__container">
                    <% for (ClienteVo cliente : clientes) { %>
                        <div class="card">
                            <div class="card--img">
                            </div>
                            <div class="card--info">
                                <p class="card--subtittle">TIPO DOC</p>
                                <p id="Clie_Tipo_Doc_<%= cliente.getClie_Id() %>" class="cardClieTipoDoc"><%= cliente.getClie_Tipo_Doc() %></id=></p>
                                 <p class="card--subtittle">N DOC</p>
                                <p id="Clie_Num_Doc_<%= cliente.getClie_Id() %>" class="cardClieNumDoc"><%= cliente.getClie_Num_Doc() %></p>
                                <p class="card--subtittle">NOM</p>
                                <p id="Clie_Nombre_<%= cliente.getClie_Id() %>" class="cardClieNombre"><%= cliente.getClie_Nombre() %></p>
                                <p class="card--subtittle">Apellido</p>
                                <p id="Clie_Apellido_<%= cliente.getClie_Id() %>" class="cardClieApellido"><%= cliente.getClie_Apellido() %></p>
                                <p class="card--subtittle">DIRECCION</p>
                                <p id="Clie_Direccion_<%= cliente.getClie_Id() %>" class="cardClieDireccion"><%= cliente.getClie_Direccion() %> </p>
                                <p class="card--subtittle">Email</p>
                                <p id="Clie_Email_<%= cliente.getClie_Id() %>" class="cardClieEmail"><%= cliente.getClie_Email() %> </p>

                                <form action="Cliente" method="post">
                                    <input type="hidden" name="enviar" value="eliminarClient">
                                    <input type="hidden" name="Clie_Id" value="<%= cliente.getClie_Id() %>">
                                    <button type="submit" class="btn-delete">Eliminar</button>
                                </form>
                            <button class="btncal" data-clie-id="<%= cliente.getClie_Id() %>">Actualizar</button>
                            </div>
                            
                        </div>
                    <% } %>
                <% } else { %>
                    <div class="card">
                        <p>No Se Encontraron Clientes.</p>
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
        
            <h2>Actualizar Cliente</h2>
            <form action="Cliente" method="post">
        
            <label for="Clie_Id"> ID Cliente</label>
            <input type="text" name="Clie_Id" id="Clie_Id"  placeholder="Ingrese El Id Del Cliente">
    
            <label for="Clie_Tipo_Doc"> Tipo De Documento</label>
            <input type="text" name="Clie_Tipo_Doc" id="Clie_Tipo_Doc" placeholder="Ingrese El Tipo De Documento">
    
            <label for="Clie_Num_Doc"> Numero De Documento</label>
            <input type="text" name="Clie_Num_Doc" id="Clie_Num_Doc"  placeholder="Ingrese El Numero De Documento">
    
            <label for="Cliee_Nombre"> Nombre</label>
            <input type="text" name="Clie_Nombre" id="Clie_Nombre"  placeholder="Ingrese El Nombre Del Cliente">
    
            <label for="Clie_Apellido"> Apellido</label>
            <input type="text" name="Clie_Apellido" id="Clie_Apellido"  placeholder="Ingrese El Apellido Del Cliente">
    
            <label for="Clie_Direccion"> Direccion</label>
            <input type="text" name="Clie_Direccion" id="Clie_Direccion"  placeholder="Ingrese La Direccion Del Cliente">
    
            <label for="Clie_Email"> Email</label>
            <input type="text" name="Clie_Email" id="Clie_Email"  placeholder="Ingrese El Email Del Cliente">
    
            <button class="btncal" name="enviar" value="updateClient">Enviar</button>
        
            </form>
            </div>
            </div>
            <% } %>

            <script type="text/javascript" src="js/modal2.js"></script>
            </body>
</html>