package com.everyluck.text;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.everyluck.Util.*;
class UtilTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void readFunctionTest() {
		String path = "";
		Util.readFunction(path);
		
	}
	@Test
	void returnFoldTextTest() {
		String path = "/Users/everyluck/eclipse-workspace/Work1/text";
		List name = Util.returnFoldText(path);
		for(Object e:name) {
			System.out.println(e);
			
		}
	}
 
	

}
