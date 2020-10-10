package jp.bacon.schedules;

import java.util.Calendar;

import jp.bacon.domain.PaymentSchedule;

public class WeeklySchedule implements PaymentSchedule {

  @Override
  public boolean IsPayDate(Calendar payDate) {
    return (payDate.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY);
  }

  @Override
  public Calendar GetPayPeriodStartDate(Calendar payDate) {
    Calendar payPeriodStartDate = Calendar.getInstance();
    payPeriodStartDate.setTime(payDate.getTime());
    payPeriodStartDate.add(Calendar.DATE, -6);
    return payPeriodStartDate;
  }
}
