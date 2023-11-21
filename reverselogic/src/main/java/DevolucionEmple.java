import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Devolucion.DevolucionDao;
import model.Devolucion.DevolucionVo;

public class DevolucionEmple extends HttpServlet{

    DevolucionVo r=new DevolucionVo(); 
    DevolucionDao rd=new DevolucionDao();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NOTA: Aqui debe llegar 
        
        System.out.println("Entró al DoGet");
        String enviar=req.getParameter("enviar");
        HttpSession session = req.getSession();
        switch(enviar){
            case "DevolucionEmple":{
            req.getRequestDispatcher("pages/CrudEmpleado/Devoluciones/Devoluciones.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Menu De Devolucion");
            break;
}
            case "RegistrarDevolucion":
            req.getRequestDispatcher("pages/CrudEmpleado/Devoluciones/RegistrarDevoluviones.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Register");
            break;

            case "ConsultarDevolucion":
            req.getRequestDispatcher("pages/CrudEmpleado/Devoluciones/consultarDevolucion.jsp").forward(req, resp);
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
            case "RegistrarDevolucion":
                System.out.println("Acabas de entrar al caso 'add'");
                session.setAttribute("mostrarModalActualizacion", true);
                add(req, resp);
                break;
    
            case "ConsultarDevolucion":
                System.out.println("Acabas de entrar al caso 'listar'");
                session.setAttribute("mostrarModalActualizacion", true);
                listar(req, resp);
                break;
        }
    }

    //? METODOS

    //? ADD - REGISTER+
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Devo_Cant_Preducto")!=null){
            r.setDevo_Cant_Preducto(Integer.parseInt(req.getParameter("Devo_Cant_Preducto"))); 
        }
        if(req.getParameter("Devo_Razon")!=null){
            r.setDevo_Razon(req.getParameter("Devo_Razon")); 
        }
        if(req.getParameter("Devo_Fecha")!=null){
            String Devo_Fecha = req.getParameter("Devo_Fecha");
            Date Fecha_Devo_Parse_Date= Date.valueOf(Devo_Fecha);
            r.setDevo_Fecha(Fecha_Devo_Parse_Date);
            
        }if(req.getParameter("Emple_id")!=null){
            r.setEmple_id(Integer.parseInt(req.getParameter("Emple_id"))); 
        }
        else{
            System.out.println("Error Al Registrar Datos");
        }
        try {
            rd.registerDevo(r);
            System.out.println("Registro insertado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/CrudEmpleado/Devoluciones/consultarDevolucion.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    

        private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<DevolucionVo> devolucion = rd.listarDevo();
        req.setAttribute("devoluciones", devolucion);
        req.getRequestDispatcher("pages/CrudEmpleado/Devoluciones/consultarDevolucion.jsp").forward(req, resp);

        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
    }
    
}
