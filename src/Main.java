import java.awt.Font;

import edu.princeton.cs.introcs.StdDraw;

public class Main {
	
	static int winj1 = 0; 

	static int winj2 = 0;
	
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
		Init.JMaj(Init.size);//
		//Init.miseMaj();//
		Init.affgraph();
		String tourdraw = "Tour "+Mov.tourj;
		StdDraw.text(92,Init.size*102+254,tourdraw);
		String scoredraw ="Score: "+Init.players[0].getName()+"   "+Main.winj1+"-"+Main.winj2+"   "+Init.players[1].getName();
		StdDraw.text((Init.size-4)*102+22,Init.size*102+254,scoredraw);
		String jouedraw =Init.players[0].getName()+", à votre tour quelle couleur voulez-vous jouer ?";
		StdDraw.text((Init.size/2)*102+51,Init.size*102+152,jouedraw);
		Init.affgraph();
		//System.out.println(Init.plateau.length);
		//System.out.println(Init.size);
		while (winj1<=Init.getCapmax() && winj2<=Init.getCapmax() ){
			//System.out.println("lol");
			Mov.Mouvementgraph();	
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