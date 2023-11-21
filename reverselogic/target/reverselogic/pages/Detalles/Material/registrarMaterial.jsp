<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/usuario.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/registrarEmple.css">

    <title>Registrar Material</title>
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
                        <li><a href="Material?enviar=material"><button>Volver</button> </a></li>
                        <li><a href="index.jsp"><button>Menu</button> </a></li>
                            <li>
                                <form action="LogoutServlet" method="post">
                                    <button type="submit" class="btnSalir">Salir</button>
                                </form> 
                            </li> 
                        </ul>
                    </li>
                </ul>
            </div>
            </header>
            <h1>Registrar material</h1>
            <div class="cont12">
           
    <form action="Material" method="post">

        <br>
        <div class="contlabel1">
        <input type="text" name="Mate_Nombre" id="Mate_Nombre" required>
        <label for="Mate_Nombre">Nombre del material>
        </div>
       <br>
        <button id="btncal" name="enviar" value="registerMaterial">Registrar</button>

    </form>
</body>
</html>