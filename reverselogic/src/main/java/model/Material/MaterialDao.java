package model.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import controller.*;
import model.Conexion;

public class MaterialDao {

    
    //!ADVERTENCIA:  En las clases Dao podremos realizar diferentes ejecuciones como lo hacemos en phpMyAdmin o WorkBench.
    //?  Atrubutos para realizar acciones en la base de datos.   
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = null;
    int r;

    public MaterialDao() {
        // La conexión se obtiene al crear una instancia del EmpleadoDao
        con = Conexion.conectar();
    }

    public int registrarMate(MaterialVo Material) {
        sql = "INSERT INTO tipo_material (Mate_Nombre) VALUES (?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Material.getMate_Nombre());

            r = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            // Manejar la excepción adecuadamente, por ejemplo, registrándola o lanzándola.
            e.printStackTrace();
            r = -1; // Indicar un error en el resultado
        }

        return r;
    }

    public List<MaterialVo> listarMate() throws SQLException {
        List<MaterialVo> material = new ArrayList<>();
        
        sql = "select * from tipo_material";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                MaterialVo r = new MaterialVo();
                r.setMate_Id(rs.getInt("Mate_Id"));
                r.setMate_Nombre(rs.getString("Mate_Nombre"));
                material.add(r);
            }
            ps.close();

            System.out.println("MaterialDao Dice:consulta exitosa");
        } catch (SQLException e) {
            System.out.println("La consulta no pudo ser ejecutada " + e.getMessage().toString());
            throw e; // Lanzar la excepción para ser manejada en el método que invoca a listar()
        } finally {
            con.close();
        }
    
        return material;
    }

    //? Actualizar material.
    public int actualizarMate(MaterialVo Material) throws SQLException{

        sql="update tipo_material set Mate_Nombre = ? where Mate_Id = ? "; 
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setString(1, Material.getMate_Nombre());
            ps.setInt(2, Material.getMate_Id());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se actualizó el registro del color correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("MaterialDao Actualizar dice: Error en la actualizacion del registro "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }
//eliminar material
    public void eliminarMate(int Mate_Id) throws SQLException {
        sql = "DELETE FROM tipo_material WHERE Mate_Id = ?";
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Mate_Id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al Eliminar El Material: " + e.getMessage());
            throw e;
        }
}
    
}