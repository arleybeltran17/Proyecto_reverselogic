package model.Usuario;

import java.security.spec.ECFieldF2m;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;
import model.Usuario.UsuarioVo;

public class UsuarioDao {

    //!ADVERTENCIA:  En las clases Dao podremos realizar diferentes ejecucuines como lo hacemos en phpMyAdmin o WorkBench.
    //?  Atrubutos para realizar acciones en la base de datos.   e
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia

    public UsuarioDao() {
        con = Conexion.conectar();
    }

    public int registrarUsu(UsuarioVo Usuario) throws SQLException{
    
        sql="INSERT INTO usuario (Usu_Nombre, Usu_Rol, Usu_Password, Emple_Id) values (?,?,?,?)";

        System.out.println(sql);

        try{
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setString(1, Usuario.getUsu_Nombre());
            ps.setInt(2, Usuario.getUsu_Rol());
            ps.setString(3, Usuario.getUsu_Password());
            ps.setInt(4, Usuario.getEmple_Id());

            r = ps.executeUpdate();
            System.out.println(ps);
            ps.close();
        } catch (SQLException e) {
        e.printStackTrace();
        r = -1; // Indicar un error en el resultado
        throw e; // Lanzar la excepción para ser manejada en el método que invoca a registrarUsu
        }


        return r;
    }

    public List<UsuarioVo> listarUsu() throws SQLException {
        List<UsuarioVo> usuario = new ArrayList<>();
        sql = "select * from usuario";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                UsuarioVo r = new UsuarioVo();
                r.setUsu_Id(rs.getInt("Usu_Id"));
                r.setUsu_Nombre(rs.getString("Usu_Nombre"));
                r.setUsu_Rol(rs.getInt("Usu_Rol"));
                r.setUsu_Password(rs.getString("Usu_Password"));
                r.setEmple_Id(rs.getInt("Emple_Id"));
                usuario.add(r);
            }
            ps.close();

            System.out.println("UsuarioDao Dice: Consulta exitosa");
        } catch (SQLException e) {
            System.out.println("La consulta no pudo ser ejecutada " + e.getMessage().toString());
            throw e; // Lanzar la excepción para ser manejada en el método que invoca a listar()
        } finally {
            con.close();
        }
    
        return usuario;
    }

    //? Actualizar usuario.
    public int actualizarUsu(UsuarioVo Usuario) throws SQLException{

        sql="update Usuario set Usu_Nombre = ?, Usu_Rol = ?, Usu_Password = ?, Emple_Id=? where Usu_Id = ? "; 
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setString(1, Usuario.getUsu_Nombre());
            ps.setInt(2, Usuario.getUsu_Rol());
            ps.setString(3, Usuario.getUsu_Password());
            ps.setInt(4, Usuario.getEmple_Id());
            ps.setInt(5, Usuario.getUsu_Id());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se actualizó el registro del Usuario correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("UsuarioDao Actualizar dice: Error en la actualizacion del registro "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }

    public void eliminarUsu(int UsuId) throws SQLException {
        sql = "DELETE FROM usuario WHERE Usu_Id = ?";
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, UsuId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al Eliminar El Usuario: " + e.getMessage());
            throw e;
        }
}

public UsuarioVo validarLogin(String username, String password) throws SQLException {
    // Lógica para validar el login en la base de datos
    // Consulta la base de datos, verifica las credenciales y devuelve un UsuarioVo si es válido
    
    // Ejemplo (consulta ficticia, adapta según tu base de datos):
    String sql = "SELECT * FROM usuario WHERE Usu_Nombre = ? AND Usu_Password = ?";
    
    try (Connection con = Conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, username);
        ps.setString(2, password);
        
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                // Crear y devolver un objeto UsuarioVo con la información del usuario
                UsuarioVo usuario = new UsuarioVo();
                usuario.setUsu_Id(rs.getInt("Usu_Id"));
                usuario.setUsu_Nombre(rs.getString("Usu_Nombre"));
                usuario.setUsu_Rol(rs.getInt("Usu_Rol"));
                
                // Puedes establecer otros atributos según tu diseño de base de datos
                
                return usuario;
            }
        }
    }
    
    // Si no se encontró un usuario válido, devuelve null
    return null;
}
}

