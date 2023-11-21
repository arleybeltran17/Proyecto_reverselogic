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

public class PrendasEmple extends HttpServlet{

    PrendaVo r=new PrendaVo(); 
    PrendaDao rd=new PrendaDao();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NOTA: Aqui debe llegar 
        
        System.out.println("Entró al DoGet");
        String enviar=req.getParameter("enviar");
    HttpSession session = req.getSession();
        switch(enviar){
            case "prendasEmple":{
            req.getRequestDispatcher("pages/CrudEmpleado/Prendas/Prendas.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Menu De Prenda");
            break;
}
            case "RegistrarPrenda":
            req.getRequestDispatcher("pages/CrudEmpleado/Prendas/RegistrarPrendas.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Register");
            break;

            case "ConsultarPrenda":
            req.getRequestDispatcher("pages/CrudEmpleado/Prendas/ConsultarPrendas.jsp").forward(req, resp);
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
            case "RegistrarPrenda":
                System.out.println("Acabas de entrar al caso 'add'");
                session.setAttribute("mostrarModalActualizacion", true);
                add(req, resp);
                break;
    
            case "ConsultarPrenda":
                System.out.println("Acabas de entrar al caso 'listar'");
                session.setAttribute("mostrarModalActualizacion", true);
                listar(req, resp);
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
            req.getRequestDispatcher("pages/CrudEmpleado/Prendas/ConsultarPrendas.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    

        private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<PrendaVo> prenda = rd.listaPrend();
        req.setAttribute("prendas", prenda);
        req.getRequestDispatcher("pages/CrudEmpleado/Prendas/ConsultarPrendas.jsp").forward(req, resp);

        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
    }

}
