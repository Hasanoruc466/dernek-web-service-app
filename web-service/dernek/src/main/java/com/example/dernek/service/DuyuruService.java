package com.example.dernek.service;

import com.example.dernek.exception.EtkinlikBulunamadiHatasi;
import com.example.dernek.models.Duyuru;
import com.example.dernek.repo.DuyuruRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
@Transactional
public class DuyuruService {
    private final DuyuruRepo duyuruRepo;

    @Autowired
    public DuyuruService(DuyuruRepo duyuruRepo) {
        this.duyuruRepo = duyuruRepo;
    }

    public Duyuru addDuyuru(Duyuru duyuru){
        return duyuruRepo.save(duyuru);
    }

    public List<Duyuru> findAllDuyuru(){
        return duyuruRepo.findAll();
    }

    public Duyuru updateDuyuru(Duyuru duyuru){
        return duyuruRepo.save(duyuru);
    }

    public Duyuru findDuyuruById(Long id){
        return duyuruRepo.findDuyuruById(id)
                .orElseThrow(() -> new EtkinlikBulunamadiHatasi("Duyuru bulunamadi..."));
    }

    public void deleteDuyuru(Long id){
        duyuruRepo.deleteDuyuruById(id);
    }

}
