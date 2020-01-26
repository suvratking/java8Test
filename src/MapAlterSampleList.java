import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapAlterSampleList {
	
	public static void main(String[] args) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				
		for(int i = 1; i <=4; i++) {
			Map<String, Object> map = new HashMap<>();
			String block_name = "Angul";
			String ind_name = null;
			if(i > 2) block_name = "Athamalik";
			if(i == 1 || i == 3) ind_name = "ind1";
			else ind_name = "ind2";
			map.put("block_name", block_name);
			map.put("ind_name", ind_name);
			map.put("rank", i);
			list.add(map);
		}
		
		System.out.println(list);
	}
	
}
