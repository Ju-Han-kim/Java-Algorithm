package level01;

/*
 * ���α׷��ӽ� level 01 ���� ���ϱ�
 * ���� �ڵ� ç���� ����2
 */
public class Task09 {

	public static void main(String[] args) {
		Solution09 s = new Solution09();
		
		System.out.println(s.solution(new int[] {4, 7, 12}, new boolean[] {true, false, true}));
	}

}

class Solution09 {
	public int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;

		for(int idx = 0; idx < absolutes.length; idx ++)
			answer += signs[idx] ? absolutes[idx] : (-1) * absolutes[idx];
		
        return answer;
    }
}