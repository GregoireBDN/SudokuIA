/*
 * TP 1 - IA Informatique : Sudoku
 * 
 * @author Tassadit BOUADI / Vincent DREVELLE
 */

public class Grille {
	private Case[][] _cases;
	private int _taille;
	private int _nbCasesVides;
	
	
	public Grille(int n){
		_taille = n;
		_nbCasesVides = n*n;
		_cases = new Case[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				_cases[i][j] = new Case(i, j, n);
			}
		}
	}
	
	public Grille(int n, int[][] grille){
		_taille = n;
		_nbCasesVides = n*n;
		_cases = new Case[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				_cases[i][j] = new Case(i, j, grille[i][j], n);
				if(_cases[i][j].getVal() != 0){
					_nbCasesVides --;
				}
			}
		}
	}
	
	public Grille(Grille grille){
		_taille = grille._taille;
		_nbCasesVides = grille._nbCasesVides;
		_cases = new Case[_taille][_taille];
		for(int i=0; i<_taille; i++){
			for(int j=0; j<_taille; j++){
				_cases[i][j] = new Case(grille.getCase(i, j));
			}
		}
	}
	
	
	public Case getCase(int i, int j){
		return _cases[i][j];
	}
	
	/*
	 * Nombre de cases vides dans la grille.
	 */
	public int getNbCasesVides(){
		return _nbCasesVides;
	}
	
	
	/*
	 * Fonction qui retourne une case vide de la grille, s'il en existe une.
	 */
	public Case getCasePossible(){
		// TODO
		Case casePoss = _cases[0][0];
		return casePoss;
	}
	
	
	/*
	 * Fonction qui donne la valeur v à la case de mêmes coordonnées que la case c.
	 */
	public void setCase(Case c, int v){
		// TODO
	}
	
	
	/*
	 * Fonction qui retourne vrai si la valeur v peut être donnée à la case c
	 * c'est-à-dire si la grille respecte toujours les contraintes du Sudoku.
	 */
	public boolean casePossible(Case c, int v){
		// TODO
		return true;
	}
	
	/*
	 * Affichage.
	 */
	public void afficheGrille(){
		int v;
		int dim = (int)Math.sqrt(_taille);
		for(int i=0; i<_taille; i++){
			if(i%dim == 0){
				System.out.print(" ");
				for(int k=0; k<=_taille; k++)
					System.out.print("--");
				System.out.println();
			}
			for(int j=0; j<_taille; j++){
				if(j%dim == 0){
					System.out.print("|");
				}
				v = _cases[i][j].getVal();
				if(v == 0){
					System.out.print("  ");					
				}
				else{
					System.out.print(v + " ");
				}
			}
			System.out.println("|");
		}
		System.out.print(" ");
		for(int k=0; k<=_taille; k++)
			System.out.print("--");
		System.out.println();		
	}
}
