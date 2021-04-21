package com.promineotech.jeep.dao;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import com.promineotech.jeep.entity.Color;
import com.promineotech.jeep.entity.Customer;
import com.promineotech.jeep.entity.Engine;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.Option;
import com.promineotech.jeep.entity.OrderRequest;
import com.promineotech.jeep.entity.Tire;

public class DefaultJeepOrderService
{
  @Autowired
  protected JeepOrderDao jeepOrderDao;
  
  /**
   * 
   * @param orderRequest
   * @return
   */
  private List<Option> getOption(OrderRequest orderRequest) {
    return jeepOrderDao.fetchOptions(orderRequest.getOptions());
  }

  /**
   * 
   * @param orderRequest
   * @return
   */
  protected Tire getTire(OrderRequest orderRequest) {
    return jeepOrderDao.fetchTire(orderRequest.getTire())
        .orElseThrow(() -> new NoSuchElementException(
            "Tire with ID=" + orderRequest.getTire() + " was not found"));
  }

  /**
   * 
   * @param orderRequest
   * @return
   */
  protected Engine getEngine(OrderRequest orderRequest) {
    return jeepOrderDao.fetchEngine(orderRequest.getEngine())
        .orElseThrow(() -> new NoSuchElementException(
            "Engine with ID=" + orderRequest.getEngine() + " was not found"));
  }

  /**
   * 
   * @param orderRequest
   * @return
   */
  protected Color getColor(OrderRequest orderRequest) {
    return jeepOrderDao.fetchColor(orderRequest.getColor())
        .orElseThrow(() -> new NoSuchElementException(
            "Color with ID=" + orderRequest.getColor() + " was not found"));
  }

  /**
   * 
   * @param orderRequest
   * @return
   */
  protected Jeep getModel(OrderRequest orderRequest) {
    return jeepOrderDao
        .fetchModel(orderRequest.getModel(), orderRequest.getTrim(),
            orderRequest.getDoors())
        .orElseThrow(() -> new NoSuchElementException("Model with ID="
            + orderRequest.getModel() + ", trim=" + orderRequest.getTrim()
            + orderRequest.getDoors() + " was not found"));
  }

  /**
   * 
   * @param orderRequest
   * @return
   */
  protected Customer getCustomer(OrderRequest orderRequest) {
    return jeepOrderDao.fetchCustomer(orderRequest.getCustomer())
        .orElseThrow(() -> new NoSuchElementException("Customer with ID="
            + orderRequest.getCustomer() + " was not found"));
  }
}