package Basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Allocate {
	
			public static int num = 4;//¼¸ÈË¼ä

			 public Map<String, String> getResult(List<Map.Entry<String,Double>> list) {
				Map<String,String>map = new HashMap<>();
        		int count=0;
        		int i=0;
//				for(int i=0;i<list.size();i++) {
//					if(i%num==0) {
//						count++;
//					}
//				  map.put(list, Integer.toString(count));
//				}
				for(Map.Entry<String, Double>a:list){
					   if(i%num==0) {
						   count++;
					   }
					   map.put(a.getKey(),Integer.toString(count));
					   i++;
				}
				return map;
			}
}
