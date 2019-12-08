package ro.sda.webdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import ro.sda.webdata.persistance.person.PersonEntitiy;
import ro.sda.webdata.persistance.service.person.PersonService;

import java.util.List;
import java.util.StringJoiner;

@Controller
@RequestMapping("person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("save")
    @ResponseBody
    public String save(@RequestBody String name) {
        personService.save(name);
        return "Saved";
    }

    @GetMapping("all")
    @ResponseBody
    public String findAll() {
        List<PersonEntitiy> persons = personService.findAll();
        StringJoiner joiner = new StringJoiner(",");
        for (PersonEntitiy person : persons) {
            joiner.add(person.getName());
        }
        return joiner.toString();
    }
}

