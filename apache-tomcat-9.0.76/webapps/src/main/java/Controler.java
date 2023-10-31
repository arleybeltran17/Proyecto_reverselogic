import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.UsuarioDao;
import model.UsuarioVo;

public class Controler extends HttpServlet {
    UsuarioVo r=new UsuarioVo(); 
    UsuarioDao rd=new UsuarioDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NOTA: Aqui debe llegar 

        System.out.println("Entró al DoGet");
        String a=req.getParameter("Enviar");

        switch(a){
            case "user-update":
                req.getRequestDispatcher("user-update.jsp").forward(req, resp);
                System.out.println("Se ha redireccionado a user-update.");
            break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String a=req.getParameter("Enviar");
        switch(a){
            case "register":
                System.out.println("Acabas de entrar al caso 'add'");
                add(req,resp);
            break;

            case "update": 
                System.out.println("Acabas de entrar al caso 'update'");
                actualizar(req, resp);
            break;

            case "login":
                System.out.println("Acabas de entrar al caso 'login'");
                iniciar(req, resp);
            break;

            case "user":
            listar(req, resp);
            break;
        }
    }

    //SECCION: METODOS

    //SECCION: ADD - REGISTER
    private void add(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("user_firstname")!=null){
            r.setUser_firstname( req.getParameter("user_firstname")); 
        }
        if(req.getParameter("user_email")!=null){
            r.setUser_email(req.getParameter("Correo")); 
        }
        if(req.getParameter("user_password")!=null){
            r.setUser_password(req.getParameter("Contrasena")); 
        }
        else{
            System.out.println("Error Al Registrar Datos");
        }
        try {
            rd.registrar(r);
            System.out.println("Registro insertado correctamente");

            //NOTA: Redireccionamiento preventivo.       
            req.getRequestDispatcher("register.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    //SECCION: UPDATE - ACTUALIZAR
    private void actualizar(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("user_id")!=null){
            r.setUser_id (Integer.parseInt(req.getParameter("user_id"))); 
        }
        if(req.getParameter("user_firstname")!=null){
            r.setUser_firstname(req.getParameter("user_firstname")); 
        }
        if(req.getParameter("user_lastname")!=null){
            r.setUser_lastname(req.getParameter("user_lastname")); 
        }
        if(req.getParameter("user_email")!=null){
            r.setUser_email(req.getParameter("user_email")); 
        }
        if(req.getParameter("user_password")!=null){
            r.setUser_password(req.getParameter("user_password")); 
        }
        
        try {
            rd.actualizar(r);
            System.out.println("Registro actualizado correctamente");

            //NOTA: Redireccionamiento preventivo.       
            req.getRequestDispatcher("user-update.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la actualizacion del registro "+e.getMessage().toString());
        }
    }

    public void iniciar(HttpServletRequest req, HttpServletResponse resp) {
    System.out.println("Esta actualmente en el login");
        //obtener parametros
        String nombre = req.getParameter("user_firstname");
        String contrasena = req.getParameter("user_password");
        
        if(nombre.equals("admin") && contrasena.equals("admin")){
            try{
                r = rd.obtenerUsuario(nombre,contrasena);
            if(r!=null){
                HttpSession iniciar = req.getSession();
                iniciar.setAttribute("user_firstname",r);
                listar(req, resp);
            }else{
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }

        }catch(Exception e) {

            System.out.println("Error en la modificacion"+e.getMessage().toString());

        }
        }else{
            try{
                r = rd.obtenerUsuario(nombre, contrasena);
            if(r!=null){
                HttpSession iniciar = req.getSession();
                iniciar.setAttribute("Usuario",r);
                req.getRequestDispatcher("dashboardDaviplata.jsp").forward(req, resp);
            }else{
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
            }catch(Exception e) {
                System.out.println("Error en la modificacion"+e.getMessage().toString());

            }
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List usuario=rd.listar();
            req.setAttribute("user_firstname", usuario);
            req.getRequestDispatcher("feed.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }   
}