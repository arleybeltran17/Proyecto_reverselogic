package model.MetodoDePago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import controller.*;
import model.Conexion;

public class MetodoDePagoDao {

    
    //!ADVERTENCIA:  En las clases Dao podremos realizar diferentes ejecuciones como lo hacemos en phpMyAdmin o WorkBench.
    //?  Atrubutos para realizar acciones en la base de datos.   
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = null;
    int r;

    public MetodoDePagoDao() {
        // La conexión se obtiene al crear una instancia del EmpleadoDao
        con = Conexion.conectar();
    }

    public int registrarMetod(MetodoDePagoVo MetodoDePago) {
        sql = "INSERT INTO metodo_de_pago (Metod_Id, Metod_Tipo) VALUES (?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, MetodoDePago.getMetod_Id());
            ps.setString(2, MetodoDePago.getMetod_Tipo());

            r = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            // Manejar la excepción adecuadamente, por ejemplo, registrándola o lanzándola.
            e.printStackTrace();
            r = -1; // Indicar un error en el resultado
        }

        return r;
    }

    public List<MetodoDePagoVo> listarMetod() throws SQLException {
        List<MetodoDePagoVo> metodo = new ArrayList<>();
        
        sql = "select * from metodo_de_pago";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                MetodoDePagoVo r = new MetodoDePagoVo();
                r.setMetod_Id(rs.getInt("Metod_Id"));
                r.setMetod_Tipo(rs.getString("Metod_Tipo"));
                metodo.add(r);
            }
            ps.close();

            System.out.println("MetodoDePagoDao Dice:consulta exitosa");
        } catch (SQLException e) {
            System.out.println("La consulta no pudo ser ejecutada " + e.getMessage().toString());
            throw e; // Lanzar la excepción para ser manejada en el método que invoca a listar()
        } finally {
            con.close();
        }
    
        return metodo;
    }

    //? Actualizar usuario.
    public int actualizarMetod(MetodoDePagoVo MetodoDePago) throws SQLException{

        sql="update metodo_de_pago set Metod_Tipo = ? where Metod_Id = ? "; 
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setString(1, MetodoDePago.getMetod_Tipo());
            ps.setInt(2,    MetodoDePago.getMetod_Id());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se actualizó el registro del Metodo correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("MetodoDePagoDao Actualizar dice: Error en la actualizacion del registro "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }

    public void eliminarMetod(int Metod_Id) throws SQLException {
        sql = "DELETE FROM metodo_de_pago WHERE Metod_Id = ?";
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Metod_Id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al Eliminar El Empleado: " + e.getMessage());
            throw e;
        }
}
    
}
