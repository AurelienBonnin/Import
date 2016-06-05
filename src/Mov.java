import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdDraw;

public class Mov {
	
	static int tourj = 1;
	
	static int z = 0;
	
	private static int a = 0;
	
	private static int change = 1;
	
	private static char couleurjchar=' ';
	
	private static int aza;
	
	static int premier;
	
	static int deuxieme;
	
	static int couleurdispo[]={0,0,0,0,0,0};
	
	static int nbxcouleurdisparu;
	
	static int nbxcouleurdispo;
	
	public static void Mouvement(){
		Init.players[0].setColor(Init.plateau[0][0]);
		Init.players[1].setColor(Init.plateau[Init.size-1][Init.size-1]);
		//System.out.println("lol "+Init.players[0].getColor());
		//System.out.println("lol "+Init.players[1].getColor());
			System.out.println("----------Tour "+ tourj+"----------");
			Init.miseMaj();
			System.out.println();
			System.out.println("Score:");
			System.out.println(Init.players[0].getName()+"   "+Main.winj1+"-"+Main.winj2+"   "+Init.players[1].getName());
			Scanner scancouleurj = new Scanner(System.in);
			System.out.println();
			System.out.println(Init.players[z].getName()+", à votre tour quelle couleur voulez vous jouer ?");
			
			do {
				aza = 0;
			    System.out.println("Rentrez une lettre en minuscule, s’il vous plaît ");
			                
			    couleurjchar = scancouleurj.nextLine().charAt(0);
			    if (couleurjchar == Init.players[1].getColor()){
			    	System.out.println("Vous ne pouvez pas jouer cette couleur, elle est déjà controlée par "+Init.players[1].getName());
			    }
			    if (couleurjchar == Init.players[0].getColor()){
			    	System.out.println("Vous ne pouvez pas jouer cette couleur, elle est déjà controlée par "+Init.players[0].getName());
			    }
			    while(aza < Init.couleur.length && couleurjchar != Init.couleur[aza])
			      aza++;
			    if (aza >= Init.couleur.length)
			    	System.out.println("La lettre " +couleurjchar+ " ne fait pas partie des couleurs disponibles!");
			}while(aza >= Init.couleur.length || couleurjchar == Init.players[1].getColor() || couleurjchar == Init.players[0].getColor());
			
			if(a%2 == 0){
				MouvJ1(couleurjchar,Init.players[0].getCap());
				z=1;
			}
			else{
				MouvJ2(couleurjchar,Init.players[1].getCap());
				z=0;
				tourj = tourj + 1;
			}
			a=a+1;
	}
	
