import java.awt.Font;

import edu.princeton.cs.introcs.StdDraw;

public class Main {
	
	static int winj1 = 0; 

	static int winj2 = 0;
	
	public static final int WINDOW_WIDTH = Init.size*102;
	
	public static final int WINDOW_HEIGHT = Init.size*102 + 100;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
	}
	
	public static void menu(){
		StdDraw.setXscale(0, 100);
		StdDraw.setYscale(0, 100);
		
		//
		Font font = new Font("Calibri",0, 25);
		StdDraw.setFont(font);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(50, 50, 20, 5);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(50, 50, "Jouer");
		while(true){
			if (StdDraw.mousePressed()){
				double x=StdDraw.mouseX();
				double y=StdDraw.mouseY();
				if (x > 30 && x < 70 && y > 45 && y < 55){
					StdDraw.clear();
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(20, 70, 20, 5);
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.text(20, 70, "Console 2J");
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(80, 70, 20, 5);
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.text(80, 70, "Graph 2J");
					while(true){
						if (StdDraw.mousePressed()){
							x=StdDraw.mouseX();
							y=StdDraw.mouseY();
							if(x > 0 && x < 40 && y > 65 && y < 75){
								console2vs2();
							}
							if(x > 60 && x < 100 && y > 65 && y < 75){
								graph2vs2();
							}
						}
					}
				}
			}
		}
	}
		
	public static void console2vs2(){
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(50, 60, "Le jeu est chargé dans la console");
		StdDraw.text(50, 50, "Cependant merci de ne pas fermer cette fenêtre");
		Init.Initialisation();
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
		//if (winj1==Init.getCapmax() && winj2==Init.getCapmax()){
			//Init.miseMaj();
			//System.out.println();
			//System.out.println("SCORE FINAL");
			//System.out.println(Init.players[0].getName()+"   "+Main.winj1+"-"+Main.winj2+"   "+Init.players[1].getName());
			//System.out.println("Bravo "+Init.players[0].getName()+"&"+Init.players[1].getName()+", l'égalité est parfaite");
			//System.out.println("Peut-être une autre partie pour vous départager ? :)");
		//}
	}
	public static void graph2vs2(){
		StdDraw.clear();
		StdDraw.setXscale(0, WINDOW_WIDTH);
		StdDraw.setYscale(0, WINDOW_HEIGHT);
		Init.InitialisationGraph();
		Init.affgraph();
		while (winj1<=Init.getCapmax() && winj2<=Init.getCapmax() ){
			System.out.println();
			Mov.Mouvement();	
		}
		if (winj1>Init.getCapmax()){
			//System.out.println("PLATEAU FINAL");
			//System.out.println();
			//Init.miseMaj();
			//System.out.println();
			//System.out.println("SCORE FINAL");
			//System.out.println(Init.players[0].getName()+"   "+Main.winj1+"-"+Main.winj2+"   "+Init.players[1].getName());
			//System.out.println("Bravo Vous avez gagné "+Init.players[0].getName()+",");
			//System.out.println("vous avez capturé plus de la moitié des pions ! :)");
		}
		if (winj2>Init.getCapmax()){
			//System.out.println("PLATEAU FINAL");
			//System.out.println();
			//Init.miseMaj();
			//System.out.println();
			//System.out.println("SCORE FINAL");
			//System.out.println(Init.players[0].getName()+"   "+Main.winj1+"-"+Main.winj2+"   "+Init.players[1].getName());
			//System.out.println("Bravo Vous avez gagné "+Init.players[1].getName()+",");
			//System.out.println("vous avez capturé plus de la moitié des pions ! :)");
		}
		//if (winj1==Init.getCapmax() && winj2==Init.getCapmax()){
			//Init.miseMaj();
			//System.out.println();
			//System.out.println("SCORE FINAL");
			//System.out.println(Init.players[0].getName()+"   "+Main.winj1+"-"+Main.winj2+"   "+Init.players[1].getName());
			//System.out.println("Bravo "+Init.players[0].getName()+"&"+Init.players[1].getName()+", l'égalité est parfaite");
			//System.out.println("Peut-être une autre partie pour vous départager ? :)");
		//}
	}
}