package model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ model.management.AllTests.class,model.dao.AllTests.class,model.elements.AllTests.class })
public class ModelAllTests {

}
