//package br.com.projetoo.mapper;
//
//import java.util.Date;
//
//import br.com.projetoo.model.Person;
//import org.springframework.stereotype.Service;
//
//import br.com.erudio.data.vo.v2.PersonVOV2;
//import br.com.projetoo.model.Person;
//
//@Service
//public class PersonMapper {

//    public PersonVOV2 convertEntityToVo(Person person) {
//        PersonVOV2 vo = new PersonVOV2();
//        vo.setId(person.getId());
//        vo.setAddress(person.getAddress());
//        vo.setBirthDay(new Date());
//        vo.setFirstName(person.getFirstName());
//        vo.setLastName(person.getLastName());
//        vo.setGender(person.getGender());
//        return vo;
//    }
//
//
//    public Person convertVoTOEntity(PersonVOV2 person) {
//        Person entity = new Person();
//        entity.setId(person.getId());
//        entity.setAddress(person.getAddress());
//        //vo.setBirthDay(new Date());
//        entity.setFirstName(person.getFirstName());
//        entity.setLastName(person.getLastName());
//        entity.setGender(person.getGender());
//        return entity;
//    }
//
//}
//
