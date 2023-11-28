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

import model.MetodoDePago.MetodoDePagoDao;
import model.MetodoDePago.MetodoDePagoVo;

public class MetodosDePagoEmple extends HttpServlet{

    MetodoDePagoVo r=new MetodoDePagoVo(); 
    MetodoDePagoDao rd=new MetodoDePagoDao();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NOTA: Aqui debe llegar 
        
        System.out.println("Entró al DoGet");
        String enviar=req.getParameter("enviar");
        HttpSession session = req.getSession();
        switch(enviar){
            case "Metodos":{
            req.getRequestDispatcher("pages/CrudEmpleado/Detalles/MetodosDePago/MetodosDePagos.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Menu De Empleado");
            break;
}
            case "RegistrarMetodos":
            req.getRequestDispatcher("pages/CrudEmpleado/Detalles/MetodosDePago/RegistrarMetodos.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Register");
            break;


            case "ConsultarMetodos":
            req.getRequestDispatcher("pages/CrudEmpleado/Detalles/MetodosDePago/ConsultarMetodos.jsp").forward(req, resp);
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
            case "RegistrarMetodos":
                System.out.println("Acabas de entrar al caso 'add'");
                session.setAttribute("mostrarModalActualizacion", true);
                add(req, resp);
                break;
    
            case "ConsultarMetodos":
                System.out.println("Acabas de entrar al caso 'listar'");
                session.setAttribute("mostrarModalActualizacion", true);
                listar(req, resp);
                break;
    
        }
    }

    //? METODOS

    //? ADD - REGISTER+
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Metod_Tipo")!=null){
            r.setMetod_Tipo( req.getParameter("Metod_Tipo")); 
        }
        else{
            System.out.println("Error Al Registrar Datos");
        }
        try {
            rd.registrarMetod(r);
            System.out.println("Registro insertado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/CrudEmpleado/Detalles/MetodosDePago/ConsultarMetodos.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    
        private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<MetodoDePagoVo> metodo = rd.listarMetod();
        req.setAttribute("metodos", metodo);
        req.getRequestDispatcher("pages/CrudEmpleado/Detalles/MetodosDePago/ConsultarMetodos.jsp").forward(req, resp);

        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos" + e.getMessage().toString());
    }
    }
}
