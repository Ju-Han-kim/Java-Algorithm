package level01;

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
		String answer = "";
//		1�ܰ� new_id�� ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ�մϴ�.
		
//		2�ܰ� new_id���� ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� �����մϴ�.
		
//		3�ܰ� new_id���� ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ�մϴ�.
		
//		4�ܰ� new_id���� ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� �����մϴ�.
		
//		5�ܰ� new_id�� �� ���ڿ��̶��, new_id�� "a"�� �����մϴ�.
		
//		6�ܰ� new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� �����մϴ�.
//		     ���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� �����մϴ�.
		
//		7�ܰ� new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�
		
		return answer;
	}
	
	
}