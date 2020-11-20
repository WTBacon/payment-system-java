package jp.bacon.general;

import jp.bacon.classifications.CommissionedClassification;
import jp.bacon.methods.HoldMethod;
import jp.bacon.db.GlobalDatabase;
import jp.bacon.payrollDbImpl.PayrollDatabaseImpl;
import jp.bacon.domain.Employee;
import jp.bacon.domain.PaymentClassification;
import jp.bacon.domain.PaymentMethod;
import jp.bacon.domain.PaymentSchedule;
import jp.bacon.schedules.BiweeklySchedule;
import junit.framework.TestCase;

public class AddCommissionedEmployeeTest extends TestCase {

  public void setUp() {
    GlobalDatabase.payrollDB = new PayrollDatabaseImpl();
  }

  public void testAddCommissionedEmployee() {
    System.err.println("TestAddCommissionedEmployee");
    int empId = 1;
    AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500.0, 3.2);
    t.Execute();
    Employee e = GlobalDatabase.payrollDB.GetEmployee(empId);
    assertNotNull(e);
    assertEquals("Lance", e.GetName());
    PaymentClassification pc = e.GetClassification();
    CommissionedClassification cc = (CommissionedClassification) pc;
    assertNotNull(cc);
    assertEquals(2500.0, cc.GetSalary());
    PaymentSchedule ps = e.GetSchedule();
    BiweeklySchedule bs = (BiweeklySchedule) ps;
    assertNotNull(bs);
    PaymentMethod pm = e.GetMethod();
    HoldMethod hm = (HoldMethod) pm;
    assertNotNull(hm);
  }
}
