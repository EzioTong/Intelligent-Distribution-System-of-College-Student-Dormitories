package View;

import java.util.HashMap;
import java.util.Map;

import Basic.Allocate;
import Basic.Rank;
import Model.Student;

public class ImportExcel{
	private Map<String,String>mapp;
	
	public Map<String,String>getMap(){
		return mapp;
	}
	
	public void Input(Map<String,Double>map1){	
		Rank rank=new Rank();
		Allocate amap=new Allocate();
	    mapp=amap.getResult(rank.getReport(map1));
	
	for (Map.Entry<String, String> entry1 : mapp.entrySet()) {
	    System.out.println(entry1.getKey() + " £º" + entry1.getValue());
	}
	
	
	
	
	
	
	
//	for(int i=0;i<s.length;i++) {
//		boolean gentle;
//		if(Math.random()<0.5) {
//			 gentle=true;
//		}else {
//			 gentle=false;
//		}
//		s[i]=new Student(Integer.toString(i),"a"+i,gentle,"18",Math.random()*100,Math.random()*100,Math.random()*100,Math.random()*100);
//		if(s[i].getSex()==true) {
//		map1.put("male  "+ s[i].getId()+" "+s[i].getName(),s[i].getScore());
//		}else {map2.put("female "+s[i].getId()+" "+s[i].getName(),s[i].getScore());}
//	} 

 
//	Map<>=ranklist.getReport(map1);
//	List list2=ranklist.getReport(map2);
// 	Map<String,Double>m1=rank.getReport(map1);
// 	for (Map.Entry<String, Double> entry : m1.entrySet()) {
//	    System.out.println(entry.getKey() + " £º" + entry.getValue());
//	}
	
//    for(int i = 0;i < list1.size();i++){
//        System.out.println(list1.get(i));
//    }
//	
//	
 }
}
