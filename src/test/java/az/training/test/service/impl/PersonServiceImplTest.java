package az.training.test.service.impl;

import az.training.test.dto.response.RespPerson;
import az.training.test.dto.response.Response;
import az.training.test.dto.response.ResponseStatus;
import az.training.test.entity.Person;
import az.training.test.enums.EnumAvailableStatus;
import az.training.test.personMapper.PersonMapper;
import az.training.test.repository.PersonRepository;
import az.training.test.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonServiceImplTest {
    @InjectMocks
    private PersonServiceImpl personService;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getPersonList() {
        Person person1 = new Person();
        person1.setId(1L);
        person1.setActive(EnumAvailableStatus.ACTIVE.value);

        Person person2 = new Person();
        person2.setId(2L);
        person2.setActive(EnumAvailableStatus.ACTIVE.value);

        List<Person> personList = Arrays.asList(person1, person2);

        RespPerson respPerson1 = new RespPerson("ad1", "soyad1");
        RespPerson respPerson2 = new RespPerson("ad2", "soyad2");

        when(personRepository.findAllByActive(EnumAvailableStatus.ACTIVE.value)).thenReturn(personList);
        when(personMapper.fromPersonListToRespPersonList(personList)).thenReturn(Arrays.asList(respPerson1, respPerson2));

        // When
        Response<List<RespPerson>> response = personService.getPersonList();

        // Then
        assertNotNull(response);
        assertEquals(ResponseStatus.getSuccessMessage(), response.getResponseStatus());
        assertNotNull(response.getT());
        assertEquals(2, response.getT().size());
        assertEquals(respPerson1, response.getT().get(0));
        assertEquals(respPerson2, response.getT().get(1));

        // Verify that the repository and mapper methods were called
        verify(personRepository, times(1)).findAllByActive(EnumAvailableStatus.ACTIVE.value);
        verify(personMapper, times(1)).fromPersonListToRespPersonList(personList);
    }

    @Test
    void getById() {
        // Given
        Long id = 1L;
        Person person = new Person();
        person.setId(id);
        person.setActive(EnumAvailableStatus.ACTIVE.value);

        RespPerson respPerson = new RespPerson("ad", "soyad");

        when(personRepository.findByIdAndActive(id, EnumAvailableStatus.ACTIVE.value)).thenReturn(person);
        when(personMapper.fromPersonToRespPerson(person)).thenReturn(respPerson);

        // When
        Response<RespPerson> response = personService.getById(id);

        // Then
        assertNotNull(response);
        assertEquals(ResponseStatus.getSuccessMessage(), response.getResponseStatus());
        assertNotNull(response.getT());
        assertEquals(respPerson, response.getT());

        // Verify that the repository and mapper methods were called
        verify(personRepository, times(1)).findByIdAndActive(id, EnumAvailableStatus.ACTIVE.value);
        verify(personMapper, times(1)).fromPersonToRespPerson(person);
    }
}