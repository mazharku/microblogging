package com.mazhar.microblog.configuration;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<UUID> {

    @Override
    public Optional<UUID> getCurrentAuditor(){

			return Optional.of(UUID.fromString("e54a8b84-2558-4b76-80d9-9e78effe1758"));
	 
    }
}
