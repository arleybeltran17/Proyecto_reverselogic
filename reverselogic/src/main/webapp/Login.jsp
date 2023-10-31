<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/Login.css">
    <link rel="stylesheet" href="css/style.css">
    <title>Login</title>
</head>
<body background="img/fondo8.jpg">
    
<h1>Bienvenido a Confecciones Ruth!!
</h1>
<p> Donde la moda siempre es tu mejor aliado</p>


<div class="cont">
    <form id="frmValidacion" novalidate>
        
    <div id="InputEmail">
        <label >E-mail </label>
        <br>
        <input type="email" name="correo" id="correo" placeholder="Ingrese el nombre del ususario" required min="5" >
        <div class="feedback"></div>
    </div>
    <br><br>
    <div id="InputPass">
        <label>Password</label>
        <br>
        <input type="password" name="pass" id="pass" placeholder="Ingrese su password" required>
        <div class="feedback"></div>
    </div>
    <br><br>
        <button type="submit" id="buton" >Ingresar</button>
        <a href="#">Has olvidado tu password?</a>

    </form>
</div>
<div class="cont2"></div>   

<script src="js/validacion.js"></script>
</body>
</html>