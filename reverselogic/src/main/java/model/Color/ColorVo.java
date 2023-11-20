package model.Color;

public class ColorVo {

    private int Color_Id;  
    private String Color_Nombre;

    public ColorVo() {
    }

    public ColorVo(int color_Id, String color_Nombre) {
        Color_Id = color_Id;
        Color_Nombre = color_Nombre;
    }

    public int getColor_Id() {
        return Color_Id;
    }

    public void setColor_Id(int color_Id) {
        Color_Id = color_Id;
    }

    public String getColor_Nombre() {
        return Color_Nombre;
    }

    public void setColor_Nombre(String color_Nombre) {
        Color_Nombre = color_Nombre;
    }
}
