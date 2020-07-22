package com.study.seulki.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.study.seulki.dto.MemberDto;

@Repository
public class MemberDao implements IMemberDao{
	
	private JdbcTemplate template;
	
	@Autowired
	public MemberDao(ComboPooledDataSource dataSource){
		this.template=new JdbcTemplate(dataSource);
	}

	@Override
	public int memberInsert(MemberDto mDto) {
		int result=0;
		
		String sql="INSERT INTO user_info VALUES(?,?,?)";
		
		result=template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, mDto.getUserId());
				ps.setString(2, mDto.getUserName());
				ps.setString(3, mDto.getUserPw());
			}	
		});
		return result;
	}

	@Override
	public MemberDto memberSelect(MemberDto mDto) {
		
		List<MemberDto> members=null;
		
		String sql="SELECT * FROM user_info WHERE user_id=? AND user_pw=?";
		
		members=template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, mDto.getUserId());
				ps.setString(2, mDto.getUserPw());
			}
			
		}, new RowMapper<MemberDto>() {

			@Override
			public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				MemberDto mDto=new MemberDto();
				mDto.setUserId(rs.getString("user_id"));
				mDto.setUserName(rs.getString("user_name"));
				mDto.setUserPw(rs.getString("user_pw"));
				
				return mDto;
			}
		} );
		
		if(members.isEmpty()) {
			return null;
		}

		return members.get(0);
		
	}
	
	@Override
	public int idSelect(String userid) {
		int result=0;
		
		String sql="SELECT COUNT(*) as id_check FROM user_info WHERE user_id=?";
		
		result=template.queryForObject(sql, Integer.class, userid);
		
		return result;
	}

	@Override
	public int memberUpdate(MemberDto mDto) {

		return 0;
	}

	@Override
	public int memberDelete(MemberDto mDto) {

		return 0;
	}

	

}
