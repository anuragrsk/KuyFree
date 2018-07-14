package com.kuyfree.app.db.repository;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.kuyfree.app.db.entity.LocationMenuEntity;
@Component
@CacheConfig(cacheNames = "MENU_REPO")
public interface MenuCRUDInterface extends CrudRepository<LocationMenuEntity, Long>{

	@Query(value = "SELECT C FROM LocationMenuEntity AS C where C.active ='Y' and C.partner_location_id=10000", nativeQuery = false)
	Page<LocationMenuEntity> findActiveAll(Pageable req);
}
