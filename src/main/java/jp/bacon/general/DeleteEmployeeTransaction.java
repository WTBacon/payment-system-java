package jp.bacon.general;

import jp.bacon.db.GlobalDatabase;
import jp.bacon.transaction.Transaction;

public class DeleteEmployeeTransaction implements Transaction {

  private final int itsEmpId;

  public DeleteEmployeeTransaction(int empId) {
    itsEmpId = empId;
  }

  public void Execute() {
    GlobalDatabase.payrollDB.DeleteEmployee(itsEmpId);
  }
}
