package com.cg.DrugsInfoService.repository;

import com.cg.DrugsInfoService.models.DrugsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugsRepository extends JpaRepository<DrugsData,Integer> {
}
