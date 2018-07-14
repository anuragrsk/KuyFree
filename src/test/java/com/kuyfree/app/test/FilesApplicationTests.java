package com.kuyfree.app.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

import com.kuyfree.app.test.rest.FilesRestTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ FilesRestTest.class, })
@SpringBootTest
public class FilesApplicationTests {

}
