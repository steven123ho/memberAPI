package com.projects.memberAPI.repository;

import com.projects.memberAPI.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
