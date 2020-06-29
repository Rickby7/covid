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
@RequestMapping("/persons")
public class PersonController {

    private WorshipRepository worshipRepository;
    private PersonRepository peopleRepository;

    @Autowired
    public PersonController(PersonRepository peopleRepository, WorshipRepository worshipRepository) {
        this.peopleRepository = peopleRepository;
        this.worshipRepository = worshipRepository;
    }

    @GetMapping("/")
    public List <Person> ViewPeople () { return peopleRepository.findAll(); }

    @GetMapping ("/{fullName}")
    public Person viewPersonById (@PathVariable String fullName) {
        return peopleRepository.findByFullName(fullName).orElseThrow(NoContentException::new);
    }

    @PostMapping ("/")
    public void savePerson (@RequestBody Person person) {
        peopleRepository.save(person);
    }

    @DeleteMapping ("/{documentNumber}")
    public void deletePerson (@PathVariable String documentNumber) {
        Person person = peopleRepository.findByDocumentNumber(documentNumber).orElseThrow(NoContentException::new);
        peopleRepository.delete(person);
    }
   /* @PutMapping ("/")
    public Person updateAllPersonDates (@RequestBody Person person) {
        Person person1 =
                peopleRepository.findByDocumentNumber(person.getDocumentNumber()).orElseThrow(NoContentException::new);
        peopleRepository.delete(person1);
        peopleRepository.save(person);
        return person;
    }*/
    @PutMapping("/")
    public void updateWorship (@RequestBody String documentNumber, String worshipId) {

        Worship worship1 = worshipRepository.findById(worshipId).orElseThrow(NoContentException::new);
        Person person1 =
                peopleRepository.findByDocumentNumber(documentNumber).orElseThrow(NoContentException::new);
        person1.setWorship(worship1);
        peopleRepository.save(person1);
    }
    }