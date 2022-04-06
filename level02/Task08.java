package level02;

/*
 * 프로그래머스 level 02 게임 맵 최단거리
 * 찾아라 프로그래밍 마에스터
 * 
 */
public class Task08 {

	public static void main(String[] args) {
		Solution08 s = new Solution08();
		
		System.out.println(s.solution(new int[][] {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
		System.out.println(s.solution(new int[][] {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
	}

}

class Solution08 {
	
    public int solution(int[][] maps) {
        int answer = 0;
        return answer;
    }
    
}
