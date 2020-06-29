package edu.co.Covid.controller;

import edu.co.Covid.controller.dto.Person;
import edu.co.Covid.controller.dto.Test;
import edu.co.Covid.controller.dto.Worship;
import edu.co.Covid.controller.exception.NoContentException;
import edu.co.Covid.controller.exception.WrongWorshipException;
import edu.co.Covid.repository.PersonRepository;
import edu.co.Covid.repository.TestRepository;
import edu.co.Covid.repository.WorshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {


    private TestRepository testRepository;
    private PersonRepository peopleRepository;
    private WorshipRepository worshipRepository;

    public TestController(TestRepository testRepository, PersonRepository peopleRepository, WorshipRepository worshipRepository) {
        this.testRepository = testRepository;
        this.peopleRepository = peopleRepository;
        this.worshipRepository = worshipRepository;
    }

    @GetMapping ("/")
    public List <Test> viewTests () {
        return testRepository.findAll();
    }

    @GetMapping ("/{id}")
    public Test viewTestsById (@PathVariable String id) {
        return testRepository.findById(id).orElseThrow(NoContentException::new);
    }

    @PostMapping("/{id}")
    public void saveTest (@RequestBody Test test, String documentNumber, @PathVariable String id) {
        Worship worship1 = worshipRepository.findById(id).orElseThrow(NoContentException::new);
        Person person1 = test.getPerson();

       /* switch (person1.getWorship() != worship1) {break;*/

        if (!peopleRepository.findByDocumentNumber(documentNumber).isPresent()) {
            peopleRepository.save(person1); }

       else {
            test.setPerson(person1);
        }


        test.setDate(new Date());
        testRepository.save(test);

    }

    @DeleteMapping("/{id}")
    public void deleteTest (@PathVariable String id) {
        testRepository.deleteById(id);
    }

}