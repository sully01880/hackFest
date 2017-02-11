package com.git.connect;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestReadOnlyRepoManager {
	
	private static final Logger logger = Logger.getLogger(TestReadOnlyRepoManager.class);
	
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
	public void testGetRepo() {
		
			try {
				Git repo = ReadOnlyRepoManager.getInstance().getRepo("C:\\temp\\hackFestTesting", 
						"https://github.com/GBTaylor/Test2.git");
				logger.debug("repo=" + repo);
			} catch (IOException | GitAPIException e) {
				logger.error(e.toString(), e);
				fail("unexpected exception");
			}
		
	}

}
