package com.example.dernek.repo;

import com.example.dernek.models.Duyuru;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DuyuruRepo extends JpaRepository<Duyuru, Long> {
    Optional<Duyuru> findDuyuruById(Long id);

    void deleteDuyuruById(Long id);
}
