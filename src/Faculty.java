

import java.util.ArrayList;

public class Faculty extends Config {

	private ArrayList<String> configArray;

	
	public Faculty(){
		configArray = new ArrayList<>();
		configArray.add(0, "1  ,11 ,RRS,0/   ,   ,LLS,1");
		configArray.add(1, "11 ,1  ,SLS,2/   ,1  ,SSS,2");
		configArray.add(2, "11 ,111,LSR,2/ 1 , 1 ,RLS,3/1  ,1  ,SRS,7/111,111,LSR,2");
		configArray.add(3, "11 ,111,RSR,3/ 1 , 1 ,LLS,2/111,111,RSR,3/1  ,1  ,SRS,4");
		configArray.add(4, "11 ,1  ,SRL,5");
		configArray.add(5, "111,111,RSL,5/ 11,111,RSL,5/ 1 , 1 ,LRS,6/1 1,1 1,LSR,10");
		configArray.add(6, "1  ,1  ,SLR,2/11 ,11 ,SRS,6");
//		configArray.add(7, "11 ,1  ,SRL,8/1  ,111,SSS,5");
		configArray.add(7, "11 ,1  ,SRL,8/1  ,111,SSS,5");
		configArray.add(8, "111,111,LSL,8/ 11,111,LSL,8/ 1 , 1 ,RRS,9/1  ,111,LSL,8/1 1,1 1,RSR,10");
		configArray.add(9, "11 ,11 ,SRS,9/1  ,1  ,SLR,3");
		configArray.add(10, "final");
	}
	
	@Override
	public String getString(int x) {
		return configArray.get(x);
	}
}
