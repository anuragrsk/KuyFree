package com.kuyfree.app.test.rest;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuyfree.app.rest.elements.response.FileResponse;
import com.kuyfree.app.rest.elements.response.FilesResponse;
import com.kuyfree.app.test.constant.AppTestConstants;
import com.kuyfree.app.util.ErrorMapping;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FilesRestTest.class)
@WebAppConfiguration
public class FilesRestTest {

	private static final Logger logger = Logger.getLogger(FilesRestTest.class);
	TestRestTemplate testTempate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	public static final String service = "/file/";

	/**
	 * Test Files REST service
	 */

	@Test
	public void testAllFilesRestService() {
		headers.add("Content-Type", "application/json");
		long startTime = System.currentTimeMillis();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = testTempate.exchange(
				AppTestConstants.endPointTest + service + "AllFiles" + "?page=1&size=5", HttpMethod.GET, entity,
				String.class);
		long endTime = System.currentTimeMillis();
		logger.debug("Response::" + (endTime - startTime));
		ObjectMapper mapper = new ObjectMapper();
		FilesResponse obj = null;
		try {
			obj = mapper.readValue(response.getBody(), FilesResponse.class);
			logger.debug("Response:: ITEMS:" + obj.getItems().size());

		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(obj.isSucess(), true);
	}

	/**
	 * Test Case to get an existing file
	 */
	@Test
	public void testFileRestService() {
		headers.add("Content-Type", "application/json");
		long startTime = System.currentTimeMillis();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = testTempate.exchange(
				AppTestConstants.endPointTest + service + "File" + "?file_id=5", HttpMethod.GET, entity, String.class);
		long endTime = System.currentTimeMillis();
		logger.debug("Response::" + (endTime - startTime));
		ObjectMapper mapper = new ObjectMapper();
		FileResponse obj = null;
		try {
			obj = mapper.readValue(response.getBody(), FileResponse.class);
			logger.debug("Response:: File ITEM:" + obj.getItem().getEnd_point());

		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(obj.isSucess(), true);
	}

	/**
	 * Test case for getting files in pages
	 */
	@Test
	public void testFilesRestService() {
		headers.add("Content-Type", "application/json");
		long startTime = System.currentTimeMillis();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = testTempate.exchange(
				AppTestConstants.endPointTest + service + "Files" + "?page=1&size=5", HttpMethod.GET, entity,
				String.class);
		long endTime = System.currentTimeMillis();
		logger.debug("Response::" + (endTime - startTime));
		ObjectMapper mapper = new ObjectMapper();
		FilesResponse obj = null;
		try {
			obj = mapper.readValue(response.getBody(), FilesResponse.class);
			logger.debug("Response:: ITEMS:" + obj.getItems().size());

		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(obj.getItems().size() > 0 && obj.getTotalPages() > 0, true);
	}

	/**
	 * Test case for non numeric file id
	 */
	@Test
	public void testInValidFileRestService() {
		headers.add("Content-Type", "application/json");
		long startTime = System.currentTimeMillis();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = testTempate.exchange(
				AppTestConstants.endPointTest + service + "File" + "?file_id=abc", HttpMethod.GET, entity,
				String.class);
		long endTime = System.currentTimeMillis();
		logger.debug("Response::" + (endTime - startTime));
		ObjectMapper mapper = new ObjectMapper();
		FileResponse obj = null;
		try {
			obj = mapper.readValue(response.getBody(), FileResponse.class);
			logger.debug("Response:: File ITEM:" + obj.getItem().getEnd_point());

		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	/**
	 * test case for non existing file
	 */
	@Test
	public void testNonExistingFileRestService() {
		headers.add("Content-Type", "application/json");
		long startTime = System.currentTimeMillis();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = testTempate.exchange(
				AppTestConstants.endPointTest + service + "File" + "?file_id=-1", HttpMethod.GET, entity, String.class);
		long endTime = System.currentTimeMillis();
		logger.error("Response::" + (endTime - startTime));
		ObjectMapper mapper = new ObjectMapper();
		FileResponse obj = null;
		try {
			obj = mapper.readValue(response.getBody(), FileResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(ErrorMapping.INVALID_FILE_ID.getDescription(), obj.getFailureMessage());
	}

	@Test
	public void testGetFileRestService() {
		headers.add("Content-Type", "application/json");
		boolean flag = true;
		long startTime = System.currentTimeMillis();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = testTempate.exchange(
				AppTestConstants.endPointTest + service + "File" + "?file_id=1", HttpMethod.GET, entity, String.class);
		long endTime = System.currentTimeMillis();
		logger.error("Response::" + (endTime - startTime));
		ObjectMapper mapper = new ObjectMapper();
		FileResponse obj = null;
		BufferedReader in = null;
		try {
			obj = mapper.readValue(response.getBody(), FileResponse.class);
			if (obj != null && obj.getItem() != null) {
				URL url = new URL(obj.getItem().getEnd_point());
				in = new BufferedReader(new InputStreamReader(url.openStream()));
				String inputLine;
				while ((inputLine = in.readLine()) != null)
					logger.error(inputLine);

			}

		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		assertEquals(flag, true);
	}
}
