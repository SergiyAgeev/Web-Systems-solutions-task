package test.task.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import test.task.exceptions.BadArgumentsException;
import test.task.model.Values;
import test.task.service.ValuesService;

@Controller
public class ValuesController {
    private static final Logger LOGGER = Logger.getLogger(ValuesController.class);

    private final ValuesService valuesService;

    public ValuesController(ValuesService valuesService) {
        this.valuesService = valuesService;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculateValues(@RequestParam Double a,
                                  @RequestParam Double b,
                                  @RequestParam Double c,
                                  Model model) {
        try {
            Values values = new Values();
            values.setValueA(a);
            values.setValueB(b);
            values.setValueC(c);
            values.setRoot1(solveQuadraticOne(values));
            values.setRoot2(solveQuadraticTwo(values));
            valuesService.add(values);
            model.addAttribute("root", values);
        } catch (RuntimeException e) {
            LOGGER.error(e);
            model.addAttribute("error_msg", e);
            return "error";
        }
        return "result";
    }

    private Double getDeterminant(Values val) {
        return val.getValueB() * val.getValueB() - 4 * val.getValueA() * val.getValueC();
    }

    private Double solveQuadraticOne(Values values) throws RuntimeException {
        double determinant = getDeterminant(values);
        if (determinant < 0) {
            throw new BadArgumentsException("Determinant < 0");
        } else if (determinant == 0) {
            return -values.getValueB() / (2 * values.getValueA());
        }
        return (-values.getValueB() + Math.sqrt(determinant)) / (2 * values.getValueA());

    }

    private Double solveQuadraticTwo(Values values) throws RuntimeException {
        double determinant = getDeterminant(values);
        if (determinant < 0) {
            throw new BadArgumentsException("Determinant < 0");
        } else if (determinant == 0) {
            return -values.getValueB() / (2 * values.getValueA());
        }
        return (-values.getValueB() - Math.sqrt(determinant)) / (2 * values.getValueA());
    }
}
