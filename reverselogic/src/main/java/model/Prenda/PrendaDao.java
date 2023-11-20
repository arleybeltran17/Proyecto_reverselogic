package model.Prenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import controller.*;
import model.Conexion;

public class PrendaDao {

    //!ADVERTENCIA:  En las clases Dao podremos realizar diferentes ejecuciones como lo hacemos en phpMyAdmin o WorkBench.
    //?  Atrubutos para realizar acciones en la base de datos.   
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = null;
    int r;

    public PrendaDao() {
        // La conexión se obtiene al crear una instancia del EmpleadoDao
        con = Conexion.conectar();
    }

    public int registrarPrend(PrendaVo Prenda) {
        sql = "INSERT INTO Prenda (Prend_Marca, Prend_Talla, Prend_Descrip, Mate_Id, Color_Id, Prod_Id) VALUES (?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Prenda.getPrend_Marca());
            ps.setString(2, Prenda.getPrend_Talla());
            ps.setString(3, Prenda.getPrend_Descrip());
            ps.setInt(4, Prenda.getMate_Id());
            ps.setInt(5, Prenda.getColor_Id());
            ps.setInt(6, Prenda.getProd_Id());
            r = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            // Manejar la excepción adecuadamente, por ejemplo, registrándola o lanzándola.
            e.printStackTrace();
            r = -1; // Indicar un error en el resultado
        }
        return r;
    }

    public List<PrendaVo> listaPrend() throws SQLException {
        List<PrendaVo> prenda = new ArrayList<>();
        
        sql = "select * from prenda";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                PrendaVo r = new PrendaVo();
                r.setPrend_Id(rs.getInt("Prend_Id"));
                r.setPrend_Marca(rs.getString("Prend_Marca"));
                r.setPrend_Talla(rs.getString("Prend_Talla"));
                r.setPrend_Descrip(rs.getString("Prend_Descrip"));
                r.setMate_Id(rs.getInt("Mate_Id"));
                r.setColor_Id(rs.getInt("Color_Id"));
                r.setProd_Id(rs.getInt("Prod_Id"));
                prenda.add(r);
            }
            ps.close();

            System.out.println("PrendaDao Dice:consulta exitosa");
        } catch (SQLException e) {
            System.out.println("La consulta no pudo ser ejecutada " + e.getMessage().toString());
            throw e; // Lanzar la excepción para ser manejada en el método que invoca a listar()
        } finally {
            con.close();
        }
    
        return prenda;
    }

    //? Actualizar usuario.
    public int actualizarPrend(PrendaVo Prenda) throws SQLException{

        sql="update prenda set Prend_Marca = ?, Prend_Talla = ?, Prend_Descrip =?, Mate_Id = ?, Color_Id = ?,Prod_Id = ? where Prend_Id = ? "; 
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setString(1, Prenda.getPrend_Marca());
            ps.setString(2, Prenda.getPrend_Talla());
            ps.setString(3, Prenda.getPrend_Descrip());
            ps.setInt(4, Prenda.getColor_Id());
            ps.setInt(5, Prenda.getMate_Id());
            ps.setInt(6, Prenda.getProd_Id());
            ps.setInt(7,    Prenda.getPrend_Id());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se actualizó el registro de la prenda correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("PrendaDao Actualizar dice: Error en la actualizacion del registro "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }

    public void eliminarPrenda(int Prend_Id) throws SQLException {
        sql = "DELETE FROM prenda WHERE Prend_Id = ?";
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Prend_Id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al Eliminar La Prenda: " + e.getMessage());
            throw e;
        }
}
}
