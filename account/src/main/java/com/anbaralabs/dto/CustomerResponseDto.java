package com.anbaralabs.dto;

import java.util.List;

/**
 * @author Ayoub Anbara
 */
public record CustomerResponseDto(
        Long id,
        String name,
        List<AccountResponseDto> account
) {
}
