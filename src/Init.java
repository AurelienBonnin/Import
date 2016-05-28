import java.awt.Color;
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
	
	static char couleur[] = {'r','o','j','v','b','i'};
	
	static int[] reverseX;
	
	static int nombredejoueurs = 2;
	
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
		//Scanner scanname1 = new Scanner(System.in);
		//System.out.println("Quel est le nom du joueur 1 ?");
		//int name1=scanname1.nextInt();
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
			else{
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
			else{
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
			else{
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
		//plateaucap[0][0]=1;
		//players[0] = new Player("Player 1",plateau[0][0],plateaucap[0][0]);
		System.out.println(players[1].getName());
		
		//System.out.println(plateau[0][0]);
		//Scanner scanname2 = new Scanner(System.in);
		//System.out.println("Quel est le nom du joueur 2 ?");
		//int name2=scanname2.nextInt();
		
		
		//plateaucap[size-1][size-1]=2;
		//players[1] = new Player("Player 2",plateau[size-1][size-1],plateaucap[size-1][size-1]);
		

		JMaj(size);
		//miseMaj();
		
		capmax = (int) ((size*size)/2);
		//System.out.println(capmax);
		//System.out.println(players[0].getName());
		//System.out.println(players[1].getName());
		
		//Mov.MouvJ1(Init.plateau[0][0],Init.players[0].getCap());
		//Mov.MouvJ2(Init.plateau[Init.size-1][Init.size-1],Init.players[1].getCap());
		System.out.println("JEU INITIALISÉ");
		//System.out.println("Tour 1");
		//Init.affcap();
		
		//System.out.println(players[0].getCap());
		
		/*String tourdraw = "Tour "+Mov.tourj;
		StdDraw.text(92,Init.size*102+254,tourdraw);
		String scoredraw ="Score: "+Init.players[0].getName()+"   "+Main.winj1+"-"+Main.winj2+"   "+Init.players[1].getName();
		StdDraw.text((Init.size-4)*102+22,Init.size*102+254,scoredraw);
		String jouedraw =Init.players[0].getName()+", à votre tour quelle couleur voulez-vous jouer ?";
		StdDraw.text((Init.size/2)*102+51,Init.size*102+152,jouedraw);*/
		
		
	}
	public static void InitialisationGraph (){
		Jeu(size);
		JCap(size);
		
		
		plateaucap[0][0]=1;
		players[0] = new Player("Player 1",plateau[0][0],plateaucap[0][0]);

		
		plateaucap[size-1][size-1]=2;
		players[1] = new Player("Player 2",plateau[size-1][size-1],plateaucap[size-1][size-1]);
		

		//JMaj(size);
		
		capmax = (int) ((size*size)/2);
		
		Init.players[0].setColor(Init.plateau[0][0]);
		Init.players[1].setColor(Init.plateau[Init.size-1][Init.size-1]);
		
		Mov.MouvJ1(Init.plateau[0][0],Init.players[0].getCap());
		Mov.MouvJ2(Init.plateau[Init.size-1][Init.size-1],Init.players[1].getCap());
		//System.out.println("JEU INITIALISÉ");
		//System.out.println("Tour 1");
		//Init.affcap();
		
		//System.out.println(players[0].getCap());
		inverse(size);
		//affreverseX();
		//System.out.println("");
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
				//w++;
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
