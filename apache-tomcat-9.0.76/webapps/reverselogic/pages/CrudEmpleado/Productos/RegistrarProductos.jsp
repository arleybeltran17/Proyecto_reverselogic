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
                            <li><a href="ProductoEmple?enviar=productoEmple"><button>Volver</button> </a></li>
                            <li><a href="menuEmp.jsp"><button>Menu</button> </a></li>
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
           
            <form action="ProductoEmple" method="post">
    
            <label for="Prod_Nombre"> Nombre Producto</label>
            <input type="text" name="Prod_Nombre" id="Prod_Nombre" placeholder="Ingrese El Nombre Del Producto">
    
            <label for="Prod_Cant"> Cantidad</label>
            <input type="text" name="Prod_Cant" id="Prod_Cant"  placeholder="Ingrese La Cantidad Del Producto">
    
            <label for="Prod_PrecioUni"> Precio Unidad</label>
            <input type="text" name="Prod_PrecioUni" id="Prod_PrecioUni"  placeholder="Ingrese El Precio Por Unidad Del Producto">
    
            <label for="Mate_ID"> Id Material</label>
            <input type="text" name="Mate_Id" id="Mate_Id"  placeholder="Ingrese El Id Del Material">
    
            <button name="enviar" value="RegistrarProductos">Enviar</button>
    
        </form>
</body>
</html>