package com.kuyfree.app.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.kuyfree.app.db.entity.FilesEntity;

public interface FilesPaging extends PagingAndSortingRepository<FilesEntity, Long> {

}
