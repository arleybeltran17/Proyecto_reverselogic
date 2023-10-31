package model.Empleado;

public class EmpleadoVo {

    private int Emple_Id;  
    private String Emple_Tipo_Doc;
    private int Emple_Num_Doc;
    private String Emple_Nombre;
    private String Emple_Apellido; 
    private String Emple_Cargo; 
    private String Emple_Direccion; 
    private String Emple_Email;

    public EmpleadoVo() {
    }

    public EmpleadoVo(int emple_Id, String emple_Tipo_Doc, int emple_Num_Doc, String emple_Nombre,
            String emple_Apellido, String emple_Cargo, String emple_Direccion, String emple_Email) {
        Emple_Id = emple_Id;
        Emple_Tipo_Doc = emple_Tipo_Doc;
        Emple_Num_Doc = emple_Num_Doc;
        Emple_Nombre = emple_Nombre;
        Emple_Apellido = emple_Apellido;
        Emple_Cargo = emple_Cargo;
        Emple_Direccion = emple_Direccion;
        Emple_Email = emple_Email;
    }

    public int getEmple_Id() {
        return Emple_Id;
    }

    public void setEmple_Id(int emple_Id) {
        Emple_Id = emple_Id;
    }

    public String getEmple_Tipo_Doc() {
        return Emple_Tipo_Doc;
    }

    public void setEmple_Tipo_Doc(String emple_Tipo_Doc) {
        Emple_Tipo_Doc = emple_Tipo_Doc;
    }

    public int getEmple_Num_Doc() {
        return Emple_Num_Doc;
    }

    public void setEmple_Num_Doc(int emple_Num_Doc) {
        Emple_Num_Doc = emple_Num_Doc;
    }

    public String getEmple_Nombre() {
        return Emple_Nombre;
    }

    public void setEmple_Nombre(String emple_Nombre) {
        Emple_Nombre = emple_Nombre;
    }

    public String getEmple_Apellido() {
        return Emple_Apellido;
    }

    public void setEmple_Apellido(String emple_Apellido) {
        Emple_Apellido = emple_Apellido;
    }

    public String getEmple_Cargo() {
        return Emple_Cargo;
    }

    public void setEmple_Cargo(String emple_Cargo) {
        Emple_Cargo = emple_Cargo;
    }

    public String getEmple_Direccion() {
        return Emple_Direccion;
    }

    public void setEmple_Direccion(String emple_Direccion) {
        Emple_Direccion = emple_Direccion;
    }

    public String getEmple_Email() {
        return Emple_Email;
    }

    public void setEmple_Email(String emple_Email) {
        Emple_Email = emple_Email;
    } 
    
}
