package jp.bacon.affilliatons;

import java.util.Calendar;

import jp.bacon.domain.Paycheck;

/**
 * In the beginning we thought this implementation class would have paychecks for any employees
 * but we got a method determining the payment schedule should be in PaymentSchedule class.
 * Therefore this class has itsPayPeriodStartDate and itsPayPeriodEndDate
 */
public class PaycheckImplementation implements Paycheck {

  private final Calendar itsPayPeriodStartDate;
  private final Calendar itsPayPeriodEndDate;

  // GrossPay is calculated by PaymentClassification
  private double itsGrossPay;
  // Deductions is calculated by Affiliation
  private double itsDeductions;
  // NetPay is calculated by (grossPay - deductions)
  private double itsNetPay;

  public PaycheckImplementation(Calendar payPeriodStartDate, Calendar payPeriodEndDate) {
    itsPayPeriodStartDate = payPeriodStartDate;
    itsPayPeriodEndDate = payPeriodEndDate;
  }

  @Override
  public Calendar GetPayPeriodStartDate() {
    return itsPayPeriodStartDate;
  }

  @Override
  public Calendar GetPayPeriodEndDate() {
    return itsPayPeriodEndDate;
  }

  @Override
  public double GetGrossPay() {
    return itsGrossPay;
  }

  @Override
  public void SetGrossPay(double grossPay) {
    itsGrossPay = grossPay;
  }

  @Override
  public String GetField(String string) {
    if (string.equals("Disposition")) {
      return "Hold";
    }
    return null;
  }

  @Override
  public double GetDeductions() {
    return itsDeductions;
  }

  @Override
  public void SetDeductions(double deductions) {
    itsDeductions = deductions;
  }

  @Override
  public double GetNetPay() {
    return itsNetPay;
  }

  @Override
  public void SetNetPay(double netPay) {
    itsNetPay = netPay;
  }
}
