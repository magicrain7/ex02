package co.micol.ex02.model;

import java.util.Scanner;

import co.micol.ex02.vo.CommonVo;

public class MemberLogin {
	private ServiceImpl service = new ServiceImpl();
	private CommonVo vo;
	Scanner sc = new Scanner(System.in);
	
	public void loginCheck() {
		System.out.println("사용자 아이디 입력하세요");
		String id = sc.next();
		System.out.println("비밀번호 입력하세요");
		String pw = sc.next();
		
		vo = new CommonVo(id, pw);  // 생성자를 통한 id, password값 전달
		vo = service.loginCheck(vo);
		
		if(vo.getName() == null) {
			System.out.println("아이디 혹은 패스워드가 다릅니다.");
		}else {
			System.out.println(vo.getName() + "님 환영합니다.");
		}
	}
	public void insert() {
		System.out.println("rno 입력하세요");
		int rno = sc.nextInt();
		System.out.println("id 입력하세요");
		String id = sc.next();
		System.out.println("title 입력하세요");
		String title = sc.next();
		System.out.println("Contents 입력하세요");
		String contents = sc.next();
		
		vo = new CommonVo(rno,id,title,contents);
		int n = service.insert(vo);
	}
}
