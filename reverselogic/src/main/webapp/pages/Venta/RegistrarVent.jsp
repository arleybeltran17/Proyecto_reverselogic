<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/usuario.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/registrarEmple.css">

    <title>Venta</title>
</head>
<body>
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
                        <li><a href="Venta?enviar=venta"><button>Volver</button> </a></li>
                        <li><a href="index.jsp"><button>Menu</button> </a></li>
                            <li> 
                                <form action="CerrarSesion" method="post">
                                    <input type="submit" class="btnSalir" value="Salir">
                                </form>
                            </li> 
                        </ul>
                    </li>
                </ul>
            </div>
            </header>
            <h1>Registrar Venta</h1>
            <div class="cont12">
           
    <form action="Venta" method="post">
        <br>
        <div class="contlabel">
        <input type="number" name="Vent_Cantidad" id="Vent_Cantidad" required>
        <label for="Vent_Cantidad"> Cantidad de la venta</label>
        </div>
        <br><br>
        <div class="contlabel2">
        <input type="Date" name="Vent_Fecha" id="Vent_Fecha" required>
        <label for="Vent_Fecha"> Fecha</label>
        </div>
        <br><br>
        <div class="contlabel3">
        <input type="text" name="Usu_Id" id="Usu_Id" required>
        <label for="Usu_Id"> Id Del Usuario</label>
        </div>
        <br><br>
        <div class="contlabel4">
        <input type="text" name="Clie_Id" id="Clie_Id" required>
        <label for="Clie_Id"> Id Del Cliente</label>
        </div>
        <br><br>
        <div class="contlabel5">
        <input type="text" name="Metod_Id" id="Metod_Id" required>
        <label for="Metod_Id"> Id Del Metodo De Pago</label>
        </div>
        <br><br>
        <div class="contlabel6">
        <input type="text" name="Prend_Id" id="Prend_Id" required>
        <label for="Prend_Id">Id Prenda</label>
        </div>
        <br>
        <button id="btncal" name="enviar" value="registerVent">Enviar</button>

    </form>
</body>
</html>