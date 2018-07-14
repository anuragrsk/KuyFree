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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kuyfree.app.controller.FilesController;
import com.kuyfree.app.db.repository.FilesCRUDInterface;
import com.kuyfree.app.rest.elements.response.FileResponse;
import com.kuyfree.app.rest.elements.response.FilesResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Files")
@Path("/api/v1/file/")
@RestController
@RequestMapping("/api/v1/file/")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class Files {

	private static final Logger logger = Logger.getLogger(Files.class);
	@Autowired
	private FilesCRUDInterface filesRepo;
	@Autowired
	private FilesController filesController;

	/**
	 * This rest end point will return all files active status for a given page
	 * size
	 * 
	 * @param req
	 * @return
	 */
	@Path("/files")
	@ApiOperation(value = "Get Files")
	@RequestMapping(value = "Files", method = RequestMethod.GET, params = { "page", "size" })
	@ResponseBody
	public FilesResponse getFiles(Pageable req) {
		FilesResponse response = filesController.getFiles(req, filesRepo);
		logger.debug(
				" Exit with " + ((response != null && response.isSucess()) ? "sucess" : response.getFailureMessage()));
		return response;
	}

	/**
	 * This rest end point will return all the files.
	 * 
	 * @return
	 */
	@Path("/allFiles")
	@ApiOperation(value = "Get All Files")
	@RequestMapping(value = "AllFiles", method = RequestMethod.GET)
	@ResponseBody
	public FilesResponse getAllFiles() {
		FilesResponse response = filesController.getFiles(filesRepo);
		logger.debug(
				" Exit with " + ((response != null && response.isSucess()) ? "sucess" : response.getFailureMessage()));
		return response;
	}

	/**
	 * This rest end point will return a file based on file id.
	 * 
	 * @param file_id
	 * @return
	 */
	@Path("/file")
	@ApiOperation(value = "Get a Files")
	@RequestMapping(value = "/File", method = RequestMethod.GET)
	@ResponseBody
	public FileResponse getFile(@RequestParam(value = "file_id") long file_id) {
		FileResponse response = filesController.getFile(filesRepo, file_id);
		logger.debug(
				" Exit with " + ((response != null && response.isSucess()) ? "sucess" : response.getFailureMessage()));
		return response;
	}

}
