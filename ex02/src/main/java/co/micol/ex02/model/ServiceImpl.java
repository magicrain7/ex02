package co.micol.ex02.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.ex02.vo.CommonVo;

public class ServiceImpl implements Service {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<CommonVo> selectList() {
		List<CommonVo> list = new ArrayList<CommonVo>();
		CommonVo vo;
		String sql = "select * from member";
		try {
			conn = DbConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new CommonVo();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				list.add(vo);
			}
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
		int n =0;
		String sql = "insert into board values(?,?,?,?)";
		try {
			conn = DbConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, vo.getRno());
			psmt.setString(2, vo.getId());
			psmt.setString(3, vo.getTitle());
			psmt.setString(4, vo.getContents());
			
			n = psmt.executeUpdate();
			System.out.println(n + "건 입력됨");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n;
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
		String sql = "select * from member where id = ? and password = ?";
		try {
			conn = DbConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
			}
			close(); //사용후 커넥션 변환
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
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
