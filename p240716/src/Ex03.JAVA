package optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ex03 {
	
	public static Optional<String> findByName(String name) {
		List<String> result = Arrays.asList("홍길동", "박보검", "이미자");
		
	/////////////////////////////////////////////////////////////////////
//		for(String s: result) {
//			if(s.equals(name))
//				//return Optional.ofNullable(s);
//				//return Optional.of(s);
//				//return new Optional(s);
//		}
//		//return null;
//		return Optional.empty();
	
	////////////////////////////////////////////////////////////////////
	
	// [문제] stream 으로 변경  pipeline으로 작업 ==================================================
	return Optional.empty(); // 임시로 해둠 
}	

// 못찾았을때도 return을 해야한다. 못찾았을때는 null로 처리 (return)
	
// Optional.of 하고 Optional.ofNullable의 차이는   => of는 null예외발생시킴, ofnullable은 null 예외발생안 시킴 optional을 리턴     
	
	public static void main(String[] args) {
		System.out.println("[이름 찾기] 1. 이미자 >> " + findByName("이미자")); // 이미자 주소 
		System.out.println("[이름 찾기] 2. 하늘 >> " + findByName("하늘")); //null 
		//System.out.println("이미자 길이 >> " + findByName("이미자").length()); // 길이
		
		System.out.println("이미자 길이 >> " + findByName("이미자").get().length()); // 길이
		
		// [NPE] ======================================================================
		//System.out.println("[이름 찾기] 2. 하늘 >> " + findByName("하늘").length()); //null 

		//String findName = findByName("하늘");
		//if(findName != null)
			//System.out.println("하늘길이 >>" + findByName("하늘").length());
		Optional<String> sky = findByName("하늘");
		if(sky.isPresent()) {
			System.out.println("하늘 길이 >> " + findByName("하늘").get().length());
		};
	}

}
// optional은 외부에서 instance 생성 불가능 객체생성 불가능
// optional은 매개변수하나