package edu.co.covid.controller;

import edu.co.covid.controller.dto.Person;
import edu.co.covid.controller.dto.Worship;
import edu.co.covid.controller.exception.NoContentException;
import edu.co.covid.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    private PersonRepository peopleRepository;
    private WorshipController worshipController;

    @Autowired
    public PersonController(PersonRepository peopleRepository, WorshipController worshipController) {
        this.peopleRepository = peopleRepository;
        this.worshipController = worshipController;
    }

    @GetMapping("/")
    public List<Person> viewPeople() {
        return peopleRepository.findAll();
    }

    @GetMapping("/{fullName}")
    public Person viewPersonByDocumentNumber(@PathVariable String documentNumber) {
        return peopleRepository.findByDocumentNumber(documentNumber).orElseThrow(NoContentException::new);
    }

    @PostMapping("/")
    public void savePerson(@RequestBody Person person) {
        peopleRepository.save(person);
    }

    @PostMapping("/{worshipId}/{documentNumber}")
    public void worshipInscriptions(@PathVariable String worshipId, String documentNumber) {

        if (peopleRepository.findByDocumentNumber(documentNumber).orElseThrow(NoContentException::new) == null
                && worshipController.viewWorshipsById(worshipId) == null) {
        } else {

            Person person =
                    peopleRepository.findByDocumentNumber(documentNumber).orElseThrow(NoContentException::new);
            person.setWorship(worshipController.viewWorshipsById(worshipId));
            peopleRepository.save(person);
        }
    }

    @DeleteMapping("/{documentNumber}")
    public void deletePerson(@PathVariable String documentNumber) {
        Person person = peopleRepository.findByDocumentNumber(documentNumber).orElseThrow(NoContentException::new);
        peopleRepository.delete(person);
    }
}