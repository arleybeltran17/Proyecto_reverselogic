package model.Prenda;

public class PrendaVo {

    private int Prend_Id;  
    private String Prend_Marca;
    private String Prend_Talla;
    private String Prend_Descrip;
    private int Mate_Id; 
    private int Color_Id;
    private int Prod_Id;

    public PrendaVo() {
    }

    public PrendaVo(int prend_Id, String prend_Marca, String prend_Talla, String prend_Descrip, int mate_Id,
            int color_Id, int prod_Id) {
        Prend_Id = prend_Id;
        Prend_Marca = prend_Marca;
        Prend_Talla = prend_Talla;
        Prend_Descrip = prend_Descrip;
        Mate_Id = mate_Id;
        Color_Id = color_Id;
        Prod_Id = prod_Id;
    }

    public int getPrend_Id() {
        return Prend_Id;
    }

    public void setPrend_Id(int prend_Id) {
        Prend_Id = prend_Id;
    }

    public String getPrend_Marca() {
        return Prend_Marca;
    }

    public void setPrend_Marca(String prend_Marca) {
        Prend_Marca = prend_Marca;
    }

    public String getPrend_Talla() {
        return Prend_Talla;
    }

    public void setPrend_Talla(String prend_Talla) {
        Prend_Talla = prend_Talla;
    }

    public String getPrend_Descrip() {
        return Prend_Descrip;
    }

    public void setPrend_Descrip(String prend_Descrip) {
        Prend_Descrip = prend_Descrip;
    }

    public int getMate_Id() {
        return Mate_Id;
    }

    public void setMate_Id(int mate_Id) {
        Mate_Id = mate_Id;
    }

    public int getColor_Id() {
        return Color_Id;
    }

    public void setColor_Id(int color_Id) {
        Color_Id = color_Id;
    }

    public int getProd_Id() {
        return Prod_Id;
    }

    public void setProd_Id(int prod_Id) {
        Prod_Id = prod_Id;
    }

    

    


    
}
