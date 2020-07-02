package edu.co.covid.controller;

import edu.co.covid.controller.dto.Responsible;
import edu.co.covid.controller.exception.NoContentException;
import edu.co.covid.repository.ResponsibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responsibles")
public class ResponsibleController {

    @Autowired
    private ResponsibleRepository responsibleRepository;

    @GetMapping("/")
    public List<Responsible> viewResponsibles () {
        return responsibleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Responsible viewResponsibleById (String id) {
        return responsibleRepository.findById(id).orElseThrow(NoContentException::new);
    }

    @PostMapping("/")
    public void saveResponsible (@RequestBody Responsible responsible) {
        responsibleRepository.save(responsible);
    }

    @DeleteMapping("/{id}")
    public void deleteResponsible (@PathVariable String id) {
        Responsible responsible = responsibleRepository.findById(id).orElseThrow(NoContentException::new);
        responsibleRepository.delete(responsible);
    }
}