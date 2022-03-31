package level02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/*
 * 프로그래머스 level 02 카카오 프렌즈 컬러링북
 * 2017 카카오코드 예선
 * 
 */
public class Task02 {

	public static void main(String[] args) {
		Solution02 s = new Solution02();
		
		System.out.println(Arrays.toString(s.solution(6, 4, new int[][] {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}})));
	}

}


class Solution02 {
    public int[] solution(int m, int n, int[][] picture) {
        int[][] convertArea = new int[m][n];
        
        ArrayList<Integer> areaList = new ArrayList<Integer>();
        
        
        /*
         * 001
         * 111
         * 위 케이스에 에러 발생
         */
//        for(int row = 0; row < m; row++) {
//        	for(int col = 0; col < n; col++) {
//        		if(picture[row][col] == 0) continue;
//        		
//        		if(row != 0 && picture[row][col] == picture[row-1][col]){
//        			convertArea[row][col] = convertArea[row-1][col];
//        			areaList.set(convertArea[row-1][col], areaList.get(convertArea[row-1][col]) + 1);
//        		} else if (col != 0 && picture[row][col] == picture[row][col-1]) {
//        			
//        			
//        			
//        			convertArea[row][col] = convertArea[row][col-1];
//        			areaList.set(convertArea[row][col-1], areaList.get(convertArea[row][col-1]) + 1);
//        		} else {
//        			areaList.add(1);
//        			convertArea[row][col] = areaList.size()-1;
//        		}
//        	}
//        }
        
        
        //
        
        System.out.println(areaList.toString());
        
        int[] answer = new int[2];
        answer[0] = areaList.size();
        answer[1] = Collections.max(areaList);
        return answer;
        
        
    }
    boolean isEquals() {
    	
    	return true;
    }
    
}
