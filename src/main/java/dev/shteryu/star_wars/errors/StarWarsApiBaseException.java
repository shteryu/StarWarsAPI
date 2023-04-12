package dev.shteryu.star_wars.errors;

import java.util.UUID;

public class StarWarsApiBaseException extends RuntimeException {
    private final UUID errorId;

    public StarWarsApiBaseException(String message) {
        super(message);
        this.errorId = UUID.randomUUID();
    }

    public UUID getErrorId() {
        return errorId;
    }

}
