package com.curso.springboot.Controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.springboot.Exceptions.UnsuportedMathOperationException;

@RestController
public class MathController {

  @RequestMapping("/sum/{n1}/{n2}")
  public Double greeting(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2)
      throws Exception {
    if (!isNumeric(n1) || !isNumeric(n2)) {
      throw new UnsuportedMathOperationException("Please, set a numeric value");
    }

    return convertToDouble(n1) + convertToDouble(n2);
  }

  @RequestMapping("/subtraction/{n1}/{n2}")
  public Double subtraction(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2)
      throws Exception {
    if (!isNumeric(n1) || !isNumeric(n2)) {
      throw new UnsuportedMathOperationException("Please, set a numeric value");
    }

    return convertToDouble(n1) - convertToDouble(n2);
  }

  @RequestMapping("/multi/{n1}/{n2}")
  public Double multiplying(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2)
      throws Exception {
    if (!isNumeric(n1) || !isNumeric(n2)) {
      throw new UnsuportedMathOperationException("Please, set a numeric value");
    }

    return convertToDouble(n1) * convertToDouble(n2);
  }

  @RequestMapping("/divide/{n1}/{n2}")
  public Double divide(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2)
      throws Exception {
    if (!isNumeric(n1) || !isNumeric(n2)) {
      throw new UnsuportedMathOperationException("Please, set a numeric value");
    }

    return convertToDouble(n1) / convertToDouble(n2);
  }

  @RequestMapping("/middle/{n1}/{n2}")
  public Double middle(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2)
      throws Exception {
    if (!isNumeric(n1) || !isNumeric(n2)) {
      throw new UnsuportedMathOperationException("Please, set a numeric value");
    }

    return (convertToDouble(n1) + convertToDouble(n2)) / 2;
  }

  @RequestMapping("/square/{n1}")
  public Double square(@PathVariable(value = "n1") String n1)
      throws Exception {
    if (!isNumeric(n1)) {
      throw new UnsuportedMathOperationException("Please, set a numeric value");
    }

    return Math.sqrt(convertToDouble(n1));
  }

  private Double convertToDouble(String strNumber) {
    if (strNumber == null) {
      return 0D;
    }
    String number = strNumber.replaceAll(",", ".").trim();
    return Double.parseDouble(number);
  }

  private boolean isNumeric(String strNumber) {
    if (strNumber == null) {
      return false;
    }
    String number = strNumber.replaceAll(",", ".").trim();

    return number.matches("[-+]?[0-9]*\\.?[0-9]+");
  }
}
