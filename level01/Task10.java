package level01;

/*
 * 프로그래머스 level 01 내적
 * 월간 코드 챌린지 시즌1
 */
public class Task10 {
	
	public static void main(String[] args) {
		Solution10 s = new Solution10();
		
		System.out.println(s.solution(new int[] {1, 2, 3, 4},new int[] {-3, -1, 0, 2}));
	}
	
}

class Solution10 {
	public int solution(int[] a, int[] b) {
        int answer = 0;
        
        for(int i = 0; i<a.length; i++)
        	answer += a[i]*b[i];

        return answer;
    }
}