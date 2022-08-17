package com.ggshin.ggprojectsolo.member.repository;

import com.ggshin.ggprojectsolo.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

//    @Query(value = "SELECT m FROM Member m WHERE m.companyType = :companyCode AND m.companyLocation = :locationCode")
    Optional<Page<Member>> findByCompanyLocationAndCompanyType(String locationCode, String companyCode, Pageable pageable);

}
