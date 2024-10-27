package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RegistrationTest {
  @Test
  void getModuleTest() {
    // Test 14
    Registration registration = new Registration();
    Module m = new Module();
    registration.setModule(m);
    assertEquals(m, registration.getModule());
  }
}
