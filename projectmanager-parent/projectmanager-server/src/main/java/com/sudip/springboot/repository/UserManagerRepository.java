package com.sudip.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudip.springboot.entity.User;

/**
 * @author 470009
 *
 */
@Repository
public interface UserManagerRepository extends JpaRepository<User,Long>{

}

