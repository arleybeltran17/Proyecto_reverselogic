import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Venta.VentaDao;
import model.Venta.VentaVo;

public class Venta extends HttpServlet{

    VentaVo r=new VentaVo(); 
    VentaDao rd=new VentaDao();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NOTA: Aqui debe llegar 
        
        System.out.println("Entró al DoGet");
        String enviar=req.getParameter("enviar");
    HttpSession session = req.getSession();
        switch(enviar){
            case "venta":{
            req.getRequestDispatcher("pages/Venta/venta.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Menu De Prenda");
            break;
}
            case "registerVent":
            req.getRequestDispatcher("pages/Venta/RegistrarVent.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Register");
            break;

            case "updateVent":
            req.getRequestDispatcher("update.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Update");
            break;

            case "ConsultarVent":
            req.getRequestDispatcher("pages/Venta/ConsultarVent.jsp").forward(req, resp);
            session.setAttribute("mostrarModalActualizacion", true);
            System.out.println("Se Ha Redireccionado Al Consult");
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
            case "registerVent":
                System.out.println("Acabas de entrar al caso 'add'");
                session.setAttribute("mostrarModalActualizacion", true);
                add(req, resp);
                break;
    
            case "updateVent":
                System.out.println("Acabas de entrar al caso 'update'");
                actualizar(req, resp);
                break;
    
            case "ConsultarVent":
                System.out.println("Acabas de entrar al caso 'listar'");
                session.setAttribute("mostrarModalActualizacion", true);
                listar(req, resp);
                break;
    
            case "eliminarVent":
                System.out.println("Has Accedido Al Caso Delete");
                session.setAttribute("mostrarModalActualizacion", true);
                
                delete(req, resp);
                break;
        }
    }

    //? METODOS

    //? ADD - REGISTER+
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Vent_Cantidad")!=null){
            r.setVent_Cantidad(Integer.parseInt(req.getParameter("Vent_Cantidad"))); 
        }
        if(req.getParameter("Vent_Fecha")!=null){
            String Venta_Fecha = req.getParameter("Vent_Fecha");
            Date Fecha_Vent_Parse_Date= Date.valueOf(Venta_Fecha);
            r.setVent_Fecha(Fecha_Vent_Parse_Date);

        }if(req.getParameter("Usu_Id")!=null){
            r.setUsu_Id(Integer.parseInt(req.getParameter("Usu_Id"))); 
        }
        if(req.getParameter("Clie_Id")!=null){
            r.setClie_Id(Integer.parseInt(req.getParameter("Clie_Id"))); 
        }
        if(req.getParameter("Metod_Id")!=null){
            r.setMetod_Id(Integer.parseInt(req.getParameter("Metod_Id"))); 
        }
        if(req.getParameter("Prend_Id")!=null){
            r.setPrend_Id(Integer.parseInt(req.getParameter("Prend_Id"))); 
        }
        else{
            System.out.println("Error Al Registrar Datos");
        }
        try {
            rd.registrarVent(r);
            System.out.println("Registro insertado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/Venta/ConsultarVent.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    //? UPDATE - ACTUALIZAR
    private void actualizar(HttpServletRequest req, HttpServletResponse resp) {


        if(req.getParameter("Vent_Id")!=null){
            r.setVent_Id(Integer.parseInt(req.getParameter("Vent_Id"))); 
        }
        if(req.getParameter("Vent_Cantidad")!=null){
            r.setVent_Cantidad(Integer.parseInt(req.getParameter("Vent_Cantidad"))); 
        }
       if(req.getParameter("Vent_Fecha")!=null){
            String Venta_Fecha = req.getParameter("Vent_Fecha");
            Date Fecha_Vent_Parse_Date= Date.valueOf(Venta_Fecha);
            r.setVent_Fecha(Fecha_Vent_Parse_Date);

        }if(req.getParameter("Usu_Id")!=null){
            r.setUsu_Id(Integer.parseInt(req.getParameter("Usu_Id"))); 
        }
        if(req.getParameter("Clie_Id")!=null){
            r.setClie_Id(Integer.parseInt(req.getParameter("Clie_Id"))); 
        }
        if(req.getParameter("Metod_Id")!=null){
            r.setMetod_Id(Integer.parseInt(req.getParameter("Metod_Id"))); 
        }
        if(req.getParameter("Prend_Id")!=null){
            r.setPrend_Id(Integer.parseInt(req.getParameter("Prend_Id"))); 
        }
        
        try {
            rd.actualizarVent(r);
            System.out.println("Registro actualizado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/Venta/ConsultarPrend.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la actualizacion del registro "+e.getMessage().toString());
        }
    }

    

        private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<VentaVo> venta = rd.listarVent();
        req.setAttribute("ventas", venta);
        req.getRequestDispatcher("pages/Venta/ConsultarVent.jsp").forward(req, resp);

        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Has ingresado a la función eliminar");
    
        String VentIdStrDelete = req.getParameter("Vent_Id");
    
        try {
            int VentIdToDelete = Integer.parseInt(VentIdStrDelete);
            System.out.println("ID Del Producto A Eliminar: " + VentIdToDelete);
    
            new VentaDao().eliminarVent(VentIdToDelete);
            System.out.println("Venta eliminado correctamente");

            // Redireccionamiento preventivo.
            // Redirige nuevamente a la página de listado de usuarios después de eliminar
            resp.sendRedirect(req.getContextPath() + "/Venta?enviar=ConsultarVent");
        } catch (NumberFormatException e) {
            // Si ocurre un error al convertir el ID a entero
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID De Venta inválido");
        } catch (SQLException e) {
            // Si ocurre un error al eliminar el usuario en la base de datos
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error Al Eliminar El Venta");
        }
    }
}
