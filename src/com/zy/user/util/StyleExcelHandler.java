package com.zy.user.util;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;

import com.alibaba.excel.event.WriteHandler;


public class StyleExcelHandler implements WriteHandler {

    @Override
    public void sheet(int i, Sheet sheet) {
        sheet.setColumnWidth(0, 50 * 50);
        sheet.setColumnWidth(1, 50 * 50);
        sheet.setColumnWidth(2, 50 * 50);
        sheet.setColumnWidth(3, 50 * 50);
        sheet.setColumnWidth(4, 50 * 50);
        sheet.setColumnWidth(5, 50 * 50);
        sheet.setColumnWidth(6, 50 * 50);
        sheet.setColumnWidth(7, 50 * 50);
        sheet.setColumnWidth(8, 50 * 50);
        sheet.setColumnWidth(9, 50 * 50);
        sheet.setColumnWidth(10, 50 * 50);
        sheet.setColumnWidth(11, 50 * 50);
        sheet.setColumnWidth(12, 50 * 50);
        sheet.setColumnWidth(13, 50 * 50);
        sheet.setColumnWidth(14, 50 * 50);

    }

    @Override
    public void row(int i, Row row) {
    }

    @Override
    public void cell(int i, Cell cell) {
        // 从第二行开始设置格式，第一行是表头
        Workbook workbook = cell.getSheet().getWorkbook();
        CellStyle cellStyle = createStyle(workbook);
        cell.getRow().getCell(i).setCellStyle(cellStyle);
    }


    private CellStyle createStyle(Workbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        // 下边框
        cellStyle.setBorderBottom(BorderStyle.THIN);
        // 左边框
        cellStyle.setBorderLeft(BorderStyle.THIN);
        // 上边框
        cellStyle.setBorderTop(BorderStyle.THIN);
        // 右边框
        cellStyle.setBorderRight(BorderStyle.THIN);
        // 水平对齐方式
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        // 垂直对齐方式
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return cellStyle;
    }
}