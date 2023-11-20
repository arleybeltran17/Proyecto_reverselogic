import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MetodoDePago.MetodoDePagoDao;
import model.MetodoDePago.MetodoDePagoVo;

public class MetodoDePago extends HttpServlet{

    MetodoDePagoVo r=new MetodoDePagoVo(); 
    MetodoDePagoDao rd=new MetodoDePagoDao();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NOTA: Aqui debe llegar 
        
        System.out.println("Entró al DoGet");
        String enviar=req.getParameter("enviar");
        HttpSession session = req.getSession();
        switch(enviar){
            case "metodo":{
            req.getRequestDispatcher("pages/Detalles/MetodoDePago/metodoDePago.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Menu De Empleado");
            break;
}
            case "registrarMetod":
            req.getRequestDispatcher("pages/Detalles/MetodoDePago/registrarMetodo.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Register");
            break;

            case "updateMetod":
            req.getRequestDispatcher("update.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Update");
            break;

            case "ConsultarMetod":
            req.getRequestDispatcher("pages/Detalles/MetodoDePago/consultarMetodo.jsp").forward(req, resp);
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
            case "registrarMetod":
                System.out.println("Acabas de entrar al caso 'add'");
                session.setAttribute("mostrarModalActualizacion", true);
                add(req, resp);
                break;
    
            case "updateMetod":
                System.out.println("Acabas de entrar al caso 'update'");
                actualizar(req, resp);
                break;
    
            case "ConsultarMetod":
                System.out.println("Acabas de entrar al caso 'listar'");
                session.setAttribute("mostrarModalActualizacion", true);
                listar(req, resp);
                break;
    
            case "eliminarMetod":
                System.out.println("Has Accedido Al Caso Delete");
                session.setAttribute("mostrarModalActualizacion", true);
                
                delete(req, resp);
                break;
        }
    }

    //? METODOS

    //? ADD - REGISTER+
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Metod_Tipo")!=null){
            r.setMetod_Tipo( req.getParameter("Metod_Tipo")); 
        }
        else{
            System.out.println("Error Al Registrar Datos");
        }
        try {
            rd.registrarMetod(r);
            System.out.println("Registro insertado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/Detalles/MetodoDePago/consultarMetodo.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    //? UPDATE - ACTUALIZAR
    private void actualizar(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Metod_Id")!=null){
            r.setMetod_Id( Integer.parseInt(req.getParameter("Metod_Id"))); 
        }

        if(req.getParameter("Metod_Tipo")!=null){
            r.setMetod_Tipo( req.getParameter("Metod_Tipo")); 
        }
        
        try {
            rd.actualizarMetod(r);
            System.out.println("Registro actualizado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/Detalles/MetodoDePago/consultarMetodo.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la actualizacion del registro "+e.getMessage().toString());
        }
    }

    

        private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<MetodoDePagoVo> metodo = rd.listarMetod();
        req.setAttribute("metodos", metodo);
        req.getRequestDispatcher("pages/Detalles/MetodoDePago/consultarMetodo.jsp").forward(req, resp);

        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Has ingresado a la función eliminar");
    
        String Metod_IdStrDelete = req.getParameter("Metod_Id");
    
        try {
            int Metod_IdToDelete = Integer.parseInt(Metod_IdStrDelete);
            System.out.println("ID Del Producto A Eliminar: " + Metod_IdToDelete);
    
            new MetodoDePagoDao().eliminarMetod(Metod_IdToDelete);
            System.out.println("metodo eliminado correctamente");

            // Redireccionamiento preventivo.
            // Redirige nuevamente a la página de listado de usuarios después de eliminar
            resp.sendRedirect(req.getContextPath() + "/MetodoDePago?enviar=ConsultarMetod");
        } catch (NumberFormatException e) {
            // Si ocurre un error al convertir el ID a entero
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID De Metodo inválido");
        } catch (SQLException e) {
            // Si ocurre un error al eliminar el usuario en la base de datos
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el Metodo");
        }
    }
    
}
