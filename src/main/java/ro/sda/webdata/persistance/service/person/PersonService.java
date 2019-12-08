package ro.sda.webdata.persistance.service.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.webdata.persistance.person.PersonEntitiy;
import ro.sda.webdata.persistance.person.PersonRepository;

import java.util.List;


@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Transactional
    public void save(String name){
        PersonEntitiy entitiy = new PersonEntitiy();
        entitiy.setName(name);
        personRepository.save(entitiy);
    }

    @Transactional(readOnly = true)
    public List<PersonEntitiy> findAll(){
        return personRepository.findAll();
    }
}
