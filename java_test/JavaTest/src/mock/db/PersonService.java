package mock.db;

public class PersonService {
	
	private PersonDao myDao;
	
	public PersonService(PersonDao myDao) {
		this.myDao = myDao;
	}
	
	public Person findById(long id) {
		return myDao.findById(id);
	}

}