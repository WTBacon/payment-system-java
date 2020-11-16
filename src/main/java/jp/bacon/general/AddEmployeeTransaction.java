package jp.bacon.general;

import jp.bacon.methods.HoldMethod;
import jp.bacon.db.GlobalDatabase;
import jp.bacon.domain.Employee;
import jp.bacon.domain.PaymentClassification;
import jp.bacon.domain.PaymentMethod;
import jp.bacon.domain.PaymentSchedule;
import jp.bacon.transaction.Transaction;

public abstract class AddEmployeeTransaction implements Transaction {

  private final int itsEmpId;
  private final String itsName;
  private final String itsAddress;

  public AddEmployeeTransaction(int empId, String name, String address) {
    itsEmpId = empId;
    itsName = name;
    itsAddress = address;
  }

  @Override
  public void Execute() {
    PaymentClassification pc = GetClassification();
    PaymentSchedule ps = GetSchedule();
    PaymentMethod pm = new HoldMethod();
    Employee e = new Employee(itsEmpId, itsName, itsAddress);
    e.SetClassification(pc);
    e.SetSchedule(ps);
    e.SetMethod(pm);
    GlobalDatabase.payrollDB.AddEmployee(itsEmpId, e);
  }

  abstract PaymentSchedule GetSchedule();

  abstract PaymentClassification GetClassification();
}
