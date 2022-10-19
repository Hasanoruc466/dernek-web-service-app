package com.example.dernek;

import com.example.dernek.models.Duyuru;
import com.example.dernek.service.DuyuruService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/duyurular")
public class DuyuruResources {
    private final DuyuruService duyuruService;

    public DuyuruResources(DuyuruService duyuruService) {
        this.duyuruService = duyuruService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Duyuru>> getAllDuyuru(){
        List<Duyuru> duyurular = duyuruService.findAllDuyuru();
        return new ResponseEntity<>(duyurular, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Duyuru> getDuyuruById(@PathVariable("id") Long id){
        Duyuru duyuru = duyuruService.findDuyuruById(id);
        return new ResponseEntity<>(duyuru, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Duyuru> addDuyuru(@RequestBody Duyuru duyuru){
        Duyuru newDuyuru = duyuruService.addDuyuru(duyuru);
        return new ResponseEntity<>(newDuyuru, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Duyuru> updateDuyuru(@RequestBody Duyuru duyuru){
        Duyuru update = duyuruService.updateDuyuru(duyuru);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Duyuru> deleteDuyuru(@PathVariable("id") Long id){
        duyuruService.deleteDuyuru(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }






}
