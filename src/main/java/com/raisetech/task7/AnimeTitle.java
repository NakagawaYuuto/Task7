package com.raisetech.task7;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class AnimeTitle {
    @GetMapping("/animes")
    public List<String> getNames(){
        return List.of("鉄腕アトム", "マジンガーZ");
    }

    @PostMapping("/animes")
    public ResponseEntity<String> HeiseiAnimeName(@RequestBody CreateForm form){
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/anime/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("name successfully created");
    }

    @PatchMapping("/animes/{id}")
    public ResponseEntity<Map<String, String>> updateName(@PathVariable("id") int id, @RequestBody UpdateForm from){
        return ResponseEntity.ok(Map.of("message", "name successfully updated"));
    }

}
