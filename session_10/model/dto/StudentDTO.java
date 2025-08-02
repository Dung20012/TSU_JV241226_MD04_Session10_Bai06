package com.data.session_10.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.*;

@Getter
@Setter
public class StudentDTO {
    private Long id;

    @NotBlank(message = "Tên sinh viên không được để trống")
    @Size(min = 2, max = 50, message = "Tên sinh viên phải từ 2 đến 50 ký tự")
    private String studentName;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotNull(message = "Điểm tuổi không được để trống")
    @Min(value = 0, message = "Điểm phải lớn hơn hoặc bằng 0")
    @Max(value = 10, message = "Điểm không được vượt quá 10")
    private Float ageMark;

    @NotNull(message = "Trạng thái học không được để trống")
    private Boolean issStudying;
}
