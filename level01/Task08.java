package level01;

import java.util.*;

/*
 * 프로그래머스 level 01 같은 숫자는 싫어
 * 연습 문제
 */
public class Task08 {

	public static void main(String[] args) {
		Solution08 s = new Solution08();
		
		System.out.println(Arrays.toString(s.solution(new int[] {1, 1, 3, 3, 0, 1, 1})));
	}

}

class Solution08 {
	public int[] solution(int []arr) {
        int[] answerTmp = new int[arr.length];
        
        answerTmp[0] = arr[0];
        int cnt = 1;
        
        for(int i = 1; i < arr.length; i++)
        	if(answerTmp[cnt-1] != arr[i]) answerTmp[cnt++] = arr[i];
		
        return Arrays.copyOfRange(answerTmp, 0, cnt);
    }
}