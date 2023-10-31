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

import model.Producto.ProductoDao;
import model.Producto.ProductoVo;

public class ReverseLogic extends HttpServlet {
    ProductoVo r=new ProductoVo(); 
    ProductoDao rd=new ProductoDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NOTA: Aqui debe llegar 

        System.out.println("Entró al DoGet");
        String enviar=req.getParameter("enviar");
        HttpSession session = req.getSession();

        switch(enviar){
            case "producto":{
            req.getRequestDispatcher("pages/Producto/producto.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Menu De Productos");
            break;
}
            case "registerProd":
            req.getRequestDispatcher("pages/Producto/registerProd.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Register");
            break;

            case "updateProd":
            req.getRequestDispatcher("update.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Update");
            break;

            case "ConsultarProd":
            req.getRequestDispatcher("pages/Producto/ConsultarProd.jsp").forward(req, resp);
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
            case "registerProd":
                System.out.println("Acabas de entrar al caso 'add'");
                session.setAttribute("mostrarModalActualizacion", true);
                add(req,resp);
            break;

            case "updateProd": 
                System.out.println("Acabas de entrar al caso 'update'");
                actualizar(req, resp);
            break;

            case "ConsultarProd":
            System.out.println("Acabas de entrar al caso 'listar'");
            session.setAttribute("mostrarModalActualizacion", true);
            listar(req, resp);
            break;

            case "eliminarProd":
            System.out.println("Has Accedido Al Caso Delete");
            session.setAttribute("mostrarModalActualizacion", true);
            delete(req, resp);

            break;
        }
    }

    //? METODOS

    //? ADD - REGISTER+
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Prod_Nombre")!=null){
            r.setProd_nombre( req.getParameter("Prod_Nombre")); 
        }
        if(req.getParameter("Prod_Cant")!=null){
            r.setProd_cant(Integer.parseInt(req.getParameter("Prod_Cant"))); 
        }
        if(req.getParameter("Prod_Preciouni")!=null){
        
            r.setProd_preciouni(Integer.parseInt(req.getParameter("Prod_Preciouni"))); 

        }if(req.getParameter("Mate_Id")!=null){
        
            r.setMate_id(Integer.parseInt(req.getParameter("Mate_Id"))); 
        }
        else{
            System.out.println("Error Al Registrar Datos");
        }
        try {
            rd.registrarProd(r);
            System.out.println("Registro insertado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/Producto/ConsultarProd.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    //? UPDATE - ACTUALIZAR
    private void actualizar(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Prod_id")!=null){
            r.setProd_id( Integer.parseInt(req.getParameter("Prod_id"))); 
        }

        if(req.getParameter("Prod_Nombre")!=null){
            r.setProd_nombre( req.getParameter("Prod_Nombre")); 
        }
        if(req.getParameter("Prod_Cant")!=null){
            r.setProd_cant(Integer.parseInt(req.getParameter("Prod_Cant"))); 
        }
        if(req.getParameter("Prod_Preciouni")!=null){
         
            r.setProd_preciouni(Integer.parseInt(req.getParameter("Prod_Preciouni"))); 
        }if(req.getParameter("Mate_Id")!=null){
        
            r.setMate_id(Integer.parseInt(req.getParameter("Mate_Id"))); 
        }
        
        try {
            rd.actualizarProd(r);
            System.out.println("Registro actualizado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/Producto/ConsultarProd.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la actualizacion del registro "+e.getMessage().toString());
        }
    }


        private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<ProductoVo> producto = rd.listarProd();
        req.setAttribute("productos", producto);
        req.getRequestDispatcher("pages/Producto/ConsultarProd.jsp").forward(req, resp);
        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Has ingresado a la función eliminar");
    
        String ProdIdStrDelete = req.getParameter("Prod_id");
    
        try {
            int ProdIdToDelete = Integer.parseInt(ProdIdStrDelete);
            System.out.println("ID Del Producto A Eliminar: " + ProdIdToDelete);
    
            new ProductoDao().eliminarProd(ProdIdToDelete);
            System.out.println("Producto eliminado correctamente");
    
            // Redireccionamiento preventivo.
            // Redirige nuevamente a la página de listado de usuarios después de eliminar
            resp.sendRedirect(req.getContextPath() + "/ReverseLogic?enviar=ConsultarProd");
        } catch (NumberFormatException e) {
            // Si ocurre un error al convertir el ID a entero
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID De Producto inválido");
        } catch (SQLException e) {
            // Si ocurre un error al eliminar el usuario en la base de datos
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el Producto");
        }
    }
}

