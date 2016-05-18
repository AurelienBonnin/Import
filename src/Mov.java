import java.util.Scanner;

public class Mov {
	
	static int tourj = 1;
	
	private static int z = 0;
	
	private static int a = 0;
	
	private static int change = 1;
	
	private static char couleurjchar=' ';
	
	private static int aza;
	
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
}