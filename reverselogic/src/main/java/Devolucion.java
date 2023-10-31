import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Devolucion.DevolucionDao;
import model.Devolucion.DevolucionVo;

public class Devolucion extends HttpServlet{

    DevolucionVo r=new DevolucionVo(); 
    DevolucionDao rd=new DevolucionDao();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NOTA: Aqui debe llegar 
        
        System.out.println("Entró al DoGet");
        String enviar=req.getParameter("enviar");
        HttpSession session = req.getSession();
        switch(enviar){
            case "devolucion":{
            req.getRequestDispatcher("pages/Devolucion/devolucion.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Menu De Devolucion");
            break;
}
            case "registerDevo":
            req.getRequestDispatcher("pages/Devolucion/registrarDevoluvion.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Register");
            break;

            case "updateDevo":
            req.getRequestDispatcher("update.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Update");
            break;

            case "consultarDevolucion":
            req.getRequestDispatcher("pages/Devolucion/consultarDevolucion.jsp").forward(req, resp);
            session.setAttribute("mostrarModalActualizacion", true);
            System.out.println("Se Ha Redireccionado Al Consultar");
            break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        System.out.println("Entró al DoPost");
        String enviar = req.getParameter("enviar");
        
        // Agregar esta línea para obtener la sesión
        HttpSession session = req.getSession();
        
        switch (enviar) {
            case "registerDevo":
                System.out.println("Acabas de entrar al caso 'add'");
                session.setAttribute("mostrarModalActualizacion", true);
                add(req, resp);
                break;
    
            case "updateDevolucion":
                System.out.println("Acabas de entrar al caso 'update'");
                actualizarDevo(req, resp);
                break;
    
            case "consultarDevolucion":
                System.out.println("Acabas de entrar al caso 'listar'");
                session.setAttribute("mostrarModalActualizacion", true);
                listar(req, resp);
                break;
    
            case "eliminarDevolucion":
                System.out.println("Has Accedido Al Caso Delete");
                session.setAttribute("mostrarModalActualizacion", true);
                
                delete(req, resp);
                break;
        }
    }

    //? METODOS

    //? ADD - REGISTER+
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Devo_Cant_Preducto")!=null){
            r.setDevo_Cant_Preducto(Integer.parseInt(req.getParameter("Devo_Cant_Preducto"))); 
        }
        if(req.getParameter("Devo_Razon")!=null){
            r.setDevo_Razon(req.getParameter("Devo_Razon")); 
        }
        if(req.getParameter("Devo_Fecha")!=null){
            String Devo_Fecha = req.getParameter("Devo_Fecha");
            Date Fecha_Devo_Parse_Date= Date.valueOf(Devo_Fecha);
            r.setDevo_Fecha(Fecha_Devo_Parse_Date);


        }if(req.getParameter("Devo_Emple_id")!=null){
            r.setDevo_Emple_id(Integer.parseInt(req.getParameter("Devo_Emple_id"))); 
        }
        else{
            System.out.println("Error Al Registrar Datos");
        }
        try {
            rd.registerDevo(r);
            System.out.println("Registro insertado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/Devolucion/consultarDevolucion.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    //? UPDATE - ACTUALIZAR
    private void actualizarDevo(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Devo_Cant_Preducto")!=null){
            r.setDevo_Cant_Preducto( Integer.parseInt( req.getParameter("Devo_Cant_Preducto"))); 
        }
        if(req.getParameter("Devo_Razon")!=null){
            r.setDevo_Razon(req.getParameter("Devo_Razon")); 
        }
        if(req.getParameter("Devo_Fecha")!=null){
            String Devo_Fecha = req.getParameter("Devo_Fecha");
            Date Fecha_Devo_Parse_Date= Date.valueOf(Devo_Fecha);
            r.setDevo_Fecha(Fecha_Devo_Parse_Date); 

        }if(req.getParameter("Devo_Emple_id")!=null){
            r.setDevo_Emple_id(Integer.parseInt(req.getParameter("Devo_Emple_id"))); 
        }

        
        try {
            rd.actualizarDevo(r);
            System.out.println("Registro actualizado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/consultaDevolucion/consultaDevolucion.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la actualizacion del registro "+e.getMessage().toString());
        }
    }

    

        private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<DevolucionVo> devolucion = rd.listarDevo();
        req.setAttribute("devoluciones", devolucion);
        req.getRequestDispatcher("pages/consultaDevolucion/consultarDevolucion.jsp").forward(req, resp);

        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Has ingresado a la función eliminar");
    
        String Devo_id = req.getParameter("Devo_id");
    
        try {
            int DevoidToDelete = Integer.parseInt(Devo_id);
            System.out.println("ID Del Producto A Eliminar: " + DevoidToDelete);

            new DevolucionDao().eliminarDevo(DevoidToDelete);
            System.out.println("Empleado eliminado correctamente");

            // Redireccionamiento preventivo.
            // Redirige nuevamente a la página de listado de usuarios después de eliminar
            resp.sendRedirect(req.getContextPath() + "/Empleado?enviar=ConsultarEmple");
        } catch (NumberFormatException e) {
            // Si ocurre un error al convertir el ID a entero
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID De Empleado inválido");
        } catch (SQLException e) {
            // Si ocurre un error al eliminar el usuario en la base de datos
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el Empleado");
        }
    }
    
}
