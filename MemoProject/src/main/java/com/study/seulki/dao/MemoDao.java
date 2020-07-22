package com.study.seulki.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.study.seulki.common.Pagination;
import com.study.seulki.dto.MemoDto;

@Repository
public class MemoDao implements IMemoDao{
	
	private JdbcTemplate template;
	
	@Autowired
	public MemoDao (ComboPooledDataSource dataSource) {
		this.template=new JdbcTemplate(dataSource);
	}

	@Override
	public int memoInsert(MemoDto memo) {
		int result=0;
		
		String sql="INSERT INTO memo_info (memo_title,memo_content,user_id,memo_date) "
				+ "VALUES (?,?,?,now())";
		
		result=template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, memo.getMemoTitle());
				ps.setString(2, memo.getMemoContent());
				ps.setString(3, memo.getmUserId());
				
			}
			
		});

		return result;
	}

	@Override
	public List<MemoDto> memoSelectList(String userId,Pagination pagination) {
		
		List<MemoDto> memos=null;
		
		String sql="SELECT * FROM memo_info WHERE user_id=?"
				+ "ORDER BY memo_date DESC LIMIT ?,?";
		
		memos=template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				
				ps.setString(1, userId);
				ps.setInt(2, pagination.getStartList());
				ps.setInt(3,pagination.getListSize());

			}
			
		}, new RowMapper<MemoDto>() {

			@Override
			public MemoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				

					MemoDto memo=new MemoDto();
					memo.setMemoNum(rs.getInt("memo_num"));
					memo.setMemoTitle(rs.getString("memo_title"));
					memo.setMemoContent(rs.getString("memo_content"));
					memo.setMemoDate(rs.getString("memo_date"));
					memo.setmUserId(rs.getString("user_id"));

				return memo;
			}
		});
		
		if(memos.isEmpty()) {
			return null;
		}


		return memos;
	}

	@Override
	public int memoUpdate(MemoDto memo) {
		int result=0;
		
		String sql="UPDATE memo_info SET "
				+ "memo_title=?, memo_content=? WHERE memo_num=?";
		
		result=template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, memo.getMemoTitle());
				ps.setString(2, memo.getMemoContent());
				ps.setInt(3, memo.getMemoNum());
						
			}
			
		});
		
		return result;
	}

	@Override
	public int memoDelete(int memoNum) {
		int result=0;
		
		String sql="DELETE FROM memo_info WHERE memo_num=?";
		
		result=template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, memoNum);
				
			}
			
		});

		return result;
	}

	@Override
	public MemoDto memoSelectOne(int memoNum) {
		List<MemoDto> memos=null;
		
		String sql="SELECT * FROM memo_info WHERE memo_num=?";
		
		memos=template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, memoNum);
				
			}
			
		}, new RowMapper<MemoDto>() {

			@Override
			public MemoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemoDto memo=new MemoDto();
				memo.setMemoNum(rs.getInt("memo_num"));
				memo.setMemoTitle(rs.getString("memo_title"));
				memo.setMemoContent(rs.getString("memo_content"));
				memo.setmUserId(rs.getString("user_id"));
				memo.setMemoDate(rs.getString("memo_date"));
				
				return memo;
			}
			
		});
		
		if(memos.isEmpty()) {
			return null;
		}

		return memos.get(0);
	}

	@Override
	public int memoListCnt(String userId) {
		int listCnt=0;
		
		String sql="SELECT COUNT(*) AS listCnt FROM memo_info WHERE user_id=?";
		
		 listCnt=template.queryForObject(sql, Integer.class, userId); 
		
		return listCnt;
	}

}
