package level02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/*
 * 프로그래머스 level 02 오픈채팅방
 * 2019 KAKAO BLIND RECRUITMENT
 * 
 */
public class Task03 {

	public static void main(String[] args) {
		Solution03 s = new Solution03();

		System.out.println(Arrays.toString(s.solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan", "Change uid1234 Ryan"})));
	}

}

class Solution03 {
    public String[] solution(String[] record) {
        return process(record);
    }
    
    public String[] process(String[] msgStr) {
    	
    	HashMap<String, String> idMap = new HashMap<String, String>();
    	
    	ArrayList<String> list = new ArrayList<String>();
    	String[] id = new String[msgStr.length];
    	
    	for(String msgUni : msgStr){
    		String[] message = msgUni.split(" ");
    		
	    	switch (message[0]) {
				case "Enter":
					id[list.size()] = message[1];
					list.add("님이 들어왔습니다.");
				case "Change":
					idMap.put(message[1].trim(), message[2].trim());
					break;
				case "Leave":
					id[list.size()] = message[1];
					list.add("님이 나갔습니다.");
					break;
	    	}
    	}
    	
    	int idx = 0;
    	String[] answer = new String[list.size()];
    			
    	for(String str : list) {
    		answer[idx] = idMap.get(id[idx++]) + str;
    	}
    	
    	return answer;
    }

}
