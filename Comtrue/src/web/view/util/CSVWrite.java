package web.view.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import au.com.bytecode.opencsv.CSVWriter;
 
public class CSVWrite {
	//출처: http://wildpup.cafe24.com/archives/82
 
    private String path;
    private String fileName;
 
    public CSVWrite() {}
 
    public CSVWrite(String path) {
    	this.path = path;
	}

	public void writeCsv(List<String[]> data) {
		//init
		File file;
		
        try {
        	//이름 생성
			do {
				fileName = UUID.randomUUID().toString().replace("-", "")+".csv";
	            file = new File(path + fileName);
	            
			} while (file.exists());
			
            CSVWriter cw = new CSVWriter(new OutputStreamWriter(new FileOutputStream(path + fileName), "EUC-KR"), ',', '"');
            Iterator<String[]> it = data.iterator();
            try {
                while (it.hasNext()) {
                    String[] s = (String[]) it.next();
                    cw.writeNext(s);
                }
            } finally {
                cw.close();
            }
        } catch (IOException e) {
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