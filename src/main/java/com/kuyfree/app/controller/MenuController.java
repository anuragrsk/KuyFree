package com.kuyfree.app.controller;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import com.kuyfree.app.db.repository.MenuCRUDInterface;
import com.kuyfree.app.model.File;
import com.kuyfree.app.rest.elements.response.FilesResponse;
import com.kuyfree.app.rest.elements.response.MenuItem;
import com.kuyfree.app.rest.elements.response.MenuResponse;
import com.kuyfree.app.services.FilesService;
import com.kuyfree.app.services.MenuService;
import com.kuyfree.app.util.ErrorMapping;
@RestController

public class MenuController {
	private static final Logger logger = Logger.getLogger(MenuController.class);
	@Autowired
	private MenuService menuService;
	public MenuResponse getMenu(Pageable req, MenuCRUDInterface menuRepo) {
		MenuResponse response = new MenuResponse();
		response.setSucess(true);
		List<MenuItem> list = Collections.emptyList();
		try {
			list = menuService.getMenu(req, response, menuRepo);
		} catch (DataAccessException ee) {
			logger.error("DataBase Exception", ee);
			response.setSucess(false);
			response.setFailureMessage(ErrorMapping.ERROR.getDescription());
		} catch (Exception e) {
			logger.error("Exception", e);
			response.setSucess(false);
			response.setFailureMessage(ErrorMapping.ERROR.getDescription());
		}
		response.setItems(list);		
		return response;
	}

}
