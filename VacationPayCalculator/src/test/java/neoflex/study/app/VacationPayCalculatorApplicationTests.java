package neoflex.study.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class VacationPayCalculatorApplicationTests {

    @Autowired
    private VacationPayCalculatorServices service;

    @Test
    public void testCalculateVacationPayWithValidDates() {
        double salary = 1000000.0;
        int vacation = 20;
        String vacationStart = "01.01.2023";
        String vacationEnd = "10.01.2023";

        String result = service.calculateVacationPay(salary, vacation, vacationStart, vacationEnd);

        assertEquals("32876.64", result);
    }

    @Test
    public void testCalculateVacationPayWithInvalidDates() {
        double salary = 1000000.0;
        int vacation = 20;
        String vacationStart = "04.05.2023";
        String vacationEnd = "01.02.2023";

        String result = service.calculateVacationPay(salary, vacation, vacationStart, vacationEnd);

        assertEquals("Начальная дата должна быть меньше конечной", result);
    }

    @Test
    public void testCalculateVacationPayWithNegativeSalary() {
        double salary = -1000000.0;
        int vacation = 20;
        String vacationStart = "01.01.2023";
        String vacationEnd = "14.01.2023";

        String result = service.calculateVacationPay(salary, vacation, vacationStart, vacationEnd);

        assertEquals("salary не может быть меньше 0", result);
    }

    @Test
    public void testCalculateVacationPayWithNegativeVacation() {
        double salary = 1000000.0;
        int vacation = -20;
        String vacationStart = "01.01.2023";
        String vacationEnd = "10.01.2023";

        String result = service.calculateVacationPay(salary, vacation, vacationStart, vacationEnd);

        assertEquals("vacation не может быть меньше 0", result);
    }

    @Test
    public void testCalculateVacationPayWithInvalidEndDate() {
        double salary = 1000000.0;
        int vacation = 20;
        String vacationStart = "01.01.2023";
        String vacationEnd = "10.01.2023fd";

        String result = service.calculateVacationPay(salary, vacation, vacationStart, vacationEnd);

        assertEquals("Неверная конечная дата отпуска", result);
    }

    @Test
    public void testCalculateVacationPayWithInvalidStartDate() {
        double salary = 1000000.0;
        int vacation = 20;
        String vacationStart = "01d.01.2023";
        String vacationEnd = "10.01.2023";

        String result = service.calculateVacationPay(salary, vacation, vacationStart, vacationEnd);

        assertEquals("Неверная начальная дата отпуска", result);
    }
    
    @Test
    public void testCalculateVacationPayWithInvalidDate() {
        double salary = 1000000.0;
        int vacation = 20;
        String vacationStart = "01.01.2023";
        String vacationEnd = "10.01.2023";

        String result = service.calculateVacationPay(salary, vacation, vacationStart, vacationEnd);

        assertEquals("vacation и количество дней между датами не совпадает", result);
    }

}
