package jp.bacon.general;

import jp.bacon.classifications.HourlyClassification;
import jp.bacon.methods.HoldMethod;
import jp.bacon.db.GlobalDatabase;
import jp.bacon.payrollDbImpl.PayrollDatabaseImpl;
import jp.bacon.domain.Employee;
import jp.bacon.domain.PaymentClassification;
import jp.bacon.domain.PaymentMethod;
import jp.bacon.domain.PaymentSchedule;
import jp.bacon.schedules.WeeklySchedule;
import junit.framework.TestCase;

public class AddHourlyEmployeeTest extends TestCase {

  public void setUp() {
    GlobalDatabase.payrollDB = new PayrollDatabaseImpl();
  }

  public void testAddHourlyEmployee() {
    System.err.println("TestAddHourlyEmployee");
    int empId = 2;
    AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
    t.Execute();
    Employee e = GlobalDatabase.payrollDB.GetEmployee(empId);
    assertNotNull(e);
    assertEquals("Bill", e.GetName());
    PaymentClassification pc = e.GetClassification();
    HourlyClassification hc = (HourlyClassification) pc;
    assertNotNull(hc);
    assertEquals(15.25, hc.GetRate());
    PaymentSchedule ps = e.GetSchedule();
    WeeklySchedule ws = (WeeklySchedule) ps;
    assertNotNull(ws);
    PaymentMethod pm = e.GetMethod();
    HoldMethod hm = (HoldMethod) pm;
    assertNotNull(hm);
  }

}
