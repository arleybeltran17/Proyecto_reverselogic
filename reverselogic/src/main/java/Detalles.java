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

import model.Empleado.EmpleadoDao;
import model.Empleado.EmpleadoVo;

public class Detalles extends HttpServlet{

    EmpleadoVo r=new EmpleadoVo(); 
    EmpleadoDao rd=new EmpleadoDao();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NOTA: Aqui debe llegar 
        
        System.out.println("Entró al DoGet");
        String enviar=req.getParameter("enviar");
        switch(enviar){
            case "detalle":{
            req.getRequestDispatcher("pages/Detalles/detalle.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Menu De Detalles");
            break;
            }
        }
    }
}
