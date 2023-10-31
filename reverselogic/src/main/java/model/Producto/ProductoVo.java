package model.Producto;

public class ProductoVo {

    //NOTA En las clases Vo almacenamos los datos que nos llegan de las vistas y la base de datos. Como una pequeña ram intermediaria.
    
    //SECCION Atributos
    private int prod_id;
    private String prod_nombre;
    private int prod_cant;
    private int prod_preciouni;
    private int mate_id;


    public ProductoVo() {
    }


    public ProductoVo(int prod_id, String prod_nombre, int prod_cant, int prod_preciouni, int mate_id) {
      this.prod_id = prod_id;
      this.prod_nombre = prod_nombre;
      this.prod_cant = prod_cant;
      this.prod_preciouni = prod_preciouni;
      this.mate_id = mate_id;
    }


    public int getProd_id() {
      return prod_id;
    }


    public void setProd_id(int prod_id) {
      this.prod_id = prod_id;
    }


    public String getProd_nombre() {
      return prod_nombre;
    }


    public void setProd_nombre(String prod_nombre) {
      this.prod_nombre = prod_nombre;
    }


    public int getProd_cant() {
      return prod_cant;
    }


    public void setProd_cant(int prod_cant) {
      this.prod_cant = prod_cant;
    }


    public int getProd_preciouni() {
      return prod_preciouni;
  }

  public void setProd_preciouni(int prod_preciouni) {
      this.prod_preciouni = prod_preciouni;
  }


    public int getMate_id() {
      return mate_id;
    }


    public void setMate_id(int mate_id) {
      this.mate_id = mate_id;
    }

    

    
}

