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

import model.Material.MaterialVo;
import model.Material.MaterialDao;

public class Material extends HttpServlet{

    MaterialVo r=new MaterialVo(); 
    MaterialDao rd=new MaterialDao();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NOTA: Aqui debe llegar 
        
        System.out.println("Entró al DoGet");
        String enviar=req.getParameter("enviar");
    HttpSession session = req.getSession();
        switch(enviar){
            case "material":{
            req.getRequestDispatcher("pages/Detalles/Material/material.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Menu De Material");
            break;
}
            case "registerMaterial":
            req.getRequestDispatcher("pages/Detalles/Material/registrarMaterial.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Register");
            break;

            case "updateMaterial":
            req.getRequestDispatcher("update.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Update");
            break;

            case "consultarMaterial":
            req.getRequestDispatcher("pages/Detalles/Material/consultarMaterial.jsp").forward(req, resp);
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
            case "registerMaterial":
                System.out.println("Acabas de entrar al caso 'add'");
                session.setAttribute("mostrarModalActualizacion", true);
                add(req, resp);
                break;
    
            case "updateMaterial":
                System.out.println("Acabas de entrar al caso 'update'");
                actualizar(req, resp);
                break;
    
            case "ConsultarMaterial":
                System.out.println("Acabas de entrar al caso 'listar'");
                session.setAttribute("mostrarModalActualizacion", true);
                listar(req, resp);
                break;
    
            case "eliminarMaterial":
                System.out.println("Has Accedido Al Caso Delete");
                session.setAttribute("mostrarModalActualizacion", true);
                
                delete(req, resp);
                break;
        }
    }

    //? METODOS

    //? ADD - REGISTER+
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Mate_Nombre")!=null){
            r.setMate_Nombre( req.getParameter("Mate_Nombre")); 
        }
        else{
            System.out.println("Error Al Registrar Datos");
        }
        try {
            rd.registrarMate(r);
            System.out.println("Registro insertado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/Detalles/Material/consultarMaterial.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    //? UPDATE - ACTUALIZAR
    private void actualizar(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Mate_Id")!=null){
            r.setMate_Id( Integer.parseInt(req.getParameter("Mate_Id"))); 
        }

        if(req.getParameter("Mate_Nombre")!=null){
            r.setMate_Nombre( req.getParameter("Mate_Nombre")); 
        }
        
        try {
            rd.actualizarMate(r);
            System.out.println("Registro actualizado correctamente");
    
            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/Material/consultarMaterial.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la actualizacion del registro "+e.getMessage().toString());
        }
    }

    

        private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<MaterialVo> material = rd.listarMate();
        req.setAttribute("materiales", material);
        req.getRequestDispatcher("pages/Detalles/Material/consultarMaterial.jsp").forward(req, resp);

        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Has ingresado a la función eliminar");
    
        String Material_IdStrDelete = req.getParameter("Mate_Id");
    
        try {
            int Material_IdToDelete = Integer.parseInt(Material_IdStrDelete);
            System.out.println("ID Del Producto A Eliminar: " + Material_IdToDelete);
    
            new MaterialDao().eliminarMate(Material_IdToDelete);
            System.out.println("Empleado eliminado correctamente");

            // Redireccionamiento preventivo.
            // Redirige nuevamente a la página de listado de usuarios después de eliminar
            resp.sendRedirect(req.getContextPath() + "/Material?enviar=consultarMaterial");
        } catch (NumberFormatException e) {
            // Si ocurre un error al convertir el ID a entero
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID De material inválido");
        } catch (SQLException e) {
            // Si ocurre un error al eliminar el usuario en la base de datos
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el material");
        }
    }
    
}
