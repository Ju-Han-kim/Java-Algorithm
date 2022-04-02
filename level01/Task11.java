package level01;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 프로그래머스 level 01 소수 만들기
 * Summer/Winter Coding(~2018)
 */
public class Task11 {

	public static void main(String[] args) {
		Solution11 s = new Solution11();
		
		System.out.println(s.solution(new int[] {1, 2, 7, 6, 4}));
		
	}

}

class Solution11 {
    public int solution(int[] nums) {
    	int answer = 0;
    	PrimeNumber pn = new PrimeNumber();
		
        // 배열 정렬
        Arrays.sort(nums);
        
        // 소수 만들기
        pn.setPrimeNumberList(nums[0]+nums[1]+nums[2], nums[nums.length-3]+nums[nums.length-2]+nums[nums.length-1]);
        
        for(int i=0; i<nums.length-2; i++) {
        	for(int j=i+1; j<nums.length-1; j++) {
        		for(int k=j+1; k<nums.length; k++) {
        			if(pn.getPrimeList().contains(nums[i]+nums[j]+nums[k])) answer++;
        		}
        	}
        }
        
        return answer;
    }
    
}

class PrimeNumber{
	
	private ArrayList<Integer> primeList = new ArrayList<Integer>();
	
	// 범위에 따른 primNumber 생성
	public void setPrimeNumberList(int from, int to) {
		boolean flag = true;
		
		for(int i = from; i <= to; i++) {
			for(int tmp = 2; tmp < i; tmp++) {
				if(Math.floorMod(i, tmp) == 0) {
					flag = false;
					break;
				}
			}
			if(flag) this.primeList.add(i);
			flag = true;
		}
	}
	
	// 소수 리스트 return
	public ArrayList<Integer> getPrimeList(){
		return this.primeList;
	}
}