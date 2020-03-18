package testsrc;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.spittr.Spitter;
import com.spittr.data.SpitterRepository;
import com.spittr.web.SpitterController;

public class SpitterControllerTest {
	
	@Test
	public void shouldShowRegistrationForm() throws Exception {
		SpitterController controller = new SpitterController();
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/spitter/register"))
		.andExpect(MockMvcResultMatchers.view().name("registrationForm"));
		
	}
	
	@Test
	public void shouldProcessRegistration() throws Exception {
		
//		SpitterRepository repository = mock(SpitterRepository.class);
//		Spitter beforeSave = new Spitter("Jack", "Bauer", "jbauer", "24hours");
//		Spitter afterSave = new Spitter(24l,"Jack", "Bauer", "jbauer", "24hours");
//		when(repository.save(beforeSave)).thenReturn(afterSave);
//		
//		SpitterController controller = new SpitterController(repository);
//		
//		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
//								.build();
//		mockMvc.perform(MockMvcRequestBuilders.post("/spitter/register")
//				.param("firstName", "Jack")
//				.param("lastName", "Bauer")
//				.param("userName", "jbauer")
//				.param("password", "24hours"))
//		.andExpect(MockMvcResultMatchers.redirectedUrl("/spitter/jbauer"));
//		
//		verify(repository,atLeastOnce()).save(beforeSave);
		
		
		
		
		
	}

}
