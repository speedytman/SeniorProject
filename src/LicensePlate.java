import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class LicensePlate {
	private String approvedPlate = null;
	private File approvedPlatesFile = new File("C:\\Users\\treyc\\git\\SeniorProject1\\src\\ApprovedLicensePlates.txt");
	private File tempFile = new File("C:\\Users\\treyc\\git\\SeniorProject1\\src\\tempFile.txt");
	
	public LicensePlate() {
		
	}
	
	//public LicensePlate(String approvedPlate) {
	//	this.approvedPlate = approvedPlate;
	//}
	
	public String getAllApprovedPlate() {
		try  
		{    
			BufferedReader br = new BufferedReader(new FileReader(approvedPlatesFile));
			StringBuffer sb = new StringBuffer();
			String line;  
			while((line=br.readLine())!=null)  
			{  
				sb.append(line);//appends line to string buffer  
				sb.append("\n");
			}  
			br.close();    //closes the stream and release the resources   
			return sb.toString();   //returns a string that textually represents the object  
		}  
		catch(IOException e)  
		{  
			e.printStackTrace();  
		}
		return approvedPlate;
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
				if(trimmedLine.equals(plateText)) continue;
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
