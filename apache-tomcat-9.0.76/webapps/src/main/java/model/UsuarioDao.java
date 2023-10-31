package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.*;

public class UsuarioDao {


    //!ADVERTENCIA:  En las clases Dao podremos realizar diferentes ejecucuines como lo hacemos en phpMyAdmin o WorkBench.
    //SECCION:  Atrubutos para realizar acciones en la base de datos.   e
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia


    //? Registrar usuario.
    public int registrar(UsuarioVo Usuario) throws SQLException{

        sql="INSERT INTO users_tbl (user_firstname, user_lastname, user_email, user_password) values (?,?,?,?)";
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setString(1, Usuario.getUser_firstname());
            ps.setString(2, Usuario.getUser_lastname());
            ps.setString(3, Usuario.getUser_email());
            ps.setString(4, Usuario.getUser_password());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se registró el usuario correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("UsuarioDao Registrar Usuario dice: Error en el regisro "+e.getMessage().toString());

        }
        finally{
            con.close();//?cerrando conexión
        }
        return r;
    }


    //? Consultar usuario.
    public List<UsuarioVo> listar() throws SQLException{
        List<UsuarioVo> usuario=new ArrayList<>();
        sql="select * from users_tbl";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            //? next para que ejecute hasta qeu no alla nada despues de la ultima fila
            while(rs.next()){ 
                UsuarioVo r=new UsuarioVo();
                //! Escribir  en el setter cada valor encontrado

                r.setUser_id(rs.getInt("user_id"));
                r.setUser_firstname(rs.getString("user_firstname"));
                r.setUser_lastname(rs.getString("user_lastname"));
                r.setUser_email(rs.getString("user_email"));
                r.setUser_password(rs.getString("user_password"));
                usuario.add(r);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return usuario;
    }


    //? Actualizar usuario.
    public int actualizar(UsuarioVo Usuario) throws SQLException{

        sql="update users_tbl set user_firstname = ?, user_lastname = ?, user_email = ?, user_password = ? where user_id = ? "; 
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setString(1, Usuario.getUser_firstname());
            ps.setString(2, Usuario.getUser_lastname());
            ps.setString(3, Usuario.getUser_email());
            ps.setString(4, Usuario.getUser_password());
            ps.setInt(5, Usuario.getUser_id());

            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se actualizó el registro del usuario correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("UsuarioDao dice: Error en la actualizacion del registro "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }

    public UsuarioVo obtenerUsuario(String user_email, String user_password) throws SQLException {
        sql = "SELECT * FROM users_tbl WHERE user_email = ? AND user_password = ?";
        UsuarioVo usuario = null;
        System.out.println("Actualmente se encuentra en el login.");
        try(Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user_email);
            ps.setString(2, user_password);

            try(ResultSet rs = ps.executeQuery();){ if (rs.next()){ 
                usuario=new UsuarioVo();
                usuario.setUser_email(rs.getString("user_email"));
                usuario.setUser_password(rs.getString("user_password"));
            // Asignar otras propiedades según corresponda
            
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el usuario: " + e.getMessage());
        } 
            return usuario;
        }

    }
}
