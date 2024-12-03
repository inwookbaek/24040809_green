package com.lec.board.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lec.board.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

	// 카카오등 social서비스를 통해서 회원가입된 회원들은 제외하고 일반회원들만
	// 가져오도록 social속성이 false인 사용자만 대상으로 한다.
	@EntityGraph(attributePaths = "roleSet")
	@Query("select m from Member m where m.mid = :mid and m.social = false")
	Optional<Member> getWithRoles(@Param("mid") String mid);
}
