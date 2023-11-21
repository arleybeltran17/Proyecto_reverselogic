import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Venta.VentaDao;
import model.Venta.VentaVo;

public class VentaEmple extends HttpServlet{

    VentaVo r=new VentaVo(); 
    VentaDao rd=new VentaDao();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NOTA: Aqui debe llegar 
        
        System.out.println("Entró al DoGet");
        String enviar=req.getParameter("enviar");
    HttpSession session = req.getSession();
        switch(enviar){
            case "ventaEmple":{
            req.getRequestDispatcher("pages/CrudEmpleado/Ventas/Ventas.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Menu De Prenda");
            break;
}
            case "RegistrarVenta":
            req.getRequestDispatcher("pages/CrudEmpleado/Ventas/RegistrarVentas.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Register");
            break;

            case "ConsultarVentas":
            req.getRequestDispatcher("pages/CrudEmpleado/Ventas/ConsultarVentas.jsp").forward(req, resp);
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
            case "RegistrarVenta":
                System.out.println("Acabas de entrar al caso 'add'");
                session.setAttribute("mostrarModalActualizacion", true);
                add(req, resp);
                break;
            case "ConsultarVentas":
                System.out.println("Acabas de entrar al caso 'listar'");
                session.setAttribute("mostrarModalActualizacion", true);
                listar(req, resp);
                break;
        }
    }

    //? METODOS

    //? ADD - REGISTER+
    private void add(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(req.getParameter("Vent_Cantidad"));        
        if(req.getParameter("Vent_Cantidad")!=null){
            r.setVent_Cantidad(Integer.parseInt(req.getParameter("Vent_Cantidad"))); 
        }
        if(req.getParameter("Vent_Fecha")!=null){
            String Venta_Fecha = req.getParameter("Vent_Fecha");
            Date Fecha_Vent_Parse_Date= Date.valueOf(Venta_Fecha);
            r.setVent_Fecha(Fecha_Vent_Parse_Date);

        }if(req.getParameter("Usu_Id")!=null){
            r.setUsu_Id(Integer.parseInt(req.getParameter("Usu_Id"))); 
        }
        if(req.getParameter("Clie_Id")!=null){
            r.setClie_Id(Integer.parseInt(req.getParameter("Clie_Id"))); 
        }
        if(req.getParameter("Metod_Id")!=null){
            r.setMetod_Id(Integer.parseInt(req.getParameter("Metod_Id"))); 
        }
        if(req.getParameter("Prend_Id")!=null){
            r.setPrend_Id(Integer.parseInt(req.getParameter("Prend_Id"))); 
        }
        else{
            System.out.println("Error Al Registrar Datos");
        }
        try {
            rd.registrarVent(r);
            System.out.println("Registro insertado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("pages/CrudEmpleado/Ventas/ConsultarVentas.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    

        private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<VentaVo> venta = rd.listarVent();
        req.setAttribute("ventas", venta);
        req.getRequestDispatcher("pages/CrudEmpleado/Ventas/ConsultarVentas.jsp").forward(req, resp);

        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
    }

}
