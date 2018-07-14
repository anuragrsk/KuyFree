package com.kuyfree.app.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.kuyfree.app.db.repository.FilesCRUDInterface;
import com.kuyfree.app.exception.FilesException;
import com.kuyfree.app.model.File;
import com.kuyfree.app.rest.elements.response.FileResponse;
import com.kuyfree.app.rest.elements.response.FilesResponse;

public interface FileServiceInterface {
	public List<File> getFiles(Pageable req, FilesResponse response, FilesCRUDInterface fileRepo);

	public List<File> getAllFiles(FilesResponse response, FilesCRUDInterface fileRepo);

	public File getFile(FileResponse response, FilesCRUDInterface filesRepo, long file_id) throws FilesException;
}
