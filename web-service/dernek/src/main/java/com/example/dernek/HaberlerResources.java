package com.example.dernek;

import com.example.dernek.models.Haberler;
import com.example.dernek.service.HaberlerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/haberler")
public class HaberlerResources {
    private final HaberlerService haberlerService;

    public HaberlerResources(HaberlerService haberlerService) {
        this.haberlerService = haberlerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Haberler>> getAllHaberler(){
        List<Haberler> haberlers = haberlerService.findAllHaberler();
        return new ResponseEntity<>(haberlers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Haberler> getHaberlerById(@PathVariable("id") Long id){
        Haberler haber = haberlerService.findHaberById(id);
        return new ResponseEntity<>(haber, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Haberler> addHaber(@RequestBody Haberler haber){
        Haberler habers = haberlerService.addHaberler(haber);
        return new ResponseEntity<>(habers, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Haberler> updateHaber(@RequestBody Haberler haber){
        Haberler update = haberlerService.updateHaber(haber);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Haberler> deleteHaber(@PathVariable("id") Long id){
        haberlerService.deleteHaber(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
