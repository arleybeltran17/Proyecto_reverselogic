<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/usuario.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/registrarEmple.css">

    <title>Registro De Productos</title>
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
                        <li><a href="ReverseLogic?enviar=producto"><button>Volver</button> </a></li>
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
            <h1>Registrar Productos</h1>
            <div class="cont12">
           
            <form action="ReverseLogic" method="post">
                
        <br>
        <div class="contlabel">
            <input type="text" name="Prod_Nombre" id="Prod_Nombre">
            <label for="Prod_Nombre"> Nombre Producto</label>
        </div>
        
        <br><br>
        <div class="contlabel1">
            <input type="text" name="Prod_Cant" id="Prod_Cant">
            <label for="Prod_Cant"> Cantidad</label>
        </div>
        <br><br>
        <div class="contlabel2">
           <input type="text" name="Prod_PrecioUni" id="Prod_PrecioUni">
           <label for="Prod_PrecioUni"> Precio Unidad</label>
        </div>
        
        <br><br>
        <div class="contlabel3">
            <input type="text" name="Mate_Id" id="Mate_Id">
            <label for="Mate_ID"> Id Material</label>
        </div>
        <br><br>
            <button id="btncal" name="enviar" value="registerProd">Enviar</button>
    
        </form>
</body>
</html>