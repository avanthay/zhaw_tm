

import java.util.ArrayList;

public class Band {
	
	private ArrayList<String> bandArray;
	private int position;
	private int reference;
	private String name;
	
	public Band(String name){
		resetBand();
		this.name = name;
	}
	
	public void resetBand(){
		bandArray = new ArrayList<String>();
		for (int i = 0; i < 29; i++){
			bandArray.add(i, " ");
		}
		position = 0;
		reference = 0;
	}
	
	public void setString(int pos, String string){
		bandArray.set(pos, string);
	}
	
	public String getString(int pos){
		return bandArray.get(pos);
	}
	
	public void addString(int pos, String x){
		bandArray.add(pos, x);
	}
	
	public int getLength(){
		return bandArray.size();
	}

	public int getPosition() {
		return position;
	}
	
	public int getReference(){
		return this.reference;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	public void setReference(int reference){
		this.reference = reference;
	}
	
	public String getName(){
		return name;
	}
}
