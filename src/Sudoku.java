/*
 * TP 1 - IA Informatique : Sudoku
 * 
 * @author Tassadit BOUADI / Vincent DREVELLE
 */
import java.util.Stack;
import java.util.HashMap;
import java.util.Map.Entry;


public class Sudoku {
	public static final int TAILLE = 9;
	private static int[][] grille1 = {
			{0,8,0,4,0,2,0,6,0},
			{0,3,4,0,0,0,9,1,0},
			{9,6,0,0,0,0,0,8,4},
			{0,0,0,2,1,6,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,3,5,7,0,0,0},
			{8,4,0,0,0,0,0,7,5},
			{0,2,6,0,0,0,1,3,0},
			{0,9,0,7,0,1,0,4,0}
		};
	private static int[][] grilleHardest = {
			{1,0,0,0,0,7,0,9,0},
			{0,3,0,0,2,0,0,0,8},
			{0,0,9,6,0,0,5,0,0},
			{0,0,5,3,0,0,9,0,0},
			{0,1,0,0,8,0,0,0,2},
			{6,0,0,0,0,4,0,0,0},
			{3,0,0,0,0,0,0,1,0},
			{0,4,0,0,0,0,0,0,7},
			{0,0,7,0,0,0,3,0,0}
		};
	private static int[][] grilleNoSolution = {
			{0,8,0,4,0,2,0,6,0},
			{0,3,4,0,0,0,9,1,0},
			{9,6,0,0,0,0,0,8,4},
			{0,0,0,2,1,6,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,3,5,7,0,0,0},
			{8,4,0,0,0,0,0,7,5},
			{0,2,6,0,0,0,1,3,0},
			{0,9,0,7,0,1,0,4,9}
		};
	
	public static void main(String[] args) {
		System.out.println("Sudoku de bon matin...");

		// Table associative des grilles à résoudre, indexées par leur nom.
		HashMap<String, Grille> grilles = new HashMap<>();
		grilles.put("1", new Grille(grille1.length, grille1));
		grilles.put("difficile", new Grille(grilleHardest.length, grilleHardest));
		grilles.put("sans solution", new Grille(grilleNoSolution.length, grilleNoSolution));
		
		// Résolution des grilles
		for (Entry<String, Grille> entry : grilles.entrySet()) {
			System.out.println("\n========================================================================");
			System.out.println("Je vais essayer de résoudre la grille " + entry.getKey() + ".");
			
			Grille grille = entry.getValue();
			grille.afficheGrille();
		
			// On place la grille dans une pile pour la résoudre
			Stack<Grille> pile = new Stack<>();
			pile.push(grille);
			
			boolean hasSolution = resoudreSudoku(pile);
			
			if (hasSolution) {
				System.out.println("La grille a été résolue.");
				Grille grilleResul = pile.peek();
				grilleResul.afficheGrille();
			}
			else {
				System.out.println("Aucune solution n'a été trouvée.");
			}
		}
	}//main
	
	
	/*
	 * Fonction récursive qui recherche la solution, 
	 * en utilisant éventuellement des retours-arrière.
	 * 
	 * La grille iniitiale doit être placée dans pileGrilles.
	 * Retourne true si une solution a été trouvée, 
	 * la solution se trouve au sommet de pileGrilles.
	 */
	public static boolean resoudreSudoku(Stack<Grille> pileGrilles){
		// TODO
		return false;
	}//resoudreSudoku

}
