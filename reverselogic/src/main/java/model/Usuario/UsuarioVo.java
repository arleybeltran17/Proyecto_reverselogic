package model.Usuario;

public class UsuarioVo {

    //NOTA En las clases Vo almacenamos los datos que nos llegan de las vistas y la base de datos. Como una pequeña ram intermediaria.
    
    //SECCION Atributos
    private int Usu_Id;
    private String Usu_Nombre;
    private int Usu_Rol;
    private String Usu_Contraseña;
    private int Emple_Id;

    public UsuarioVo() {
    }

    public UsuarioVo(int usu_Id, String usu_Nombre, int usu_Rol, String usu_Contraseña, int emple_Id) {
        Usu_Id = usu_Id;
        Usu_Nombre = usu_Nombre;
        Usu_Rol = usu_Rol;
        Usu_Contraseña = usu_Contraseña;
        Emple_Id = emple_Id;
    }

    public int getUsu_Id() {
        return Usu_Id;
    }

    public void setUsu_Id(int usu_Id) {
        Usu_Id = usu_Id;
    }

    public String getUsu_Nombre() {
        return Usu_Nombre;
    }

    public void setUsu_Nombre(String usu_Nombre) {
        Usu_Nombre = usu_Nombre;
    }

    public int getUsu_Rol() {
        return Usu_Rol;
    }

    public void setUsu_Rol(int usu_Rol) {
        Usu_Rol = usu_Rol;
    }

    public String getUsu_Contraseña() {
        return Usu_Contraseña;
    }

    public void setUsu_Contraseña(String usu_Contraseña) {
        Usu_Contraseña = usu_Contraseña;
    }

    public int getEmple_Id() {
        return Emple_Id;
    }

    public void setEmple_Id(int emple_Id) {
        Emple_Id = emple_Id;
    }

    
    
}
