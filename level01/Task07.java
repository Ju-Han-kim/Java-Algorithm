package level01;

import java.util.*;
import java.util.stream.Collectors;

/*
 * ���α׷��ӽ� level 01 ���� ���� ���ϱ�
 * ���� �ڵ� ç���� ����3
 */
public class Task07 {
	
	public static void main(String[] args) {
		Solution07 s = new Solution07();
		
		System.out.println(s.solution(new int[] {5, 8, 4, 0, 6, 7, 9}));
	}
	
	
}

class Solution07 {
	
	public int solution(int[] numbers) {
		int answer = 0;
		
		Set<Integer> set = Arrays.stream(numbers).boxed().collect(Collectors.toSet());
		
		for(int i=0;i<10;i++) {
			if(!set.contains(i)) {
				answer += i;
			}
		}
		
        return answer;
    }
	
}
