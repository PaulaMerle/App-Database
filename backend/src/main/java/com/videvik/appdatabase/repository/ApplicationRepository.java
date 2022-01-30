package com.videvik.appdatabase.repository;

import com.videvik.appdatabase.entity.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path="applications")
public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Integer> {

}