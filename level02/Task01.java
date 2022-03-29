package level02;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * ���α׷��ӽ� level 02 ��ü���� ���
 * 2017 īī���ڵ� ����
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
        
        // ���� �� ����
        PictureCase pictureCase = new PictureCase();
        Calc calc = new Calc();
        
        // ���ǿ� ���� ����� �� ����
        for(String dataUni : data) {
//        	System.out.println(dataUni + " ��û! ");
        	pictureCase.addCase(dataUni, false);
        }
        
        // ���� ����� �� * ������ ��� �迭
        return pictureCase.cntCases() * calc.factorial(8-pictureCase.cntConditionElements());
        
    }
    
}

class PictureCase {
	
	private HashSet<String> cases;
	private HashSet<Character> conditionElements;
	
	public PictureCase() {
		this.cases = new HashSet<String>(); 
		this.conditionElements = new HashSet<Character>();
		
		// {A, C, F, J, M, N, R, T} 8�� �ʱ�ȭ
		this.cases.add("00000000");
	}
	
	// ���� �߰��� ���� Case ����
	public HashSet<String> addCase(String inputCase, boolean subFlag) {
//		System.out.println("====================== ��û ���� ==================");
		HashSet<String> tmp = new HashSet<String>();
		Matcher matcher;
		
		// ������ ����ǥ�������� ����
		/*
		 * [0](\\w{3})[a]
		 */
		Character[] caseArr = new Character[] {inputCase.charAt(0), inputCase.charAt(2)};
		Character[] regArr = new Character[] {'0', '0'};
		int partNum = Integer.parseInt(inputCase.substring(4));
		
//		System.out.println("caseArr �ʱⰪ : "+Arrays.toString(caseArr));
//		System.out.println("regArr �ʱⰪ : "+Arrays.toString(regArr));
		
		// �ε�ȣ���� �ߺ� �¿� �� ���� �̻�����.
		
		
//		System.out.println("���ǰ� Set : " + conditionElements.toString());
//		
//		System.out.println("caseArr ���� �� : "+Arrays.toString(caseArr));
//		System.out.println("regArr ���� �� : "+Arrays.toString(regArr));
		
		switch (inputCase.charAt(3)) {
			case '=':
//				System.out.println("= ����!");
				// 0, 2 �ε��� ���ǿ� �ִ� �����ڸ� ������ ���� ���� �ο����� Ȯ��
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
//				System.out.println("> ����!");
				for(int i = partNum+1; i <= 6; i++) {
					tmp.addAll(addCase(inputCase.replace(">"+partNum, "="+i), true));
				}
				break;
			case '<':
//				System.out.println("< ����!");
				for(int i = partNum-1; i >= 0; i--) {
					tmp.addAll(addCase(inputCase.replace("<"+partNum, "="+i), true));
				}
				break;
		}
		
		// ��ó��
		this.conditionElements.add(caseArr[0]);
		this.conditionElements.add(caseArr[1]);
		this.cases = tmp;
		
//		System.out.println("������� : " + cases.toString());
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