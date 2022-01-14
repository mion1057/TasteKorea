package com.tastekorea.webapp.guide.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.tastekorea.webapp.common.dao.TasteDao;
import com.tastekorea.webapp.guide.domain.Companion;
import com.tastekorea.webapp.guide.dao.CompanionRowMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CompanionDao extends TasteDao {

	/**
	 * 신규 가이드 등록
	 * 
	 * @param companion
	 * @return
	 */
	public Companion save(Companion companion) {
		long id = add(companion);
		log.debug("신규 companion saved and return id: " + id);

		companion.setId(id);
		return companion;
	}

	public long add(Companion companion) {
		String sql = "INSERT INTO Companion(email, passwd, name, phone, ssn, " + " sex, photo, introduction, region)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator preparedStatementCreator = (connection) -> {
			PreparedStatement pstmt = connection.prepareStatement(sql, new String[] { "id" });
			pstmt.setString(1, companion.getEmail());
			pstmt.setString(2, companion.getPasswd());
			pstmt.setString(3, companion.getName());
			pstmt.setString(4, companion.getPhone());
			pstmt.setString(5, companion.getSsn());
			pstmt.setString(6, String.valueOf(companion.getSex()));
			pstmt.setString(7, companion.getPhoto());
			pstmt.setString(8, companion.getIntroduction());
			pstmt.setString(9, companion.getRegion());

			return pstmt;
		};
		jdbcTemplate.update(preparedStatementCreator, keyHolder);
		return keyHolder.getKey().longValue();
	}

	/**
	 * 가이드 id로 조회
	 * 
	 * @param cid
	 * @return
	 */
	public Companion findById(long id) {
		String sql = "SELECT * FROM Companion WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new CompanionRowMapper(), id);
	}

	/**
	 * 가이드 email로 조회
	 * 
	 * @param email
	 * @return
	 */
	public Companion findByEmail(String email) {
		String sql = "SELECT * FROM Companion WHERE email = ?";
		return jdbcTemplate.queryForObject(sql, new CompanionRowMapper(), email);
	}

	/**
	 * sql : SELECT * FROM Companion regDate DESC LIMIT 2 OFFSET 0 LIMIT n : 가져올 행의
	 * 수 (0이면 아무것도 안가져옴) OFFSET n : 가져올 행의 시작(첫 행이 0부터 시작)
	 * 
	 * LIMIT n = LIMIT n OFFSET 0 LIMIT size OFFSET start = LIMIT start, size
	 * 
	 * 결론 -. 페이징시 한 페이지의 크기는 LIMIT으로 지정 -. 페이지 번호는 OFFSET으로 지정 -. 한 페이지 크기가 10이고
	 * 2페이지를 조회하려면 LIMIT 10 OFFSET (2 * LIMIT
	 * 
	 * sql : SELECT * FROM Companion ORDER BY regDate DESC LIMIT 2 OFFSET 0
	 * 
	 * @param pageable
	 * @return
	 */
	public Page<Companion> findAll(Pageable pageable) {
		String sql = pagingQuery("SELECT * FROM Companion", pageable);
		List<Companion> list = jdbcTemplate.query(sql, new CompanionRowMapper());

		return new PageImpl<Companion>(list, pageable, count("Companion"));
	}

	public Companion login(String email) {
		String sql = "SELECT * FROM Companion WHERE email = ?";
		return jdbcTemplate.queryForObject(sql, new CompanionRowMapper(), email);
	}

	//  내가 만들어볼 이메일 체크 함수
	public boolean isEmailCheck(String email) {
		System.out.println("DAO들어왔습니까?");
		String sql = "SELECT * FROM COMPANION WHERE email=?";
		List<Companion> list = null;
		list = jdbcTemplate.query(sql, new CompanionRowMapper(), email);

		if (list == null || list.equals(null) || list.size() == 0) {
			return true;
		}
		return false;
	}
}
