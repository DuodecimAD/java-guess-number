import java.util.Scanner;
/**
 * @author Antony
 *
 */
public class GuessNumber {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("devinette : guess the number i picked between 0 and 100 ! \n");
			System.out.println("Do you wanna play ? YES/NO :");
			do {
				Scanner scan = new Scanner(System.in);
				String input = scan.nextLine();
				if (input.isEmpty()) {
					System.out.println("You didn't write anything. Please write YES or NO :");
				}else {
					String upper = input.toUpperCase();
					char check = upper.charAt(0);
					int maxtries = 100;
					if(check == 'Y') {			
						do {
							System.out.println("Pick a number between 0 and 100 :");
							int tries = 0;	
							int winningnumber = (int)(Math.random() * 99 + 1);
							if (scan.hasNextInt()) {
								int yournumber = Integer.parseInt(scan.nextLine());
								if(yournumber > 0 && yournumber < 100) {							
									do {
										if (yournumber < winningnumber) {
											tries++;
											System.out.println("You picked the number : " + yournumber + ". It's LOWER than the number i picked ! try again :");
											yournumber = Integer.parseInt(scan.nextLine());
										}else if (yournumber > winningnumber) {
											tries++;
											System.out.println("You picked the number : " + yournumber + ". It's HIGHER than the number i picked ! try again :");
											yournumber = Integer.parseInt(scan.nextLine());
										}else {
											tries++;
											if (tries < maxtries) {
												maxtries = tries;
											}	
											System.out.println("You picked the number : " + yournumber + ". It's CORRECT, GOOD JOB. You found my number in " + tries + " tries ! And your max tries this session was : "+ maxtries +". Would you like to play again ? YES/NO : ");	
											do {		
												input = scan.nextLine();
												if (input.isEmpty()) {
													System.out.println("You didn't write anything. Please write YES or NO :");
												}else {
													upper = input.toUpperCase();
													check = upper.charAt(0);
													if (check == 'Y') {
														break;
													}else if(check == 'N') {
														System.out.println("Bye !");
														scan.close();
														System.exit(0);
													}else {
														System.out.println("You wrote something else. Please write YES or NO :");
													}	
												}
											} while (true);
											break;	
										}	
								} while (true);

								}else if (yournumber <= 0 || yournumber >= 100) {
									System.out.println("I said between 0 and 100, please reenter a number :");
									yournumber = Integer.parseInt(scan.nextLine());
								}else {
									System.out.println("It's not a number, please reenter a number between 0 and 100 :");
									yournumber = Integer.parseInt(scan.nextLine());
								}
							}else{
								System.out.println("It's not a number !");
								scan.nextLine();
							}
						} while (true);	
					}else if(check == 'N') {
						System.out.println("you said no, bye !");
						scan.close();
						System.exit(0);
					}else{
						System.out.println("You wrote something else. Please write YES or NO :");
					}
				}
			}while(true);
	}
}
