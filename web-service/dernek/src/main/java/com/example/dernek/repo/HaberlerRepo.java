package com.example.dernek.repo;

import com.example.dernek.models.Haberler;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HaberlerRepo extends JpaRepository<Haberler, Long> {
    void deleteHaberById(Long id);

    Optional<Haberler> findHaberById(Long id);
}
