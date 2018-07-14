package com.kuyfree.app.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.kuyfree.app.db.entity.LocationMenuEntity;

public interface MenuPaging extends PagingAndSortingRepository<LocationMenuEntity, Long>{

}
