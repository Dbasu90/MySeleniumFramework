package com.deb.utils;

import com.deb.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelReaderUtil {

    private ExcelReaderUtil() {
    }

    public static List<Map<String, String>> getTestData(String sheetName) {
        List<Map<String, String>> result = new ArrayList<>();
        try (FileInputStream file = new FileInputStream(FrameworkConstants.getTestDataPath())) {
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int lastRow = sheet.getLastRowNum();
            int lastCol = sheet.getRow(0).getLastCellNum();

            Map<String, String> map;

            for (int i = 1; i <= lastRow; i++) {
                map = new HashMap<>();
                for (int j = 0; j < lastCol; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                result.add(map);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Excel File you trying to read is not found");
        } catch (IOException e) {
            throw new RuntimeException("Some I/O exception happened  while reading excel file");
        }

        return result;


    }


}
