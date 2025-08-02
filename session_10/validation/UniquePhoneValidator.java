package com.data.session_10.validation;

import com.data.session_10.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePhoneValidator implements ConstraintValidator<UniquePhone, String> {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !customerRepository.existsByPhone(value);
    }
}