	public static void Mouvementgraph(){
		//Init.players[0].setColor(Init.plateau[0][0]);
		//Init.players[1].setColor(Init.plateau[Init.size-1][Init.size-1]);
		//System.out.println("lol "+Init.players[0].getColor());
		//System.out.println("lol "+Init.players[1].getColor());
			//String tourdraw = "Tour "+tourj;
			//StdDraw.text(92,Init.size*102+254,tourdraw);
			//System.out.println("----------Tour "+tourj+"----------");
			//Init.miseMaj();
			//String scoredraw ="Score: "+Init.players[0].getName()+"   "+Main.winj1+"-"+Main.winj2+"   "+Init.players[1].getName();
			//StdDraw.text((Init.size-4)*102+22,Init.size*102+254,scoredraw);
			//System.out.println("Score:");
			//System.out.println(Init.players[0].getName()+"   "+Main.winj1+"-"+Main.winj2+"   "+Init.players[1].getName());
			//Scanner scancouleurj = new Scanner(System.in);
			//System.out.println();
			//String jouedraw =Init.players[z].getName()+", à votre tour quelle couleur voulez-vous jouer ?";
			//StdDraw.text((Init.size/2)*102+51,Init.size*102+152,jouedraw);
			//System.out.println(Init.players[z].getName()+", à votre tour quelle couleur voulez vous jouer ?");
			if(StdDraw.mousePressed()){
				int clicx=(int) StdDraw.mouseX() /(Main.WINDOW_WIDTH / Init.size);
				int clicy=(int) StdDraw.mouseY() /(Main.WINDOW_WIDTH / Init.size);
				//System.out.println("XXX"+StdDraw.mouseX()+"   "+"YYY"+StdDraw.mouseY());
				aza = 0;
				//int x=Init.reverseX[clicy];
				//int y= clicx;
				//System.out.println("X000X"+x+"-_-_-_-"+"Y000Y"+y);
				if (-1<clicx && clicx<Init.size && -1<clicy && clicy<Init.size){
					int x=Init.reverseX[clicy];
					int y= clicx;
					//System.out.println("lourd");
					for (int i = 0;i< Init.couleur.length;i++){
						if(Init.plateau[x][y] == Init.couleur[i]){
							aza++;
						}
					}
					if (Init.plateau[x][y] != Init.players[1].getColor() && Init.plateau[x][y] != Init.players[0].getColor() && aza != 0){
						couleurjchar=Init.plateau[x][y];
						if(a%2 == 0){
							MouvJ1(couleurjchar,Init.players[0].getCap());
							z=1;
							//System.out.println("lol1");
						}
						else{
							MouvJ2(couleurjchar,Init.players[1].getCap());
							z=0;
							StdDraw.setPenColor(StdDraw.WHITE);
							String tourdraw = "Tour "+tourj;
							StdDraw.text(92,Init.size*102+254,tourdraw);
							tourj = tourj + 1;
							StdDraw.setPenColor(StdDraw.BLACK);
							tourdraw = "Tour "+tourj;
							StdDraw.text(92,Init.size*102+254,tourdraw);
							//System.out.println("lol2");
						}
						//System.out.println("lol3");
						Init.players[0].setColor(Init.plateau[0][0]);
						Init.players[1].setColor(Init.plateau[Init.size-1][Init.size-1]);
						//Init.miseMaj();
						StdDraw.setPenColor(StdDraw.WHITE);
						StdDraw.filledRectangle((Main.WINDOW_WIDTH/2),Main.WINDOW_WIDTH+200,Main.WINDOW_WIDTH,102);
						StdDraw.setPenColor(StdDraw.BLACK);
						Init.affgraph();
//						String tourdraw = "Tour "+tourj;
//						StdDraw.text(92,Init.size*102+254,tourdraw);
						String scoredraw ="Score: "+Init.players[0].getName()+"   "+Main.winj1+"-"+Main.winj2+"   "+Init.players[1].getName();
						StdDraw.text((Init.size-4)*102+15,Init.size*102+254,scoredraw);
						String jouedraw =Init.players[z].getName()+", à votre tour quelle couleur voulez-vous jouer ?";
						StdDraw.text((Init.size/2)*102+51,Init.size*102+152,jouedraw);
						a=a+1;
					}
				}
				/*for (int i = 0;i< Init.couleur.length;i++){
					if(Init.plateau[x][y] == Init.couleur[i]){
						aza++;
					}
				}
				if (Init.plateau[x][y] != Init.players[1].getColor() && Init.plateau[x][y] != Init.players[0].getColor() && aza != 0){
					couleurjchar=Init.plateau[x][y];
					if(a%2 == 0){
						MouvJ1(couleurjchar,Init.players[0].getCap());
						z=1;
						System.out.println("lol1");
					}
					else{
						MouvJ2(couleurjchar,Init.players[1].getCap());
						z=0;
						tourj = tourj + 1;
						System.out.println("lol2");
					}
					System.out.println("lol3");
					Init.players[0].setColor(Init.plateau[0][0]);
					Init.players[1].setColor(Init.plateau[Init.size-1][Init.size-1]);
					StdDraw.clear();
					Init.affgraph();
					String tourdraw = "Tour "+tourj;
					StdDraw.text(92,Init.size*102+254,tourdraw);
					String scoredraw ="Score: "+Init.players[0].getName()+"   "+Main.winj1+"-"+Main.winj2+"   "+Init.players[1].getName();
					StdDraw.text((Init.size-4)*102+22,Init.size*102+254,scoredraw);
					String jouedraw =Init.players[z].getName()+", à votre tour quelle couleur voulez-vous jouer ?";
					StdDraw.text((Init.size/2)*102+51,Init.size*102+152,jouedraw);
					a=a+1;
				}*/
			}
	}
	
