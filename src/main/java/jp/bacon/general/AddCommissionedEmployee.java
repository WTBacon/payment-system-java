package jp.bacon.general;

import jp.bacon.classifications.CommissionedClassification;
import jp.bacon.domain.PaymentClassification;
import jp.bacon.domain.PaymentSchedule;
import jp.bacon.schedules.BiweeklySchedule;

public class AddCommissionedEmployee extends AddEmployeeTransaction {

  private final double itsSalary;
  private final double itsCommissionRate;

  public AddCommissionedEmployee(int empId, String name, String address, double salary,
      double commissionRate) {
    super(empId, name, address);
    itsSalary = salary;
    itsCommissionRate = commissionRate;
  }

  @Override
  PaymentClassification GetClassification() {
    return new CommissionedClassification(itsSalary, itsCommissionRate);
  }

  @Override
  PaymentSchedule GetSchedule() {
    return new BiweeklySchedule();
  }
}
