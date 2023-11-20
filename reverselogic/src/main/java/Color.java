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

import model.Color.ColorVo;
import model.Color.ColorDao;

public class Color extends HttpServlet{

    ColorVo r=new ColorVo(); 
    ColorDao rd=new ColorDao();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NOTA: Aqui debe llegar 
        
        System.out.println("Entró al DoGet");
        String enviar=req.getParameter("enviar");
    HttpSession session = req.getSession();
        switch(enviar){
            case "color":{
            req.getRequestDispatcher("pages/Detalles/Color/color.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Menu De Color");
            break;
}
            case "registrarColor":
            req.getRequestDispatcher("pages/Detalles/Color/registrarColor.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Register");
            break;

            case "updateColor":
            req.getRequestDispatcher("update.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Update");
            break;

            case "consultarColor":
            req.getRequestDispatcher("pages/Detalles/Color/consultarColor.jsp").forward(req, resp);
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
            case "registrarColor":
                System.out.println("Acabas de entrar al caso 'add'");
                session.setAttribute("mostrarModalActualizacion", true);
                add(req, resp);
                break;
    
            case "updateColor":
                System.out.println("Acabas de entrar al caso 'update'");
                actualizar(req, resp);
                break;
    
            case "consultarColor":
                System.out.println("Acabas de entrar al caso 'listar'");
                session.setAttribute("mostrarModalActualizacion", true);
                listar(req, resp);
                break;
    
            case "eliminarColor":
                System.out.println("Has Accedido Al Caso Delete");
                session.setAttribute("mostrarModalActualizacion", true);
                
                delete(req, resp);
                break;
        }
    }

    //? METODOS

    //? ADD - REGISTER+
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Color_Nombre")!=null){
            r.setColor_Nombre( req.getParameter("Color_Nombre")); 
        }
        else{
            System.out.println("Error Al Registrar Datos");
        }
        try {
            rd.registrarColor(r);
            System.out.println("Registro insertado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/Detalles/Color/consultarColor.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    //? UPDATE - ACTUALIZAR
    private void actualizar(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Color_Id")!=null){
            r.setColor_Id( Integer.parseInt(req.getParameter("Color_Id"))); 
        }

        if(req.getParameter("Color_Nombre")!=null){
            r.setColor_Nombre( req.getParameter("Color_Nombre")); 
        }
        
        try {
            rd.actualizarColor(r);
            System.out.println("Registro actualizado correctamente");
    
            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/Detalles/Color/consultarColor.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la actualizacion del registro "+e.getMessage().toString());
        }
    }

    

        private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<ColorVo> color = rd.listarColor();
        req.setAttribute("colores", color);
        req.getRequestDispatcher("pages/Detalles/Color/consultarColor.jsp").forward(req, resp);

        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Has ingresado a la función eliminar");
    
        String Color_IdStrDelete = req.getParameter("Color_Id");
    
        try {
            int Color_IdToDelete = Integer.parseInt(Color_IdStrDelete);
            System.out.println("ID Del Producto A Eliminar: " + Color_IdToDelete);
    
            new ColorDao().eliminarColor(Color_IdToDelete);
            System.out.println("Empleado eliminado correctamente");

            // Redireccionamiento preventivo.
            // Redirige nuevamente a la página de listado de usuarios después de eliminar
            resp.sendRedirect(req.getContextPath() + "/Color?enviar=consultarColor");
        } catch (NumberFormatException e) {
            // Si ocurre un error al convertir el ID a entero
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID De color inválido");
        } catch (SQLException e) {
            // Si ocurre un error al eliminar el usuario en la base de datos
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el color");
        }
    }
    
}
