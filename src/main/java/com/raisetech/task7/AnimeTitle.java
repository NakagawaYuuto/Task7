package com.raisetech.task7;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class AnimeTitle {
    @GetMapping("/anime")
    public List<String> getNames(){
        return List.of("鉄腕アトム", "マジンガーZ");
    }

    @GetMapping("/animes")
    public String anime (@RequestParam(value = "japan")String animation){
        if (animation.equals("tetuwanatomu")){
            return "『鉄腕アトム』は、手塚治虫のSF漫画作品及び同作を原作としたテレビアニメである";
        } else if (animation.equals(("manzingaaz"))) {
            return "『マジンガーZ』は、永井豪の漫画、原作を共にする東映動画制作のテレビアニメである。";
        }
        return "当てはまるのがありません。（tetuwanatomu, mazingaaz";
    }

    @PostMapping("/animes")
    public ResponseEntity<String> OldAnimeName(@RequestBody CreateForm form){
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/anime/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("name successfully created");
    }

    @PatchMapping("/animes/{id}")
    public ResponseEntity<Map<String, String>> updateName(  @PathVariable("id") int id, @RequestBody UpdateForm from){
        return ResponseEntity.ok(Map.of("message", "name successfully updated"));
    }

    @DeleteMapping("/animes/{id}")
    public ResponseEntity<Map<String, String>> deleteMenu(@PathVariable("id") int id) {
        return ResponseEntity.ok(Map.of("message", "name successfully deleted"));
    }
}
