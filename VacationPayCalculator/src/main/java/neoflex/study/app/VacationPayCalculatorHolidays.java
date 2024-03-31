package neoflex.study.app;

import java.time.MonthDay;

public enum VacationPayCalculatorHolidays {

    NEW_YEAR(MonthDay.of(1, 1)),
    NEW_YEAR_2(MonthDay.of(1, 2)),
    NEW_YEAR_3(MonthDay.of(1, 3)),
    NEW_YEAR_4(MonthDay.of(1, 4)),
    NEW_YEAR_5(MonthDay.of(1, 5)),
    NEW_YEAR_6(MonthDay.of(1, 6)),
    NEW_YEAR_7(MonthDay.of(1, 8)),
    CHRISTMAS(MonthDay.of(1, 7)),
    DEFENDER_OF_THE_FATHERLAND_DAY(MonthDay.of(2, 23)),
    INTERNATIONAL_WOMENS_DAY(MonthDay.of(3, 8)),
    MAY_DAY(MonthDay.of(5, 1)),
    VICTORY_DAY(MonthDay.of(5, 9)),
    DAY_OF_NATIONAL_UNITY(MonthDay.of(11, 4)),
    RUSSIA_DAY(MonthDay.of(12, 6));

    private final MonthDay monthDay;
    
    public MonthDay getMonthDay() {
        return monthDay;
    }
    
    VacationPayCalculatorHolidays(MonthDay monthDay) {
    	this.monthDay = monthDay;
    }
    
}