	///
	public static void fgraph1vsIA(){
		int tourjoue = 0;
		while(tourjoue==0){
			if(StdDraw.mousePressed()){
				int clicx=(int) StdDraw.mouseX() /(Main.WINDOW_WIDTH / Init.size);
				int clicy=(int) StdDraw.mouseY() /(Main.WINDOW_WIDTH / Init.size);
				//System.out.println("XXX"+StdDraw.mouseX()+"   "+"YYY"+StdDraw.mouseY());
				aza = 0;
				//int x=Init.reverseX[clicy];
				//int y= clicx;
				//System.out.println("X000X"+x+"-_-_-_-"+"Y000Y"+y);
				if (-1<clicx && clicx<Init.size && -1<clicy && clicy<Init.size){
					int x=Init.reverseX[clicy];
					int y= clicx;
					//System.out.println("lourd");
					for (int i = 0;i< Init.couleur.length;i++){
						if(Init.plateau[x][y] == Init.couleur[i]){
							aza++;
						}
					}
					if (Init.plateau[x][y] != Init.players[1].getColor() && Init.plateau[x][y] != Init.players[0].getColor() && aza != 0){
							couleurjchar=Init.plateau[x][y];
							MouvJ1(couleurjchar,Init.players[0].getCap());
							z=1;
							//System.out.println("lol1");
							tourjoue=1;
							}
					}
				}
		}
					}

	
	public static void Mouvementgraphhumain(int nbdujoueur){
		int tourjoue = 0;
		while(tourjoue==0){
			if(StdDraw.mousePressed()){
				int clicx=(int) StdDraw.mouseX() /(Main.WINDOW_WIDTH / Init.size);
				int clicy=(int) StdDraw.mouseY() /(Main.WINDOW_WIDTH / Init.size);
				//System.out.println("XXX"+StdDraw.mouseX()+"   "+"YYY"+StdDraw.mouseY());
				aza = 0;
				//int x=Init.reverseX[clicy];
				//int y= clicx;
				//System.out.println("X000X"+x+"-_-_-_-"+"Y000Y"+y);
				if (-1<clicx && clicx<Init.size && -1<clicy && clicy<Init.size){
					int x=Init.reverseX[clicy];
					int y= clicx;
					//System.out.println("lourd");
					for (int i = 0;i< Init.couleur.length;i++){
						if(Init.plateau[x][y] == Init.couleur[i]){
							aza++;
						}
					}
					if (Init.nombredejoueurs==2){
						if (Init.plateau[x][y] != Init.players[1].getColor() && Init.plateau[x][y] != Init.players[0].getColor() && aza != 0){
							couleurjchar=Init.plateau[x][y];
							if(nbdujoueur == 0){
								MouvJ1(couleurjchar,Init.players[0].getCap());
							}
							if(nbdujoueur == 1){
								MouvJ2(couleurjchar,Init.players[1].getCap());
							}
							if(nbdujoueur == 2){
								MouvJ3(couleurjchar,Init.players[2].getCap());
							}
							if(nbdujoueur == 3){
								MouvJ4(couleurjchar,Init.players[3].getCap());
							}
							//MouvJ1(couleurjchar,Init.players[0].getCap());
							//System.out.println("lol1");
							tourjoue=1;
							}
					}
					if (Init.nombredejoueurs==3){
						if (Init.plateau[x][y] != Init.players[1].getColor() && Init.plateau[x][y] != Init.players[0].getColor()&& Init.plateau[x][y] != Init.players[2].getColor() && aza != 0){
							couleurjchar=Init.plateau[x][y];
							if(nbdujoueur == 0){
								MouvJ1(couleurjchar,Init.players[0].getCap());
							}
							if(nbdujoueur == 1){
								MouvJ2(couleurjchar,Init.players[1].getCap());
							}
							if(nbdujoueur == 2){
								MouvJ3(couleurjchar,Init.players[2].getCap());
							}
							if(nbdujoueur == 3){
								MouvJ4(couleurjchar,Init.players[3].getCap());
							}
							//MouvJ1(couleurjchar,Init.players[0].getCap());
							//System.out.println("lol1");
							tourjoue=1;
							}
					}
					if (Init.nombredejoueurs==4){
						if (Init.plateau[x][y] != Init.players[1].getColor() && Init.plateau[x][y] != Init.players[0].getColor()&& Init.plateau[x][y] != Init.players[2].getColor() && Init.plateau[x][y] != Init.players[3].getColor() && aza != 0){
							couleurjchar=Init.plateau[x][y];
							if(nbdujoueur == 0){
								MouvJ1(couleurjchar,Init.players[0].getCap());
							}
							if(nbdujoueur == 1){
								MouvJ2(couleurjchar,Init.players[1].getCap());
							}
							if(nbdujoueur == 2){
								MouvJ3(couleurjchar,Init.players[2].getCap());
							}
							if(nbdujoueur == 3){
								MouvJ4(couleurjchar,Init.players[3].getCap());
							}
							//MouvJ1(couleurjchar,Init.players[0].getCap());
							//System.out.println("lol1");
							tourjoue=1;
							}
					}
					
					
					if (Init.plateau[x][y] != Init.players[1].getColor() && Init.plateau[x][y] != Init.players[0].getColor()&& Init.plateau[x][y] != Init.players[2].getColor() && Init.plateau[x][y] != Init.players[3].getColor() && aza != 0){
							couleurjchar=Init.plateau[x][y];
							if(nbdujoueur == 0){
								MouvJ1(couleurjchar,Init.players[0].getCap());
							}
							if(nbdujoueur == 1){
								MouvJ2(couleurjchar,Init.players[1].getCap());
							}
							if(nbdujoueur == 2){
								MouvJ3(couleurjchar,Init.players[2].getCap());
							}
							if(nbdujoueur == 3){
								MouvJ4(couleurjchar,Init.players[3].getCap());
							}
							//MouvJ1(couleurjchar,Init.players[0].getCap());
							//System.out.println("lol1");
							tourjoue=1;
							}
					}
				}
		}
					}
	
	
	///
	///
	///
	public static void afficherscore(){
		StdDraw.setPenColor(StdDraw.BLACK);
		String tourdraw = "Tour "+tourj;
		StdDraw.text(92,Init.size*102+254,tourdraw);
		//System.out.println("lol2");

		//System.out.println("lol3");
		Init.players[0].setColor(Init.plateau[0][0]);
		Init.players[1].setColor(Init.plateau[Init.size-1][Init.size-1]);
		if(Init.nombredejoueurs == 3){
			Init.players[2].setColor(Init.plateau[0][Init.size-1]);
		}
		if (Init.nombredejoueurs == 4){
			Init.players[2].setColor(Init.plateau[0][Init.size-1]);
			Init.players[3].setColor(Init.plateau[Init.size-1][0]);
		}
	
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle((Main.WINDOW_WIDTH/2),Main.WINDOW_WIDTH+200,Main.WINDOW_WIDTH,102);
		StdDraw.setPenColor(StdDraw.BLACK);
		Init.affgraph();
	
		StdDraw.text(92,Init.size*102+254,tourdraw);
		String scoredraw ="Score: "+Init.players[0].getName()+"   "+Main.winj1+"-"+Main.winj2+"   "+Init.players[1].getName();
		StdDraw.text((Init.size-4)*102+15,Init.size*102+254,scoredraw);
		String jouedraw =Init.players[z].getName()+", à votre tour quelle couleur voulez-vous jouer ?";
		StdDraw.text((Init.size/2)*102+51,Init.size*102+152,jouedraw);
	}
	///
	///
	///
	
