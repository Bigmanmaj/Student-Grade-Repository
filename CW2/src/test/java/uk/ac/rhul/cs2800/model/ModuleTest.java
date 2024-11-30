package uk.ac.rhul.cs2800.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ModuleTest {
  @Test
  void testModuleCode() {
    // Test 11
    Module m = new Module();
    m.setCode("CS2800");
    assertEquals("CS2800", m.getCode());
  }

  @Test
  void testModuleName() {
    // Test 12
    Module m = new Module();
    m.setName("CS2800");
    assertEquals("CS2800", m.getName());
  }

  @Test
  void testModuleMnc() {
    // Test 13
    Module m = new Module();
    m.setMnc(true);
    assertEquals(true, m.getMnc());
  }
}
