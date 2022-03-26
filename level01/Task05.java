package level01;

import java.util.*;

/*
 * 프로그래머스 level 01 키패드 누르기
 * 2020 카카오 인턴십
 */
public class Task05 {

	public static void main(String[] args) {
		
		Solution05 s = new Solution05();
		
		System.out.println(s.solution(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
		System.out.println(s.solution(new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
		
	}

}

class Solution05 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        TouchKeypad touchKeypad = new TouchKeypad();
        
        for(int number : numbers) {
        	if(number == 0)
        		number = 11;
        	
        	char flag;
        	
        	if(number == 1 || number == 4 || number == 7) {
        		flag = 'L';
        	} else if (number == 3 || number == 6 || number == 9) {
        		flag = 'R';
        	} else {
        		if(touchKeypad.get_left_distance(number) > touchKeypad.get_right_distance(number)) {
        			flag = 'R';
        		} else if (touchKeypad.get_left_distance(number) < touchKeypad.get_right_distance(number)) {
        			flag = 'L';
        		} else {
        			flag = hand.toUpperCase().charAt(0);
        		}
        	}
        	answer += flag;
        	touchKeypad.set_finger(flag, number);
        }
        
        
        return answer;
    }
}

class TouchKeypad {
	
	private int left;
	private int right;
	
	public TouchKeypad() {
		this.left = 10;
		this.right = 12;
	}
	
	public int get_left_distance(int input_num) {
		int[] left_idx = get_idx(this.left);
		int[] input_num_idx = get_idx(input_num);
		
		return (Math.abs(input_num_idx[0] - left_idx[0]) + Math.abs(input_num_idx[1] - left_idx[1]));
	}
	
	public int get_right_distance(int input_num) {
		int[] right_idx = get_idx(this.right);
		int[] input_num_idx = get_idx(input_num);
		
		return (Math.abs(input_num_idx[0] - right_idx[0]) + Math.abs(input_num_idx[1] - right_idx[1]));
	}
	
	private int[] get_idx(int num) {
		return new int[] {(num - 1)/3, Math.floorMod(num - 1, 3)};
	}
	
	public void set_finger(char flag, int number) {
		if(flag == 'L')
			this.left = number;
		else
			this.right = number;
	}
	
}