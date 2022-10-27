package com.example.diagnositexample;

import org.springframework.stereotype.Service;
import src.syck.diagnostic.data.Level;
import src.syck.diagnostic.utils.MetaDataUtils;
import syckdiagnostic.syckdiagnosticstarter.aspect.DiagnosticBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static src.syck.diagnostic.data.DiagnosticEntryBuilder.entry;
import static src.syck.diagnostic.data.DiagnosticEntryBuilder.info;
import static syck.diagnostic.context.DiagnosticCtxHolder.ctx;
@DiagnosticBean
@Service
public class DefaultCalc implements Calculator{
    @Override
    public int add(ExampleController.AddRequest r) {
        if(r.getTwo() > 1000) throw new IllegalArgumentException("Value is To high");
        return r.getOne() + r.getTwo();
    }
}
