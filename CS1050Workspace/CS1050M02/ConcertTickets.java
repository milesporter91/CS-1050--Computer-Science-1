import java.util.Scanner;

public class ConcertTickets {

	public static void main(String[] args) {
		char ticketSection;
		int rowNumber;
		String section = "";
		System.out.println("Please choose a section: ");
		System.out.println("F: Front Section");
		System.out.println("C: Center Section");
		System.out.println("S: Side Section");
		System.out.println("U: Upper Section");
		Scanner kb = new Scanner(System.in);
		ticketSection = kb.next().toUpperCase().charAt(0);
		if (ticketSection == 'F') {
			section = "Section F";
		} else if (ticketSection == 'C') {
			section = "Section C";
		} else if (ticketSection == 'S') {
			section = "Section S";
		} else if (ticketSection == 'U') {
			section = "Section U";
		} else {
			System.out.println("Invalid Section. Program terminating.");
		}
		if (section != "") {
			System.out.println("Please choose a row between 1-60.");
			rowNumber = kb.nextInt();
			if (rowNumber > 1 && rowNumber <= 15) {
				System.out.println(section + " Row " + rowNumber + " price: $450");
			} else if (rowNumber > 15 && rowNumber <= 30) {
				System.out.println(section + " Row " + rowNumber + " price: $300");
			} else if (rowNumber > 30 && rowNumber <= 60) {
				System.out.println(section + " Row " + rowNumber + " price: $200");
			} else {
				System.out.println("Invalid row choice. Program terminating.");
			}
		}
	
	
	kb.close();
	}

}
