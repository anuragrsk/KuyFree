package com.kuyfree.app.controller;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.kuyfree.app.db.repository.FilesCRUDInterface;
import com.kuyfree.app.exception.FilesException;
import com.kuyfree.app.model.File;
import com.kuyfree.app.rest.elements.response.FileResponse;
import com.kuyfree.app.rest.elements.response.FilesResponse;
import com.kuyfree.app.services.FilesService;
import com.kuyfree.app.util.ErrorMapping;

/**
 * Products controller class
 * 
 * @author anuraag
 *
 */
@RestController
public class FilesController {

	private static final Logger logger = Logger.getLogger(FilesController.class);
	@Autowired
	private FilesService filesService;

	/**
	 * 
	 * @param productCrud
	 * @param req
	 * @param categoryId
	 * @return
	 */
	public FilesResponse getFiles(Pageable req, FilesCRUDInterface fileRepo) {
		FilesResponse response = new FilesResponse();
		response.setSucess(true);
		List<File> list = Collections.emptyList();
		try {
			list = filesService.getFiles(req, response, fileRepo);
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

	/**
	 * 
	 * @param productRepo
	 * @return
	 */
	public FilesResponse getFiles(FilesCRUDInterface fileRepo) {
		FilesResponse response = new FilesResponse();
		response.setSucess(true);
		List<File> list = Collections.emptyList();
		try {
			list = filesService.getAllFiles(response, fileRepo);
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

	/**
	 * 
	 * @param filesRepo
	 * @param file_id
	 * @return
	 */
	public FileResponse getFile(FilesCRUDInterface filesRepo, long file_id) {
		FileResponse response = new FileResponse();
		response.setSucess(true);
		File file = null;
		try {
			file = filesService.getFile(response, filesRepo, file_id);
		} catch (DataAccessException ee) {
			logger.error("DataBase Exception", ee);
			response.setSucess(false);
			response.setFailureMessage(ErrorMapping.ERROR.getDescription());
		} catch (FilesException e) {
			logger.error("FilesException", e);
			response.setSucess(false);
			response.setFailureMessage(e.getMessage());
		} catch (Exception e) {
			logger.error("Exception", e);
			response.setSucess(false);
			response.setFailureMessage(ErrorMapping.ERROR.getDescription());
		}
		response.setItem(file);
		return response;
	}

}
