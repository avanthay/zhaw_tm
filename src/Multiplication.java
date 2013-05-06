

import java.util.ArrayList;

public class Multiplication extends Config {
	
	private ArrayList<String> configArray;

	
	public Multiplication(){
		configArray = new ArrayList<String>();
		configArray.add(0, "1  , 1 ,RRS,0/x  ,   ,RSS,1/   ,   ,SSS,4");
		configArray.add(1, "1  ,1  ,SLS,2/   ,   ,SSS,4");
		configArray.add(2, "11 ,11 ,SLS,2/1  ,1  ,SRS,3");
		configArray.add(3, "1  ,   ,RSS,1/11 ,111,SRR,3");
		configArray.add(4, "final");
	}

	@Override
	public String getString(int x) {
		return configArray.get(x);
	}

}
