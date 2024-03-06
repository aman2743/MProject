import java.util.HashMap;

public class StringToCharArray {
	public static void main(String[] args) {
		String str = "My name is Aman Kumar";
		int len = str.length();
		int count;
		char c;
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < len; i++) {
			c = str.charAt(i);
			if (hm.containsKey(c)) {
				count = hm.get(c);
				count++;
				hm.replace(c, count);
			} else {
				hm.put(c, 1);
			}
		}
      for(Character key:hm.keySet()) {
    	  System.out.println(key+":"+hm.get(key));
    	  
    	  if(hm.get(key)==1) {
    		 System.out.println(key);
    		 break;
    	  }
      }
	}
}
