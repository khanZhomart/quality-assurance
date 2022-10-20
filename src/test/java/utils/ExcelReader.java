package utils;

import com.google.common.collect.Streams;
import constants.Constants;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ExcelReader {

    public static List<String> keywords(String testName) {
        Sheet sheet = Optional.ofNullable(read(testName)).orElseThrow(() -> new IllegalArgumentException("Unknown sheet"));
        return Streams.stream(sheet.rowIterator())
                .map(row -> row.getCell(4).getStringCellValue())
                .filter(keyword -> !keyword.equals("KEYWORD"))
                .collect(Collectors.toList());
    }

    private static Sheet read(String sheetName) {
        try {
            InputStream inputStream = new FileInputStream(Constants.EXCEL_PATH);
            Workbook workbook = new XSSFWorkbook(inputStream);
            return workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
