package jp.bacon.domain;

import java.util.Calendar;

public class NoAffiliation implements Affiliation {

  @Override
  public double GetServiceCharge(Calendar date) {
    return 0;
  }

  @Override
  public double CalculateDeductions(Paycheck pc) {
    return 0;
  }
}
