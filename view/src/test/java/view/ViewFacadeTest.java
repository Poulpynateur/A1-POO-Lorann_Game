package view;

import static org.junit.Assert.*;

import org.junit.*;

public class ViewFacadeTest {

	private ViewFacade viewFacade;

	@Before
	public void setUp() throws Exception {
		viewFacade = new ViewFacade();
	}


	@Test
	public void testGetScore() {
		assertEquals(viewFacade.score,viewFacade.getScore());
	}

}
