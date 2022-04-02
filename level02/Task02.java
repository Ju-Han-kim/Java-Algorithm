package level02;

import java.util.Arrays;

/*
 * 프로그래머스 level 02 카카오 프렌즈 컬러링북
 * 2017 카카오코드 예선
 * 
 */
public class Task02 {

	public static void main(String[] args) {
		Solution02 s = new Solution02();

		System.out.println(Arrays.toString(s.solution(6, 4, new int[][] { { 1, 1, 1, 0 }, { 1, 1, 1, 0 },
				{ 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 } })));
	}

}

class Solution02 {
	int[][] pictureSnap;
	boolean[][] chkPicture;
	int max = 0;
	int cnt = 0;

	public int[] solution(int m, int n, int[][] picture) {

		pictureSnap = picture;
		chkPicture = new boolean[m][n];

		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				if (pictureSnap[row][col] == 0 || chkPicture[row][col])
					continue;
				int tmpCnt = getArea(pictureSnap[row][col], row, col);
				if (tmpCnt > 0) {
					cnt++;
					max = max > tmpCnt ? max : tmpCnt;
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = cnt;
		answer[1] = max;
		return answer;
	}

	public int getArea(int val, int row, int col) {
		if (isEnd(row, col) || chkPicture[row][col])
			return 0;

		if (pictureSnap[row][col] != val)
			return 0;
		chkPicture[row][col] = true;

		return 1 + getArea(pictureSnap[row][col], row - 1, col) + getArea(pictureSnap[row][col], row, col - 1)
				+ getArea(pictureSnap[row][col], row + 1, col) + getArea(pictureSnap[row][col], row, col + 1);
	}

	public boolean isEnd(int row, int col) {
		if (row >= chkPicture.length || row < 0 || col >= chkPicture[0].length || col < 0)
			return true;
		return false;
	}

}
