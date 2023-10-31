package model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.*;
import model.Conexion;
import model.Cliente.ClienteVo;

public class ClienteDao {
    //!ADVERTENCIA:  En las clases Dao podremos realizar diferentes ejecuciones como lo hacemos en phpMyAdmin o WorkBench.
    //?  Atrubutos para realizar acciones en la base de datos.   e
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia


    //? Registrar Cliente.
    public int registrarClient(ClienteVo Cliente) throws SQLException{

        sql="INSERT INTO Cliente (Clie_Tipo_Doc, Clie_Num_Doc, Clie_Nombre, Clie_Apellido, Clie_Direccion, Clie_Email) values (?,?,?,?,?,?)";
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setString(1, Cliente.getClie_Tipo_Doc());
            ps.setInt(2,    Cliente.getClie_Num_Doc());
            ps.setString(3, Cliente.getClie_Nombre());
            ps.setString(4, Cliente.getClie_Apellido());
            ps.setString(5, Cliente.getClie_Direccion());
            ps.setString(6, Cliente.getClie_Email());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            

        }catch(Exception e){

            System.out.println("ClienteDao Registrar_Cliente: Error en el registro "+e.getMessage().toString());
        }
        finally{
            con.close();//?cerrando conexión
            System.out.println("Se Registró El Cliente Correctamente, Revisa La Base De Datos.");
        }
        return r;
    }


    //? Consultar usuario.
    public List<ClienteVo> listarClient() throws SQLException {
        List<ClienteVo> cliente = new ArrayList<>();
        sql = "select * from cliente";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                ClienteVo r = new ClienteVo();
                r.setClie_Id(rs.getInt("Clie_Id"));
                r.setClie_Tipo_Doc(rs.getString("Clie_Tipo_Doc"));
                r.setClie_Num_Doc(rs.getInt("Clie_Num_Doc"));
                r.setClie_Nombre(rs.getString("Clie_Nombre"));
                r.setClie_Apellido(rs.getString("Clie_Apellido"));
                r.setClie_Direccion(rs.getString("Clie_Direccion"));
                r.setClie_Email(rs.getString("Clie_Email"));
                cliente.add(r);
            }
            ps.close();
            System.out.println("ClienteDao Dice:consulta exitosa");
        } catch (SQLException e) {
            System.out.println("La consulta no pudo ser ejecutada " + e.getMessage().toString());
            throw e; // Lanzar la excepción para ser manejada en el método que invoca a listar()
        } finally {
            con.close();
        }
    
        return cliente;
    }

    //? Actualizar usuario.
    public int actualizarClient(ClienteVo Cliente) throws SQLException{

        sql="update cliente set Clie_Tipo_Doc = ?, Clie_Num_Doc = ?, Clie_Nombre = ?, Clie_Apellido=?, Clie_Direccion = ?, Clie_Email = ? where Clie_Id = ? "; 
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setString(1, Cliente.getClie_Tipo_Doc());
            ps.setInt(2,    Cliente.getClie_Num_Doc());
            ps.setString(3, Cliente.getClie_Nombre());
            ps.setString(4, Cliente.getClie_Apellido());
            ps.setString(5, Cliente.getClie_Direccion());
            ps.setString(6, Cliente.getClie_Email());
            ps.setInt(7,    Cliente.getClie_Id());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se actualizó el registro del Cliente correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("ClienteDao Actualizar dice: Error en la actualizacion del registro "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }

    public void eliminarClient(int ClieId) throws SQLException {
        sql = "DELETE FROM cliente WHERE Clie_id = ?";
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, ClieId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al Eliminar El Cliente: " + e.getMessage());
            throw e;
        }
}
    
}