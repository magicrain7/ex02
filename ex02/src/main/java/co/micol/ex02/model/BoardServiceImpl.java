package co.micol.ex02.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.ex02.vo.CommonVo;

public class BoardServiceImpl implements Service {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<CommonVo> selectList() {
		List<CommonVo> list = new ArrayList<CommonVo>();
		CommonVo vo;
		String sql = "select * from board";
		try {
			conn = DbConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new CommonVo();
				vo.setRno(rs.getInt("rno"));
				vo.setId(rs.getString("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
				list.add(vo);
			}
			close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public CommonVo select(CommonVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(CommonVo vo) {
		return 0;
	}
	@Override
	public int update(CommonVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(CommonVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CommonVo loginCheck(CommonVo vo) {
		// TODO Auto-generated method stub
		return null;
	}
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
