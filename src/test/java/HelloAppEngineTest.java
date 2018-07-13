import java.io.IOException;


import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Test;

public class HelloAppEngineTest {

  @Test
  public void test() throws IOException, ServletException {
    MockHttpServletResponse response = new MockHttpServletResponse();
	new HelloAppEngine().doPost(null, response);
    Assert.assertEquals("text/html", response.getContentType());
    Assert.assertEquals("UTF-8", response.getCharacterEncoding());
    Assert.assertEquals("Hello App Engine!\r\n", response.getWriterContent().toString());
  }
}
