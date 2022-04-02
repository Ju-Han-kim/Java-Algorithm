package level02;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 프로그래머스 level 02 기능개발
 * 스택/큐
 * 
 */
public class Task04 {

	public static void main(String[] args) {
		Solution04 s = new Solution04();

		System.out.println(Arrays.toString(s.solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1})));
	}

}

class Solution04 {
	
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        
        int cnt = 0;
        int beforeNeedsTime = 0;
        
        int nowDate = 0;
        
        for(int idx = 0; idx < progresses.length; idx++) {
        	Job job = new Job(progresses[idx], speeds[idx]);
        	
        	if(nowDate >= job.getNeedsTime()) {
        		answerList.set(answerList.size()-1, ++cnt);
        	} else {
        		if(beforeNeedsTime >= job.getNeedsTime()) {
        			answerList.set(answerList.size()-1, ++cnt);
        		} else {
        			answerList.add(1);
        			beforeNeedsTime = job.getNeedsTime();
        			nowDate = job.getNeedsTime();
        			cnt = 1;
        		}
        	}
        }
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}

class Job {
	
	private int progress;
	private int speed;
	
	public Job(int progress, int speed) {
		this.progress = progress;
		this.speed = speed;
	}
	
	public int getNeedsTime() {
		return (int)Math.ceil((100-this.progress)*1.0/speed);
	}
	
}