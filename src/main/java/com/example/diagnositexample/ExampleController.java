package com.example.diagnositexample;

import lombok.AllArgsConstructor;
import lombok.CustomLog;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import syck.diagnostic.factory.DiagnosticFactory;
import syck.diagnostic.proxy.DiagnosticProxyFactory;
import syckdiagnostic.syckdiagnosticstarter.aspect.SyckDiagnostic;

import static syck.diagnostic.context.DiagnosticCtxBuilder.http;

@RestController
@CustomLog
public class ExampleController {

//    private final Logger logger = DiagnosticLoggerFactory.getLogger(ExampleController.class);
    private final Calculator calculator;

    private final DiagnosticFactory factory;

    public ExampleController(Calculator calculator, DiagnosticFactory factory) {
        this.calculator = calculator;
        this.factory = factory;
    }

    @GetMapping("/{one}/{two}/{userId}")
    @SyckDiagnostic(type = "CALCULATOR", correlationId = "#userId")
    public ResponseEntity<?> handle (@PathVariable int one, @PathVariable int two,  @PathVariable String userId) {

        log.info("Test of diagnostic logger custom annoation");

        return ResponseEntity.ok(calculator.add(new AddRequest(one, two)));
    }

    @Data
    @AllArgsConstructor
    static class AddRequest {
        private int one;
        private int two;
    }
}
