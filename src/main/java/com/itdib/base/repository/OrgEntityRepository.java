package com.itdib.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itdib.base.entity.OrgEntity;

/**
 * @author @dibyapp, Name : Dibyaprakash, Email : dibyapp@geekyants.com
 * @Project : mt-base-service
 */
@Repository
@Transactional
public interface OrgEntityRepository extends JpaRepository<OrgEntity, Integer> {
	
	OrgEntity findByInstanceName(String instanceName);
}
