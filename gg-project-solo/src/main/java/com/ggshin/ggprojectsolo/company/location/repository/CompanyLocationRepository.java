package com.ggshin.ggprojectsolo.company.location.repository;

import com.ggshin.ggprojectsolo.company.location.entity.CompanyLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyLocationRepository extends JpaRepository<CompanyLocation, Long> {
}
