<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/usuario.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/registrarPrenda.css">

    <title>Prenda</title>
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
            <h1>Registrar Prenda</h1>
            <div class="cont12">
           
    <form action="Prenda" method="post">
        <br>
        <br>
        <div class="contlabel1">
        <input type="text" name="Prend_Marca" id="Prend_Marca" required>
        <label for="Prend_Marca"> Marca de la prenda </label>
        </div>
        <br><br>
        <div class="contlabel2">
            <label for="Prend_Talla"> Talla de la Prenda</label>
            <select name='Prend_Talla' id="Prend_Talla">
                <option value="0">-selecciona una opcion-</option>
                <option value="1">6</option>
                <option value="2">8</option>
                <option value="3">10</option>
                <option value="4">12</option>
                <option value="5">14</option>
                <option value="6">16</option>
                <option value="7">S</option>
                <option value="8">XS</option>
                <option value="9">M</option>
                <option value="10">L</option>
                <option value="11">XL</option>
                <option value="12">XXL</option>
            </select>
        </div>
        <br><br>
        <div class="contlabel3">
        <input type="text" name="Prend_Descrip" id="Prend_Descrip" required>
        <label for="Prend_Descrip"> Descripcion</label>
        </div>
        <br><br>
        <div class="contlabel4">
        <input type="text" name="Mate_Id" id="Mate_Id" required>
        <label for="Mate_Id"> ID Material</label>
        </div>
        <br><br>
        <div class="contlabel5">
        <input type="text" name="Color_Id" id="Color_Id" required>
        <label for="Color_Id"> ID Color</label>
        </div>
        <br><br>
        <div class="contlabel6">
        <input type="text" name="Prod_Id" id="Prod_Id" required>
        <label for="Prod_Id"> ID Producto</label>
        </div>
        <br>
        <button id="btncal" name="enviar" value="registerPrend">Enviar</button>

    </form>
</body>
</html>