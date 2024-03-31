package neoflex.study.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
public class VacationPayCalculatorController {

    private final VacationPayCalculatorServices service;

    public VacationPayCalculatorController(VacationPayCalculatorServices service) {
        this.service = service;
    }

    @GetMapping("/calculate")
    public String getVacationPay(@RequestParam("salary") double salary,
                                 @RequestParam("vacation") int vacation,
                                 @RequestParam(value = "vacationStart", required = false) String vacationStart,
                                 @RequestParam(value = "vacationEnd", required = false) String vacationEnd)
            throws MissingServletRequestParameterException {

        try {
            if (vacationStart == null && vacationEnd == null) {
                return service.calculateVacationPay(salary, vacation);
            }
            return service.calculateVacationPay(salary, vacation, vacationStart, vacationEnd);
        }
        catch (NullPointerException ex) {
            if (vacationStart == null) throw new MissingServletRequestParameterException("vacationStart","String");
            else throw new MissingServletRequestParameterException("vacationEnd","String");
        }
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> handleNotFoundException(MissingServletRequestParameterException ex) {
        String msg = "Не указан параметр: " + ex.getParameterName();
        return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleNotFoundException(MethodArgumentTypeMismatchException ex) {
        String msg = "Неверный формат параметра: " + ex.getName();
        return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
    }

}
