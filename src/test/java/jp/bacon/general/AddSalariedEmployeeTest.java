package jp.bacon.general;

import jp.bacon.classifications.SalariedClassification;
import jp.bacon.methods.HoldMethod;
import jp.bacon.db.GlobalDatabase;
import jp.bacon.payrollDbImpl.PayrollDatabaseImpl;
import jp.bacon.domain.Employee;
import jp.bacon.domain.PaymentClassification;
import jp.bacon.domain.PaymentMethod;
import jp.bacon.domain.PaymentSchedule;
import jp.bacon.schedules.MonthlySchedule;
import junit.framework.TestCase;

public class AddSalariedEmployeeTest extends TestCase {

  public void setUp() {
    GlobalDatabase.payrollDB = new PayrollDatabaseImpl();
  }

  public void testAddSalariedEmployee() {
    System.err.println("AddSalariedEmployeeTest");
    int empId = 1;

    AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
    t.Execute();
    Employee e = GlobalDatabase.payrollDB.GetEmployee(empId);

    assertNotNull(e);
    assertEquals("Bob", e.GetName());

    PaymentClassification pc = e.GetClassification();
    SalariedClassification sc = (SalariedClassification) pc;

    assertNotNull(sc);
    assertEquals(1000.00, sc.GetSalary());

    PaymentSchedule ps = e.GetSchedule();
    MonthlySchedule ms = (MonthlySchedule) ps;

    assertNotNull(ms);

    PaymentMethod pm = e.GetMethod();
    HoldMethod hm = (HoldMethod) pm;

    assertNotNull(hm);
  }

}
