package util;

import org.junit.Assert;
import org.junit.Test;

import main.java.util.DBUtil;

public class DBUtilsTest {

	@Test
	public void escapeSpecialCharactersTest() {
		
		String likeString = "'abc%edf'";
		String result = DBUtil.escapeSpecialCharacters(likeString, false);
		Assert.assertEquals(result, "\\'abc\\%edf\\'");
				
	}
	
}
