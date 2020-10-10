package jp.bacon.schedules;

import java.util.Calendar;

import jp.bacon.domain.PaymentSchedule;

public class MonthlySchedule implements PaymentSchedule {

  private boolean IsLastDayOfMonth(Calendar date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date.getTime());
    return (cal.getActualMaximum(Calendar.DATE) == cal.get(Calendar.DATE));
  }

  @Override
  public boolean IsPayDate(Calendar payDate) {
    return IsLastDayOfMonth(payDate);
  }

  @Override
  public Calendar GetPayPeriodStartDate(Calendar payDate) {
    Calendar payPeriodStartDate = Calendar.getInstance();
    payPeriodStartDate.setTime(payDate.getTime());
    payPeriodStartDate.set(Calendar.DATE, 1);
    return payPeriodStartDate;
  }
}
