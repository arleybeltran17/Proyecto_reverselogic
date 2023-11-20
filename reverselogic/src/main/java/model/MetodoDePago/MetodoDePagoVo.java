package model.MetodoDePago;

public class MetodoDePagoVo {

    private int Metod_Id;  
    private String Metod_Tipo;

    public MetodoDePagoVo() {
    }

    public MetodoDePagoVo(int metod_Id, String metod_Tipo) {
        Metod_Id = metod_Id;
        Metod_Tipo = metod_Tipo;
    }
    public int getMetod_Id() {
        return Metod_Id;
    }
    public void setMetod_Id(int metod_Id) {
        Metod_Id = metod_Id;
    }
    public String getMetod_Tipo() {
        return Metod_Tipo;
    }
    public void setMetod_Tipo(String metod_Tipo) {
        Metod_Tipo = metod_Tipo;
    }
}
