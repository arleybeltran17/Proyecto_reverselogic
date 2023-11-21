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

public class ProductoEmple extends HttpServlet {
    ProductoVo r=new ProductoVo(); 
    ProductoDao rd=new ProductoDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NOTA: Aqui debe llegar 

        System.out.println("Entró al DoGet");
        String enviar=req.getParameter("enviar");
        HttpSession session = req.getSession();

        switch(enviar){
            case "productoEmple":{
            req.getRequestDispatcher("pages/CrudEmpleado/Productos/Productos.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Menu De Productos");
            break;
}
            case "RegistrarProductos":
            req.getRequestDispatcher("pages/CrudEmpleado/Productos/RegistrarProductos.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Register");
            break;

            case "ConsultarProductos":
            req.getRequestDispatcher("pages/CrudEmpleado/Productos/ConsultarProductos.jsp").forward(req, resp);
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
            case "RegistrarProductos":
                System.out.println("Acabas de entrar al caso 'add'");
                session.setAttribute("mostrarModalActualizacion", true);
                add(req,resp);
            break;

            case "ConsultarProductos":
            System.out.println("Acabas de entrar al caso 'listar'");
            session.setAttribute("mostrarModalActualizacion", true);
            listar(req, resp);
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
            req.getRequestDispatcher("pages/CrudEmpleado/Productos/ConsultarProductos.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }


        private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<ProductoVo> producto = rd.listarProd();
        req.setAttribute("productos", producto);
        req.getRequestDispatcher("pages/CrudEmpleado/Productos/ConsultarProductos.jsp").forward(req, resp);
        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
    }

    
}

