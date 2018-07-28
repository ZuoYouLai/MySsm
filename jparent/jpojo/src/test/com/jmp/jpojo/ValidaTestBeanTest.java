package com.jmp.jpojo;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;

public class ValidaTestBeanTest {

     /**
        *
        */
      @Test
      public void test001(){
          ValidaTestBean validaTestBean = new ValidaTestBean();
          validaTestBean.setAge(300);
          System.err.println(validaTestBean.toString());
      }

       /**
          *
          */
        @Test
        public void test002(){
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            ValidaTestBean validaTestBean = new ValidaTestBean(null, "testName", 300, "pppppxsds", new Date(), new Date());
            Set<ConstraintViolation<ValidaTestBean>> violations = validator.validate(validaTestBean);
            for(ConstraintViolation<ValidaTestBean> data:violations){
                System.out.println(data.getPropertyPath().toString() + ":" + data.getMessage());
            }
        }


}
