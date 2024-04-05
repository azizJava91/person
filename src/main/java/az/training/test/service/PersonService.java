package az.training.test.service;

import az.training.test.dto.request.ReqPerson;
import az.training.test.dto.response.RespPerson;
import az.training.test.dto.response.Response;

import java.util.List;

public interface PersonService {
    Response<RespPerson> add(ReqPerson reqPerson);

    Response<List<RespPerson>> getPersonList();

    Response<RespPerson> getById(Long id);

    Response<RespPerson> update(ReqPerson reqPerson);

    Response<RespPerson> delete(Long id);
}
