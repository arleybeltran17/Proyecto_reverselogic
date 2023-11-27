import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;

import com.lowagie.text.pdf.PdfWriter;
import java.util.ArrayList;
import java.util.List;
import model.Venta.VentaVo;
import model.Venta.VentaDao;

public class Reportes extends HttpServlet {
    // Configura la respuesta HTTP para PDF
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        System.out.println("Entró al DoGet");
        String enviar=req.getParameter("enviar");


        switch(enviar){
            case "reporteVenta":{
    try{
    resp.setContentType("application/pdf");
    resp.setHeader("Content-Disposition", "inline; filename=informe.pdf");

    // Crea un nuevo documento PDF
    Document document = new Document();
    PdfWriter.getInstance(document, resp.getOutputStream());

    document.open();
    document.add(new Paragraph("Infome detalles de venta."));
    document.add(new Paragraph(" "));
    document.add(new Paragraph("En este reporte mostraremos la cantidad de ventas, si han aumentado o disminuido las ventas, tambien mostraremos una tabla con las ventas generadas."));
    document.add(new Paragraph(" "));       
   

    List<VentaVo> ventas = null;
        try {
            ventas = new VentaDao().listarVent();
        } catch (Exception e) {
        e.printStackTrace();
        }
    
    if (ventas != null && !ventas.isEmpty()) {
        PdfPTable table = new PdfPTable(7);
        table.getDefaultCell().setPadding(8);
        
        table.addCell(new Phrase("Cantidad De La Venta"));
        table.addCell(new Phrase("Fecha De La Venta"));
        table.addCell(new Phrase("Usuario ID"));
        table.addCell(new Phrase("Cliente ID"));
        table.addCell(new Phrase("Metodo De Pago ID"));
        table.addCell(new Phrase("Prenda ID"));
    

        for(VentaVo venta: ventas){
            String CantidadVentaSTR= String.valueOf(venta.getVent_Cantidad());
            String FechaVentaSTR= String.valueOf(venta.getVent_Fecha());
            String UsuarioIdSTR= String.valueOf(venta.getUsu_Id());
            String ClienteIdSTR = String.valueOf(venta.getClie_Id());
            String MetodoIdSTR = String.valueOf(venta.getMetod_Id());
            String PrendaIdSTR = String.valueOf(venta.getPrend_Id());

            table.addCell(CantidadVentaSTR);
            table.addCell(FechaVentaSTR);
            table.addCell(UsuarioIdSTR);
            table.addCell(ClienteIdSTR);
            table.addCell(MetodoIdSTR); 
            table.addCell(PrendaIdSTR);   
        }

    document.add(table);
    }else{
        PdfPTable tableError = new PdfPTable(1);
        tableError.addCell(new Phrase("No Se Encontraron Detalles De Una Venta"));
        document.add(tableError);
    }
    document.close();
} catch (DocumentException e) {
    e.printStackTrace();
}
}
    break;
        }
    }
}


