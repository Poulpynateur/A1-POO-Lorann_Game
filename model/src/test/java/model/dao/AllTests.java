package model.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AbstractDAOTest.class, ImportLevelTest.class, LorannBDDConnectorTest.class,ProcedureDAOTest.class })
public class AllTests {

}