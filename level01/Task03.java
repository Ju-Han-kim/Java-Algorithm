package level01;

import java.util.*;

/*
 * 프로그래머스 level 01 신고 결과 받기
 * 2022 KAKAO BLIND RECRUITMENT
 */
public class Task03 {

	public static void main(String[] args) {
		
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi", "apeach muzi"};
		int k = 2;
		
		int[] answer = new int[id_list.length];
		int[] chkReport = new int[id_list.length];
		
		HashSet<String> reportSet = new HashSet<String>(Arrays.asList(report));
		String[] reportArray = new String[id_list.length];
		
		for(String r : reportSet) {
			int indexfrom = Arrays.asList(id_list).indexOf(r.split(" ")[0]);
			int indexto = Arrays.asList(id_list).indexOf(r.split(" ")[1]);
			
			chkReport[indexto]++;
			reportArray[indexto] += " "+String.valueOf(indexfrom);
		}
		
		for(int i = 0; i < id_list.length; i++) {
			if(chkReport[i] >= k)
				for(String index : reportArray[i].replace("null ", "").split(" ")) {
						answer[Integer.parseInt(index)]++;
				}
		}
		
		System.out.println(Arrays.toString(answer));
		
	}

}
