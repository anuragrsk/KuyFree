package com.kuyfree.app.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kuyfree.app.db.entity.LocationMenuEntity;
import com.kuyfree.app.db.repository.MenuCRUDInterface;
import com.kuyfree.app.model.File;
import com.kuyfree.app.rest.elements.response.MenuItem;
import com.kuyfree.app.rest.elements.response.MenuResponse;

@Service
public class MenuService {
	private static final Logger logger = Logger.getLogger(MenuService.class);

	public List<MenuItem> getMenu(Pageable req, MenuResponse response, MenuCRUDInterface menuRepo) {
		List<MenuItem> menuItems = Collections.emptyList();
		if (menuRepo == null) {
			logger.debug("MenuService:End  MenuCRUDInterface is null retruning empty::");
			return menuItems;
		}
		Page<LocationMenuEntity> it = menuRepo.findActiveAll(req);
		logger.debug("MenuService:  ITEM::"+it.getTotalPages());

		response.setTotalPages(it.getTotalPages());
		MenuItem cat = null;
		menuItems = new ArrayList<MenuItem>();

		for (LocationMenuEntity menu : it) {
			cat=new MenuItem();
			BeanUtils.copyProperties(menu, cat);
			menuItems.add(cat);
		}
		logger.debug("MenuService:End retruning size::" + menuItems.size());
		return menuItems;
	}



}
