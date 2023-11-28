<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/usuario.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/registrarEmple.css">

    <title>Color</title>
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
                        <li><a href="MenuEmpleado?enviar=menu"><button>Menu</button> </a></li>
                        <li><a href="ColoresEmple?enviar=Color"><button>Volver</button> </a></li> 
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
            <h1>Registrar Color</h1>
            <div class="cont12">
           
    <form action="ColoresEmple" method="post">
        <br>
        <div class="contlabel1">
        <input type="text" name="Color_Nombre" id="Color_Nombre" required>
        <label for="Color_Nombre"> Nombre del color </label>
        </div>
       <br>
        <button id="btncal" name="enviar" value="RegistrarColores">Registrar</button>

    </form>
</body>
</html>