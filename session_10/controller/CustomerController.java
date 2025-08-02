package com.data.session_10.controller;

import com.data.session_10.dto.CustomerDTO;
import com.data.session_10.model.entity.Customer;
import com.data.session_10.model.entity.Customer.Role;
import com.data.session_10.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customerList";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setStatus(true);
        customerDTO.setRole("USER");  // Nếu role trong DTO là String
        model.addAttribute("customerDTO", customerDTO);
        return "customerForm";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam("id") Long id, Model model) {
        Customer customer = customerService.findById(id);
        if (customer == null) return "redirect:/customers";

        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setUsername(customer.getUsername());
        dto.setPassword(customer.getPassword());
        dto.setEmail(customer.getEmail());
        dto.setPhone(customer.getPhone());
        dto.setStatus(customer.getStatus());
        dto.setRole(String.valueOf(customer.getRole()));

        model.addAttribute("customerDTO", dto);
        return "customerForm";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("customerDTO") CustomerDTO dto,
                       BindingResult result) {
        if (result.hasErrors()) return "customerForm";

        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setUsername(dto.getUsername());
        customer.setPassword(dto.getPassword());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setStatus(dto.getStatus());
        customer.setRole(Role.valueOf(dto.getRole())); // Convert String to Enum

        if (dto.getId() == null) {
            customerService.save(customer);
        } else {
            customerService.update(customer);
        }

        return "redirect:/customers";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        customerService.delete(id);
        return "redirect:/customers";
    }
}
