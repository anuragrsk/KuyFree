
package com.kuyfree.app.db.repository;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.kuyfree.app.db.entity.FilesEntity;

@Component
@CacheConfig(cacheNames = "FILES_REPO")
public interface FilesCRUDInterface extends CrudRepository<FilesEntity, Long> {
	@Cacheable
	List<FilesEntity> findAll();
	@Cacheable

	@Query(value = "SELECT C FROM FilesEntity AS C where C.status ='ACTIVE'", nativeQuery = false)
	List<FilesEntity> findActiveAll();
	@Cacheable

	@Query(value = "SELECT C FROM FilesEntity AS C where C.status ='ACTIVE' and C.id=?", nativeQuery = false)
	FilesEntity findActiveById(long id);
	@Cacheable

	@Query(value = "SELECT C FROM FilesEntity  AS C where C.status ='ACTIVE'", nativeQuery = false)
	Page<FilesEntity> findAll(Pageable pageRequest);

}
