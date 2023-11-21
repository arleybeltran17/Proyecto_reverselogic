<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/usuario.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/registrarEmple.css">
    <title>Usuario</title>
</head>

    <body>
        <div class="cont2">
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
            <h1>Registrar Usuario</h1>
            <div class="cont12">
            <form action="Usuario" id="frmValidacion1" method="post">
                <div class="contlabel">
                    <div id="Usu_Nombre">
                        <input type="text" name="Usu_Nombre" id="Usu_Nombre" >
                        <label for="Usu_Nombre">Nombre del Usuario</label>
                        <div class="feedback"></div>
                    </div>
                </div>
                <br><br>
                <div class="contlabel1">
                    <div id="Usu_Rol">
                        <input type="text" name="Usu_Rol" id="Usu_Rol">
                        <label for="Usu_Rol">Rol Usuario</label>
                        <div class="feedback"></div>
                    </div>
                </div>
                <br><br>
                <div class="contlabel2">
                    <div id="Usu_Password">
                        <input type="password" name="Usu_Password" id="Usu_Password">
                        <label for="Usu_Password">Contraseña Usuario</label>
                        <div class="feedback"></div> 
                    </div>
                </div>
                    <br><br>
                <div class="contlabel3">
                    <div id="Emple_Id">
                        <input type="text" name="Emple_Id" id="Emple_Id">
                        <label for="Emple_Id">Id Empleado</label>
                        <div class="feedback"></div>
                    </div>
                </div>
                <br><br>
                <button id="btncal" name="enviar" value="registerUsu">Enviar</button>
            </form>
        </div>

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