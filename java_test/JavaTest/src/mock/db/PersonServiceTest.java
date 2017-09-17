package mock.db;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class PersonServiceTest {
	
	@Mock private PersonDao personDao;
	
	@Test
	public void testFindById() {
		MockitoAnnotations.initMocks(this);
		PersonService service = new PersonService(personDao);
		service.findById(1L);
		Mockito.verify(personDao).findById(1L);
	}
	
	@Test
	public void test() {
		PersonService service = new PersonService(personDao);
		Mockito.when(personDao.findById(1L)).thenReturn(createTestEntity());
		Person actual = service.findById(1L);
		Assert.assertEquals("John", actual.getFirstName());
		Assert.assertEquals("Oliver", actual.getLastName());
		Mockito.verify(personDao).findById(1L);
	}
	
	private Person createTestEntity() {
		Person entity = new Person();
		entity.setFirstName("John");
		entity.setLastName("Oliver");
		return entity;
	}

}