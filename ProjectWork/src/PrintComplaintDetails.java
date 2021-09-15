public class PrintComplaintDetails{
	static void print(CustomerDetails details){
		System.out.println(details.DateReceived + " "+ details.Product+" "+details.SubProduct+" "+details.Issue+" "+details.SubIssue+" "+details.Company+" "+details.ZIPcode+" "+details.State+" "+details.Submittedvia+" "+details.DateSentToCompany+" "+details.CompanyResponseToConsumer+" "+details.TimelyResponse+" "+details.ConsumerDisputed);
	}
}
