package level02;

import java.util.Arrays;

/*
 * 프로그래머스 level 02 행렬 테두리 회전하기
 * 2021 Dev-Matching: 웹 백엔드 개발
 * 
 */
public class Task06 {

	public static void main(String[] args) {
		Solution06 s = new Solution06();
		
		System.out.println(Arrays.toString(s.solution(6, 6, new int[][] {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}})));
		System.out.println(Arrays.toString(s.solution(3, 3, new int[][] {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}})));
		System.out.println(Arrays.toString(s.solution(100, 97, new int[][] {{1, 1, 100, 97}})));
		
	}

}

class Solution06 {
	
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        Box box = new Box(rows, columns);
        
        for(int i = 0; i < queries.length; i++) {
        	answer[i] = box.process(queries[i]); 
        }
        
        return answer;
    }
	
}

class Box {
	
	private int rows;
	private int columns;
	
	private int[][] box;
	
	public Box(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		
		init();
	}
	
	private void init() {
		this.box = new int[this.rows][this.columns];
		
		int num = 1;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				this.box[i][j] = num++;
			}
		}
	}
	
	public int process(int[] query) {
		
		int x1 = query[0] - 1;
		int y1 = query[1] - 1;
		int x2 = query[2] - 1;
		int y2 = query[3] - 1;
		
		int tmp = box[x1][y1];
		int min = box[x1][y1];
		
		for(int x = x1; x < x2; x++) {
			box[x][y1] = box[x + 1][y1];
			min = Math.min(min, box[x][y1]);
		}
		
		for(int y = y1; y < y2; y++) {
			box[x2][y] = box[x2][y + 1];
			min = Math.min(min, box[x2][y]);
		}
		
		for(int x = x2; x > x1; x--) {
			box[x][y2] = box[x - 1][y2];
			min = Math.min(min, box[x][y2]);
		}
		
		for(int y = y2; y > y1; y--) {
			box[x1][y] = box[x1][y - 1];
			min = Math.min(min, box[x1][y]);
		}
		
		box[x1][y1 + 1] = tmp;
		
		return min;
	}
}
