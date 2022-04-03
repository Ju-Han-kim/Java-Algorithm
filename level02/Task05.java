package level02;

/*
 * 프로그래머스 level 02 문자열 압축
 * 2020 KAKAO BLIND RECRUITMENT
 * 
 */
public class Task05 {

	public static void main(String[] args) {
		Solution05 s = new Solution05();
		
		System.out.println(s.solution("aabbaccc"));
		System.out.println(s.solution("ababcdcdababcdcd"));
		System.out.println(s.solution("abcabcdede"));
		System.out.println(s.solution("abcabcabcabcdededededede"));
		System.out.println(s.solution("xababcdcdababcdcd"));
		System.out.println(s.solution("a"));
	}

}

class Solution05 {
	public int solution(String s) {
        int minZipLength = 1001;
        
        for(int i = 1; i <= s.length()/2 + 1; i++) {
        	Zip zip = new Zip(s, i);
        	minZipLength = Math.min(minZipLength, zip.getZipStr().length());
        }
        return minZipLength;
    }
}

class Zip {
	
	private String beforeStr;
	private String zipStr;
	private int zipNum;
	
	public Zip(String beforeStr, int zipNum) {
		this.beforeStr = beforeStr;
		this.zipNum = zipNum;
		
		this.doZip();
	}
	
	public void doZip() {
		StringBuffer zipStrBuffer = new StringBuffer();
		int repeatNum = 1;
		
		int i = 0;
		while(true) {
			if(beforeStr.substring(i + zipNum).indexOf(beforeStr.substring(i, i + zipNum)) == 0) {
				repeatNum++;
			} else {
				if(repeatNum != 1) {
					zipStrBuffer.append(repeatNum);
					repeatNum = 1;
				}
				zipStrBuffer.append(beforeStr.substring(i, i + zipNum));
			}
			
			i += zipNum;
			
			if(i + zipNum > beforeStr.length()) {
				zipStrBuffer.append(beforeStr.substring(i));
				break;
			} else if(i == beforeStr.length()) {
				break;
			}
		}
		
		zipStr = zipStrBuffer.toString();
	}
	
	public String getZipStr() {
		return this.zipStr;
	}
	
}