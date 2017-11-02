package web.view.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class XLSWrite {
    private String path;
    private String fileName;

    public XLSWrite() {}
 
    public XLSWrite(String path) {
    	this.path = path;
	}
    
    public void writeXLS(List<String[]> data) {
		//init
		File file;
    	HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("mySheet");		//Sheet명 설정
		
		HSSFRow row;

		for (int i = 0; i < data.size(); i++) {
			//출력 row 생성
			row = sheet.createRow(i);
			
			for (int j = 0; j < data.get(i).length; j++) {
				//출력 cell 생성
				row.createCell(j).setCellValue(data.get(i)[j]);				
			}
		}
		
    	//이름 생성
		do {
			fileName = UUID.randomUUID().toString().replace("-", "")+".xls";
            file = new File(path + fileName);
            
		} while (file.exists());
		
		// 출력 파일 위치및 파일명 설정
		FileOutputStream outFile;
		try {
			outFile = new FileOutputStream(path + fileName);
			workbook.write(outFile);
			outFile.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
    
    
}