package level01;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * 프로그래머스 level 01 폰켓몬
 * 찾아라 프로그래밍 마에스터
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

