package com.cg.DrugsInfoService.repository;

import com.cg.DrugsInfoService.models.DrugsData;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//public interface DrugsRepository extends JpaRepository<DrugsData,Integer> {
public interface DrugsRepository extends MongoRepository<DrugsData, Integer> {
    Optional<DrugsData> getDrugsDataByDrugName(String drugName);
//    @Query("{name:'?0'}")
//   DrugsData findItemByName(String name);
//
//    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
//    List<DrugsData> findAll(String category);
//
//    public long count();

}
