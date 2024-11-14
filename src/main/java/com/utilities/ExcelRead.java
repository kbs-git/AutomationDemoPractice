package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelRead {

    public static XSSFSheet readExcel(String filePath) throws IOException {
        FileInputStream fs=new FileInputStream(new File(filePath));
        XSSFWorkbook workbook=new XSSFWorkbook(fs);
        XSSFSheet sh =workbook.getSheetAt(0);
        return sh;
    }
}
