package pkgEmpty;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Retirement;

import org.apache.poi.ss.formula.functions.*;

public class TestFinance {

	@Test
	public void TestPV() {

		int iYearsToWork = 40;
		double dAnnualReturnWorking = 7;
		int iYearsRetired = 20;
		double dAnnualReturnRetired = 2;
		double dRequiredIncome = 10000;
		double dMonthlySSI = 2642;
		
		Retirement ret = new Retirement(iYearsToWork, dAnnualReturnWorking,iYearsRetired, dAnnualReturnRetired, dRequiredIncome, dMonthlySSI);
		
		double PV = Retirement.PV(dAnnualReturnRetired / 12 / 100, iYearsRetired * 12, dRequiredIncome - dMonthlySSI, 0, false);
		double myPV = ret.TotalAmountToSave(); 
		
		System.out.println(PV);
		System.out.println(myPV);
		
		assertEquals(1454485.55,Math.abs(myPV),0.01);
		assertEquals(1454485.55,Math.abs(PV),0.01);
		
	}

	@Test
	public void TestPMT() {

		int iYearsToWork = 40;
		double dAnnualReturnWorking = 7;
		int iYearsRetired = 20;
		double dAnnualReturnRetired = 2;
		double dRequiredIncome = 10000;
		double dMonthlySSI = 2642;
		
		Retirement ret = new Retirement(iYearsToWork, dAnnualReturnWorking,iYearsRetired, dAnnualReturnRetired, dRequiredIncome, dMonthlySSI);
		
		double PMT = ret.PMT(dAnnualReturnWorking / 12 / 100, iYearsToWork * 12, 0,  ret.TotalAmountToSave(), false);
		double myPMT = ret.MonthlySavings();
		
		System.out.println(PMT);
		System.out.println(ret.MonthlySavings());
		
		assertEquals(554.13,Math.abs(myPMT),0.01);
		assertEquals(554.13,Math.abs(PMT),0.01);
	}
}
