package com.kuyfree.app.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kuyfree.app.controller.FilesController;
import com.kuyfree.app.controller.MenuController;
import com.kuyfree.app.db.repository.FilesCRUDInterface;
import com.kuyfree.app.db.repository.MenuCRUDInterface;
import com.kuyfree.app.rest.elements.response.FilesResponse;
import com.kuyfree.app.rest.elements.response.MenuItem;
import com.kuyfree.app.rest.elements.response.MenuResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "LocationMenu")
@Path("/api/v1/location/")
@RestController
@RequestMapping("/api/v1/location/")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class KuyFreeLocationMenu {
	private static final Logger logger = Logger.getLogger(KuyFreeLocationMenu.class);
	@Autowired
	private MenuCRUDInterface menuRepo;
	@Autowired
	private MenuController menuController;
	@Path("/menueItems")
	@ApiOperation(value = "Get Menu items list")
	@RequestMapping(value = "menu", method = RequestMethod.GET, params = { "page", "size" })
	@ResponseBody
	public MenuResponse getMenu(Pageable req) {
		MenuResponse response = menuController.getMenu(req, menuRepo);
		logger.debug(
				" Exit with " + ((response != null && response.isSucess()) ? "sucess" : response.getFailureMessage()));
		return response;
	}
}
