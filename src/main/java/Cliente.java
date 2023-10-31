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

import model.Cliente.ClienteDao;
import model.Cliente.ClienteVo;

public class Cliente extends HttpServlet {
    ClienteVo r=new ClienteVo(); 
    ClienteDao rd=new ClienteDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NOTA: Aqui debe llegar 

        System.out.println("Entró al DoGet");
        String enviar=req.getParameter("enviar");
        HttpSession session = req.getSession();

        switch(enviar){
            case "cliente":{
            req.getRequestDispatcher("pages/Cliente/cliente.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Menu De Cliente");
            break;
}
            case "registerClient":
            req.getRequestDispatcher("pages/Cliente/registerClient.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Register");
            break;

            case "updateClient":
            req.getRequestDispatcher("update.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Update");
            break;

            case "ConsultarClient":
            req.getRequestDispatcher("pages/Cliente/ConsultarClient.jsp").forward(req, resp);
            session.setAttribute("mostrarModalActualizacion", true);
            System.out.println("Se Ha Redireccionado Al Consult");
            break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String enviar=req.getParameter("enviar");

        HttpSession session = req.getSession();
        switch(enviar){
            case "registerClient":
                System.out.println("Acabas de entrar al caso 'add'");
                session.setAttribute("mostrarModalActualizacion", true);
                add(req,resp);
            break;

            case "updateClient": 
                System.out.println("Acabas de entrar al caso 'update'");
                actualizar(req, resp);
            break;

            case "listarClient":
            System.out.println("Acabas de entrar al caso 'listar'");
            listar(req, resp);
            break;

            case "eliminarClient":
            System.out.println("Has Accedido Al Caso Delete");
            session.setAttribute("mostrarModalActualizacion", true);
            delete(req, resp);

            break;
        }
    }

    //? METODOS

    //? ADD - REGISTER+
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Clie_Tipo_Doc")!=null){
            r.setClie_Tipo_Doc( req.getParameter("Clie_Tipo_Doc")); 
        }
        if(req.getParameter("Clie_Num_Doc")!=null){
            r.setClie_Num_Doc(Integer.parseInt(req.getParameter("Clie_Num_Doc"))); 
        }
        if(req.getParameter("Clie_Nombre")!=null){
            r.setClie_Nombre(req.getParameter("Clie_Nombre")); 

        }if(req.getParameter("Clie_Apellido")!=null){
            r.setClie_Apellido(req.getParameter("Clie_Apellido")); 
        }
        if(req.getParameter("Clie_Direccion")!=null){
            r.setClie_Direccion(req.getParameter("Clie_Direccion")); 
        }
        if(req.getParameter("Clie_Email")!=null){
            r.setClie_Email(req.getParameter("Clie_Email")); 
        }
        else{
            System.out.println("Error Al Registrar Datos");
        }
        try {
            rd.registrarClient(r);
            System.out.println("Registro insertado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/Cliente/ConsultarClient.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    //? UPDATE - ACTUALIZAR
    private void actualizar(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Clie_Id")!=null){
            r.setClie_Id( Integer.parseInt(req.getParameter("Clie_Id"))); 
        }

        if(req.getParameter("Clie_Tipo_Doc")!=null){
            r.setClie_Tipo_Doc( req.getParameter("Clie_Tipo_Doc")); 
        }
        if(req.getParameter("Clie_Num_Doc")!=null){
            r.setClie_Num_Doc(Integer.parseInt(req.getParameter("Clie_Num_Doc"))); 
        }
        if(req.getParameter("Clie_Nombre")!=null){
            r.setClie_Nombre(req.getParameter("Clie_Nombre")); 

        }if(req.getParameter("Clie_Apellido")!=null){
            r.setClie_Apellido(req.getParameter("Clie_Apellido")); 
        }
        if(req.getParameter("Clie_Direccion")!=null){
            r.setClie_Direccion(req.getParameter("Clie_Direccion")); 
        }
        if(req.getParameter("Clie_Email")!=null){
            r.setClie_Email(req.getParameter("Clie_Email")); 
        }
        
        try {
            rd.actualizarClient(r);
            System.out.println("Registro actualizado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/Cliente/ConsultarClient.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la actualizacion del registro "+e.getMessage().toString());
        }
    }

    

        private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<ClienteVo> cliente = rd.listarClient();
        req.setAttribute("cliente", cliente);
        req.getRequestDispatcher("pages/Cliente/ConsultarClient.jsp").forward(req, resp);
        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Has ingresado a la función eliminar");
    
        String ClieIdStrDelete = req.getParameter("Clie_Id");
    
        try {
            int ClieIdToDelete = Integer.parseInt(ClieIdStrDelete);
            System.out.println("ID Del Producto A Eliminar: " + ClieIdToDelete);
    
            new ClienteDao().eliminarClient(ClieIdToDelete);
            System.out.println("Cliente eliminado correctamente");
    
            // Redireccionamiento preventivo.
            // Redirige nuevamente a la página de listado de usuarios después de eliminar
            resp.sendRedirect(req.getContextPath() + "/Cliente?enviar=ConsultarClient");
        } catch (NumberFormatException e) {
            // Si ocurre un error al convertir el ID a entero
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID De Cliente inválido");
        } catch (SQLException e) {
            // Si ocurre un error al eliminar el usuario en la base de datos
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el Cliente");
        }
    }   
}