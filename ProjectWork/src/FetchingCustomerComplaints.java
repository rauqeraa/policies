import java.util.*;
import java.time.*;

public class FetchingCustomerComplaints{ 

	LoadFile file = new LoadFile();
	Set<String> set = null;

	void loadFileData() {
		file.loadComplaints();
		set = file.GetComplaints().keySet();
	}
	void daysToCloseComplaints(String k) {
		set = file.GetComplaints().keySet();
		for (String  value: set) {
			if (value.equals(k)) {
				int a = 0, b = 0, c = 0;
				int x = 0, y= 0, z = 0;
				if (file.GetComplaints().get(value).DateReceived.length() == 10) {
					a = Integer.parseInt(file.GetComplaints().get(value).DateReceived.substring(0, 2));
					b = Integer.parseInt(file.GetComplaints().get(value).DateReceived.substring(3, 5));
					c = Integer.parseInt(file.GetComplaints().get(value).DateReceived.substring(6, 10));
				}else{
					continue;
				}
				if(file.GetComplaints().get(value).DateSentToCompany.length() == 10) {
					x=Integer.parseInt(file.GetComplaints().get(value).DateSentToCompany.substring(0, 2));
					y=Integer.parseInt(file.GetComplaints().get(value).DateSentToCompany.substring(3, 5));
					z=Integer.parseInt(file.GetComplaints().get(value).DateSentToCompany.substring(6, 10));
				}else{
					continue;
				}
				if (b > 0 && b<= 31 && y> 0 && y <= 31 && a > 0 && a <= 12 && x > 0 && x <= 12) {
					LocalDate date1 = LocalDate.of(z,x,y);
					LocalDate date2 = LocalDate.of(c,a,b);
					System.out.println("Complaint ID : " +value+" days " + date1.compareTo(date2));
				}
			}

		}
	}

	public void complaintsBasedOnYear(String year) {
		set = file.GetComplaints().keySet();
		for (String value : set) {
			if (file.GetComplaints().get(value).DateReceived.contains(year)) {
				PrintComplaintDetails.print(file.GetComplaints().get(value));
			}
		}

	}

	void complaintsBasedOnCompany(String companyName) {
		for (String value : set) {
			if (file.GetComplaints().get(value).Company.equalsIgnoreCase(companyName)) {
				PrintComplaintDetails.print(file.GetComplaints().get(value));
			}
		}
	}

	void complaintsBasedOnComplaintID(String id) {
		for (String value : set) {
			if (value.equals(id)) {
				PrintComplaintDetails.print(file.GetComplaints().get(value));
			}
		}
	}

	void closedComplaints() {
		for (String value : set) {
			String CompanyResponse= file.GetComplaints().get(value).CompanyResponseToConsumer;

			if (CompanyResponse.equalsIgnoreCase("Closed") || CompanyResponse.equalsIgnoreCase("Closed with explanation")) {
				PrintComplaintDetails.print(file.GetComplaints().get(value));
			}
		}

	}

	void complaintsReceivingTimelyResponse() {
		for (String value : set) {
			if (file.GetComplaints().get(value).TimelyResponse.equals("Yes")) {
				PrintComplaintDetails.print(file.GetComplaints().get(value));
			}
		}
	}

}