import java.util.*;

public class ComplaintsFetchingFromUser{
	public static void main(String[] args) {
		FetchingCustomerComplaints  complaintFetch= new FetchingCustomerComplaints();
		complaintFetch.loadFileData();
		boolean bool=true;
		while(bool){
			Scanner rj= new Scanner(System.in);
			Scanner pal= new Scanner(System.in);
			Scanner kal= new Scanner(System.in);
			Scanner sal= new Scanner(System.in);
			Scanner zal = new Scanner(System.in);
			System.out.println("Enter a Number between 1 to 7 : ");
			System.out.println("1 --> To Display all the complaints based on the year provided by the user ! ");
			System.out.println("2 --> To Display all the complaints based on the name of the bank provided by the user ! ");
			System.out.println("3 --> To Display complaints based on the complaint id provided by the user ! ");
			System.out.println("4 --> To Display number of days took by the Bank to close the complaint ! ");
			System.out.println("5 --> To Display all the complaints closed/closed with explanation ! ");
			System.out.println("6 --> To Display all the complaints which received a timely response ! ");
			int entry= rj.nextInt();
			switch (entry) {
			case 1:
				System.out.println("Enter the year to fetch data : ");
				String year =pal.nextLine();
				complaintFetch.complaintsBasedOnYear(year);
				break;
			case 2:
				System.out.println("Enter Company Name to fetch data : ");
				String companyName = kal.nextLine();
				complaintFetch.complaintsBasedOnCompany(companyName);
				break;
			case 3:
				System.out.println("Enter complaint ID to fetch data : ");
				String complaintID = sal.nextLine();
				complaintFetch.complaintsBasedOnComplaintID(complaintID);
				break;
			case 4:
				System.out.println("Enter complaint ID to fetch no of days : ");
				String complaintsID= zal.nextLine();
				complaintFetch.daysToCloseComplaints(complaintsID);
				break;
			case 5:
				complaintFetch.closedComplaints();
				break;
			case 6:
				complaintFetch.complaintsReceivingTimelyResponse();
				break;
			}
		}
	}

}
