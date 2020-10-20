package jp.bacon.general;

import jp.bacon.classifications.SalariedClassification;
import jp.bacon.domain.PaymentClassification;
import jp.bacon.domain.PaymentSchedule;
import jp.bacon.schedules.MonthlySchedule;

public class AddSalariedEmployee extends AddEmployeeTransaction {

  private final double itsSalary;

  public AddSalariedEmployee(int empId, String name, String address, double salary) {
    super(empId, name, address);
    itsSalary = salary;
  }

  @Override
  public PaymentClassification GetClassification() {
    return new SalariedClassification(itsSalary);
  }

  @Override
  public PaymentSchedule GetSchedule() {
    return new MonthlySchedule();
  }
}
