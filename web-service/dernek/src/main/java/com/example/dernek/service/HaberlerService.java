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

    public Haberler findHaberById(Long id){
        return  haberlerRepo.findHaberById(id)
                .orElseThrow(() -> new EtkinlikBulunamadiHatasi("Haber bulunamadı..."));
    }

    public Haberler updateHaber(Long id, Haberler haberler){
    	Haberler updateHabers = findHaberById(id);
    	updateHabers.setKonu(haberler.getKonu());
    	updateHabers.setIcerik(haberler.getIcerik());
    	updateHabers.setGecerlilikTarihi(haberler.getGecerlilikTarihi());
    	updateHabers.setHaberUrl(haberler.getHaberUrl());
        return  haberlerRepo.save(updateHabers);
    }

    public void deleteHaber(Long id){
        haberlerRepo.deleteHaberById(id);
    }
}
