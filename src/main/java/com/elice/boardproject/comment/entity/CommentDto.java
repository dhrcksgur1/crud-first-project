package com.elice.boardproject.comment.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommentDto {

    @NotBlank(message = "공백은 입력되지 않습니다.")
    @Size(max = 50, message = "50자 미만으로 작성해주세요")
    private String content;
}
