package com.example.projects.export;

import com.example.projects.domain.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Product> products;

    private void writeHeaderRow(){
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        Cell cell = row.createCell(0);
        cell.setCellValue("ID");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("Category ID");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("Name");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("Price");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("Color");
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue("Quantity");
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue("Created Date");
        cell.setCellStyle(style);

        cell = row.createCell(7);
        cell.setCellValue("Buy By");
        cell.setCellStyle(style);
    }

    private void writeDataRow(){
        int rowCount = 1;
        for (Product product : products){
            Row row = sheet.createRow(rowCount++);

            Cell cell = row.createCell(0);
            cell.setCellValue(product.getId());
            sheet.autoSizeColumn(0);

            cell = row.createCell(1);
            cell.setCellValue(product.getCategoryId());
            sheet.autoSizeColumn(1);

            cell = row.createCell(2);
            cell.setCellValue(product.getName());
            sheet.autoSizeColumn(2);

            cell = row.createCell(3);
            cell.setCellValue(product.getPrice());
            sheet.autoSizeColumn(3);

            cell = row.createCell(4);
            cell.setCellValue(product.getColor());
            sheet.autoSizeColumn(4);

            cell = row.createCell(5);
            cell.setCellValue(product.getQuantity());
            sheet.autoSizeColumn(5);

            cell = row.createCell(6);
            cell.setCellValue(String.valueOf(product.getCreated_date()));
            sheet.autoSizeColumn(6);

            cell = row.createCell(7);
            cell.setCellValue(product.getBuy_by());
            sheet.autoSizeColumn(7);
        }
    }

    public void Export(HttpServletResponse response) throws IOException {
        writeDataRow();
        writeHeaderRow();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    public ProductExcelExporter(List<Product> products){
        this.products = products;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Products");
    }
}
