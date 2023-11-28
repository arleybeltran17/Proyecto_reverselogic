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

import model.Color.ColorVo;
import model.Color.ColorDao;

public class ColoresEmple extends HttpServlet{

    ColorVo r=new ColorVo(); 
    ColorDao rd=new ColorDao();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NOTA: Aqui debe llegar 
        
        System.out.println("Entró al DoGet");
        String enviar=req.getParameter("enviar");
    HttpSession session = req.getSession();
        switch(enviar){
            case "Color":{
            req.getRequestDispatcher("pages/CrudEmpleado/Detalles/Colores/ColorEmple.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Menu De Color");
            break;
}
            case "RegistrarColores":
            req.getRequestDispatcher("pages/CrudEmpleado/Detalles/Colores/RegistrarColores.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Register");
            break;

            case "ConsultarColores":
            req.getRequestDispatcher("pages/CrudEmpleado/Detalles/Colores/ConsultarColores.jsp").forward(req, resp);
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
            case "RegistrarColores":
                System.out.println("Acabas de entrar al caso 'add'");
                session.setAttribute("mostrarModalActualizacion", true);
                add(req, resp);
                break;
    
           
            case "ConsultarColores":
                System.out.println("Acabas de entrar al caso 'listar'");
                session.setAttribute("mostrarModalActualizacion", true);
                listar(req, resp);
                break;
        }
    }

    //? METODOS

    //? ADD - REGISTER+
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Color_Nombre")!=null){
            r.setColor_Nombre( req.getParameter("Color_Nombre")); 
        }
        else{
            System.out.println("Error Al Registrar Datos");
        }
        try {
            rd.registrarColor(r);
            System.out.println("Registro insertado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/CrudEmpleado/Detalles/Colores/ConsultarColores.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

        private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<ColorVo> color = rd.listarColor();
        req.setAttribute("colores", color);
        req.getRequestDispatcher("pages/CrudEmpleado/Detalles/Colores/ConsultarColores.jsp").forward(req, resp);

        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
    }
}