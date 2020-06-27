package Basic;

import java.util.*;

public class  Rank {
	
	
	public List<Map.Entry<String, Double>>getReport(Map<String,Double> report) {
        List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(report.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {            //Ωµ–Ú≈≈–Ú
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                //return o1.getValue().compareTo(o2.getValue());
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<String, Double> mapping : list) {
            report.put(mapping.getKey(),mapping.getValue());
            System.out.println(mapping.getKey() + " " + mapping.getValue());
        }

        return list;
    }
}
