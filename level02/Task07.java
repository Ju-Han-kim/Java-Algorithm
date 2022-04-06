package level02;

/*
 * 프로그래머스 level 02 멀쩡한 사각형
 * Summer/Winter Coding(2019)
 * 
 */
public class Task07 {

	public static void main(String[] args) {
		Solution07 s = new Solution07();
		
		System.out.println(s.solution(8, 12));
	}

}

class Solution07 {
    public long solution(int w, int h) {
    	long gcd = gcd(w, h);
        
        // (전체 개수) - (꼭짓점 지나는 기준 사라지는 단위 개수) * 포함 수
        long answer = ((long)w * h) - ( w/gcd + h/gcd - 1 ) * gcd;
        
        return answer;
    }
    
    public long gcd(long p, long q) {
    	if (q == 0) return p;
    	return gcd(q, p % q);
    }
}
