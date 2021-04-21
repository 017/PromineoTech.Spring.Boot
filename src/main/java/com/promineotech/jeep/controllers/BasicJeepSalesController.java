package com.promineotech.jeep.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.jeep.entity.Jeep;

@RestController()
@RequestMapping("/jeeps")
public class BasicJeepSalesController implements JeepSalesController {
  public List<Jeep> fetchJeeps(String model, String trim) {
    return null;
  }
}
