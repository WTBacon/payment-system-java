package jp.bacon.schedules;

import java.util.Calendar;
import java.util.GregorianCalendar;

import jp.bacon.domain.PaymentSchedule;

public class BiweeklySchedule implements PaymentSchedule {

  private final Calendar FIRST_PAYABLE_FRIDAY = new GregorianCalendar(2001, Calendar.NOVEMBER, 9);

  @Override
  public boolean IsPayDate(Calendar payDate) {
    Calendar cal = Calendar.getInstance();
    if ((payDate.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY)) {
      cal.setTime(FIRST_PAYABLE_FRIDAY.getTime());
      while (cal.compareTo(payDate) <= 0) {
        if (cal.equals(payDate)) {
          return true;
        }
        cal.add(Calendar.DATE, 14);
      }
    }
    return false;
  }

  @Override
  public Calendar GetPayPeriodStartDate(Calendar payDate) {
    Calendar payPeriodStartDate = Calendar.getInstance();
    payPeriodStartDate.setTime(payDate.getTime());
    payPeriodStartDate.add(Calendar.DATE, -13);
    return payPeriodStartDate;
  }
}
