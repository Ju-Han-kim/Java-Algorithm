package level01;

import java.util.HashMap;

public class Task01 {
	
	public static void main(String[] args) {
		
		Method method = new Method();
//		System.out.println(method.solution("one4seveneight"));
//		System.out.println(method.solution("23four5six7"));
//		System.out.println(method.solution("2three45sixseven"));
//		System.out.println(method.solution("123"));
		System.out.println(method.solution("zeroonetwothreefourfivesixseveneightninenine"));
		
	}
	
}

class Method{
	int solution(String s) {
		
		String s_tmp = s.toLowerCase();
		
		HashMap<String, Integer> chCode = new HashMap<String, Integer>();
		
		chCode.put("zero", 0);
		chCode.put("one", 1);
		chCode.put("two", 2);
		chCode.put("three", 3);
		chCode.put("four", 4);
		chCode.put("five", 5);
		chCode.put("six", 6);
		chCode.put("seven", 7);
		chCode.put("eight", 8);
		chCode.put("nine", 9);
		
		HashMap<Character, String> numIndex = setIndex(chCode);
		
		int i = 0;
		
		while(i < s.length()) {
			if(!isNum(s.charAt(i))) {
				String[] str = numIndex.get(s.charAt(i)).split(",");
				
				for(String tmpKey : str) {
					if(s_tmp.contains(tmpKey)) {
						s_tmp = s_tmp.replaceFirst(tmpKey, chCode.get(tmpKey).toString());
						i += tmpKey.length();
					}
				}
			} else {
				i++;
			}
		}
		
		int answer = Integer.parseInt(s_tmp);
		return answer;
	}
	
	HashMap<Character, String> setIndex(HashMap<String, Integer> chCode){
		
		HashMap<Character, String> numIndex = new HashMap<Character, String>();
		
		for(String key : chCode.keySet()) {
			String tmpKey = numIndex.get(key.charAt(0)); 
			if(tmpKey == null){
				numIndex.put(key.charAt(0), key + ",");
			} else {
				numIndex.put(key.charAt(0), tmpKey + key);
			}
		}
		
		return numIndex;
	}
	
	boolean isNum(char a) {
		return (a-'0' >= 0 && a-'0' < 10) ? true : false;
	}
}
