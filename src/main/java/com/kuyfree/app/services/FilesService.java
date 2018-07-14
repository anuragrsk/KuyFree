package com.kuyfree.app.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kuyfree.app.config.FileServerLocationConfiguration;
import com.kuyfree.app.constants.AppConstants;
import com.kuyfree.app.db.entity.FilesEntity;
import com.kuyfree.app.db.repository.FilesCRUDInterface;
import com.kuyfree.app.exception.FilesException;
import com.kuyfree.app.model.File;
import com.kuyfree.app.rest.elements.response.FileResponse;
import com.kuyfree.app.rest.elements.response.FilesResponse;
import com.kuyfree.app.util.ErrorMapping;

@Service
public class FilesService implements FileServiceInterface {
	private static final Logger logger = Logger.getLogger(FilesService.class);

	@Autowired
	private FileServerLocationConfiguration serverConfig;

	/**
	 * Get all files for a page
	 * 
	 * @param req
	 * @param response
	 * @param fileRepo
	 * @return
	 */
	public List<File> getFiles(Pageable req, FilesResponse response, FilesCRUDInterface fileRepo) {

		List<File> products = Collections.emptyList();
		if (fileRepo == null) {
			logger.debug("FilesService:End  FilesCRUDInterface is null retruning empty::");
			return products;
		}
		Page<FilesEntity> it = fileRepo.findAll(req);
		response.setTotalPages(it.getTotalPages());
		File cat = null;
		products = new ArrayList<File>();

		for (FilesEntity catalog : it) {
			cat = new File();
			catalog.setAlt_end_point(getEndpoint(catalog.getAlt_end_point()));
			catalog.setEnd_point(getEndpoint(catalog.getEnd_point()));
			BeanUtils.copyProperties(catalog, cat);
			products.add(cat);
		}
		logger.debug(" :End retruning size::" + products.size());
		return products;
	}

	/**
	 * Get All files
	 * 
	 * @param response
	 * @param fileRepo
	 * @return
	 */
	public List<File> getAllFiles(FilesResponse response, FilesCRUDInterface fileRepo) {

		List<File> files = Collections.emptyList();
		if (fileRepo == null) {
			logger.debug("FilesService:End  FilesCRUDInterface is null retruning empty::");
			return files;
		}
		List<FilesEntity> it = fileRepo.findAll();

		File cat = null;
		files = new ArrayList<File>();

		for (FilesEntity catalog : it) {
			cat = new File();
			catalog.setAlt_end_point(getEndpoint(catalog.getAlt_end_point()));
			catalog.setEnd_point(getEndpoint(catalog.getEnd_point()));
			BeanUtils.copyProperties(catalog, cat);
			files.add(cat);
		}
		logger.debug(" :End retruning size::" + files.size());
		return files;
	}

	/**
	 * Get a file for a file id
	 * 
	 * @param response
	 * @param filesRepo
	 * @param file_id
	 * @return
	 * @throws FilesException
	 */
	public File getFile(FileResponse response, FilesCRUDInterface filesRepo, long file_id) throws FilesException {

		File files = new File();
		if (filesRepo == null) {
			logger.debug("FilesService:End  FilesCRUDInterface is null retruning empty::");
			return files;
		}
		FilesEntity it = filesRepo.findActiveById(file_id);
		if (it != null) {
			it.setAlt_end_point(getEndpoint(it.getAlt_end_point()));
			it.setEnd_point(getEndpoint(it.getEnd_point()));
			BeanUtils.copyProperties(it, files);
		} else {
			throw new FilesException(ErrorMapping.INVALID_FILE_ID.getDescription(),
					ErrorMapping.INVALID_FILE_ID.getErrorCode());
		}
		return files;
	}

	/**
	 * Construct end point
	 * 
	 * @param endPoint
	 * @return
	 */
	private String getEndpoint(String endPoint) {
		if(endPoint.contains("http"))
			return endPoint;
		return AppConstants.HTTP + AppConstants.COLON + AppConstants.FORWARD_SLASHS + serverConfig.getIp()
				+ AppConstants.COLON + serverConfig.getPort() + endPoint;
	}
}
