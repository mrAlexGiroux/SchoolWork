/**
 * 
 */
package ca.csf.dfc.classes.main.console;

import java.util.ArrayList;

import java.util.Scanner;
import java.util.ArrayList;

import ca.csf.dfc.classes.TrainGrandeVitesse;
import ca.csf.dfc.classes.TrainMarchandises;
import ca.csf.dfc.classes.TrainVoyageurs;
import ca.csf.dfc.classes.VehiculeFerroviaire;

/**
 * @author girou
 *
 */
public class MainConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		ArrayList<VehiculeFerroviaire> gareDeTrain = new ArrayList<>();
		int choixUtilisateur = -1;


		for (int i = 0; i < 10; i++) {
			
			System.out.print("Choisissez la sorte du train no " + (i+1) + " (1.Voyageurs 2.TGV 3.Marchandises)\n");
			
			choixUtilisateur = scanner.nextInt();
			
			switch (choixUtilisateur) {
				case 1:
					{
						gareDeTrain.add(new TrainVoyageurs("modele" + i, "reference" + i));
						break;
					}
				case 2:
					{
						gareDeTrain.add(new TrainGrandeVitesse("modele" + i, "reference" + i));
						break;
					}

				case 3:
					{
						gareDeTrain.add(new TrainMarchandises("modele" + i, "reference" + i));
						break;
					}
				default:
					break;
			}
		}

		for (int i = 0; i < 10; i++) {
			System.out.print(gareDeTrain.get(i).toString() + "\n");
			int choixTrain = -1;
			if (gareDeTrain.get(i).getClassTrain() == "TrainVoyageurs") {
				System.out.print("1. Accelerer 2.Ralentir \n");
				scanner.nextInt();
				switch (choixTrain) {
					case 1:
						{
							// accelerer le train
						break;
						}
					case 2:
						{
							// ralentir le train
						break;
						}
					default:
						break;
				}
			}
			else if (gareDeTrain.get(i).getClassTrain() == "TrainGrandeVitesse") {
				System.out.print("1. Accelerer 2.Ralentir 3.ActiverWifi \n");
				scanner.nextInt();
				switch (choixTrain) {
					case 1:
						{
							// accelerer le train
						break;
						}
					case 2:
						{
							// ralentir le train
						break;
						}
						case 3:
						{
							// activer wifi si la vitesse du train est plus grande que 200km/h
						break;
						}
					default:
						break;
				}
				
			}
			else if (gareDeTrain.get(i).getClassTrain() == "TrainMarchandises") {
				System.out.print("1. Accelerer 2.Ralentir 3.Attacher Remorque 4. Detacher Remorque \n");
				scanner.nextInt();
				switch (choixTrain) {
					case 1:
						{
							// accelerer le train
						break;
						}
					case 2:
						{
							// ralentir le train
						break;
						}
					case 3:
					{
						// Attacher une remorque
						break;
					}
					case 4:
					{
						// Detacher une remorque s'il y en a
					}
					default:
						break;
				}
				
			}
			scanner.close();
		}
		

	}

}
