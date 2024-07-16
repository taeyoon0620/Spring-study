package optional;

import java.util.Arrays;
import java.util.List;

/* [Optional]
 * NPE : NullPointerException
 * ===================================================================================
*/
public class Ex01 {
	public static void main(String[] args) {

		List<String> result = Arrays.asList("홍길동", "박보검", "이미자");
		
		for(String s: result) {
			if(s.equals("이미자"))
				System.out.println(s);
		}
		
	}

}

// 이미자를 외부에서 넣을거다. 검색을 해서 찾으면 주소를 리턴.
