import java.util.concurrent.TimeUnit;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.NotifyBuilder;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertTrue;

import com.nisum.SpringApp;

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest(classes=SpringApp.class)
public class SampleCamelAppTest {
	
	@Autowired
	public CamelContext camelContext;
	
	@Test
	public void printsMessagesOnConsoleForEvery2Secs(){
		
		NotifyBuilder notifyBuilder = new NotifyBuilder(camelContext).whenDone(2).create();
		
		assertTrue(notifyBuilder.matches(3, TimeUnit.SECONDS));
	}
	
}
