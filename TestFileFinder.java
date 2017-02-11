package com.git.connect;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.borland.connect.data_pool.PropertyMapping;
import com.microfocus.connectorInterface.ConnectorProperties;
import com.microfocus.connectorInterface.FoundFile;

public class TestFileFinder {
	private static final Logger logger = Logger.getLogger(TestFileFinder.class);
	
	@Before
	public void setUp() throws Exception {
		BasicConfigurator.configure(new ConsoleAppender(
				new PatternLayout("%d{ISO8601} %-5p (%t) [%F:%L)] %m%n")));
	    Logger.getRootLogger().setLevel(Level.DEBUG);
		logger.debug("setup");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetFilesAssociatedWith11223344() {
		GitFileFinder fileFinder = new GitFileFinder("C:\\temp\\hackFestTesting");
		try {
			List<FoundFile> files = fileFinder.getFilesAssociatedWithIssuedId("https://github.com/sully01880/hackFest.git", 
					"master", "447788");
			for (FoundFile foundFile : files) {
				logger.debug("foundFile=" + foundFile);
			}
		} catch (IOException | GitAPIException e) {
			logger.error(e.toString(), e);
			fail("unexpected exception");
		}
	}
	
	@Test
	public void testGetFilesAssociatedWith555666777() {
		GitFileFinder fileFinder = new GitFileFinder("C:\\temp\\hackFestTesting");
		try {
			List<FoundFile> files = fileFinder.getFilesAssociatedWithIssuedId("https://github.com/GBTaylor/Test5.git", 
					"master", "555666777");
			for (FoundFile foundFile : files) {
				logger.debug("foundFile=" + foundFile);
			}
		} catch (IOException | GitAPIException e) {
			logger.error(e.toString(), e);
			fail("unexpected exception");
		}
	}
	
	@Test
	public void testGetFilesAssociatedWith999888777() {
		GitFileFinder fileFinder = new GitFileFinder("C:\\temp\\hackFestTesting");
		try {
			List<FoundFile> files = fileFinder.getFilesAssociatedWithIssuedId("https://github.com/sully01880/hackFest.git", 
					"master", "999888777");
			for (FoundFile foundFile : files) {
				logger.debug("foundFile=" + foundFile);
			}
		} catch (IOException | GitAPIException e) {
			logger.error(e.toString(), e);
			fail("unexpected exception");
		}
	}
	
	@Test
	public void testGetFilesAssociatedWith222() {
		GitFileFinder fileFinder = new GitFileFinder("C:\\temp\\hackFestTesting");
		try {
			List<FoundFile> files = fileFinder.getFilesAssociatedWithIssuedId("https://github.com/sully01880/hackFest.git", 
					"master", "222");
			for (FoundFile foundFile : files) {
				logger.debug("foundFile=" + foundFile);
			}
		} catch (IOException | GitAPIException e) {
			logger.error(e.toString(), e);
			fail("unexpected exception");
		}
	}
	
	@Test
	public void testGetFilesAssociatedWith666888444() {
		GitFileFinder fileFinder = new GitFileFinder("C:\\temp\\hackFestTesting");
		try {
			List<FoundFile> files = fileFinder.getFilesAssociatedWithIssuedId("https://github.com/sully01880/hackFest.git", 
					"master", "666888444");
			for (FoundFile foundFile : files) {
				logger.debug("foundFile=" + foundFile);
			}
		} catch (IOException | GitAPIException e) {
			logger.error(e.toString(), e);
			fail("unexpected exception");
		}
	}
	
	@Test
	public void testDiff() {
		ConnectorProperties props = new ConnectorProperties();
		props.addProperty(PropertyMapping.URL, "https://github.com/sully01880/hackFest.git");
		
		//foundFile=FoundFile [getFileName()=chris3.txt, getCurrentVersion()=508336702a9a42b54112470868045d5404d57a2a, 
		//getPreviousVersion()=ccd4d9f248b86ea4b19df21a5cdb6cc5f59bc8fa, getFileStatus()=updated]
		GitFileFinder fileFinder = new GitFileFinder("C:\\temp\\hackFestTesting");
		String diffOutput = fileFinder.getDiffHtml(props, "master", "chris3.txt", 
				"508336702a9a42b54112470868045d5404d57a2a", "ccd4d9f248b86ea4b19df21a5cdb6cc5f59bc8fa");
		logger.debug("diffOutput=" + diffOutput);
	}
	
	

}
