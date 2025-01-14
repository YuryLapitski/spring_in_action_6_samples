package tacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import tacos.entity.TacoOrder;
import tacos.repository.TacoOrderRepository;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    private final TacoOrderRepository tacoOrderRepository;

    @Autowired
    public OrderController(TacoOrderRepository tacoOrderRepository) {
        this.tacoOrderRepository = tacoOrderRepository;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        tacoOrderRepository.save(tacoOrder);
        sessionStatus.setComplete();

        return "redirect:/";
    }

//    @PostMapping
//    public String processOrder(@Valid TacoOrder order, Errors errors,
//                               SessionStatus sessionStatus) {
//        if (errors.hasErrors()) {
//            log.info(errors.getAllErrors().toString());
//            return "orderForm";
//        }
//
//        log.info("Order submitted: {}", order);
//        sessionStatus.setComplete();
//
//        return "redirect:/";
//    }
}
