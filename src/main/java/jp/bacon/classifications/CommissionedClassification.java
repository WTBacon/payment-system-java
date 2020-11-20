package jp.bacon.classifications;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import jp.bacon.domain.Paycheck;
import jp.bacon.domain.PaymentClassification;
import jp.bacon.util.Date;

/**
 * The employees who have this commission can get their rewards according to their achievement. To
 * do that, this classification must have employees' sales (itsReceipts) and commission rate
 * (itsCommission Rate).
 */
public class CommissionedClassification implements PaymentClassification {

  private final double itsSalary;
  private final double itsCommissionRate;
  private final Map<Calendar, SalesReceipt> itsReceipts;

  public CommissionedClassification(double salary, double commissionRate) {
    itsSalary = salary;
    itsCommissionRate = commissionRate;
    itsReceipts = new HashMap<Calendar, SalesReceipt>();
  }

  public double GetSalary() {
    return itsSalary;
  }

  public double GetRate() {
    return itsCommissionRate;
  }

  public void AddReceipt(Calendar saleDate, double amount) {
    itsReceipts.put(saleDate, new SalesReceipt(saleDate, amount));
  }

  public SalesReceipt GetReceipt(Calendar date) {
    return itsReceipts.get(date);
  }

  @Override
  public double CalculatePay(Paycheck pc) {
    double commission = 0.0;
    for (SalesReceipt receipt : itsReceipts.values()) {
      if (Date.IsBetween(receipt.GetSaleDate(), pc.GetPayPeriodStartDate(), pc
          .GetPayPeriodEndDate())) {
        commission += receipt.GetAmount() * itsCommissionRate;
      }
    }
    return itsSalary + commission;
  }
}
