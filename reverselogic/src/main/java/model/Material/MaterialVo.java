package model.Material;

public class MaterialVo {

    private int Mate_Id;  
    private String Mate_Nombre;

    public MaterialVo() {
    }

    public MaterialVo(int mate_Id, String mate_Nombre) {
        Mate_Id = mate_Id;
        Mate_Nombre = mate_Nombre;
    }

    public int getMate_Id() {
        return Mate_Id;
    }

    public void setMate_Id(int mate_Id) {
        Mate_Id = mate_Id;
    }

    public String getMate_Nombre() {
        return Mate_Nombre;
    }

    public void setMate_Nombre(String mate_Nombre) {
        Mate_Nombre = mate_Nombre;
    }

    

    
}