package net.skhu.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BookRegister {

    @NotEmpty @NotBlank
    @Size(min=3, max=12)
    String title;

    @NotEmpty
    @Size(min=2, max=12)
    String author;

    @NotEmpty @NotBlank
    @Size(min=1000, max=3)
    String price;

    @NotEmpty @NotBlank
    @Size(min=2, max=30)
    String publisher;


    int categoryId;
}

