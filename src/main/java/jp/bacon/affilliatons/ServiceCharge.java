package jp.bacon.affilliatons;

import java.util.Calendar;

public class ServiceCharge {

  private final Calendar itsDate;
  private final double itsAmount;

  public ServiceCharge(Calendar date, double amount) {
    itsDate = date;
    itsAmount = amount;
  }

  public Calendar GetDate() {
    return itsDate;
  }

  public double GetAmount() {
    return itsAmount;
  }
}
