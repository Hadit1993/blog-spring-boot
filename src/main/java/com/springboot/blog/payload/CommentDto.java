package com.springboot.blog.payload;

import com.springboot.blog.entity.Comment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel("Comment model information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    @ApiModelProperty(value = "Comment id")
    private long id;

    @ApiModelProperty(value = "Comment owner's name")
    @NotEmpty(message = "name must not be empty")
    private String name;

    @ApiModelProperty(value = "Comment owner's email")
    @NotEmpty(message = "email must not be empty")
    @Email
    private String email;

    @ApiModelProperty(value = "Comment body")
    @NotEmpty
    @Size(min = 10, message = "comment body must be minimum 10 characters")
    private String body;

}
