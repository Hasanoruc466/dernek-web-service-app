package com.example.dernek.service;

import com.example.dernek.exception.EtkinlikBulunamadiHatasi;
import com.example.dernek.models.Haberler;
import com.example.dernek.repo.HaberlerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
@Transactional
public class HaberlerService {
    private final HaberlerRepo haberlerRepo;

    @Autowired
    public HaberlerService(HaberlerRepo haberlerRepo) {
        this.haberlerRepo = haberlerRepo;
    }

    public Haberler addHaberler(Haberler haberler){
        return haberlerRepo.save(haberler);
    }

    public List<Haberler> findAllHaberler(){
        return haberlerRepo.findAll();
    }

    public Haberler updateHaber(Haberler haberler){
        return  haberlerRepo.save(haberler);
    }

    public Haberler findHaberById(Long id){
        return  haberlerRepo.findHaberById(id)
                .orElseThrow(() -> new EtkinlikBulunamadiHatasi("Haber bulunamadı..."));
    }

    public void deleteHaber(Long id){
        haberlerRepo.deleteHaberById(id);
    }
}
