package optional;

import java.util.Arrays;
import java.util.List;

public class Ex02 {
	
	public static String findByName(String name) {
		List<String> result = Arrays.asList("홍길동", "박보검", "이미자");
		
		for(String s: result) {
			if(s.equals(name))
				return s;
		}
		return null;
	}
// 못찾았을때도 return을 해야한다. 못찾았을때는 null로 처리 (return)
	
	public static void main(String[] args) {
		System.out.println("[이름 찾기] 1. 이미자 >> " + findByName("이미자")); // 이미자 주소 
		System.out.println("[이름 찾기] 2. 하늘 >> " + findByName("하늘")); //null 
	
		System.out.println("[이름 찾기] 1. 이미자 >> " + findByName("이미자").length()); //
		
		// [NPE] ======================================================================
		//System.out.println("[이름 찾기] 2. 하늘 >> " + findByName("하늘").length()); //null 

		String findName = findByName("하늘");
		if(findName != null)
			System.out.println("하늘길이 >>" + findByName("하늘").length());
		
	}

}
