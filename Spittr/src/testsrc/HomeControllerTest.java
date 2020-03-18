package testsrc;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.spittr.web.HomeController;

public class HomeControllerTest {
	
//	@Test
//	public void testHome() {
//		HomeController hc = new HomeController();
//		assertEquals("home", hc.home());
//	}
	
	@Test
	public void testHomePage() throws Exception {
		HomeController home = new HomeController();
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(home).build();
		mockMvc
		.perform(MockMvcRequestBuilders.get("/"))
		.andExpect(MockMvcResultMatchers.view().name("home"));
	}
	
}
