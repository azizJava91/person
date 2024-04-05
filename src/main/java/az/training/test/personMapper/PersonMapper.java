package az.training.test.personMapper;

import az.training.test.dto.request.ReqPerson;
import az.training.test.dto.response.RespPerson;
import az.training.test.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    RespPerson fromPersonToRespPerson(Person person);
    List<RespPerson> fromPersonListToRespPersonList(List<Person> personList);

    @Mapping(target = "id", ignore = true)
    Person fromReqPersonToPerson(ReqPerson reqPerson);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    void update(ReqPerson reqPerson, @MappingTarget Person person);

}
