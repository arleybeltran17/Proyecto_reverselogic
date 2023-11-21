<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/usuario.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/registrarEmple.css">

    <title>Empleado</title>
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
                            <li><a href="index.jsp"><button>Menú</button> </a></li>
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
            <h1>Registrar Empleado</h1>
            <div class="cont12">
           
    <form action="Empleado" method="post">
        <br>
        <div class="contlabel">
        <input type="text" name="Emple_Tipo_Doc" id="Emple_Tipo_Doc" required>
        <label for="Emple_Tipo_Doc"> Tipo De Documento</label>
        </div>
        <br>
        <br>
        <div class="contlabel1">
        <input type="text" name="Emple_Num_Doc" id="Emple_Num_Doc" required>
        <label for="Emple_Num_Doc"> Numero De Documento</label>
        </div>
        <br><br>
        <div class="contlabel2">
        <input type="text" name="Emple_Nombre" id="Emple_Nombre" required>
        <label for="Emple_Nombre"> Nombre</label>
        </div>
        <br><br>
        <div class="contlabel3">
        <input type="text" name="Emple_Apellido" id="Emple_Apellido" required>
        <label for="Emple_Apellido"> Apellido</label>
        </div>
        <br><br>
        <div class="contlabel4">
        <input type="text" name="Emple_Cargo" id="Emple_Cargo" required>
        <label for="Emple_Cargo"> Cargo</label>
        </div>
        <br><br>
        <div class="contlabel5">
        <input type="text" name="Emple_Direccion" id="Emple_Direccion" required>
        <label for="Emple_Direccion"> Direccion</label>
        </div>
        <br><br>
        <div class="contlabel6">
        <input type="text" name="Emple_Email" id="Emple_Email" required>
        <label for="Emple_Email"> Email</label>
        </div>
        <br>
        <button id="btncal" name="enviar" value="registerEmple">Enviar</button>

    </form>
</body>
</html>