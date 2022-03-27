package level01;

import java.util.HashMap;
import java.util.Stack;

/*
 * 프로그래머스 level 01 크레인 인형뽑기 게임
 * 2019 카카오 개발자 겨울 인턴십
 */
public class Task06 {

	public static void main(String[] args) {
		Solution06 s = new Solution06();
		
		System.out.println(s.solution(new int[][] {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[] {1, 5, 3, 5, 1, 2, 1, 4}));

	}

}

class Solution06 {
	
	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        // 바구니 Stack
        Basket basket = new Basket();
        
        HashMap<Integer, Stack<Integer>> crain = new HashMap<Integer, Stack<Integer>>();
        
        // Make crain map
        for(int size = 0; size < board.length; size++) {
        	Stack<Integer> part = new Stack<Integer>();
        	
        	for(int partition = 0; partition < board.length; partition++) {
        		if(board[board.length-partition-1][size] != 0) {
        			part.push(board[board.length-partition-1][size]);
        		} else {
        			break;
        		}
        	}
        	crain.put(size + 1, part);
        }
        
        // 실행
        for(int move : moves) 
        	if(!crain.get(move).isEmpty())	basket.pushElement(crain.get(move).pop());
        
        answer = basket.getPopCount() * 2;
        
        return answer;
    }
	
}

class Basket {
	
	Stack<Integer> basket = new Stack<Integer>();
	
	private int popCount = 0;
	
	public void pushElement(int element) {
		if(!basket.isEmpty() && basket.peek() == element) {
			basket.pop();
			this.popCount++;
		} else {
			basket.push(element);
		}
	}
	
	public int getPopCount() {
		return this.popCount;
	}
	
}