package com.example.testspringa1;

import com.example.testspringa1.ankieta.Ankieta;
import com.example.testspringa1.ankieta.AnkietaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/api/ankieta")
public class TestSpringa1Application {

    private final AnkietaRepository ankietaRepository;

    public TestSpringa1Application(AnkietaRepository ankietaRepository){
        this.ankietaRepository = ankietaRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TestSpringa1Application.class, args);


    }


    @GetMapping()
    public List<Ankieta> komunikatAnkiety() {
        return ankietaRepository.findAll();
    }

    record  NewAnkietaRequest(
            String name,
            List<String> answers
    ){

    }

    @PostMapping
    public void addAnkieta(@RequestBody NewAnkietaRequest request){
        Ankieta ankieta = new Ankieta();
        ankieta.setName(request.name);
        ankieta.setAnswers(request.answers);
        ankietaRepository.save(ankieta);


    }

    @DeleteMapping("{ankietaId}")
    public void  deleteAnkieta(@PathVariable("ankietaId") Integer id){
        ankietaRepository.deleteById(id);
    }


    // TODO (Tutek Springa poza Basic)
  //  @PutMapping("{ankietaId}")
   // public ResponseEntity<Ankieta> updateAnkieta(@PathVariable("ankietaId") Integer id,
    //                                                        @RequestBody NewAnkietaRequest request){
     //   Optional<Ankieta> ankieta = ankietaRepository.findById(id);
      //  ankieta.setName(request.name);
       // ankieta.setAnswers(request.answers);

     //   ankietaRepository.save(ankieta);
     //   return ResponseEntity.ok(ankieta);

    //}



}




