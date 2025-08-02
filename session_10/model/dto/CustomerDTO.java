package com.data.session_10.dto;

import com.data.session_10.validation.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class CustomerDTO {
    private Long id;

    @NotBlank(message = "Tên đăng nhập không được để trống")
    @UniqueUsername
    private String username;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 6, message = "Mật khẩu phải từ 6 ký tự trở lên")
    private String password;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    @UniqueEmail
    private String email;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^(03|05|07|08|09)\\d{8}$", message = "Số điện thoại phải bắt đầu bằng 03, 05, 07, 08 hoặc 09 và có 10 số")
    @UniquePhone
    private String phone;

    private Boolean status = true;

    private String role = "USER";
}
