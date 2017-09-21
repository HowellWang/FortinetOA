While there is no concrete DB in the project, we consider using Mock Object to complete the test work. 
We can use JUnit and Mockito to test the service layer implementation class.

In order to complete the test, we need to do such steps:

- Add Mockito Framework for Unit tests mockito-core to project's pom.xml file
- Create ServiceTest class, Autowire service class, mock objects, call service method and Assert expected results.


example:
```java
public class ServiceTest {

    @Mock
    Database database;
    
 
    @Autowired
    @InjectMocks

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void test() {
        
        //Mocking Database open and close methods
        doNothing().when(database).openConnection();
        doNothing().when(database).closeConnection();
        ////
    }
}
```