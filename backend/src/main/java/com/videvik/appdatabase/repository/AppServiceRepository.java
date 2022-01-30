package com.videvik.appdatabase.repository;

import com.videvik.appdatabase.entity.AppServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path="services")
public interface AppServiceRepository extends JpaRepository<AppServiceEntity, Integer> {

}