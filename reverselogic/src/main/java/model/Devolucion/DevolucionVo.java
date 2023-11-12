package model.Devolucion;

import java.sql.Date;

public class DevolucionVo {

    //NOTA En las clases Vo almacenamos los datos que nos llegan de las vistas y la base de datos. Como una pequeña ram intermediaria.
    
    //SECCION Atributos
    private int Devo_id;
    private int Devo_Cant_Preducto;
    private String Devo_Razon;
    private Date Devo_Fecha;
    private int Emple_id;

    public DevolucionVo() {
    }

    public DevolucionVo(int devo_id, int devo_Cant_Preducto, String devo_Razon, Date devo_Fecha, int emple_id) {
        Devo_id = devo_id;
        Devo_Cant_Preducto = devo_Cant_Preducto;
        Devo_Razon = devo_Razon;
        Devo_Fecha = devo_Fecha;
        Emple_id = emple_id;
    }

    public int getDevo_id() {
        return Devo_id;
    }

    public void setDevo_id(int devo_id) {
        Devo_id = devo_id;
    }

    public int getDevo_Cant_Preducto() {
        return Devo_Cant_Preducto;
    }

    public void setDevo_Cant_Preducto(int devo_Cant_Preducto) {
        Devo_Cant_Preducto = devo_Cant_Preducto;
    }

    public String getDevo_Razon() {
        return Devo_Razon;
    }

    public void setDevo_Razon(String devo_Razon) {
        Devo_Razon = devo_Razon;
    }

    public Date getDevo_Fecha() {
        return Devo_Fecha;
    }

    public void setDevo_Fecha(Date devo_Fecha) {
        Devo_Fecha = devo_Fecha;
    }

    public int getEmple_id() {
        return Emple_id;
    }

    public void setEmple_id(int emple_id) {
        Emple_id = emple_id;
    }

    
    

}
