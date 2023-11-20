package model.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import controller.*;
import model.Conexion;
import model.Material.MaterialVo;

public class ColorDao {

    
    //!ADVERTENCIA:  En las clases Dao podremos realizar diferentes ejecuciones como lo hacemos en phpMyAdmin o WorkBench.
    //?  Atrubutos para realizar acciones en la base de datos.   
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = null;
    int r;

    public ColorDao() {
        // La conexión se obtiene al crear una instancia del EmpleadoDao
        con = Conexion.conectar();
    }

    public int registrarColor(ColorVo Color) {
        sql = "INSERT INTO color (Color_Nombre) VALUES (?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Color.getColor_Nombre());

            r = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            // Manejar la excepción adecuadamente, por ejemplo, registrándola o lanzándola.
            e.printStackTrace();
            r = -1; // Indicar un error en el resultado
        }

        return r;
    }

    public List<ColorVo> listarColor() throws SQLException {
        List<ColorVo> color = new ArrayList<>();
        
        sql = "select * from color";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                ColorVo r = new ColorVo();
                r.setColor_Id(rs.getInt("Color_Id"));
                r.setColor_Nombre(rs.getString("Color_Nombre"));
                color.add(r);
            }
            ps.close();

            System.out.println("ColorDao Dice:consulta exitosa");
        } catch (SQLException e) {
            System.out.println("La consulta no pudo ser ejecutada " + e.getMessage().toString());
            throw e; // Lanzar la excepción para ser manejada en el método que invoca a listar()
        } finally {
            con.close();
        }
    
        return color;
    }

    //? Actualizar usuario.
    public int actualizarColor(ColorVo Color) throws SQLException{

        sql="update color set Color_Nombre = ? where Color_Id = ? "; 
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setString(1, Color.getColor_Nombre());
            ps.setInt(2, Color.getColor_Id());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se actualizó el registro del color correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("ColorDao Actualizar dice: Error en la actualizacion del registro "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }

    public void eliminarColor(int Color_Id) throws SQLException {
        sql = "DELETE FROM color WHERE Color_Id = ?";
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Color_Id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al Eliminar El color: " + e.getMessage());
            throw e;
        }
}
    
}