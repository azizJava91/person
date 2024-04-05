package az.training.test.service.impl;

import az.training.test.dto.request.ReqPerson;
import az.training.test.dto.response.RespPerson;
import az.training.test.dto.response.Response;
import az.training.test.dto.response.ResponseStatus;
import az.training.test.entity.Person;
import az.training.test.enums.EnumAvailableStatus;
import az.training.test.personMapper.PersonMapper;
import az.training.test.repository.PersonRepository;
import az.training.test.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonMapper personMapper;
    private final PersonRepository personRepository;

    @Override
    public Response<RespPerson> add(ReqPerson reqPerson) {
        Response response = new Response();
        personRepository.save(personMapper.fromReqPersonToPerson(reqPerson));
        response.setT(personMapper.fromPersonToRespPerson(personMapper.fromReqPersonToPerson(reqPerson)));
        response.setResponseStatus(ResponseStatus.getSuccessMessage());
        return response;
    }

    @Override
    public Response<List<RespPerson>> getPersonList() {
        Response response = new Response<>();
        response.setT(personMapper.fromPersonListToRespPersonList(personRepository.findAllByActive(EnumAvailableStatus.ACTIVE.value)));
        response.setResponseStatus(ResponseStatus.getSuccessMessage());
        return response;
    }

    @Override
    public Response<RespPerson> getById(Long id) {
        Response response = new Response<>();
        response.setT(personMapper.fromPersonToRespPerson(personRepository.findByIdAndActive(id, EnumAvailableStatus.ACTIVE.value)));
        response.setResponseStatus(ResponseStatus.getSuccessMessage());
        return response;

    }

    @Override
    public Response<RespPerson> update(ReqPerson reqPerson) {
        Response response = new Response<>();
        Person person = personRepository.findByIdAndActive(reqPerson.getId(), EnumAvailableStatus.ACTIVE.value);
        personMapper.update(reqPerson, person);
        personRepository.save(person);
        response.setT(personMapper.fromPersonToRespPerson(person));
        response.setResponseStatus(ResponseStatus.getSuccessMessage());
        return response;
    }

    @Override
    public Response<RespPerson> delete(Long id) {
        Response response = new Response<>();
        Person person = personRepository.findByIdAndActive(id, EnumAvailableStatus.ACTIVE.value);
        response.setT(personMapper.fromPersonToRespPerson(person));
        person.setActive(EnumAvailableStatus.DEACTIVE.value);
        personRepository.save(person);
        response.setResponseStatus(ResponseStatus.getSuccessMessage());
        return response;
    }
}
