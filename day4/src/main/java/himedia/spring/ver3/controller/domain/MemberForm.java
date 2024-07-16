package himedia.spring.ver3.controller.domain;

public class MemberForm {
	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
// dto가아니다 계층간의 이동을하지않았다.
// id가 없다 -> repository에서 결정이 나서 save할때 결정이나서 form 에는 id가필요가없다.
