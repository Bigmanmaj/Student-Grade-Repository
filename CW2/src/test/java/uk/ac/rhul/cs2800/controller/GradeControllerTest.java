package uk.ac.rhul.cs2800.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import uk.ac.rhul.cs2800.model.Grade;
import uk.ac.rhul.cs2800.model.Module;
import uk.ac.rhul.cs2800.model.Student;
import uk.ac.rhul.cs2800.repository.GradeRepository;
import uk.ac.rhul.cs2800.repository.ModuleRepository;
import uk.ac.rhul.cs2800.repository.StudentRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class GradeControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private GradeRepository graderepository;

  @Autowired
  private ModuleRepository moduleRepository;

  @Autowired
  private StudentRepository studentRepository;

  @BeforeEach
  void beforeEach() {
    Module m = new Module();
    m.setCode("2800");
    m = moduleRepository.save(m);
    Student s = new Student();
    s.setId(1);
    s = studentRepository.save(s);
    Grade grade = new Grade();
    grade.setScore(94);
    grade.setStudent(s);
    grade.setModule(m);
    grade = graderepository.save(grade);
  }

  @Test
  void addGradeTest() throws JsonProcessingException, Exception {
    Map<String, Integer> params = new HashMap<String, Integer>();
    params.put("student_id", 1);
    params.put("score", 94);
    params.put("module_code", 2800);
      MvcResult action = mockMvc
          .perform(MockMvcRequestBuilders.post("/grades/addGrade")
              .contentType(MediaType.APPLICATION_JSON)
              .content(objectMapper.writeValueAsString(params)).accept(MediaType.APPLICATION_JSON))
          .andReturn();
      assertEquals(HttpStatus.OK.value(), action.getResponse().getStatus());
  }
}
