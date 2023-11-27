package model.Venta;

import java.security.spec.ECFieldF2m;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;
import model.Empleado.EmpleadoVo;
import model.Venta.VentaVo;

public class VentaDao {
    
    //!ADVERTENCIA:  En las clases Dao podremos realizar diferentes ejecucuines como lo hacemos en phpMyAdmin o WorkBench.
    //?  Atrubutos para realizar acciones en la base de datos.   e
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia

    public VentaDao() {
        con = Conexion.conectar();
    }

    public int registrarVent(VentaVo venta) throws SQLException {
        String sql = "{CALL realizar_venta(?, ?, ?, ?, ?)}";
    
        try (CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, venta.getVent_Cantidad());
            cs.setInt(2, venta.getUsu_Id());
            cs.setInt(3, venta.getClie_Id());
            cs.setInt(4, venta.getMetod_Id());
            cs.setInt(5, venta.getPrend_Id());
    
            boolean resultado = cs.execute();
            if (resultado) {
                // Puedes procesar los resultados si el procedimiento almacenado devuelve algo
            }
    
            String mensaje = cs.getString("mensaje");
            System.out.println(mensaje);
    
            return 1; // Puedes ajustar el valor de retorno según tus necesidades
        } catch (Exception e) {
            System.out.println("El Error Es: " + e.getMessage());
            return -1; // Indicar un error en el resultado
        }
    }
    
    

    public List<VentaVo> listarVent() throws SQLException {
        List<VentaVo> venta = new ArrayList<>();
        sql = "select * from venta";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                VentaVo r = new VentaVo();
                r.setVent_Id(rs.getInt("Vent_Id"));
                r.setVent_Cantidad(rs.getInt("Vent_Cantidad"));              
                r.setVent_Fecha(rs.getDate("Vent_Fecha"));
                r.setUsu_Id(rs.getInt("Usu_Id"));
                r.setClie_Id(rs.getInt("Clie_Id"));
                r.setMetod_Id(rs.getInt("Metod_Id"));
                r.setPrend_Id(rs.getInt("Prend_Id"));
                venta.add(r);
            }
            ps.close();

            System.out.println("VentaDao Dice: Consulta exitosa");
        } catch (SQLException e) {
            System.out.println("La consulta no pudo ser ejecutada " + e.getMessage().toString());
            throw e; // Lanzar la excepción para ser manejada en el método que invoca a listar()
        } finally {
            con.close();
        }
    
        return venta;
    }

//? Actualizar usuario.
public int actualizarVent(VentaVo Venta) throws SQLException{

        sql="update venta set Vent_Cantidad = ?, Vent_Fecha = ?, Usu_Id = ?, Clie_Id=?,Metod_Id = ?, Prend_Id = ? where Vent_Id = ? "; 
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setInt(1, Venta.getVent_Cantidad());
            ps.setDate(2, Venta.getVent_Fecha());
            ps.setInt(3, Venta.getUsu_Id());
            ps.setInt(4, Venta.getClie_Id());
            ps.setInt(5, Venta.getMetod_Id());
            ps.setInt(6, Venta.getPrend_Id());
            ps.setInt(7, Venta.getVent_Id());

            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se actualizó el registro del Empleado correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("EmpleadoDao Actualizar dice: Error en la actualizacion del registro "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }



    public void eliminarVent(int VentId) throws SQLException {
        sql = "DELETE FROM venta WHERE Vent_Id = ?";
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, VentId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al Eliminar La Venta: " + e.getMessage());
            throw e;
        }
}

}
