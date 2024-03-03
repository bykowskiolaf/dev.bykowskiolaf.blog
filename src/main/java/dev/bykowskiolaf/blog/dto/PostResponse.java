package dev.bykowskiolaf.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class PostResponse {
    private final UUID uuid;
    private final String title;
    private final Instant creationDate;
    private final UUID creatorUuid;
}