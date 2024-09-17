package ru.kokhno.menuservice.storage.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import ru.kokhno.menuservice.exception.MenuServiceException;

@Slf4j
public enum Category {
    BREAKFAST,
    LUNCH,
    DINNER;

    @JsonCreator
    public static Category fromString(final String category) {
        try {
            return Category.valueOf(category.toUpperCase());
        } catch (IllegalArgumentException e) {
            String message = "Failed to convert a category from a string: " + category;
            log.info(message);
            throw MenuServiceException.builder()
                    .message(message)
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }
}
