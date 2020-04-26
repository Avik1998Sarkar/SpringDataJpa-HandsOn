package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
	@Query("select c from Country c where co_name like %?1% order by co_name")
	List<Country> findByOrderByName(String name);
	@Query("select c from Country c where co_name like ?1% order by co_name")
	List<Country> findByOrderByAlpha(String name);
}