package fileGenerator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;

        import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
        import org.apache.poi.ss.usermodel.Cell;
        import org.apache.poi.ss.usermodel.CellStyle;
        import org.apache.poi.ss.usermodel.Font;
        import org.apache.poi.ss.usermodel.IndexedColors;
        import org.apache.poi.ss.usermodel.Row;
        import org.apache.poi.ss.usermodel.Sheet;
        import org.apache.poi.ss.usermodel.Workbook;
        import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelMachineUsage {

   String FileName ;
   String PolicyName;
   String Extension = ".csv";

   public ExelMachineUsage(String loadBalancingPolicy){
       this.PolicyName = loadBalancingPolicy;

   }


   public void fileMaker() throws FileNotFoundException
    {

          FileName = "C:\\Users\\danya\\Desktop\\CreatedNow.csv";
          FileOutputStream fos = new FileOutputStream(FileName,true);

    }


}
