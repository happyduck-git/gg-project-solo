package com.ggshin.ggprojectsolo.company.type.repository;

import com.ggshin.ggprojectsolo.company.type.entity.CompanyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyTypeRepository extends JpaRepository<CompanyType, Long> {
}