	public static boolean Touche(int i, int j,int z){
		int mini, minj, maxi, maxj;
		if (i==0) {
			mini=0;
		}
		else {
			mini = i-1;
			}
		
		if (j==0) {
			minj=0;
		}
		else {
			minj = j-1;
			}
		
		if (i==Init.size-1) {
			maxi=Init.size-1;
		}
		else {
			maxi = i+1;
			}
		
		if (j==Init.size-1) {
			maxj=Init.size-1;
		}
		else {
			maxj = j+1;
			}

		if (Init.plateaucap[mini][j]==z){
			return true;
		}
		if (Init.plateaucap[i][minj]==z){
			return true;
		}
		if (Init.plateaucap[maxi][j]==z){
			return true;
		}
		if (Init.plateaucap[i][maxj]==z){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void MouvJ1(char couleurj1,int z){
		int cmp1 = 1;
		int cmp2 = 2;
		while (cmp1!=cmp2){
			cmp1 = Comptenbx(z);
			for(int i = 0; i < Init.size; i++){
		        for(int j = 0; j < Init.size; j++){
		            if (Init.plateau[i][j]==couleurj1){
		            	if (Touche(i,j,z)){
		            		Init.plateaucap[i][j] = z;
		            	}
		            }
		        }
			}
			cmp2 = Comptenbx(z);
			Main.winj1 = cmp2;
		}
		for(int m = 0; m < Init.size; m++){
	        for(int n = 0; n < Init.size; n++){
	            if (Init.plateaucap[m][n]==z){
	            		Init.plateau[m][n] = couleurj1;
	            	}
	            }
	        }
	    }
	
	public static void MouvJ2(char couleurj2, int z){
		int cmp1 = 1;
		int cmp2 = 2;
		while (cmp1!=cmp2){
			cmp1 = Comptenbx(z);
			for(int i = Init.size-1; -1 < i;){
				for(int j = Init.size-1; -1 < j;){
					if (Init.plateau[i][j]==couleurj2){
						if (Touche(i,j,z)){
							Init.plateaucap[i][j] = z;
						}
					}
					j=j-1;
				}
				i=i-1;
			}
			cmp2 = Comptenbx(z);
			Main.winj2 = cmp2;
		}
		for(int m = 0; m < Init.size; m++){
	        for(int n = 0; n < Init.size; n++){
	            if (Init.plateaucap[m][n]==z){
	            		Init.plateau[m][n] = couleurj2;
	            	}
	            }
	        }
	    }
	
	public static void MouvJ3(char couleurj3, int z){
		int cmp1 = 1;
		int cmp2 = 2;
		while (cmp1!=cmp2){
			cmp1 = Comptenbx(z);
			for(int i = 0 ; i < Init.size;i++){
				for(int j = Init.size-1; -1 < j;){
					if (Init.plateau[i][j]==couleurj3){
						if (Touche(i,j,z)){
							Init.plateaucap[i][j] = z;
						}
					}
					j=j-1;
				}
			}
			cmp2 = Comptenbx(z);
			Main.winj3 = cmp2;
		}
		for(int m = 0; m < Init.size; m++){
	        for(int n = 0; n < Init.size; n++){
	            if (Init.plateaucap[m][n]==z){
	            		Init.plateau[m][n] = couleurj3;
	            	}
	            }
	        }
	    }
	
	public static void MouvJ4(char couleurj4, int z){
		int cmp1 = 1;
		int cmp2 = 2;
		while (cmp1!=cmp2){
			cmp1 = Comptenbx(z);
			for(int i = Init.size-1; -1 < i;){
				for(int j = 0 ; j < Init.size;j++){
					if (Init.plateau[i][j]==couleurj4){
						if (Touche(i,j,z)){
							Init.plateaucap[i][j] = z;
						}
					}
				}
				i=i-1;
			}
			cmp2 = Comptenbx(z);
			Main.winj4 = cmp2;
		}
		for(int m = 0; m < Init.size; m++){
	        for(int n = 0; n < Init.size; n++){
	            if (Init.plateaucap[m][n]==z){
	            		Init.plateau[m][n] = couleurj4;
	            	}
	            }
	        }
	    }
	
	public static void IAleatoire(int valueplayer){
		int bonnecouleur = 0;
		//char couleurvalide = 0;
		while(bonnecouleur == 0){
			char couleurvalide = 0;
			Random r = new Random();
			couleurvalide=Init.couleur[r.nextInt(6)];
			System.out.println(couleurvalide);
			if (couleurvalide != Init.players[1].getColor() && couleurvalide != Init.players[0].getColor()){
				couleurjchar=couleurvalide;
				bonnecouleur=1;
				Init.affgraph();
				System.out.println(couleurvalide);
			}
			else{
				bonnecouleur = 0;
			}
			System.out.println("5lol5");
		}
		System.out.println("Lolilol");
		if (valueplayer == 1){
			MouvJ1(couleurjchar,Init.players[0].getCap());
		}
		if (valueplayer == 2){
			MouvJ2(couleurjchar,Init.players[1].getCap());
		}
		if (valueplayer == 3){
			MouvJ3(couleurjchar,Init.players[2].getCap());
		}
		if (valueplayer == 4){
			MouvJ4(couleurjchar,Init.players[3].getCap());
		}
		Init.affgraph();
	}
	
	public static int Comptenbx(int z){
		int nbxcap = 0;
		for(int i = 0; i < Init.size; i++){
	        for(int j = 0; j < Init.size; j++){
	            if (Init.plateaucap[i][j]==z){
	            	nbxcap=nbxcap+1;
	            }
	        }
	    }
		return nbxcap;
	}
	
	public static void IAcaptureplus(){
		int bonnecouleur = 0;
		//char couleurvalide = 0;
		while(bonnecouleur == 0){
			char couleurvalide = 0;
			Random r = new Random();
			couleurvalide=Init.couleur[r.nextInt(6)];
			System.out.println(couleurvalide);
			if (couleurvalide != Init.players[1].getColor() && couleurvalide != Init.players[0].getColor()){
				couleurjchar=couleurvalide;
				bonnecouleur=1;
				Init.affgraph();
				System.out.println(couleurvalide);
			}
			else{
				bonnecouleur = 0;
			}
			System.out.println("5lol5");
		}
		System.out.println("Lolilol");
		MouvJ2(couleurjchar,Init.players[1].getCap());
		Init.affgraph();
	}
		
	public static void score () {
		Main.caselibre = 0;
		for (int i = 0; i<6;i++){
			couleurdispo[i] = 0;
		}
		//Main.winj1=12345;
		//Main.winj2=22777;
		//Main.winj3=33000000;
		//Main.winj4=1177;
		int [] classement ={Main.winj1,Main.winj2,Main.winj3,Main.winj4};
		Arrays.sort(classement);
		premier = classement[3];
		deuxieme = classement[2];
		//System.out.println(classement[3]);// plus grand
		//System.out.println(classement[2]);// deuxieme 
		System.out.println(premier+"LOLOLO");// plus grand
		System.out.println(deuxieme+"fffff");
		for(int i = 0; i < Init.size; i++){
	        for(int j = 0; j < Init.size; j++){
	            if (Init.plateaucap[i][j] ==0){
	            	Main.caselibre ++;
	            }
	        }
	    }
		for(int i = 0; i < Init.size; i++){
	        for(int j = 0; j < Init.size; j++){
	            if (Init.plateau[i][j] =='r'){
	            	couleurdispo[0]++;
	            }
	            if (Init.plateau[i][j] =='o'){
	            	couleurdispo[1]++;
	            }
	            if (Init.plateau[i][j] =='j'){
	            	couleurdispo[2]++;
	            }
	            if (Init.plateau[i][j] =='v'){
	            	couleurdispo[3]++;
	            }
	            if (Init.plateau[i][j] =='b'){
	            	couleurdispo[4]++;
	            }
	            if (Init.plateau[i][j] =='i'){
	            	couleurdispo[5]++;
	            }
	        }
	    }
		nbxcouleurdisparu=0;
		for (int i = 0; i<6;i++){
			if (couleurdispo[i]==0){
				System.out.println("azertyuiop");
				nbxcouleurdisparu++;
			}
		}
		nbxcouleurdispo=0;
		nbxcouleurdispo=6-nbxcouleurdisparu;
	}
}