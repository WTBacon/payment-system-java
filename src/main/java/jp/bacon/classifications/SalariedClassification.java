package jp.bacon.classifications;

import jp.bacon.domain.Paycheck;
import jp.bacon.domain.PaymentClassification;

public class SalariedClassification implements PaymentClassification {

  private final double itsSalary;

  public SalariedClassification(double salary) {
    itsSalary = salary;
  }

  public double GetSalary() {
    return itsSalary;
  }

  @Override
  public double CalculatePay(Paycheck pc) {
    return itsSalary;
  }
}
