package model.Venta;

import java.sql.Date;

public class VentaVo {
    
    private int Vent_Id;
    private int Vent_Cantidad;
    private Date Vent_Fecha;
    private int Usu_Id;
    private int Clie_Id;
    private int Metod_Id;
    private int Prend_Id;

    public VentaVo() {
    }

    public VentaVo(int vent_Id, int vent_Cantidad, Date vent_Fecha, int usu_Id, int clie_Id, int metod_Id,
            int prend_Id) {
        Vent_Id = vent_Id;
        Vent_Cantidad = vent_Cantidad;
        Vent_Fecha = vent_Fecha;
        Usu_Id = usu_Id;
        Clie_Id = clie_Id;
        Metod_Id = metod_Id;
        Prend_Id = prend_Id;
    }

    public int getVent_Id() {
        return Vent_Id;
    }

    public void setVent_Id(int vent_Id) {
        Vent_Id = vent_Id;
    }

    public int getVent_Cantidad() {
        return Vent_Cantidad;
    }

    public void setVent_Cantidad(int vent_Cantidad) {
        Vent_Cantidad = vent_Cantidad;
    }

    public Date getVent_Fecha() {
        return Vent_Fecha;
    }

    public void setVent_Fecha(Date vent_Fecha) {
        Vent_Fecha = vent_Fecha;
    }

    public int getUsu_Id() {
        return Usu_Id;
    }

    public void setUsu_Id(int usu_Id) {
        Usu_Id = usu_Id;
    }

    public int getClie_Id() {
        return Clie_Id;
    }

    public void setClie_Id(int clie_Id) {
        Clie_Id = clie_Id;
    }

    public int getMetod_Id() {
        return Metod_Id;
    }

    public void setMetod_Id(int metod_Id) {
        Metod_Id = metod_Id;
    }

    public int getPrend_Id() {
        return Prend_Id;
    }

    public void setPrend_Id(int prend_Id) {
        Prend_Id = prend_Id;
    }

    

    
}