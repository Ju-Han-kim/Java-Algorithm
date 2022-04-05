package level02;

/*
 * 프로그래머스 level 02 행렬 테두리 회전하기
 * 2021 Dev-Matching: 웹 백엔드 개발
 * 
 */
public class Task06 {

	public static void main(String[] args) {
		Solution06 s = new Solution06();
		
		System.out.println(s.solution(6, 6, new int[][] {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}));
		System.out.println(s.solution(3, 3, new int[][] {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}}));
		System.out.println(s.solution(100, 97, new int[][] {{1, 1, 100, 97}}));
		
	}

}

class Solution06 {
	
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        return answer;
    }
	
}
