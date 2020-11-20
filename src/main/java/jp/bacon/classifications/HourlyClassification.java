package jp.bacon.classifications;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import jp.bacon.domain.Paycheck;
import jp.bacon.domain.PaymentClassification;
import jp.bacon.util.Date;

/**
 * The employees who have this commission can get their salaries according to their work time. To do
 * that, this classification must have employees' time cards (itsTimeCards) and hourly wage
 * (itsHourlyRate).
 */
public class HourlyClassification implements PaymentClassification {

  private final Map<Calendar, TimeCard> itsTimeCards;
  private final double itsHourlyRate;

  public HourlyClassification(double hourlyRate) {
    itsTimeCards = new HashMap<Calendar, TimeCard>();
    itsHourlyRate = hourlyRate;
  }

  public double GetRate() {
    return itsHourlyRate;
  }

  public TimeCard GetTimeCard(Calendar date) {
    return itsTimeCards.get(date);
  }

  public void AddTimeCard(Calendar date, double amount) {
    itsTimeCards.put(date, new TimeCard(date, amount));
  }

  @Override
  public double CalculatePay(Paycheck pc) {
    double totalPay = 0;
    for (TimeCard tc : itsTimeCards.values()) {
      if (Date.IsBetween(tc.GetDate(), pc.GetPayPeriodStartDate(), pc.GetPayPeriodEndDate())) {
        if (8 < tc.GetHours()) {
          totalPay += itsHourlyRate * 8 + itsHourlyRate * (tc.GetHours() - 8) * 1.5;
        } else {
          totalPay += itsHourlyRate * tc.GetHours();
        }
      }
    }
    return totalPay;
  }
}
