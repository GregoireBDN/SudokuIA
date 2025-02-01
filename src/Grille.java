/*
 * TP 1 - IA Informatique : Sudoku
 * 
 * @author Tassadit BOUADI / Vincent DREVELLE
 */

public class Grille {
	private Case[][] _cases;
	private int _taille;
	private int _nbCasesVides;
	private int _regionSize;

	public Grille(int n) {
		_taille = n;
		_nbCasesVides = n * n;
		_regionSize = (int) Math.sqrt(_taille);
		_cases = new Case[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				_cases[i][j] = new Case(i, j, n);
			}
		}
	}

	public Grille(int n, int[][] grille) {
		_taille = n;
		_nbCasesVides = n * n;
		_cases = new Case[n][n];
		_regionSize = (int) Math.sqrt(_taille);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				_cases[i][j] = new Case(i, j, grille[i][j], n);
				if (_cases[i][j].getVal() != 0) {
					_nbCasesVides--;
				}
			}
		}
	}

	public Grille(Grille grille) {
		_taille = grille._taille;
		_nbCasesVides = grille._nbCasesVides;
		_regionSize = grille._regionSize;
		_cases = new Case[_taille][_taille];
		for (int i = 0; i < _taille; i++) {
			for (int j = 0; j < _taille; j++) {
				_cases[i][j] = new Case(grille.getCase(i, j));
			}
		}
	}

	public Case getCase(int i, int j) {
		return _cases[i][j];
	}

	/*
	 * Nombre de cases vides dans la grille.
	 */
	public int getNbCasesVides() {
		return _nbCasesVides;
	}

	/*
	 * Fonction qui retourne une case vide de la grille, s'il en existe une.
	 */
	public Case getCasePossible() {
		for (Case[] colonne : _cases) {
			for (Case c : colonne) {
				if (verifCase(c)) {
					return c;
				}
			}
		}
		return null;
	}

	public Case getCasePossibleOptimized() {
		for (Case[] colonne : _cases) {
			for (Case c : colonne) {
				if (verifCase(c)) {
					return c;
				}
			}
		}
		return null;
	}

	/*
	 * Fonction qui donne la valeur v à la case de mêmes coordonnées que la case c.
	 */
	public void setCase(Case c, int v) {
		_cases[c.getI()][c.getJ()].setVal(v);
		_nbCasesVides--;
	}

	/*
	 * Fonction qui retourne vrai si la case c est vide.
	 */
	public boolean verifCase(Case c) {
		return c.getVal() == 0;
	}

	/*
	 * Fonction qui retourne vrai si la valeur v peut être donnée à la colonne
	 * colonne.
	 */
	public boolean verifColonne(int colonne, int valeur) {
		for (int i = 0; i < _taille; i++) {
			if (_cases[i][colonne].getVal() == valeur) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Fonction qui retourne vrai si la valeur v peut être donnée à la ligne ligne.
	 */
	public boolean verifLigne(int ligne, int valeur) {
		for (int j = 0; j < _taille; j++) {
			if (_cases[ligne][j].getVal() == valeur) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Fonction qui retourne vrai si la valeur v peut être donnée à la région
	 * region.
	 */
	public boolean verifRegion(Case c, int valeur) {
		int debutRegionI = c.getI() / _regionSize * _regionSize;
		int debutRegionJ = c.getJ() / _regionSize * _regionSize;
		for (int i = debutRegionI; i < debutRegionI + _regionSize; i++) {
			for (int j = debutRegionJ; j < debutRegionJ + _regionSize; j++) {
				if (_cases[i][j].getVal() == valeur) {
					return false;
				}
			}
		}
		return true;
	}

	/*
	 * Fonction qui retourne vrai si la valeur v peut être donnée à la case c
	 * c'est-à-dire si la grille respecte toujours les contraintes du Sudoku.
	 */
	public boolean casePossible(Case c, int v) {
		Case caseGrille = getCase(c.getI(), c.getJ());
		// Vérifie si la case est déjà remplie
		if (!verifCase(caseGrille)) {
			return false;
		}

		// Vérification de la ligne
		if (!verifLigne(caseGrille.getI(), v)) {
			return false;
		}

		// Vérification de la colonne
		if (!verifColonne(caseGrille.getJ(), v)) {
			return false;
		}

		// Vérification de la région
		if (!verifRegion(caseGrille, v)) {
			return false;
		}

		return true;
	}

	/*
	 * Affichage.
	 */
	public void afficheGrille() {
		int v;
		int dim = (int) Math.sqrt(_taille);
		for (int i = 0; i < _taille; i++) {
			if (i % dim == 0) {
				System.out.print(" ");
				for (int k = 0; k <= _taille; k++)
					System.out.print("--");
				System.out.println();
			}
			for (int j = 0; j < _taille; j++) {
				if (j % dim == 0) {
					System.out.print("|");
				}
				v = _cases[i][j].getVal();
				if (v == 0) {
					System.out.print("  ");
				} else {
					System.out.print(v + " ");
				}
			}
			System.out.println("|");
		}
		System.out.print(" ");
		for (int k = 0; k <= _taille; k++)
			System.out.print("--");
		System.out.println();
	}
}
