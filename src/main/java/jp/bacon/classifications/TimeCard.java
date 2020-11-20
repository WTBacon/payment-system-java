package jp.bacon.classifications;

import java.util.Calendar;

public class TimeCard {

  private final Calendar itsDate;
  private final double itsHours;

  public TimeCard(Calendar date, double hours) {
    itsDate = date;
    itsHours = hours;
  }

  public Calendar GetDate() {
    return itsDate;
  }

  public double GetHours() {
    return itsHours;
  }
}
