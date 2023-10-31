package model;

public class UsuarioVo {

    //NOTA En las clases Vo almacenamos los datos que nos llegan de las vistas y la base de datos. Como una pequeña ram intermediaria.
    
    //SECCION Atributos
    private int user_id;
    private String user_firstname;
    private String user_lastname;
    private String user_email;
    private String user_password;


    //SECCION Getters & Setters    
    //idUsuario
    
    
public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public String getUser_firstname() {
        return user_firstname;
    }
    public void setUser_firstname(String user_firstname) {
        this.user_firstname = user_firstname;
    }
    public String getUser_lastname() {
        return user_lastname;
    }
    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }
    public String getUser_email() {
        return user_email;
    }
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
    public String getUser_password() {
        return user_password;
    }
    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
    // SECCION Constructors
    
    public UsuarioVo() {
    }
    public UsuarioVo(int user_id, String user_firstname, String user_lastname, String user_email,
            String user_password) {
        this.user_id = user_id;
        this.user_firstname = user_firstname;
        this.user_lastname = user_lastname;
        this.user_email = user_email;
        this.user_password = user_password;
    }

    
}

