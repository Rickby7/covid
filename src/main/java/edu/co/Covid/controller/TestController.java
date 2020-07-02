package edu.co.covid.controller;

import edu.co.covid.controller.dto.Person;
import edu.co.covid.controller.dto.Test;
import edu.co.covid.controller.exception.NoContentException;
import edu.co.covid.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private PersonController personController;
    private TestRepository testRepository;

    @Autowired
    public TestController(PersonController personController, TestRepository testRepository) {
        this.personController = personController;
        this.testRepository = testRepository;
    }

    @GetMapping("/")
    public List<Test> viewTests() {
        return testRepository.findAll();
    }

    @GetMapping("/{id}")
    public Test viewTestsById(@PathVariable String id) {
        return testRepository.findById(id).orElseThrow(NoContentException::new);
    }

    @PostMapping("/{id}")
    public void saveTest(@RequestBody Test test) {

        Person person
                = personController.viewPersonByDocumentNumber(test.getPerson().getDocumentNumber());

        if (personController.viewPersonByDocumentNumber(test.getPerson().getDocumentNumber()) == null) {
            personController.savePerson(test.getPerson());
        } else {
            person.setFullName(test.getPerson().getFullName());
            person.setMobile(test.getPerson().getMobile());
            test.setPerson(person);
        }
        test.setDate(new Date());
        testRepository.save(test);
    }

    @DeleteMapping("/{id}")
    public void deleteTest(@PathVariable String id) {
        testRepository.deleteById(id);
    }
}