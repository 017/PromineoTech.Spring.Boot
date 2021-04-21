package com.promineotech.jeep.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.jeep.entity.Jeep;

@RestController
public class BasicJeepSalesController implements JeepSalesController {
  public List<Jeep> fetchJeeps(String model, String trim) {
    return null;
  }
}
