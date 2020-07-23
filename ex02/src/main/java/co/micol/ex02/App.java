package co.micol.ex02;

import java.util.ArrayList;
import java.util.List;

import co.micol.ex02.model.BoardServiceImpl;
import co.micol.ex02.model.MemberLogin;
import co.micol.ex02.vo.CommonVo;

public class App {
	
    public static void main(String[] args){
//    	MemberLogin ml = new MemberLogin();
//    	ml.loginCheck();
    	BoardServiceImpl board = new BoardServiceImpl();
    	List<CommonVo> list = new ArrayList<CommonVo>();
    	list = board.selectList();
    	for(CommonVo vo : list) {
    		System.out.print(vo.getRno() + " ");
    		System.out.print(vo.getId() + " ");
    		System.out.print(vo.getTitle() + " ");
    		System.out.println(vo.getContents() + " ");
    	}
    	
    	MemberLogin mi = new MemberLogin();
    	mi.insert();
    }  
}
