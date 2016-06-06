import java.awt.Font;

import edu.princeton.cs.introcs.StdDraw;

public class Main {
	
	static int winj1 = 0; 

	static int winj2 = 0;
	
	static int winj3 = 0;
	
	static int winj4 = 0;
	
	static int caselibre = 0;
	
	static String nomdujoueur; 
	
	public static final int WINDOW_WIDTH = Init.size*102;
	
	public static final int WINDOW_HEIGHT = Init.size*102 + 306;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
	}
	
	public static void menu(){
		//StdDraw.setCanvasSize(Init.size*51,Init.size*51);
		StdDraw.setXscale(0, 100);
		StdDraw.setYscale(0, 100);
		
		//
		Font font = new Font("Arial",0, 20);
		StdDraw.setFont(font);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setFont(new Font("Arial", Font.PLAIN, 50));
		StdDraw.textLeft(25,80,"6 Couleurs");
		StdDraw.filledRectangle(50, 50, 10, 5);
		StdDraw.setFont(new Font("Arial", 0, 20));
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(50, 50, "Jouer");
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		StdDraw.textLeft(20,20,"VENKATRAMIAH & BONNIN   A1G9D");
		while(true){
			if (StdDraw.mousePressed()){
				double x=StdDraw.mouseX();
				double y=StdDraw.mouseY();
				if (x > 40 && x < 60 && y > 45 && y < 55){
					StdDraw.clear();
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(20, 70, 20, 5);
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.text(20, 70, "Console 2J");
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(80, 70, 20, 5);
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.text(80, 70, "Graph 2J");
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(80, 50, 20, 5);
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.text(80, 50, "1J VS IA ");
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(20, 50, 20, 5);
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.text(20, 50, "Graph 4J");
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(20, 30, 20, 5);
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.text(20, 30, "Graph 3J");
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(80, 30, 20, 5);
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.text(80, 30, "IA VS IA ");
					while(true){
						if (StdDraw.mousePressed()){
							x=StdDraw.mouseX();
							y=StdDraw.mouseY();
							if(x > 0 && x < 40 && y > 65 && y < 75){
								console1vs1();
							}
							if(x > 60 && x < 100 && y > 65 && y < 75){
								Init.nombredejoueurs = 2;
								test4j();
							}
							if(x > 60 && x < 100 && y > 45 && y < 55){
								graph1vsIA();
							}
							if(x > 0 && x < 40 && y > 45 && y < 55){
								Init.nombredejoueurs = 4;
								test4j();
							}
							if (x > 60 && x < 100 && y > 25 && y < 35){
								graphIAvsIA();
							}
							if (x > 0 && x < 40 && y > 25 && y < 35){
								Init.nombredejoueurs = 3;
								test4j();
							}
						}
					}
				}
			}
		}
	}
		
	public static void console1vs1(){
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(50, 60, "Le jeu est chargé dans la console");
		StdDraw.text(50, 50, "Cependant merci de ne pas fermer cette fenêtre");
		Init.Initialisation(0,2,0);
		while (winj1<=Init.getCapmax() && winj2<=Init.getCapmax() ){
			System.out.println();
			Mov.Mouvement();	
		}
		if (winj1>Init.getCapmax()){
			System.out.println("PLATEAU FINAL");
			System.out.println();
			Init.miseMaj();
			System.out.println();
			System.out.println("SCORE FINAL");
			System.out.println(Init.players[0].getName()+"   "+Main.winj1+"-"+Main.winj2+"   "+Init.players[1].getName());
			System.out.println("Bravo Vous avez gagné "+Init.players[0].getName()+",");
			System.out.println("vous avez capturé plus de la moitié des pions ! :)");
		}
		if (winj2>Init.getCapmax()){
			System.out.println("PLATEAU FINAL");
			System.out.println();
			Init.miseMaj();
			System.out.println();
			System.out.println("SCORE FINAL");
			System.out.println(Init.players[0].getName()+"   "+Main.winj1+"-"+Main.winj2+"   "+Init.players[1].getName());
			System.out.println("Bravo Vous avez gagné "+Init.players[1].getName()+",");
			System.out.println("vous avez capturé plus de la moitié des pions ! :)");
		}
	}
	
	
	public static void graph1vsIA(){
		StdDraw.clear();
		StdDraw.setXscale(0, WINDOW_WIDTH);
		StdDraw.setYscale(0, WINDOW_HEIGHT);
		Init.Initialisation(1, 2, 1);
		Init.JMaj(Init.size);
		Init.affgraph();
		String tourdraw = "Tour "+Mov.tourj;
		StdDraw.text(92,Init.size*102+254,tourdraw);
		String scoredraw ="Score: "+Init.players[0].getName()+"   "+Main.winj1+"-"+Main.winj2+"   "+Init.players[1].getName();
		StdDraw.text((Init.size-4)*102+22,Init.size*102+254,scoredraw);
		String jouedraw =Init.players[0].getName()+", à votre tour quelle couleur voulez-vous jouer ?";
		StdDraw.text((Init.size/2)*102+51,Init.size*102+152,jouedraw);
		Init.affgraph();
		while (winj1<=Init.getCapmax() && winj2<=Init.getCapmax() ){
			
			Mov.z=0;
			Mov.afficherscore();
			Mov.fgraph1vsIA();
			Mov.afficherscore();
			Mov.z=1;
			Mov.IAleatoire(2);
			Mov.tourj ++;
		}
		if (winj1>Init.getCapmax()){
			
			StdDraw.filledRectangle(WINDOW_WIDTH/2, WINDOW_HEIGHT/2, WINDOW_WIDTH/3, WINDOW_HEIGHT/3);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(WINDOW_WIDTH/2, WINDOW_HEIGHT/2, (WINDOW_WIDTH/3)-10, (WINDOW_HEIGHT/3)-10);
			StdDraw.setPenColor(StdDraw.BLACK);
			String win1txt= "Bravo, "+Init.players[0].getName()+" a gagné !";
			StdDraw.text(WINDOW_WIDTH/2, WINDOW_HEIGHT/2, win1txt);
		}
		if (winj2>Init.getCapmax()){
			StdDraw.filledRectangle(WINDOW_WIDTH/2, WINDOW_HEIGHT/2, WINDOW_WIDTH/3, WINDOW_HEIGHT/3);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(WINDOW_WIDTH/2, WINDOW_HEIGHT/2, (WINDOW_WIDTH/3)-10, (WINDOW_HEIGHT/3)-10);
			StdDraw.setPenColor(StdDraw.BLACK);
			String win2txt= "Bravo, "+Init.players[1].getName()+" a gagné !";
			StdDraw.text(WINDOW_WIDTH/2, WINDOW_HEIGHT/2, win2txt);
		}
	}
	
	public static void graphIAvsIA(){
		StdDraw.clear();
		StdDraw.setXscale(0, WINDOW_WIDTH);
		StdDraw.setYscale(0, WINDOW_HEIGHT);
		Init.Initialisation(1, 2, 2);
		Init.affgraph();
		String tourdraw = "Tour "+Mov.tourj;
		StdDraw.text(92,Init.size*102+254,tourdraw);
		String scoredraw ="Score: "+Init.players[0].getName()+"   "+Main.winj1+"-"+Main.winj2+"   "+Init.players[1].getName();
		StdDraw.text((Init.size-4)*102+22,Init.size*102+254,scoredraw);
		String jouedraw =Init.players[0].getName()+", à votre tour quelle couleur voulez-vous jouer ?";
		StdDraw.text((Init.size/2)*102+51,Init.size*102+152,jouedraw);
		while (winj1<=Init.getCapmax() && winj2<=Init.getCapmax() ){
			
			Mov.z=0;
			Mov.afficherscore();
			Mov.IAleatoire(1);
			Mov.z=1;
			Mov.afficherscore();
			Mov.IAleatoire(2);
			Mov.tourj ++;
		}
		if (winj1>Init.getCapmax()){
			
			StdDraw.filledRectangle(WINDOW_WIDTH/2, WINDOW_HEIGHT/2, WINDOW_WIDTH/3, WINDOW_HEIGHT/3);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(WINDOW_WIDTH/2, WINDOW_HEIGHT/2, (WINDOW_WIDTH/3)-10, (WINDOW_HEIGHT/3)-10);
			StdDraw.setPenColor(StdDraw.BLACK);
			String win1txt= "Bravo, "+Init.players[0].getName()+" a gagné !";
			StdDraw.text(WINDOW_WIDTH/2, WINDOW_HEIGHT/2, win1txt);
		}
		if (winj2>Init.getCapmax()){
			StdDraw.filledRectangle(WINDOW_WIDTH/2, WINDOW_HEIGHT/2, WINDOW_WIDTH/3, WINDOW_HEIGHT/3);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(WINDOW_WIDTH/2, WINDOW_HEIGHT/2, (WINDOW_WIDTH/3)-10, (WINDOW_HEIGHT/3)-10);
			StdDraw.setPenColor(StdDraw.BLACK);
			String win2txt= "Bravo, "+Init.players[1].getName()+" a gagné !";
			StdDraw.text(WINDOW_WIDTH/2, WINDOW_HEIGHT/2, win2txt);
		}
	}
	public static void test4j(){
		StdDraw.clear();
		StdDraw.setXscale(0, WINDOW_WIDTH);
		StdDraw.setYscale(0, WINDOW_HEIGHT);
		Init.Initialisation(1,Init.nombredejoueurs, 0);
		Init.affgraph();
		Mov.banniere();
		/*
		String tourdraw = "Tour "+Mov.tourj;
		StdDraw.text(92,Init.size*102+254,tourdraw);
		String scoredraw ="Score: "+Init.players[0].getName()+"   "+Main.winj1+"-"+Main.winj2+"   "+Init.players[1].getName();
		StdDraw.text((Init.size-4)*102+22,Init.size*102+254,scoredraw);
		String jouedraw =Init.players[0].getName()+", à votre tour quelle couleur voulez-vous jouer ?";
		StdDraw.text((Init.size/2)*102+51,Init.size*102+152,jouedraw);*/
		Mov.score();
		while(Mov.premier <= Mov.deuxieme+Main.caselibre && Init.nombredejoueurs != Mov.nbxcouleurdispo){
			Mov.z=0;
			Mov.banniere();
			Mov.Mouvementgraphhumain(Mov.z);
			Mov.score();
			Mov.z=1;
			Mov.banniere();
			Mov.Mouvementgraphhumain(Mov.z);
			Mov.score();
			if (Init.nombredejoueurs>2){
				Mov.z=2;
				Mov.banniere();
				Mov.Mouvementgraphhumain(Mov.z);
				Mov.score();
				if(Init.nombredejoueurs>3){
					Mov.z=3;
					Mov.banniere();
					Mov.Mouvementgraphhumain(Mov.z);
					Mov.score();
				}
			}
			Mov.tourj ++;
		}
		Mov.banniere();
		StdDraw.filledRectangle(WINDOW_WIDTH/2, WINDOW_HEIGHT/2, WINDOW_WIDTH/3, WINDOW_HEIGHT/3);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(WINDOW_WIDTH/2, WINDOW_HEIGHT/2, (WINDOW_WIDTH/3)-10, (WINDOW_HEIGHT/3)-10);
		StdDraw.setPenColor(StdDraw.BLACK);
		if(Mov.premier==winj1){
			nomdujoueur=Init.players[0].getName();
		}
		if(Mov.premier==winj2){
			nomdujoueur=Init.players[1].getName();
		}
		if(Mov.premier==winj3){
			nomdujoueur=Init.players[2].getName();
		}
		if(Mov.premier==winj4){
			nomdujoueur=Init.players[3].getName();
		}
		String win1txt= "Bravo, "+nomdujoueur+" a gagné !";
		StdDraw.text(WINDOW_WIDTH/2, WINDOW_HEIGHT/2, win1txt);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(WINDOW_WIDTH/2, WINDOW_HEIGHT/2 - 400, 250, 75);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(WINDOW_WIDTH/2, WINDOW_HEIGHT/2 - 400, "menu");
		while(true){
			if (StdDraw.mousePressed()){
				double x=StdDraw.mouseX();
				double y=StdDraw.mouseY();
				if (x > (WINDOW_WIDTH/2)-250 && x < (WINDOW_WIDTH/2)+250 && y > (WINDOW_HEIGHT/2 - 400)-75 && y < (WINDOW_HEIGHT/2 - 400)+75){
					StdDraw.clear();
					menu();
				}
		}
		}
	}
}