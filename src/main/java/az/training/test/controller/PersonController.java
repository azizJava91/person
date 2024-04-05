package az.training.test.controller;

import az.training.test.dto.request.ReqPerson;
import az.training.test.dto.response.RespPerson;
import az.training.test.dto.response.Response;
import az.training.test.personMapper.PersonMapper;
import az.training.test.repository.PersonRepository;
import az.training.test.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/add")
    public Response<RespPerson> add(@RequestBody ReqPerson reqPerson){
        return personService.add(reqPerson);

    }

    @GetMapping("/list")
    public Response<List<RespPerson>> getPersonList(){
        return personService.getPersonList();
    }

    @GetMapping("/getById/{id}")
    public Response<RespPerson>getById(@PathVariable Long id){
     return personService.getById(id);
    }

    @PutMapping("/update")
    public Response<RespPerson>update(@RequestBody ReqPerson reqPerson){
        return personService.update(reqPerson);
    }

    @PutMapping("/delete/{id}")
    public Response<RespPerson> delete(@PathVariable Long id){
        return personService.delete(id);
    }
}
