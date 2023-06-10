package hust.soict.globalict.lab01;
import java.util.Scanner;

public class NumberOfDay {
	public static int checkMonth(String strMonth) {
		switch (strMonth) {
		case "January":
		case "Jan.":
		case "Jan":
		case "1":
		case "March":
		case "Mar.":
		case "Mar":
		case "3":
		case "May":
		case "5":
		case "July":
		case "Jul":
		case "7":
		case "August":
		case "Aug.":
		case "Aug":
		case "8":
		case "October":
		case "Oct.":
		case "Oct":
		case "10":
		case "December":
		case "Dec.":
		case "Dec":
		case "12":
			return 31;
		case "April":
		case "Apr.":
		case "Apr":
		case "4":
		case "June":
		case "Jun":
		case "6":
		case "September":
		case "Sept.":
		case "Sep":
		case "9":
		case "November":
		case "Nov.":
		case "Nov":
		case "11":
			return 30;
		case "February":
		case "Feb.":
		case "Feb":
		case "2":
			return 28;
		default:
			System.out.println("Invalid month, enter again !");
			return -1;
		}
	}

	public static int checkYear(String strYear) {
		try {
			int year = Integer.parseInt(strYear);
			if (year >= 0) {
				return year;
			}
		} catch (NumberFormatException e) {

		}
		System.out.println("Invalid year, enter again !");
		return -1;
	}

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);		
		String input;
		String[] str;
		int year, numberOfDay;
		System.out.println("Enter the month, then the year, separated by a space : ");
		
		while (true) {
			input = inp.nextLine();
			str = input.split(" ");
			if (str.length != 2) {
				System.out.println("Invalid input, enter again !");
				continue;
			}
			numberOfDay = checkMonth(str[0]);
			year = checkYear(str[1]);
			if (numberOfDay !=-1 && year !=-1) break;
		}

		boolean isNhuan = true;
		if (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)) {
			isNhuan = false;
		}
		if (isNhuan && numberOfDay == 28)
			numberOfDay = 29;
		System.out.println("Number of days : " + numberOfDay);

		inp.close();
	}
}