package level01;

/*
 * ���α׷��ӽ� level 01 ����
 * ���� �ڵ� ç���� ����1
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