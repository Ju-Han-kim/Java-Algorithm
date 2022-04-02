package level02;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 프로그래머스 level 02 단체사진 찍기
 * 2017 카카오코드 본선
 * 
 */
public class Task01 {

	public static void main(String[] args) {
		Solution01 s = new Solution01();
		
		System.out.println(s.solution(2, new String[] {"N~F=0", "R~T>2"}));
		System.out.println(s.solution(2, new String[] {"M~C<2", "C~M>1"}));
	}

}


class Solution01 {
	public int solution(int n, String[] data) {
        
        // 최초 값 셋팅
        PictureCase pictureCase = new PictureCase();
        Calc calc = new Calc();
        
        // 조건에 따른 경우의 수 생성
        for(String dataUni : data) {
//        	System.out.println(dataUni + " 요청! ");
        	pictureCase.addCase(dataUni, false);
        }
        
        // 최종 경우의 수 * 나머지 요소 배열
        return pictureCase.cntCases() * calc.factorial(8-pictureCase.cntConditionElements());
        
    }
    
}

class PictureCase {
	
	private HashSet<String> cases;
	private HashSet<Character> conditionElements;
	
	public PictureCase() {
		this.cases = new HashSet<String>(); 
		this.conditionElements = new HashSet<Character>();
		
		// {A, C, F, J, M, N, R, T} 8명 초기화
		this.cases.add("00000000");
	}
	
	// 조건 추가에 따른 Case 저장
	public HashSet<String> addCase(String inputCase, boolean subFlag) {
//		System.out.println("====================== 요청 시작 ==================");
		HashSet<String> tmp = new HashSet<String>();
		Matcher matcher;
		
		// 조건을 정규표현식으로 변경
		/*
		 * [0](\\w{3})[a]
		 */
		Character[] caseArr = new Character[] {inputCase.charAt(0), inputCase.charAt(2)};
		Character[] regArr = new Character[] {'0', '0'};
		int partNum = Integer.parseInt(inputCase.substring(4));
		
//		System.out.println("caseArr 초기값 : "+Arrays.toString(caseArr));
//		System.out.println("regArr 초기값 : "+Arrays.toString(regArr));
		
		// 부등호에서 중복 태울 때 값이 이상해짐.
		
		
//		System.out.println("조건값 Set : " + conditionElements.toString());
//		
//		System.out.println("caseArr 변경 후 : "+Arrays.toString(caseArr));
//		System.out.println("regArr 변경 후 : "+Arrays.toString(regArr));
		
		switch (inputCase.charAt(3)) {
			case '=':
//				System.out.println("= 진입!");
				// 0, 2 인덱스 조건에 있는 구분자를 가져와 기존 조건 부여여부 확인
				for(int idx = 0; idx < 2; idx++) {
					if(this.conditionElements.contains(caseArr[idx])) {
						regArr[idx] = caseArr[idx];
					}
				}
				
				for(int index = 0; index < 2; index++) {
					String reg = new StringBuilder("[").append(regArr[index]).append("](\\w{").append(partNum).append("})[").append(regArr[1-index]).append("]").toString();
					Pattern pattern = Pattern.compile(reg);
//					System.out.println("reg : " + reg);
					for(String caseUni : cases) {
						matcher = pattern.matcher(caseUni);
//						System.out.println("caseUni : " + caseUni);
						int i = 0;
						while(matcher.find(i)) {
							i = matcher.start() + 1;
							tmp.add(caseUni.substring(0, i-1) + caseUni.substring(i-1).replaceFirst(reg, caseArr[index] + matcher.group().substring(1, partNum+1) + caseArr[1-index]));
						}
					}
				}
				if(subFlag) return tmp;
				break;
			case '>':
//				System.out.println("> 진입!");
				for(int i = partNum+1; i <= 6; i++) {
					tmp.addAll(addCase(inputCase.replace(">"+partNum, "="+i), true));
				}
				break;
			case '<':
//				System.out.println("< 진입!");
				for(int i = partNum-1; i >= 0; i--) {
					tmp.addAll(addCase(inputCase.replace("<"+partNum, "="+i), true));
				}
				break;
		}
		
		// 후처리
		this.conditionElements.add(caseArr[0]);
		this.conditionElements.add(caseArr[1]);
		this.cases = tmp;
		
//		System.out.println("최종결과 : " + cases.toString());
		return this.cases;
	}
	
	public int cntCases() {
		return cases.size();
	}
	
	public int cntConditionElements() {
		return conditionElements.size();
	}
	
}

class Calc {
	public int factorial(int num) {
		if(num <= 1) 
			return 1;
		else
			return num * factorial(num - 1); 
	}
}