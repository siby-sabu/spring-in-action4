package testsrc;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import com.spittr.Spittle;
import com.spittr.data.SpittleRepository;
import com.spittr.web.SpittleController;


public class SpittleControllerTest {
	
	@Test
	public void shouldShowRecentSpittles() throws Exception {
		
		
		List<Spittle> expectedSpittles = createSpittleList(20);
		SpittleRepository repository = Mockito.mock(SpittleRepository.class);
		when(repository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);
		SpittleController controller = new SpittleController(repository);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
				.build();
		mockMvc.perform(MockMvcRequestBuilders.get("/spittles"))
		.andExpect(MockMvcResultMatchers.view().name("spittles"))
		.andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
		.andExpect(MockMvcResultMatchers.model().attribute("spittleList", Matchers.hasItems(expectedSpittles.toArray())));
}
	
	@Test
	public void shouldReturnPagedSpittles() throws Exception {
		List<Spittle> expectedSpittles = createSpittleList(50);
		SpittleRepository repository = mock(SpittleRepository.class);
		SpittleController controller = new SpittleController(repository);
		when(repository.findSpittles(12345, 50)).thenReturn(expectedSpittles);
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/spittles"))
				.build();
		
		mockMvc.perform(MockMvcRequestBuilders.get("/spittles?max=12345&count=50"))
		.andExpect(MockMvcResultMatchers.view().name("spittles"))
		.andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
		.andExpect(MockMvcResultMatchers.model().attribute("spittleList", Matchers.hasItems(expectedSpittles.toArray())));
	}
	
	@Test
	public void shouldReturnOneSpittle() throws Exception {
		Spittle expectedSpittle = new Spittle(12345l, "Test Spittle", new Date(), 1.0d, 2.0d);
		
		SpittleRepository repository  = mock(SpittleRepository.class);
		when(repository.findOne(12345l)).thenReturn(expectedSpittle);
		SpittleController controller =new SpittleController(repository);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/spittles/12345"))
		.andExpect(MockMvcResultMatchers.view().name("spittle"))
		.andExpect(MockMvcResultMatchers.model().attributeExists("spittle"))
		.andExpect(MockMvcResultMatchers.model().attribute("spittle", expectedSpittle));
	}

	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<>();
		for(int i = 0;i<count;i++) {
			spittles.add(new Spittle("spittle"+i, new Date()));
		}
		return spittles;
	}


}
