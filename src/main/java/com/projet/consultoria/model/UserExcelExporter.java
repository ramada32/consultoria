package com.projet.consultoria.model;

//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFFont;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserExcelExporter {
//    private XSSFWorkbook workbook;
//    private XSSFSheet sheet;
//    private List<Clientes> listUsers;
//
//    public UserExcelExporter(List<Clientes> listUsers) {
//        this.listUsers = listUsers;
//        workbook = new XSSFWorkbook();
//    }
//
//
//    private void writeHeaderLine() {
//        sheet = workbook.createSheet("Clientes");
//
//        Row row = sheet.createRow(0);
//
//        CellStyle style = workbook.createCellStyle();
//        XSSFFont font = workbook.createFont();
//        font.setBold(true);
//        font.setFontHeight(16);
//        style.setFont(font);
//
//        createCell(row, 0, "User ID", style);
//        createCell(row, 1, "Name", style);
//        createCell(row, 2, "Peso", style);
//        createCell(row, 3, "Product", style);
//        createCell(row, 4, "Value_Product", style);
//
//    }
//
//    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
//        sheet.autoSizeColumn(columnCount);
//        Cell cell = row.createCell(columnCount);
//        if (value instanceof Integer) {
//            cell.setCellValue((Integer) value);
//        } else if (value instanceof Boolean) {
//            cell.setCellValue((Boolean) value);
//        }else {
//            cell.setCellValue((String) value);
//        }
//        cell.setCellStyle(style);
//    }
//
//    private void writeDataLines() {
//        int rowCount = 1;
//
//        CellStyle style = workbook.createCellStyle();
//        XSSFFont font = workbook.createFont();
//        font.setFontHeight(14);
//        style.setFont(font);
//
//        for (Clientes user : listUsers) {
//            Row row = sheet.createRow(rowCount++);
//            int columnCount = 0;
//
//            createCell(row, columnCount++, user.getId(), style);
//            createCell(row, columnCount++, user.getName(), style);
//            createCell(row, columnCount++, user.getPeso(), style);
//            createCell(row, columnCount++, user.getProduct(), style);
//            createCell(row, columnCount++, user.getValProd(), style);
//
//        }
//    }
//
//    public void export(HttpServletResponse response) throws IOException {
//        writeHeaderLine();
//        writeDataLines();
//
//        ServletOutputStream outputStream = response.getOutputStream();
//        workbook.write(outputStream);
//        workbook.close();
//
//        outputStream.close();
//
//    }
}
