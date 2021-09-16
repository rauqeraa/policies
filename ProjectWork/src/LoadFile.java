import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
public class LoadFile {
	HashMap<String, CustomerDetails> Complaints= new HashMap<String,CustomerDetails>();
	public void loadComplaints(){
		String filePath="C:\\Users\\ELCOT\\Videos\\complaints";
		String str="";
		 try {
			BufferedReader br=new BufferedReader(new FileReader(filePath));
			while ((str=br.readLine())!=null)
			{
				String[] entities=str.split(",");
				CustomerDetails customer=new CustomerDetails();
				customer.DateReceived=entities[0];
				customer.Product=entities[1];
				customer.SubProduct=entities[2];
				customer.Issue=entities[3];
				customer.SubIssue=entities[4];
				customer.Company=entities[5];
				customer.State=entities[6];
				customer.ZIPcode=entities[7];
				customer.Submittedvia=entities[8];
				customer.DateSentToCompany=entities[9];
				customer.CompanyResponseToConsumer=entities[10];
				customer.TimelyResponse=entities[11];
				customer.ConsumerDisputed=entities[12];
				Complaints.put(entities[13],customer); 
			}
			br.close();
		}catch(FileNotFoundException e) {
			System.out.println("File Not Found"+e.getStackTrace());
		}catch(IOException ex){
			System.out.println(ex.getStackTrace());
		}
	}
	HashMap<String,CustomerDetails> GetComplaints(){
		return Complaints;
	}
	
}


