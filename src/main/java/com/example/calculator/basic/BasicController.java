package com.example.calculator.basic;

import static com.example.calculator.model.ResultBuilder.getResult;
import static com.example.calculator.model.ResultBuilder.getResultFromError;

import java.util.Base64;

import com.example.calculator.model.ApiResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


@RestController
@RequestMapping("/basic")
public class BasicController {

   @GetMapping("/calculus")
   public ApiResult calculus(@RequestParam String inputString ) {
      try{
         byte[] decodedBytes = Base64.getDecoder().decode(inputString);
         String decodedString = new String(decodedBytes);
         Expression expression = new ExpressionBuilder(decodedString).build();
         return getResult(expression.evaluate());
      }catch(Exception e){
         return getResultFromError(e.getMessage());
      }
   }
}
