package kr.co.hk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.hk.dto.S_Board_DTO;

public class BoardDAO {

	public static void insert_S_Board(S_Board_DTO dto) {
		// S_Board에 글을 쓰는 쿼리문
		System.out.println("[insert_S_Board 메서드 실행]");
		Connection conn = DBConnector.getConn();
		PreparedStatement ps = null;
		String sql = "INSERT INTO s_board "
				+ " (board_no, board_title, board_content, regdate, cnt) "
				+ " VALUES (?, ?, ?, ?, 0)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getBoard_No());
			ps.setString(2, dto.getBoard_Title());
			ps.setString(3, dto.getBoard_Content());
			ps.setString(4, dto.getRegdate());
			ps.execute();
			System.out.println("글쓰기 성공");
		} catch (Exception e) {
			System.out.println("글쓰기 실패");
		} finally {
			DBConnector.closeConn(null, ps, conn);
		}

		System.out.println("[insert_S_Board 메서드 종료]");
	}

	public static int get_MaxBoardNum() {
		// 보드넘버 최대값을 가져오는 메소드
		System.out.println("[get_MaxBoardNum 메소드 실행]");
		int maxBN = 0;
		Connection conn = DBConnector.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select max(board_no) maxbn from s_board";

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				maxBN = rs.getInt("maxbn");
			}
			System.out.println("맥스 보드 넘버 갖고오기 성공");
		} catch (Exception e) {
			System.out.println("맥스 보드 넘버 갖고오기 실패");
		} finally {
			DBConnector.closeConn(rs, ps, conn);
		}

		System.out.println("[get_MaxBoardNum 메소드 종료]");
		return maxBN;
	}

	public static List<S_Board_DTO> getBoardDTOList() {
		System.out.println("[getBoardDTO 메서드 실행]");
		List<S_Board_DTO> lsd = new ArrayList<S_Board_DTO>();
		Connection conn = DBConnector.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select board_no, board_title, "
				+ " board_content, to_char(regdate, 'yyyy-mm-dd') regdate, cnt from s_board order by board_no";

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				S_Board_DTO sd = new S_Board_DTO();
				sd.setBoard_No(rs.getInt("board_no"));
				sd.setBoard_Title(rs.getString("board_title"));
				sd.setBoard_Content(rs.getString("board_content"));
				sd.setRegdate(rs.getString("regdate"));
				sd.setCnt(rs.getInt("cnt"));
				lsd.add(sd);
			}
			System.out.println("Board 리스트화 성공");
		} catch (Exception e) {
			System.out.println("Board 리스트화 실패");
			e.printStackTrace();
		} finally {
			DBConnector.closeConn(rs, ps, conn);
		}

		System.out.println("[getBoardDTO 메서드 종료]");
		return lsd;
	}
}
