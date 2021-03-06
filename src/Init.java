import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdDraw;

public class Init {
	
	//static int w = 0;
	
	static int capmax;
	
	static char[][] plateau;
	
	static int[][] plateaucap;
	
	static char[][] plateaumaj;
	
	static int size = 13;
	
	static int TXT_BAN = 202;
	
	static int CELL_WIDTH = 102;
	
	static int WINDOW_WIDTH = Init.size*CELL_WIDTH;
	
	static int WINDOW_HEIGHT = WINDOW_WIDTH + TXT_BAN;
	
	static int WINDOW_HEIGHT_REF = 13 * CELL_WIDTH + TXT_BAN;
	
	static char couleur[] = {'r','o','j','v','b','i'};
	
	static int[] reverseX;
	
	static int nombredejoueurs = 2;
	
	public static void rescale() {
		WINDOW_WIDTH = Init.size*CELL_WIDTH;
		WINDOW_HEIGHT = WINDOW_WIDTH + TXT_BAN;
	}
	
	public static char[] getCouleur() {
		return couleur;
	}
	static Player[] players = new Player[4];
	
	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}
	
	public static int getSize() {
		return size;
	}
	
	public static int getCapmax() {
		return capmax;
	}
	
	public static int getCellWidth() {
		return Main.WINDOW_WIDTH / size;
	}
	
	public static int getCellHeight() {
		return WINDOW_HEIGHT / size;
	}

	public static void Initialisation (int CouG,int nbxP,int nbxIA){
		
		if (CouG == 0){
			Scanner scansize = new Scanner(System.in);
			System.out.println("Taille de la grille ?");
			while (!scansize.hasNextInt()) {
				System.out.println("Veuillez rentrer un entier s'il vous plaît !");
				scansize.nextLine();
			}
			size=scansize.nextInt();
			Jeu(size);
			JCap(size);
		}
		if (CouG == 1){///Mode Graph
			Jeu(size);
			JCap(size);
			
			inverse(size);
		}
		if (nbxP == 2){
			if (nbxIA == 2){
				plateaucap[0][0]=1;
				players[0] = new Player("IA 1",plateau[0][0],plateaucap[0][0]);
				plateaucap[size-1][size-1]=2;
				players[1] = new Player("IA 2",plateau[size-1][size-1],plateaucap[size-1][size-1]);
			}
			if (nbxIA == 1){
				plateaucap[0][0]=1;
				players[0] = new Player("Player 1",plateau[0][0],plateaucap[0][0]);
				plateaucap[size-1][size-1]=2;
				players[1] = new Player("IA 2",plateau[size-1][size-1],plateaucap[size-1][size-1]);
			}
			if (nbxIA == 0){
				plateaucap[0][0]=1;
				players[0] = new Player("Player 1",plateau[0][0],plateaucap[0][0]);
				plateaucap[size-1][size-1]=2;
				players[1] = new Player("Player 2",plateau[size-1][size-1],plateaucap[size-1][size-1]);
			}
			Mov.MouvJ1(Init.plateau[0][0],Init.players[0].getCap());
			Mov.MouvJ2(Init.plateau[Init.size-1][Init.size-1],Init.players[1].getCap());
		}
		if (nbxP == 3){
			if(nbxIA == 3){
				plateaucap[0][0]=1;
				players[0] = new Player("IA 1",plateau[0][0],plateaucap[0][0]);
				plateaucap[size-1][size-1]=2;
				players[1] = new Player("IA 2",plateau[size-1][size-1],plateaucap[size-1][size-1]);
				plateaucap[0][size-1]=3;
				players[2] = new Player("IA 3",plateau[0][size-1],plateaucap[0][size-1]);
				
			}
			if(nbxIA == 2){
				plateaucap[0][0]=1;
				players[0] = new Player("Player 1",plateau[0][0],plateaucap[0][0]);
				plateaucap[size-1][size-1]=2;
				players[1] = new Player("IA 2",plateau[size-1][size-1],plateaucap[size-1][size-1]);
				plateaucap[0][size-1]=3;
				players[2] = new Player("IA 3",plateau[0][size-1],plateaucap[0][size-1]);
			}
			if(nbxIA == 1){
				plateaucap[0][0]=1;
				players[0] = new Player("Player 1",plateau[0][0],plateaucap[0][0]);
				plateaucap[size-1][size-1]=2;
				players[1] = new Player("Player 2",plateau[size-1][size-1],plateaucap[size-1][size-1]);
				plateaucap[0][size-1]=3;
				players[2] = new Player("IA 3",plateau[0][size-1],plateaucap[0][size-1]);
			}
			if (nbxIA == 0){
				plateaucap[0][0]=1;
				players[0] = new Player("Player 1",plateau[0][0],plateaucap[0][0]);
				plateaucap[size-1][size-1]=2;
				players[1] = new Player("Player 2",plateau[size-1][size-1],plateaucap[size-1][size-1]);
				plateaucap[0][size-1]=3;
				players[2] = new Player("Player 3",plateau[0][size-1],plateaucap[0][size-1]);
			}
			Mov.MouvJ1(Init.plateau[0][0],Init.players[0].getCap());
			Mov.MouvJ2(Init.plateau[Init.size-1][Init.size-1],Init.players[1].getCap());
			Mov.MouvJ3(Init.plateau[0][Init.size-1],Init.players[2].getCap());
		}
		if (nbxP == 4){
			if (nbxIA == 4){
				plateaucap[0][0]=1;
				players[0] = new Player("IA 1",plateau[0][0],plateaucap[0][0]);
				plateaucap[size-1][size-1]=2;
				players[1] = new Player("IA 2",plateau[size-1][size-1],plateaucap[size-1][size-1]);
				plateaucap[0][size-1]=3;
				players[2] = new Player("IA 3",plateau[0][size-1],plateaucap[0][size-1]);
				plateaucap[size-1][0]=4;
				players[3] = new Player("IA 4",plateau[size-1][0],plateaucap[size-1][0]);
			}
			if (nbxIA == 3){
				plateaucap[0][0]=1;
				players[0] = new Player("Player 1",plateau[0][0],plateaucap[0][0]);
				plateaucap[size-1][size-1]=2;
				players[1] = new Player("IA 2",plateau[size-1][size-1],plateaucap[size-1][size-1]);
				plateaucap[0][size-1]=3;
				players[2] = new Player("IA 3",plateau[0][size-1],plateaucap[0][size-1]);
				plateaucap[size-1][0]=4;
				players[3] = new Player("IA 4",plateau[size-1][0],plateaucap[size-1][0]);
			}
			if (nbxIA == 2){
				plateaucap[0][0]=1;
				players[0] = new Player("Player 1",plateau[0][0],plateaucap[0][0]);
				plateaucap[size-1][size-1]=2;
				players[1] = new Player("Player 2",plateau[size-1][size-1],plateaucap[size-1][size-1]);
				plateaucap[0][size-1]=3;
				players[2] = new Player("IA 3",plateau[0][size-1],plateaucap[0][size-1]);
				plateaucap[size-1][0]=4;
				players[3] = new Player("IA 4",plateau[size-1][0],plateaucap[size-1][0]);
			}
			if (nbxIA == 1){
				plateaucap[0][0]=1;
				players[0] = new Player("Player 1",plateau[0][0],plateaucap[0][0]);
				plateaucap[size-1][size-1]=2;
				players[1] = new Player("Player 2",plateau[size-1][size-1],plateaucap[size-1][size-1]);
				plateaucap[0][size-1]=3;
				players[2] = new Player("Player 3",plateau[0][size-1],plateaucap[0][size-1]);
				plateaucap[size-1][0]=4;
				players[3] = new Player("IA 4",plateau[size-1][0],plateaucap[size-1][0]);
			}
			if (nbxIA == 0){
				plateaucap[0][0]=1;
				players[0] = new Player("Player 1",plateau[0][0],plateaucap[0][0]);
				plateaucap[size-1][size-1]=2;
				players[1] = new Player("Player 2",plateau[size-1][size-1],plateaucap[size-1][size-1]);
				plateaucap[0][size-1]=3;
				players[2] = new Player("Player 3",plateau[0][size-1],plateaucap[0][size-1]);
				plateaucap[size-1][0]=4;
				players[3] = new Player("Player 4",plateau[size-1][0],plateaucap[size-1][0]);
			}
			Mov.MouvJ1(Init.plateau[0][0],Init.players[0].getCap());
			Mov.MouvJ2(Init.plateau[Init.size-1][Init.size-1],Init.players[1].getCap());
			Mov.MouvJ3(Init.plateau[0][Init.size-1],Init.players[2].getCap());
			Mov.MouvJ4(Init.plateau[Init.size-1][0],Init.players[3].getCap());
		}
		

		JMaj(size);
		
		capmax = (int) ((size*size)/2);
		
		System.out.println("JEU INITIALISÉ");
	}

	public static void Jeu(int size) {
		plateau = new char[size][size];
		for(int i = 0; i < size; i++) {
			for(int j=0; j < size; j++) {
				Random r = new Random();
				plateau[i][j]= couleur[r.nextInt(6)];
			}
		}
		while(plateau[0][0]==plateau[size-1][size-1]){
			Random r = new Random();
			plateau[size-1][size-1]= couleur[r.nextInt(6)];
		}
		while(plateau[0][0]==plateau[0][size-1]||plateau[size-1][size-1]==plateau[0][size-1]){
			Random r = new Random();
			plateau[0][size-1]= couleur[r.nextInt(6)];
		}
		while(plateau[0][0]==plateau[size-1][0]||plateau[size-1][size-1]==plateau[size-1][0]||plateau[0][size-1]==plateau[size-1][0]){
			Random r = new Random();
			plateau[size-1][0]= couleur[r.nextInt(6)];
		}
	}
	
	public static void JCap(int size) {
		plateaucap = new int[size][size];
		for(int i = 0; i < size; i++) {
			for(int j=0; j < size; j++) {
				plateaucap[i][j]= 0;
			}
		}
	}
	public static void JMaj(int size) {
		plateaumaj = new char[size][size];
		for(int i = 0; i < size; i++) {
			for(int j=0; j < size; j++) {
				plateaumaj[i][j]= plateau[i][j];
			}
		}
	}
	public static void aff(){
		for(int i = 0; i < size; i++){
	        for(int j = 0; j < size; j++){
	            System.out.print(plateau[i][j] + " ");
	        }
	        System.out.println();
	    }
	}
	public static void affcap(){
		for(int i = 0; i < size; i++){
	        for(int j = 0; j < size; j++){
	            System.out.print(plateaucap[i][j] + " ");
	        }
	        System.out.println();
	    }
	}
	public static void affmaj(){
		for(int i = 0; i < size; i++){
	        for(int j = 0; j < size; j++){
	            System.out.print(plateaumaj[i][j] + " ");
	        }
	        System.out.println();
	    }
	}
	public static void miseMaj(){
		for(int i = 0; i < size; i++){
	        for(int j = 0; j < size; j++){
	            if (plateaucap[i][j]!=0){
	            	if (plateau[i][j]=='r'){
	            		plateaumaj[i][j]='R';
	            	}
	            	
	            	if (plateau[i][j]=='o'){
	            		plateaumaj[i][j]='O';
	            	}
	            	
	            	if (plateau[i][j]=='j'){
	            		plateaumaj[i][j]='J';
	            	}
	            	
	            	if (plateau[i][j]=='v'){
	            		plateaumaj[i][j]='V';
	            	}
	            	
	            	if (plateau[i][j]=='b'){
	            		plateaumaj[i][j]='B';
	            	}
	            	
	            	if (plateau[i][j]=='i'){
	            		plateaumaj[i][j]='I';
	            	}
	            	
	            }
	        }
	    }
	affmaj();
	}
	public static void affgraph() {
		
		int CELL_WIDTH = getCellWidth();
		int n = 0;
		int m = 0;
		for (int i = size-1; i>-1; i--) {
			for (int j = 0; j<size; j++) {
				int semiWidth = CELL_WIDTH / 2;
				int x = j * CELL_WIDTH + semiWidth;
				int y = i * CELL_WIDTH + semiWidth;
				StdDraw.setPenColor(getColorFromChar(plateau[n][m]));
				StdDraw.filledSquare(x, y, semiWidth);
				StdDraw.setPenColor(Color.black);
				StdDraw.square(x, y, semiWidth);
				if (plateaucap[n][m]!=0){
					String z = "" +plateaucap[n][m];
					StdDraw.text(x, y, z);
				}
				m++;
			}
			m=0;
			n++;
		}
		n=0;
	}
	
	public static Color getColorFromChar(char c) {
		if (c == 'r') {
			return Color.RED;
		}
		if (c == 'o') {
			return Color.ORANGE;
		}
		if (c == 'j') {
			return Color.YELLOW;
		}
		if (c == 'v') {
			return Color.GREEN;
		}
		if (c == 'b') {
			return Color.BLUE;
		}
		if (c == 'i'){
			return Color.MAGENTA;
		}
		else {
			return Color.BLACK;
		}
	}
	
	public static void inverse(int size) {
		int n = 0;
		reverseX = new int[size];
		for (int i = size-1; i>0; i--) {
			reverseX[n]=i;
			n++;
		}
	}
	
	public static void affreverseX(){
		for(int i = 0; i < size; i++){
	            System.out.print(reverseX[i] + "---");
	    }
	}	
}
