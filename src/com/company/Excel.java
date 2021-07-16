package com.company;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class Excel {
    private Workbook book;
    private Sheet sheet;

    public Excel() {
        book = new HSSFWorkbook();
        sheet = book.createSheet("Test");
    }

    public void setData(int row, int column, String data) {
        Row excelRow = sheet.getRow(row);
        if (excelRow == null) {
            excelRow = sheet.createRow(row);
        }
        excelRow.createCell(column).setCellValue(data);
    }

    public void save(String path) {
        //CellStyle cellStyle = book.createCellStyle();
        //Font font = book.createFont();
        //font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        //cellStyle.setFont(font);

        for (int i = 0; i <= 50; i++) {
            //sheet.createRow(0).createCell(i).setCellStyle(cellStyle);
            sheet.autoSizeColumn(i);
        }

        //trans - mm
        //holedoh - mm
        //vorotnaya - mm, speed - sm/s
        //sobst art - sm/s (1, 2)
        //pechenochnye - sm/s
        //selez - mm, sm^2, mm, sm/s
        //
        try {
            book.write(new FileOutputStream(path));
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
