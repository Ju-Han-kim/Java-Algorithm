package level01;

/*
 * 프로그래머스 level 01 로또의 최고 순위와 최저 순위
 * 2021 Dev-Matching : 웹 백엔드 개발
 */
public class Task02 {
	
	public static void main(String[] args) {
		
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		
		int min = 7;
		int cnt = 0;
		
		for(int i : lottos) {
			if (i == 0){
				cnt++;
				continue;
			}
			for(int j : win_nums) {
				if(i == j) {
					min--;
					break;
				}
			}
		}
		
		min = min==7 ? 6 : min;
		
		System.out.println("max : "+ (min<cnt?1:min-cnt) + " / min : " + min);
		
	}
	
}
