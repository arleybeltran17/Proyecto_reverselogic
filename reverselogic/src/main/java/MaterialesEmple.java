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

public class MaterialesEmple extends HttpServlet{

    MaterialVo r=new MaterialVo(); 
    MaterialDao rd=new MaterialDao();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NOTA: Aqui debe llegar 
        
        System.out.println("Entró al DoGet");
        String enviar=req.getParameter("enviar");
    HttpSession session = req.getSession();
        switch(enviar){
            case "Materiales":{
            req.getRequestDispatcher("pages/CrudEmpleado/Detalles/Materiales/Materiales.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Menu De Material");
            break;
}
            case "RegisterMateriales":
            req.getRequestDispatcher("pages/CrudEmpleado/Detalles/Materiales/RegistrarMateriales.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Register");
            break;


            case "ConsultarMateriales":
            req.getRequestDispatcher("pages/CrudEmpleado/Detalles/Materiales/ConsultarMateriales.jsp").forward(req, resp);
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
            case "RegisterMateriales":
                System.out.println("Acabas de entrar al caso 'add'");
                session.setAttribute("mostrarModalActualizacion", true);
                add(req, resp);
                break;
    
    
            case "ConsultarMateriales":
                System.out.println("Acabas de entrar al caso 'listar'");
                session.setAttribute("mostrarModalActualizacion", true);
                listar(req, resp);
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
            req.getRequestDispatcher("pages/CrudEmpleado/Detalles/Materiales/ConsultarMateriales.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

        private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<MaterialVo> material = rd.listarMate();
        req.setAttribute("materiales", material);
        req.getRequestDispatcher("pages/CrudEmpleado/Detalles/Materiales/consultarMateriales.jsp").forward(req, resp);

        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
    }

}
