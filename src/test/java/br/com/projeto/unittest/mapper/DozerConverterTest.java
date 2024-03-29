package br.com.projeto.unittest.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import br.com.projeto.unittests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.projetoo.data.vo.v1.PersonVo;
import br.com.projetoo.mapper.DozerMapper;
import br.com.projetoo.model.Person;
import br.com.projetoo.mapper.DozerMapper;
import br.com.projetoo.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DozerConverterTest {

        MockPerson inputObject;

        @BeforeEach
        public void setUp() {
            inputObject = new MockPerson();
        }

        @Test
        public void parseEntityToVOTest() {
            PersonVo output = DozerMapper.parseObject(inputObject.mockEntity(), PersonVo.class);
            assertEquals(Long.valueOf(0L), output.getKey());
            assertEquals("First Name Test0", output.getFirstName());
            assertEquals("Last Name Test0", output.getLastName());
            assertEquals("Address Test0", output.getAddress());
            assertEquals("Male", output.getGender());
        }

        @Test
        public void parseEntityListToVOListTest() {
            List<PersonVo> outputList = DozerMapper.parseListObjects(inputObject.mockEntityList(), PersonVo.class);
            PersonVo outputZero = outputList.get(0);

            assertEquals(Long.valueOf(0L), outputZero.getKey());
            assertEquals("First Name Test0", outputZero.getFirstName());
            assertEquals("Last Name Test0", outputZero.getLastName());
            assertEquals("Address Test0", outputZero.getAddress());
            assertEquals("Male", outputZero.getGender());

            PersonVo outputSeven = outputList.get(7);

            assertEquals(Long.valueOf(7L), outputSeven.getKey());
            assertEquals("First Name Test7", outputSeven.getFirstName());
            assertEquals("Last Name Test7", outputSeven.getLastName());
            assertEquals("Address Test7", outputSeven.getAddress());
            assertEquals("Female", outputSeven.getGender());

            PersonVo outputTwelve = outputList.get(12);

            assertEquals(Long.valueOf(12L), outputTwelve.getKey());
            assertEquals("First Name Test12", outputTwelve.getFirstName());
            assertEquals("Last Name Test12", outputTwelve.getLastName());
            assertEquals("Address Test12", outputTwelve.getAddress());
            assertEquals("Male", outputTwelve.getGender());
        }

        @Test
        public void parseVOToEntityTest() {
            Person output = DozerMapper.parseObject(inputObject.mockVO(), Person.class);
            assertEquals(Long.valueOf(0L), output.getId());
            assertEquals("First Name Test0", output.getFirstName());
            assertEquals("Last Name Test0", output.getLastName());
            assertEquals("Address Test0", output.getAddress());
            assertEquals("Male", output.getGender());
        }

        @Test
        public void parserVOListToEntityListTest() {
            List<Person> outputList = DozerMapper.parseListObjects(inputObject.mockVOList(), Person.class);
            Person outputZero = outputList.get(0);

            assertEquals(Long.valueOf(0L), outputZero.getId());
            assertEquals("First Name Test0", outputZero.getFirstName());
            assertEquals("Last Name Test0", outputZero.getLastName());
            assertEquals("Address Test0", outputZero.getAddress());
            assertEquals("Male", outputZero.getGender());

            Person outputSeven = outputList.get(7);

            assertEquals(Long.valueOf(7L), outputSeven.getId());
            assertEquals("First Name Test7", outputSeven.getFirstName());
            assertEquals("Last Name Test7", outputSeven.getLastName());
            assertEquals("Address Test7", outputSeven.getAddress());
            assertEquals("Female", outputSeven.getGender());

            Person outputTwelve = outputList.get(12);

            assertEquals(Long.valueOf(12L), outputTwelve.getId());
            assertEquals("First Name Test12", outputTwelve.getFirstName());
            assertEquals("Last Name Test12", outputTwelve.getLastName());
            assertEquals("Address Test12", outputTwelve.getAddress());
            assertEquals("Male", outputTwelve.getGender());
        }
    }


