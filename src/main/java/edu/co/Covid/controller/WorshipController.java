package edu.co.Covid.controller;

import edu.co.Covid.controller.dto.Person;
import edu.co.Covid.controller.dto.Worship;
import edu.co.Covid.controller.exception.NoContentException;
import edu.co.Covid.repository.PersonRepository;
import edu.co.Covid.repository.WorshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worship")
public class WorshipController {

    private WorshipRepository worshipRepository;
    private PersonRepository peopleRepository;

    @Autowired
    public WorshipController(PersonRepository peopleRepository, WorshipRepository worshipRepository) {
        this.peopleRepository = peopleRepository;
        this.worshipRepository = worshipRepository;
    }

    @GetMapping("/")
    public List <Worship> worships () {
        return worshipRepository.findAll();
    }

    @PostMapping("/")
    public void createWorships () {

        Worship firstWorship = new Worship();
        firstWorship.setId("1");
        Worship secondWorship = new Worship();
        secondWorship.setId("2");

        worshipRepository.save(firstWorship);
        worshipRepository.save(secondWorship);
    }
}