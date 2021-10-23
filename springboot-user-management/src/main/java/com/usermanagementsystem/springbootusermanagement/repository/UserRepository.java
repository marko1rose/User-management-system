package com.usermanagementsystem.springbootusermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.usermanagementsystem.springbootusermanagement.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "select * from user u where u.first_name like %:keyword% or u.last_name like %:keyword%", nativeQuery = true)
	List<User> findByKeyword(@Param("keyword") String keyword);
}
