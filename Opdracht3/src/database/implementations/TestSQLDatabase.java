package database.implementations;

import static org.junit.Assert.*;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import common.DBException;
import common.DBMissingException;
import common.factories.CustomerFactory;
import database.helpers.DataSource;
import model.Customer;
import model.ModelBase;
import model.Person;

public class TestSQLDatabase {

        private DatabaseSQL<Person> personDb = new DatabaseSQL<Person>(Person.class);
        private DatabaseSQL<Customer> customerDb = new DatabaseSQL<Customer>(Customer.class);

        @BeforeClass
        public static void setUpBeforeClass() throws Exception {
                DataSourceFactory.setType(DataSource.SQL);
        }

        @AfterClass
        public static void tearDownAfterClass() throws Exception {
        }

        @Before
        public void setUp() throws Exception {
                dropTable(personDb);
                personDb.createTable();

                dropTable(customerDb);
                customerDb.createTable();
        }

        private void dropTable(DatabaseSQL<? extends ModelBase> db) throws SQLException {
                Connection conn = null;
                try {
                        conn = personDb.createConnection();
                        Statement s = conn.createStatement();
                        s.execute("DROP TABLE " + db.getTableName());
                        s.close();

                } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                if (conn != null) conn.close();
        }

        @Test
        public void testWriteDB() throws DBMissingException, DBException, SQLException {
                List<Person> persons = new ArrayList<Person>();
                Person p1 = new Person();
                p1.setFirstName("Sven");
                p1.setLastName("Awesome");
                p1.setId(1);
                Person p2 = new Person();
                p2.setFirstName("Peter");
                p2.setLastName("Dude");
                p2.setId(2);
                Person p3 = new Person();
                p3.setFirstName("Andre");
                p3.setLastName("Doc");
                p3.setId(3);
                persons.add(p1);
                persons.add(p2);
                persons.add(p3);

                personDb.writeDB(persons, false);

                List <Person> persoonslijst = personDb.readDB();
                assertTrue(persoonslijst.contains(p1));
                assertTrue(persoonslijst.contains(p2));
                assertTrue(persoonslijst.contains(p3));

        }


        @Test
        public void testComplexWriteDB() throws DBMissingException, DBException, SQLException {
                List<Customer> customers = new ArrayList<Customer>();

                for (int i = 0; i < 10; i++) {
                	Customer c = CustomerFactory.getCustomer();
                	c.setId(i+1);
                        customers.add(c);
                }

                customerDb.writeDB(customers, false);

                List <Customer> customersReturned = customerDb.readDB();
                assertEquals(10, customersReturned.size());

                for (Customer customer : customersReturned) {
                        assertTrue(customers.contains(customer));
                }
        }

}