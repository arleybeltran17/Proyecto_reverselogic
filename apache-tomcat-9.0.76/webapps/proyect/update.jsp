<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Bienvenido Al Register</h1>

    <form action="controler" method="post">

        <label for="user_id"> ID</label>
        <input type="text" name="user_id" id="user_id"  placeholder="Ingrese Su Nombre">

        <label for="user_firstname"> Nombre </label>
        <input type="text" name="user_firstname" id="user_firstname"  placeholder="Ingrese Su Nombre">

        <label for="user_lastname"> Apellido</label>
        <input type="text" name="user_lastname" id="user_lastname"  placeholder="Ingrese Su Apellido">

        <label for="user_email"> Correo</label>
        <input type="text" name="user_email" id="user_email"  placeholder="Ingrese Su Correo">

        <label for="user_password"> Contraseña</label>
        <input type="password" name="user_password" id="user_password"  placeholder="Ingrese Su Contraseña">

        <button name="enviar" value="update">Enviar</button>

    </form>
</body>
</html>