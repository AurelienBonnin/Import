
public class Player {

	private String name;
	
	private char color;
	
	private int cap = 0;

	
	
	public Player(String name, char color, int cap) {
		super();
		this.name = name;
		this.color = color;
		this.cap = cap;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}
	
}
