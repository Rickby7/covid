package edu.co.covid.controller;

import edu.co.covid.controller.dto.Worship;
import edu.co.covid.controller.exception.NoContentException;
import edu.co.covid.repository.WorshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worship")
public class WorshipController {

    @Autowired
    private WorshipRepository worshipRepository;

    @GetMapping("/")
    public List <Worship> viewWorships () {
        return worshipRepository.findAll();
    }

    @GetMapping("/")
    public Worship viewWorshipsById (@PathVariable String id) {
        return worshipRepository.findById(id).orElseThrow(NoContentException::new);
    }

    @PostMapping("/")
    public void createWorships (@RequestBody Worship worship) {
        worshipRepository.save(worship);
    }

    @PostMapping("/")
    public void createWorships2 (@RequestBody Worship worship) {

        Worship firstWorship = new Worship();
        firstWorship.setId("1");

        Worship secondWorship = new Worship();
        firstWorship.setId("2");
    }
}