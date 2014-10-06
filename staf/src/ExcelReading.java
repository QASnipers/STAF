import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.staf.pages.PG_01_SearchVehicle;
import com.staf.reader.ExcelReader;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



public class ExcelReading {

	public static void main(String[] args) throws Exception{
		
		List<String> dataList = new ArrayList<String>();
		dataList.add("pickUpLocation");
		dataList.add("pickUpMonth");
		dataList.add("pickUpDay");
		dataList.add("pickUpTime");
		dataList.add("dropOffMonth");
		dataList.add("dropOffDay");
		dataList.add("dropOffTime");
		

		//ExcelReader.readXLData(dataList);
		
		/*List<String> headers = new ArrayList<String>();
		headers.add("SearchByVehicle");
		
		Map<String,String[]> columnValues = new HashMap<String,String[]>();
		String[] rowValues = new String[10]; // TODO: row count
		rowValues[0] = "abc";
		columnValues.put(headers.get(0),rowValues );
		columnValues.put("pickUpLocation", new String[]{"80110","84730948","36538"});
		columnValues.put("pickUpMonth", new String[]{"spe","oct","nov"});
		
		// reading
		String firstloc =  columnValues.get("pickupLocation")[0];
		
		
		//if(headers.get(0).equalsIgnoreCase())
		
		
		
	      Workbook workbook = Workbook.getWorkbook(new File("src/TESTDATA.xls"));
	      Sheet sheet = workbook.getSheet(0);
	      Cell cell1 = sheet.getCell(0, 0);
	     
	      System.out.println(cell1.getContents());
	      Cell cell2 = sheet.getCell(1,0); // column/row
	      System.out.println(cell2.getContents());
	      workbook.close();*/
		
	}

}
