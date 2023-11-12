package model.Devolucion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;
import model.Devolucion.DevolucionVo;

public class DevolucionDao {


    //!ADVERTENCIA:  En las clases Dao podremos realizar diferentes ejecucuines como lo hacemos en phpMyAdmin o WorkBench.
    //?  Atrubutos para realizar acciones en la base de datos.   e
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia

    public DevolucionDao() {
        con = Conexion.conectar();
    }

    public int registerDevo(DevolucionVo Devolucion) throws SQLException{
    
        sql="INSERT INTO devolucion (Devo_Cant_Preducto, Devo_Razon, Devo_Fecha,Emple_id) values (?,?,?,?)";

        System.out.println(sql);

        try{ 
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setInt(1, Devolucion.getDevo_Cant_Preducto());
            ps.setString(2, Devolucion.getDevo_Razon());
            ps.setDate(3,Devolucion.getDevo_Fecha());
            ps.setInt(4, Devolucion.getEmple_id());

            r = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            // Manejar la excepción adecuadamente, por ejemplo, registrándola o lanzándola.
            e.printStackTrace();
            r = -1; // Indicar un error en el resultado
        }

        return r;
    }

    public List<DevolucionVo> listarDevo () throws SQLException {
        List<DevolucionVo> devolucion = new ArrayList<>();
        sql = "select * from devolucion";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                DevolucionVo r = new DevolucionVo();
                r.setDevo_id(rs.getInt("Devo_id"));
                r.setDevo_Cant_Preducto(rs.getInt("Devo_Cant_Preducto"));
                r.setDevo_Razon(rs.getString("Devo_Razon"));
                r.setDevo_Fecha(rs.getDate("Devo_Fecha"));
                r.setEmple_id(rs.getInt("Emple_id"));
                devolucion.add(r);
            }
            ps.close();

            System.out.println("DevolucionDao Dice: Consulta exitosa");
        } catch (SQLException e) {
            System.out.println("La consulta no pudo ser ejecutada " + e.getMessage().toString());
            throw e; // Lanzar la excepción para ser manejada en el método que invoca a listar()
        } finally {
            con.close();
        }
    
        return devolucion;
    }

    //? Actualizar devolucion.
    public int actualizarDevo(DevolucionVo Devolucion) throws SQLException{

        sql="update Devolucion set Devo_Cant_Preducto = ?, Devo_Razon = ?, Devo_Fecha = ?, Emple_id=? where Devo_id = ? "; 
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setInt(1, Devolucion.getDevo_Cant_Preducto());
            ps.setString(2, Devolucion.getDevo_Razon());
            ps.setDate(3, Devolucion.getDevo_Fecha());
            ps.setInt(4, Devolucion.getEmple_id());
            ps.setInt(5, Devolucion.getDevo_id());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se actualizó el registro del devolucion correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("DevolucionDao Actualizar dice: Error en la actualizacion del registro "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }

    public void eliminarDevo(int Devo_id) throws SQLException {
        sql = "DELETE FROM usuario WHERE Devo_id = ?";
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Devo_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al Eliminar la Devolucion: " + e.getMessage());
            throw e;
        }
}

}

