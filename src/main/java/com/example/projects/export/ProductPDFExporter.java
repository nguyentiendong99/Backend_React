package com.example.projects.export;

import com.example.projects.domain.Product;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.security.core.parameters.P;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ProductPDFExporter {
    private List<Product> list;

    public ProductPDFExporter(List<Product> list) {
        this.list = list;
    }
    private void writeTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.ORANGE);
        cell.setPadding(5);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.white);

        cell.setPhrase(new Phrase("ID" , font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Category ID" , font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Name" , font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Price" , font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Color" , font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Quantity" , font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Created Date" , font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Buy By" , font));
        table.addCell(cell);

    }

    private void writeTableData(PdfPTable table){
        for (Product product : list){
            table.addCell(String.valueOf(product.getId()));
            table.addCell(String.valueOf(product.getCategoryId()));
            table.addCell(product.getName());
            table.addCell(String.valueOf(product.getPrice()));
            table.addCell(product.getColor());
            table.addCell(String.valueOf(product.getQuantity()));
            table.addCell(String.valueOf(product.getCreated_date()));
            table.addCell(product.getBuy_by());
        }
    }

    public void Export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document , response.getOutputStream());
        document.open();
        document.add(new Paragraph("List All Products"));
        //TODO : xet so cot ma muon xuat
        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);
        writeTableHeader(table);
        writeTableData(table);
        document.add(table);
        document.close();
    }
}
