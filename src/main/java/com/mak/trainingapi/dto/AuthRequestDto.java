package com.mak.trainingapi.dto;

import javax.validation.constraints.NotNull;

public record AuthRequestDto (
        @NotNull String username,
        @NotNull String password
){

}
