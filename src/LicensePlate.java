import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class LicensePlate {
	private String approvedPlate = null;
	private File approvedPlatesFile = new File("src\\ApprovedLicensePlates.txt");
	private File tempFile = new File("src\\tempFile.txt");
	
	public LicensePlate() {
		
	}
	
	//public LicensePlate(String approvedPlate) {
	//	this.approvedPlate = approvedPlate;
	//}
	
	public String getApprovedPlate(int lineNumber) {
		try  
		{    
			BufferedReader br = new BufferedReader(new FileReader(approvedPlatesFile));
			String line;
			for(int i = 0; i < lineNumber; i++) {
				br.readLine();
			}
			line = br.readLine() + "\n";
			br.close();
			return line;  
		}
		catch(IOException e)  
		{  
			e.printStackTrace();  
		}
		return approvedPlate;
	}
	
	public int getNumberOfLicensePlates() {
		BufferedReader br;
		int lineNumber = 0;
		String currentLine;
		try {
			br = new BufferedReader(new FileReader(approvedPlatesFile));
			while((currentLine = br.readLine()) != null) {
				lineNumber++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lineNumber;
	}
	
	public void addApprovedPlate(String plateText) {
		try  
		{  
		Writer bw = new BufferedWriter(new FileWriter(approvedPlatesFile, true));  //creates a buffering character input stream   
		bw.append(plateText + "\n");
		bw.close();
		}  
		catch(IOException e)  
		{  
		e.printStackTrace();  
		}
	}
	
	public void setApprovedPlateFileLocation(String fileLocation) {
		this.approvedPlatesFile = new File(fileLocation);
	}
	
	public void removeApprovedPlate(String plateText) {
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(approvedPlatesFile));
			Writer bw = new BufferedWriter(new FileWriter(tempFile));
			
			String currentLine;
			
			while((currentLine = br.readLine()) != null) 
			{
				String trimmedLine = currentLine.trim();
				if(trimmedLine.equals(plateText.toUpperCase())) continue;
				bw.write(currentLine + System.getProperty("line.separator"));
			}
			bw.close();
			br.close();
			approvedPlatesFile.delete();
			tempFile.renameTo(approvedPlatesFile);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
