import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class GetData {

    static FileInputStream fis;
    static XSSFWorkbook workbook;
    static DataFormatter formatter;

    public static void main (String[] str) {

        readData();
    }

    public static void readData () {

        try {

            fis = new FileInputStream("src//main//resources//excelSheets//differentTypesOfData.xlsx");
            workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("data");

            int rowCount = sheet.getPhysicalNumberOfRows();

            for (int i=0;i<rowCount;i++) {

                XSSFRow row = sheet.getRow(i);
                for (int j=0;j<row.getLastCellNum();j++) {

                    formatter = new DataFormatter();
                    Object value = formatter.formatCellValue(row.getCell(j));
                    System.out.print(value + " || ");
                }

                System.out.println();
                fis.close();
            }
        } catch (IOException exp) {

            System.out.println(exp.getMessage());
        }
    }
}
