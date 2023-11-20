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

import model.Prenda.PrendaDao;
import model.Prenda.PrendaVo;

public class Prenda extends HttpServlet{

    PrendaVo r=new PrendaVo(); 
    PrendaDao rd=new PrendaDao();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NOTA: Aqui debe llegar 
        
        System.out.println("Entró al DoGet");
        String enviar=req.getParameter("enviar");
    HttpSession session = req.getSession();
        switch(enviar){
            case "prenda":{
            req.getRequestDispatcher("pages/Prenda/prenda.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Menu De Prenda");
            break;
}
            case "registerPrend":
            req.getRequestDispatcher("pages/Prenda/registrarPrend.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Register");
            break;

            case "updatePrend":
            req.getRequestDispatcher("update.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Update");
            break;

            case "consultarPrend":
            req.getRequestDispatcher("pages/Prenda/consultarPrend.jsp").forward(req, resp);
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
            case "registerPrend":
                System.out.println("Acabas de entrar al caso 'add'");
                session.setAttribute("mostrarModalActualizacion", true);
                add(req, resp);
                break;
    
            case "updatePrend":
                System.out.println("Acabas de entrar al caso 'update'");
                actualizar(req, resp);
                break;
    
            case "consultarPrend":
                System.out.println("Acabas de entrar al caso 'listar'");
                session.setAttribute("mostrarModalActualizacion", true);
                listar(req, resp);
                break;
    
            case "eliminarPrend":
                System.out.println("Has Accedido Al Caso Delete");
                session.setAttribute("mostrarModalActualizacion", true);
                
                delete(req, resp);
                break;
        }
    }

    //? METODOS

    //? ADD - REGISTER+
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Prend_Marca")!=null){
            r.setPrend_Marca( req.getParameter("Prend_Marca")); 
        }
        if(req.getParameter("Prend_Talla")!=null){
            r.setPrend_Talla(req.getParameter("Prend_Talla")); 
        }
        if(req.getParameter("Prend_Descrip")!=null){
            r.setPrend_Descrip(req.getParameter("Prend_Descrip")); 

        }if(req.getParameter("Color_Id")!=null){
            r.setColor_Id(Integer.parseInt(req.getParameter("Color_Id"))); 
        }
        if(req.getParameter("Mate_Id")!=null){
            r.setMate_Id(Integer.parseInt(req.getParameter("Mate_Id"))); 
        }
        if(req.getParameter("Prod_Id")!=null){
            r.setProd_Id(Integer.parseInt(req.getParameter("Prod_Id"))); 
        }
        else{
            System.out.println("Error Al Registrar Datos");
        }
        try {
            rd.registrarPrend(r);
            System.out.println("Registro insertado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/Prenda/consultarPrend.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    //? UPDATE - ACTUALIZAR
    private void actualizar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("Prend_Id")!=null){
            r.setPrend_Id(Integer.parseInt(req.getParameter("Prend_Id"))); 
        }
        if(req.getParameter("Prend_Marca")!=null){
            r.setPrend_Marca( req.getParameter("Prend_Marca")); 
        }
        if(req.getParameter("Prend_Talla")!=null){
            r.setPrend_Talla(req.getParameter("Prend_Talla")); 
        }
        if(req.getParameter("Prend_Descrip")!=null){
            r.setPrend_Descrip(req.getParameter("Prend_Descrip")); 

        }if(req.getParameter("Color_Id")!=null){
            r.setColor_Id(Integer.parseInt(req.getParameter("Color_Id"))); 
        }
        if(req.getParameter("Mate_Id")!=null){
            r.setMate_Id(Integer.parseInt(req.getParameter("Mate_Id"))); 
        }
        if(req.getParameter("Prod_Id")!=null){
            r.setProd_Id(Integer.parseInt(req.getParameter("Prod_Id"))); 
        }
        
        try {
            rd.actualizarPrend(r);
            System.out.println("Registro actualizado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/Prenda/consultarPrend.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la actualizacion del registro "+e.getMessage().toString());
        }
    }

    

        private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<PrendaVo> prenda = rd.listaPrend();
        req.setAttribute("prendas", prenda);
        req.getRequestDispatcher("pages/Prenda/consultarPrend.jsp").forward(req, resp);

        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Has ingresado a la función eliminar");
    
        String PrendIdStrDelete = req.getParameter("Prend_Id");
    
        try {
            int PrendIdToDelete = Integer.parseInt(PrendIdStrDelete);
            System.out.println("ID Del Producto A Eliminar: " + PrendIdToDelete);
    
            new PrendaDao().eliminarPrenda(PrendIdToDelete);
            System.out.println("Empleado eliminado correctamente");

            // Redireccionamiento preventivo.
            // Redirige nuevamente a la página de listado de usuarios después de eliminar
            resp.sendRedirect(req.getContextPath() + "/Prenda?enviar=consultarPrend");
        } catch (NumberFormatException e) {
            // Si ocurre un error al convertir el ID a entero
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID De Prenda inválido");
        } catch (SQLException e) {
            // Si ocurre un error al eliminar el usuario en la base de datos
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el Prenda");
        }
    }
}
