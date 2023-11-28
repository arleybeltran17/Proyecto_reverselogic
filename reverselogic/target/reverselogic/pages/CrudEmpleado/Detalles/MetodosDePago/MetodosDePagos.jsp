<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/usuario.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
    <title>Metodo De Pago</title>
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
                            <li><a href="Detalles?enviar=detalle"><button>Volver</button></a></li>
                            <li><a href="MenuEmpleado?enviar=menu"><button>Menu</button> </a></li>
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
    <h1 class="titulo"> Opciones De Metodo De Pago</h1>

    <main class="containerCards">
        <div class="cards">
            <div class="prendas">
                <div class="imgChaqueta">
                    <img src="img/registrarUsu.avif" alt="" width="200px" height="150px">
                    <div class="detalle">
                        <h2>Registrar</h2>
                    </div>
                        <div class="btnContainer">
                            <a href="MetodosDePagoEmple?enviar=RegistrarMetodos"> <button class="">Ingresar</button></a>
                        </div>
                    
                </div>
            </div>
        </div>

        

        <div class="cards">
            <div class="prendas">
                <div class="imgChaqueta">
                    <img src="img/consultarUsu.png" alt="" width="200px" height="150px">
                    <div class="detalle">
                        <h2>Consultar</h2>
                        <div class="btnContainer">
                            <a href="MetodosDePagoEmple?enviar=ConsultarMetodos"> <button class="btnEliminar">Ingresar</button></a>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        </main>
    <footer>
        <div class="media">
              <a href="https://www.facebook.com/profile.php?id=100037372663548"><img class="img1" src="img/facebook.png"></a>
        <a href="whatsapp://send?phone=+3013519220"><img class="img1" src="img/whatsapp.png"></a>
        <a href="https://www.instagram.com/laura34vega12/"><img class="img1" src="img/instagram (1).png"></a>
        </div>
        <p>&copy; 2023 Confecciones ruth Derechos reservados</p>
    </footer>
    <script src="js/menu.js"></script>
</body>
</html>