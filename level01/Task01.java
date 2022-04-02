package level01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * 프로그래머스 level 01 숫자 문자열과 영단어
 * 2021 카카오 채용연계형 인턴십
 */
public class Task01 {
	
	public static void main(String[] args) {
		
		Method method = new Method();
//		System.out.println(method.solution("one4seveneight"));
//		System.out.println(method.solution("23four5six7"));
//		System.out.println(method.solution("2three45sixseven"));
//		System.out.println(method.solution("123"));
		System.out.println(method.solution("zerofourfivesix1seveneightnineninezero"));
		
	}
	
}

class Method{
	int solution(String s) {
		
		String s_tmp = s.toLowerCase();
		
		
		List<String> chCode = new ArrayList<String>();
		
		chCode.add("zero");
		chCode.add("one");
		chCode.add("two");
		chCode.add("three");
		chCode.add("four");
		chCode.add("five");
		chCode.add("six");
		chCode.add("seven");
		chCode.add("eight");
		chCode.add("nine");
		
		HashMap<Character, String> numIndex = setIndex(chCode);
		
		int i = 0;
		
		while(i < s.length() - 1) {
			if(!isNum(s.charAt(i)) && numIndex.containsKey(s.charAt(i))) {
				String[] str = numIndex.remove(s.charAt(i)).split(",");
				
				for(String tmpKey : str) {
					if(s_tmp.contains(tmpKey)) {
						s_tmp = s_tmp.replaceAll(tmpKey, String.valueOf(chCode.indexOf(tmpKey)));
						if(s.charAt(i) - '0' == chCode.indexOf(tmpKey))
							i += tmpKey.length();
					}
				}
                if(numIndex.isEmpty())
					break;
			} else {
				i++;
			}
		}
		
		int answer = Integer.parseInt(s_tmp);
		return answer;
	}
	
	HashMap<Character, String> setIndex(List<String> chCode){
		
		HashMap<Character, String> numIndex = new HashMap<Character, String>();
		
		for(String key : chCode) {
			String tmpKey = numIndex.get(key.charAt(0)); 
			if(tmpKey == null){
				numIndex.put(key.charAt(0), key);
			} else {
				numIndex.put(key.charAt(0), tmpKey+ "," + key);
			}
		}
		
		return numIndex;
	}
	
	boolean isNum(char a) {
		return (a >= '0' && a <= '9') ? true : false;
	}
}
