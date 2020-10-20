package jp.bacon.general;

import jp.bacon.classifications.HourlyClassification;
import jp.bacon.domain.PaymentClassification;
import jp.bacon.domain.PaymentSchedule;
import jp.bacon.schedules.WeeklySchedule;

public class AddHourlyEmployee extends AddEmployeeTransaction {

  private final double itsHourlyRate;

  public AddHourlyEmployee(int empId, String name, String address, double hourlyRate) {
    super(empId, name, address);
    itsHourlyRate = hourlyRate;
  }

  @Override
  PaymentClassification GetClassification() {
    return new HourlyClassification(itsHourlyRate);
  }

  @Override
  PaymentSchedule GetSchedule() {
    return new WeeklySchedule();
  }
}
