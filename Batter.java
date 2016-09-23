package baseball;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Batter {
	
	//instance variables
	private String name, team;
	private LocalDate dob;
	private int age, ab, g;
	private double r, hr, rbi, sb, ops, obp, slg, war, rawValue, valueAboveZero, value;
	
	//constructor
	public Batter(String name, String team, LocalDate dob, int ab, int g, double r, double hr, double rbi, double sb,
			double ops, double obp, double slg, double war) {
		this.name = name;
		this.team = team;
		this.dob = dob;
		this.ab = ab;
		this.g = g;
		this.r = r;
		this.hr = hr;
		this.rbi = rbi;
		this.sb = sb;
		this.ops = ops;
		this.obp = obp;
		this.slg = slg;
		this.war = war;
	}
	
	public int getAge() {
		LocalDate now = LocalDate.now();
		this.age = (int) ChronoUnit.YEARS.between(this.dob, now);
		return this.age;
	}
	
	public double calcRawValue() {
		this.rawValue = ((this.r/19.16666667)+(this.hr/11.5)+(this.rbi/20.83333333)+(this.sb/7.537037037)+((((((this.obp*(this.ab*1.15))+2178.8)/((this.ab*1.15)+6682))+(((this.slg*this.ab)+2528.5)/(this.ab+5993)))-0.748)/0.005055555556));
		//this.rawValue = ((this.r/SGP.getRAvg())+(this.hr/SGP.getHRAvg())+(this.rbi/SGP.getRBIAvg())+(this.sb/SGP.getSBAvg())+((((((this.obp*(this.ab*1.15))+2178.8)/((this.ab*1.15)+6682))+(((this.slg*this.ab)+2528.5)/(this.ab+5993)))-0.748)/SGP.getOPSAvg()));
		return this.rawValue;
	}
	
	public double calcValueAboveZero() {
		this.valueAboveZero = this.rawValue - 5.91;
		//this.valueAboveZero = this.rawValue - (average of x largest rawValues, where x is the number of players with avg $ values above 0);
		return this.valueAboveZero;
	}
	
	public double calcValue() {
		double priceMult = 2.1192;
		this.value = (this.valueAboveZero*(this.rawValue/5.91))*priceMult;
		this.value = Math.round(this.value * 100.0) / 100.0;
		return this.value;
	}
	
	public static void main(String[] args) {
		Batter ca = new Batter("Colin Aardsma", "CHC", LocalDate.of(1981, 10, 24), 600, 162, 102, 40, 110, 25, 1.115, .515, .600, 4.7);

		System.out.println(ca.getAge());
		System.out.println(ca.calcRawValue());
		System.out.println(ca.calcValueAboveZero());
		System.out.println("$" + ca.calcValue());
	}
	
	
//	Calendar c = new GregorianCalendar();
//    c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
//    c.set(Calendar.MINUTE, 0);
//    c.set(Calendar.SECOND, 0);
//    Date d1 = c.getTime(); //the midnight, that's the first second of the day.


}
