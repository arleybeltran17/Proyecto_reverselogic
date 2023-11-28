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
    <title>Listado De Metodo De Pago</title>
</head>
<body >
    <div class="cont2"></div>
        <div class="all">
    <header>
        <img src="<%= request.getContextPath() %>/img/logo-removebg-preview.png" alt="Mi Imagen">
        
        
    <div class="menu">
        <ul>
            <li class="submenu">
                <a href="#"><img class="imgbtn" src="<%= request.getContextPath() %>/img/usuario-de-perfil.png" alt="Usuario"></a>
                <ul>
                    <li><a href="#"><button>Perfil</button></a></li>
                        <li><a href="MenuEmpleado?enviar=menu"><button>Menu</button> </a></li>
                        <li><a href="MetodosDePagoEmple?enviar=Metodos"><button>Volver</button> </a></li> 
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
    <br><br>
    <%@ page import="model.MetodoDePago.MetodoDePagoVo" %>
    <%@ page import="model.MetodoDePago.MetodoDePagoDao" %>

    <%-- Obtener la lista de usuarios desde la base de datos --%>
    <% List<MetodoDePagoVo> metodos = null;
        try {
            metodos = new MetodoDePagoDao().listarMetod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>

    <%-- Verificar si hay usuarios y mostrarlos --%>
    <% if (metodos != null && !metodos.isEmpty()) { %>
            <%-- Recorrer la lista de productos y mostrar sus detalles --%>
                <div class="card__container">
                    <% for (MetodoDePagoVo metodo : metodos) { %>
                        <div class="card">
                            <div class="card--img">
                            </div>
                            <div class="card--info">
                                <p class="card--subtittle">Id Metodo De Pago</p>
                                <p id="Metod_Id_<%= metodo.getMetod_Id() %>" class="cardMetod_Id" ><%= metodo.getMetod_Id() %></id></p>
                                 <br>
                                <p class="card--subtittle">Tipo de Metodo De Pago</p>
                                <p id="Metod_Tipo_<%= metodo.getMetod_Id() %>" class="cardMetod_Tipo" ><%= metodo.getMetod_Tipo() %></p>
                                <br>
                                
                                <br>
                            </div>
                            
                        </div>
                    <% } %>
                <% } else { %>
                    <div class="card">
                        <p>No Se Encontraron Metodos.</p>
                    </div>
                <% } %>
            </div>
        </div>
    </div>
   
        <script type="text/javascript" src="js/modal9.js"></script>
    </body>
</html>