package level01;

import java.util.Arrays;
import java.util.HashSet;

/*
 * ���α׷��ӽ� level 01 �ű� ���̵� ��õ
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
		
//		1�ܰ� new_id�� ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ�մϴ�.
		answer = answer.toLowerCase();
		
//		2�ܰ� new_id���� ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� �����մϴ�.
		String nonStr = "~ ! @ # $ % ^ & * ( ) = + [ { ] } : ? , < > /";
		HashSet<String> nonSet = new HashSet<String>(Arrays.asList(nonStr.split(" ")));
		
		for(String s : nonSet) {
			answer = answer.replace(s, "");
		}
		
//		3�ܰ� new_id���� ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ�մϴ�.
		while(answer.contains("..")) {
			answer = answer.replace("..", ".");
		}
		
//		4�ܰ� new_id���� ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� �����մϴ�.
		if(answer.length() != 0 && answer.charAt(0) == '.') {
			answer = answer.substring(1);
		}
		if(answer.length() != 0 && answer.charAt(Math.max(answer.length()-1, 0)) == '.') {
			answer = answer.substring(0, Math.max(answer.length()-1, 0));
		}
		
//		5�ܰ� new_id�� �� ���ڿ��̶��, new_id�� "a"�� �����մϴ�.
		if(answer.length() == 0)
			answer = "a";
		
//		6�ܰ� new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� �����մϴ�.
//		     ���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� �����մϴ�.
		if(answer.length() >= 16)
			answer = answer.substring(0, answer.charAt(14) == '.' ? 14 : 15);
		
//		7�ܰ� new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�
		if(answer.length() <= 2) {
			char s = answer.charAt(answer.length() - 1);
			for(int cnt = answer.length(); cnt < 3; cnt++) {
				answer = answer + s;
			}
		}
		
		return answer;
	}
	
}



