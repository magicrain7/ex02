package co.micol.ex02.model;

import java.util.List;

import co.micol.ex02.vo.CommonVo;

public interface Service {
	public List<CommonVo> selectList();   //리스트 종류를 가지고옴.
	public CommonVo select(CommonVo vo);  //특정 한레코드 조회.
	public int insert(CommonVo vo);  //레코드 추가.
	public int update(CommonVo vo);
	public int delete(CommonVo vo);
	public CommonVo loginCheck(CommonVo vo); //로그인 체크용
}
