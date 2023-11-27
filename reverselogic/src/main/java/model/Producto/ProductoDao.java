package model.Producto;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;

public class ProductoDao {


    //!ADVERTENCIA:  En las clases Dao podremos realizar diferentes ejecucuines como lo hacemos en phpMyAdmin o WorkBench.
    //?  Atrubutos para realizar acciones en la base de datos.
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia

    public ProductoDao() {
        con = Conexion.conectar();
    }

    public int registrarProd(ProductoVo Producto) throws SQLException{

        sql="INSERT INTO producto (Prod_Nombre, Prod_Cant, Prod_PrecioUni, Mate_Id) values (?,?,?,?)";

        System.out.println(sql);

        try{ 
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setString(1, Producto.getProd_nombre());
            ps.setInt(2, Producto.getProd_cant());
            ps.setInt(3, Producto.getProd_precioUni());
            ps.setInt(4, Producto.getMate_id());

            r = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            // Manejar la excepción adecuadamente, por ejemplo, registrándola o lanzándola.
            e.printStackTrace();
            r = -1; // Indicar un error en el resultado
        }

        return r;
    }

    public List<ProductoVo> listarProd() throws SQLException {
        List<ProductoVo> producto = new ArrayList<>();
        sql = "select * from producto";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                ProductoVo r = new ProductoVo();
                r.setProd_id(rs.getInt("Prod_Id"));
                r.setProd_nombre(rs.getString("Prod_Nombre"));
                r.setProd_cant(rs.getInt("Prod_Cant"));
                r.setProd_preciouni(rs.getInt("Prod_Preciouni"));
                r.setMate_id(rs.getInt("Mate_Id"));
                producto.add(r);
            }
            ps.close();

            System.out.println("ProductoDao Dice: Consulta exitosa");
        } catch (SQLException e) {
            System.out.println("La consulta no pudo ser ejecutada " + e.getMessage().toString());
            throw e; // Lanzar la excepción para ser manejada en el método que invoca a listar()
        } finally {
            con.close();
        }
    
        return producto;
    }

    //? Actualizar usuario.
    public int actualizarProd(ProductoVo Producto) throws SQLException{

        sql="update producto set Prod_Nombre = ?, Prod_Cant = ?, Prod_Preciouni = ?, Mate_Id=? where Prod_Id = ? "; 
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setString(1, Producto.getProd_nombre());
            ps.setInt(2, Producto.getProd_cant());
            ps.setInt(3, Producto.getProd_precioUni());
            ps.setInt(4, Producto.getMate_id());
            ps.setInt(5, Producto.getProd_id());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se actualizó el registro del producto correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("ProductoDao Actualizar dice: Error en la actualizacion del registro "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }

    public void eliminarProd(int ProdId) throws SQLException {
        sql = "DELETE FROM producto WHERE Prod_id = ?";
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, ProdId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al Eliminar El Producto: " + e.getMessage());
            throw e;
        }
}

}

