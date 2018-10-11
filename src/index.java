import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class index {

	public static void main(String[] args) {
		
		//Creating the LinkedList Data structure to save the Subject and timetable
		LinkedList<Object> ExamTT = new LinkedList<Object>();
		
		//Creating Scanner instance for Keyboard inputs
		Scanner scanner = new Scanner(System.in);
		
		//Subject left to ask status boolean
		boolean anyMore = false;
		
		do {
			//Get the subject input
			System.out.println("Enter your Subject");
			String subjectInput = scanner.nextLine();
			
			//User notice message
			System.out.println("Please enter a date in the Exam date in the following format (MM-DD)");
			
			//Variable to store the user input without the year part
			String dateInput = scanner.nextLine();
			
			//ToDo check exception for date entries and format
			
			//Add to Timetable
			String[][] data = new String[1][];
			
			//Store subject
			data[0][0] = subjectInput;
			//Store date
			data[0][1] = dateInput;
			
			//Add to Timetable LinkedList
			ExamTT.add(data);
			
			try {
				//Converting the user input
				Date dateConverted = new SimpleDateFormat("yyyy-mm-dd").parse("2018-"+dateInput);
				/*System.out.println("Converted Date "+ dateConverted.toString());*/
				
				
				
				//Date comparison relative to today and printing outputs
				int today = dateConverted.compareTo(new Date());
				
				if(today == 0) {
					
					System.out.println("Date entered is Today.");
				}
				else if (today < 0) {
					System.out.println("Date entered is a Past Date.");
				}
				else if (today > 0) {
					System.out.println("Date entered is a Future Date.");
				}
				else {
					System.out.println("Error occured");
				}
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			//Ask whether there are any more subjects
			System.out.println("Do you have any more subjects to add, type Y for (Yes) or N for (No)");
			String status = scanner.nextLine();
				
			//ToDo fix the exception situation		
			
			//Compare input and loop the subject collection
			anyMore = status.equalsIgnoreCase("Y");

			
		}while(anyMore);
		


		
	}

}
