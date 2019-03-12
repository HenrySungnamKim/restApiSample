package com.henry.api.controller;

import com.henry.api.model.YourStore;
import com.henry.api.model.YourStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * com.henry.api.controller
 * RESTController.java
 *
 * @Author : henry
 * @Data : 2019-03-08
 * @Version : 1.0
 */
@RestController
public class RESTController {

    @Autowired
    YourStoreRepository yourStoreRepository;

    @GetMapping("/stores")
    public List<YourStore> getStores(){
        return yourStoreRepository.findAll();
    }

    @GetMapping("/stores/{id}")
    public YourStore getStoreOne(@RequestParam Long id) throws YourStoreNotFoundException {
        Optional<YourStore> optionalYourStore  = yourStoreRepository.findById(id);
        if(!optionalYourStore.isPresent())
            throw new YourStoreNotFoundException("id -" , id);
        return optionalYourStore.get();
    }

    private class YourStoreNotFoundException extends Throwable {
        public YourStoreNotFoundException(String s, Long id) {
        }
    }
    @PostMapping("/stores")
    public ResponseEntity<Object> postYourStore(@RequestBody YourStore yourStore){
        YourStore yourStoreTosave = yourStoreRepository.save(yourStore);
        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(yourStoreTosave.getId())
                    .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/stores/{id}")
    public ResponseEntity<Object> updateYourStore(@RequestBody YourStore yourStore, @PathVariable Long id){
        Optional<YourStore> optionalYourStore = yourStoreRepository.findById(id);
        if(!optionalYourStore.isPresent())
            return ResponseEntity.notFound().build();

        yourStore.setId(id);
        yourStoreRepository.save(yourStore);

        return ResponseEntity.noContent().build();
    }
}
