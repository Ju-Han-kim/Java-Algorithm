package level01;

import java.util.Arrays;
import java.util.HashSet;

/*
 * 프로그래머스 level 01 신규 아이디 추천
 * 2021 KAKAO BLIND RECRUITMENT
 */
public class Task04 {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		System.out.println(s.solution("...!@BaT#*..y.abcdefghijklm"));
		System.out.println(s.solution("z-+.^."));
		System.out.println(s.solution("=.="));
		System.out.println(s.solution("123_.def"));
		System.out.println(s.solution("abcdefghijklmn.p"));
		System.out.println(s.solution(""));
	}
	
}

class Solution {
	
	public String solution(String new_id) {
		
		String answer = new_id;
		
//		1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
		answer = answer.toLowerCase();
		
//		2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
		String nonStr = "~ ! @ # $ % ^ & * ( ) = + [ { ] } : ? , < > /";
		HashSet<String> nonSet = new HashSet<String>(Arrays.asList(nonStr.split(" ")));
		
		for(String s : nonSet) {
			answer = answer.replace(s, "");
		}
		
//		3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
		while(answer.contains("..")) {
			answer = answer.replace("..", ".");
		}
		
//		4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
		if(answer.length() != 0 && answer.charAt(0) == '.') {
			answer = answer.substring(1);
		}
		if(answer.length() != 0 && answer.charAt(Math.max(answer.length()-1, 0)) == '.') {
			answer = answer.substring(0, Math.max(answer.length()-1, 0));
		}
		
//		5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
		if(answer.length() == 0)
			answer = "a";
		
//		6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//		     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
		if(answer.length() >= 16)
			answer = answer.substring(0, answer.charAt(14) == '.' ? 14 : 15);
		
//		7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다
		if(answer.length() <= 2) {
			char s = answer.charAt(answer.length() - 1);
			for(int cnt = answer.length(); cnt < 3; cnt++) {
				answer = answer + s;
			}
		}
		
		return answer;
	}
	
}



