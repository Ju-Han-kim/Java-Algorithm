package level02;

import java.util.Arrays;

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
	
	// 상하좌우 이동 초기셋팅
	int[] rowCon = new int[] {-1, 1, 0, 0};
	int[] colCon = new int[] {0, 0, -1, 1};
	int[] init;
	
    public int solution(int[][] maps) {
    	init = new int[] {maps.length, maps[0].length};
        
        return getMinPath(0, 0, maps);
    }
    
    public int getMinPath(int nowRow, int nowCol, int[][] maps) {
    	
    	int minPath = 10000;
    	int pathCase = 0;
    	
    	maps[nowRow][nowCol] = 0;
    	// 상하좌우 검증
    	for(int i = 0; i < 4; i++) {
    		if(nowRow + rowCon[i] < 0 || nowCol + colCon[i] < 0 || nowRow + rowCon[i] >= init[0] || nowCol + colCon[i] >= init[1]) continue;
    		
    		if(maps[nowRow + rowCon[i]][nowCol + colCon[i]] == 1) {
    			int[][] mapCopy = new int[init[0]][init[1]];
    			
    			for(int row=0;row<init[0];row++) {
    				for(int col=0;col<init[1];col++) {
    					mapCopy[row][col] = maps[row][col];
    				}
    			}
    			
    			int tmpMinPath = getMinPath(nowRow + rowCon[i], nowCol + colCon[i], mapCopy);
    			minPath = tmpMinPath == 10001 ? 10001 : Math.min(minPath, 1 + tmpMinPath);
    			pathCase++;
    		}
    	}
    	
    	if(nowRow == init[0] - 1 && nowCol == init[1] - 1) return 1;
    	else if(pathCase == 0) return 10000;
    	else if(minPath == 10001) return -1;
    	else return minPath;
    }
    
}
















