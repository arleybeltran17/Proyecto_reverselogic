package model.Cliente;

public class ClienteVo {

    private int Clie_Id;  
    private String Clie_Tipo_Doc;
    private int Clie_Num_Doc;
    private String Clie_Nombre;
    private String Clie_Apellido; 
    private String Clie_Direccion; 
    private String Clie_Email;

    public ClienteVo() {
    }

    public ClienteVo(int clie_Id, String clie_Tipo_Doc, int clie_Num_Doc, String clie_Nombre, String clie_Apellido,
            String clie_Direccion, String clie_Email) {
        Clie_Id = clie_Id;
        Clie_Tipo_Doc = clie_Tipo_Doc;
        Clie_Num_Doc = clie_Num_Doc;
        Clie_Nombre = clie_Nombre;
        Clie_Apellido = clie_Apellido;
        Clie_Direccion = clie_Direccion;
        Clie_Email = clie_Email;
    }

    public int getClie_Id() {
        return Clie_Id;
    }

    public void setClie_Id(int clie_Id) {
        Clie_Id = clie_Id;
    }

    public String getClie_Tipo_Doc() {
        return Clie_Tipo_Doc;
    }

    public void setClie_Tipo_Doc(String clie_Tipo_Doc) {
        Clie_Tipo_Doc = clie_Tipo_Doc;
    }

    public int getClie_Num_Doc() {
        return Clie_Num_Doc;
    }

    public void setClie_Num_Doc(int clie_Num_Doc) {
        Clie_Num_Doc = clie_Num_Doc;
    }

    public String getClie_Nombre() {
        return Clie_Nombre;
    }

    public void setClie_Nombre(String clie_Nombre) {
        Clie_Nombre = clie_Nombre;
    }

    public String getClie_Apellido() {
        return Clie_Apellido;
    }

    public void setClie_Apellido(String clie_Apellido) {
        Clie_Apellido = clie_Apellido;
    }

    public String getClie_Direccion() {
        return Clie_Direccion;
    }

    public void setClie_Direccion(String clie_Direccion) {
        Clie_Direccion = clie_Direccion;
    }

    public String getClie_Email() {
        return Clie_Email;
    }

    public void setClie_Email(String clie_Email) {
        Clie_Email = clie_Email;
    }
}
