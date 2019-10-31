package cs.csf.dfc.main.console;
import java.util.*;

public class MainConsole {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int userChoice = 0;
		System.out.print("Choisissez");
		userChoice = scanner.nextInt();

		switch(userChoice) {
			case 1:
			{
				double moyenne = 0;
				for (int i = 0; i < 10; i++) {
					moyenne = scanner.nextDouble();
				}
				System.out.print(moyenne / 10);
				
				break;
			}
			case 2:
			{
				String chaineUn = scanner.nextLine();
				String chaineDeux = scanner.nextLine();

				if (chaineUn.compareTo(chaineDeux) > 0) {
					System.out.println("La premiere est plus petite que la seconde");
				}
				else if (chaineUn.compareTo(chaineDeux) < 0) {
					System.out.println("La premiere est plus grande que la seconde");
				}
				else {
					System.out.println("Chaines egales");
				}

				scanner.close();	
				break;
			}
			case 3:
			{
				SentenceGenerator sentenceGenerator = new SentenceGenerator();
				System.out.println(sentenceGenerator.GenerateSentence());
				break;
			}
			case 4:
			{
				break;
			}
			case 5:
			{
				break;
			}
			case 6:
			{
				break;
			}
		}

	}

}
