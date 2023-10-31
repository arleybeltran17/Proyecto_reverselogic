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

import model.Empleado.EmpleadoDao;
import model.Empleado.EmpleadoVo;

public class Empleado extends HttpServlet{

    EmpleadoVo r=new EmpleadoVo(); 
    EmpleadoDao rd=new EmpleadoDao();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NOTA: Aqui debe llegar 
        
        System.out.println("Entró al DoGet");
        String enviar=req.getParameter("enviar");
    HttpSession session = req.getSession();
        switch(enviar){
            case "empleado":{
            req.getRequestDispatcher("pages/Empleado/empleado.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Menu De Empleado");
            break;
}
            case "registerEmple":
            req.getRequestDispatcher("pages/Empleado/registerEmple.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Register");
            break;

            case "updateEmple":
            req.getRequestDispatcher("update.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Update");
            break;

            case "ConsultarEmple":
            req.getRequestDispatcher("pages/Empleado/ConsultarEmple.jsp").forward(req, resp);
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
            case "registerEmple":
                System.out.println("Acabas de entrar al caso 'add'");
                session.setAttribute("mostrarModalActualizacion", true);
                add(req, resp);
                break;
    
            case "updateEmple":
                System.out.println("Acabas de entrar al caso 'update'");
                actualizar(req, resp);
                break;
    
            case "ConsultarEmple":
                System.out.println("Acabas de entrar al caso 'listar'");
                session.setAttribute("mostrarModalActualizacion", true);
                listar(req, resp);
                break;
    
            case "eliminarEmple":
                System.out.println("Has Accedido Al Caso Delete");
                session.setAttribute("mostrarModalActualizacion", true);
                
                delete(req, resp);
                break;
        }
    }

    //? METODOS

    //? ADD - REGISTER+
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Emple_Tipo_Doc")!=null){
            r.setEmple_Tipo_Doc( req.getParameter("Emple_Tipo_Doc")); 
        }
        if(req.getParameter("Emple_Num_Doc")!=null){
            r.setEmple_Num_Doc(Integer.parseInt(req.getParameter("Emple_Num_Doc"))); 
        }
        if(req.getParameter("Emple_Nombre")!=null){
            r.setEmple_Nombre(req.getParameter("Emple_Nombre")); 

        }if(req.getParameter("Emple_Apellido")!=null){
            r.setEmple_Apellido(req.getParameter("Emple_Apellido")); 
        }
        if(req.getParameter("Emple_Cargo")!=null){
            r.setEmple_Cargo(req.getParameter("Emple_Cargo")); 
        }
        if(req.getParameter("Emple_Direccion")!=null){
            r.setEmple_Direccion(req.getParameter("Emple_Direccion")); 
        }
        if(req.getParameter("Emple_Email")!=null){
            r.setEmple_Email(req.getParameter("Emple_Email")); 
        }
        else{
            System.out.println("Error Al Registrar Datos");
        }
        try {
            rd.registrarEmple(r);
            System.out.println("Registro insertado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/Empleado/ConsultarEmple.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    //? UPDATE - ACTUALIZAR
    private void actualizar(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Emple_Id")!=null){
            r.setEmple_Id( Integer.parseInt(req.getParameter("Emple_Id"))); 
        }

        if(req.getParameter("Emple_Tipo_Doc")!=null){
            r.setEmple_Tipo_Doc( req.getParameter("Emple_Tipo_Doc")); 
        }
        if(req.getParameter("Emple_Num_Doc")!=null){
            r.setEmple_Num_Doc(Integer.parseInt(req.getParameter("Emple_Num_Doc"))); 
        }
        if(req.getParameter("Emple_Nombre")!=null){
            r.setEmple_Nombre(req.getParameter("Emple_Nombre")); 

        }if(req.getParameter("Emple_Apellido")!=null){
            r.setEmple_Apellido(req.getParameter("Emple_Apellido")); 
        }
        if(req.getParameter("Emple_Cargo")!=null){
            r.setEmple_Cargo(req.getParameter("Emple_Cargo")); 
        }
        if(req.getParameter("Emple_Direccion")!=null){
            r.setEmple_Direccion(req.getParameter("Emple_Direccion")); 
        }
        if(req.getParameter("Emple_Email")!=null){
            r.setEmple_Email(req.getParameter("Emple_Email")); 
        }
        
        try {
            rd.actualizarEmple(r);
            System.out.println("Registro actualizado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/Empleado/ConsultarEmple.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la actualizacion del registro "+e.getMessage().toString());
        }
    }

    

        private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<EmpleadoVo> empleado = rd.listarEmple();
        req.setAttribute("empleados", empleado);
        req.getRequestDispatcher("pages/Empleado/ConsultarEmple.jsp").forward(req, resp);

        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Has ingresado a la función eliminar");
    
        String EmpleIdStrDelete = req.getParameter("Emple_Id");
    
        try {
            int EmpleIdToDelete = Integer.parseInt(EmpleIdStrDelete);
            System.out.println("ID Del Producto A Eliminar: " + EmpleIdToDelete);
    
            new EmpleadoDao().eliminarEmple(EmpleIdToDelete);
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
