package com.sudip.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sudip.springboot.entity.Task;

/**
 * @author 470009
 *
 */
@Repository
public interface TaskManagerRepository extends JpaRepository<Task,Long>{

	@Query("SELECT count(t) FROM Task t where t.projectDetails.projectId = ?1")
	public Long getTotalTasksForProjectId(Long projectId);
}

