package level01;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * ���α׷��ӽ� level 01 ���ϸ�
 * ã�ƶ� ���α׷��� ��������
 */
public class Task12 {

	public static void main(String[] args) {
		Solution12 s = new Solution12();
		
		System.out.println(s.solution(new int[] {3, 3, 3, 2, 2, 2}));
	}

}

class Solution12 {
	public int solution(int[] nums) {
        return Math.min(Arrays.stream(nums).boxed().collect(Collectors.toSet()).size(), nums.length/2);
    }
    
}

