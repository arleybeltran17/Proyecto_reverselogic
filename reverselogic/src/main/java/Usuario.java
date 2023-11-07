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

import model.Usuario.UsuarioDao;
import model.Usuario.UsuarioVo;

public class Usuario extends HttpServlet{

    UsuarioVo r=new UsuarioVo(); 
    UsuarioDao rd=new UsuarioDao();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NOTA: Aqui debe llegar 
        
        System.out.println("Entró al DoGet");
        String enviar=req.getParameter("enviar");
    HttpSession session = req.getSession();
        switch(enviar){
            case "usuario":{
            req.getRequestDispatcher("pages/Usuario/usuario.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Menu De Usuarios");
            break;
}
            case "registerUsu":
            req.getRequestDispatcher("pages/Usuario/registerUsu.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Register");
            break;

            case "updateUsu":
            req.getRequestDispatcher("update.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Update");
            break;

            case "ConsultarUsu":
            req.getRequestDispatcher("pages/Usuario/ConsultarUsu.jsp").forward(req, resp);
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
            case "registerUsu":
                System.out.println("Acabas de entrar al caso 'add'");
                session.setAttribute("mostrarModalActualizacion", true);
                add(req, resp);
                break;
    
            case "updateUsu":
                System.out.println("Acabas de entrar al caso 'update'");
                actualizar(req, resp);
                break;
    
            case "ConsultarUsu":
                System.out.println("Acabas de entrar al caso 'listar'");
                session.setAttribute("mostrarModalActualizacion", true);
                listar(req, resp);
                break;
    
            case "eliminarUsu":
                System.out.println("Has Accedido Al Caso Delete");
                session.setAttribute("mostrarModalActualizacion", true);
                
                delete(req, resp);
                break;

                case "LoginUsu":
                System.out.println("Has Accedido Al Caso Login");
                session.setAttribute("mostrarModalActualizacion", true);
                
                LoginUser(req, resp);
                break;
        }
    }

    //? METODOS

    //? ADD - REGISTER+
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Usu_Nombre")!=null){  
            r.setUsu_Nombre( req.getParameter("Usu_Nombre")); 
        }
        if(req.getParameter("Usu_Rol")!=null){
            r.setUsu_Rol(Integer.parseInt(req.getParameter("Usu_Rol"))); 
        }
        if(req.getParameter("Usu_Password")!=null){
            r.setUsu_Password(req.getParameter("Usu_Password"));
            
        }if(req.getParameter("Emple_Id")!=null){
            r.setEmple_Id(Integer.parseInt(req.getParameter("Emple_Id"))); 
        }
        else{
            System.out.println("Error Al Registrar Datos");
        }
        try {
            rd.registrarUsu(r);
            System.out.println("Registro insertado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/Usuario/ConsultarUsu.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    //? UPDATE - ACTUALIZAR
    private void actualizar(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Usu_Nombre")!=null){
            r.setUsu_Nombre( req.getParameter("Usu_Nombre")); 
        }
        if(req.getParameter("Usu_Rol")!=null){
            r.setUsu_Rol(Integer.parseInt(req.getParameter("Usu_Rol"))); 
        }
        if(req.getParameter("Usu_Password")!=null){
            r.setUsu_Password(req.getParameter("Usu_Password")); 

        }if(req.getParameter("Emple_Id")!=null){
            r.setEmple_Id(Integer.parseInt(req.getParameter("Emple_Id"))); 
        }

        
        try {
            rd.actualizarUsu(r);
            System.out.println("Registro actualizado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/Usuario/ConsultarUsu.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la actualizacion del registro "+e.getMessage().toString());
        }
    }

        private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<UsuarioVo> usuario = rd.listarUsu();
        req.setAttribute("usuarios", usuario);
        req.getRequestDispatcher("pages/Usuario/ConsultarUsu.jsp").forward(req, resp);

        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Has ingresado a la función eliminar");
    
        String UsuIdStrDelete = req.getParameter("Usu_Id");
    
        try {
            int UsuIdToDelete = Integer.parseInt(UsuIdStrDelete);
            System.out.println("ID Del Producto A Eliminar: " + UsuIdToDelete);
    
            new UsuarioDao().eliminarUsu(UsuIdToDelete);
            System.out.println("Usuario eliminado correctamente");

            // Redireccionamiento preventivo.
            // Redirige nuevamente a la página de listado de usuarios después de eliminar
            resp.sendRedirect(req.getContextPath() + "/Usuario?enviar=ConsultarUsu");
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

    private void LoginUser(HttpServletRequest req,  HttpServletResponse resp) throws ServletException, IOException{
        String Nombre= req.getParameter("inputUsername");
        String Password = req.getParameter("inputPassword");

        if(Nombre != null && Nombre.isEmpty() && Password != null && Password.isEmpty()){
            try{
                if (rd.validarLogin(Nombre,Password)) {
                    System.out.println("La Validacion Ha Sido Exitosa");
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                    
                }else{
                    System.out.println("Usuario Y/O Contraseña No Encontrados");
                    req.setAttribute("mensaje", "Usuario Y/O Contraseña No Encontrados:(");
                    req.getRequestDispatcher("Login.jsp");
                }
            }catch(Exception e){
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error Al Iniciar Sesion");
            }

        }else{
            req.setAttribute("mensaje", "Usuario Y/O Contraseña No Encontrados:(");
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
    }
    
}
