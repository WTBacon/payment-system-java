package jp.bacon.ClassificationTransactions;

import java.util.Calendar;

import jp.bacon.classifications.HourlyClassification;
import jp.bacon.database.GlobalDatabase;
import jp.bacon.domain.Employee;
import jp.bacon.domain.PaymentClassification;
import jp.bacon.transaction.Transaction;

public class TimeCardTransaction implements Transaction {
	private final Calendar itsDate;
	private final double itsHours;
	private final int itsEmpId;

	public TimeCardTransaction(Calendar date, double hours, int empId) {
		itsDate = date;
		itsHours = hours;
		itsEmpId = empId;
	}

	public void Execute() {
		Employee e = GlobalDatabase.payrollDB.GetEmployee(itsEmpId);
		if (e != null) {
			PaymentClassification pc = e.GetClassification();
			if (pc instanceof HourlyClassification) {
				HourlyClassification hc = (HourlyClassification) pc;
				hc.AddTimeCard(itsDate, itsHours);
			} else {
				throw new RuntimeException("Tried to add timecard to non-hourly employee.");
			}
		} else {
			throw new RuntimeException("No such employee.");
		}
	}
}
