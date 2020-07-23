package lulski;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lulski.model.NavigationMenuItem;
import lulski.service.DatabaseSequenceGeneratorService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DatabaseSequenceGeneratorServiceTest {

  @Autowired
  private DatabaseSequenceGeneratorService sequenceGeneratorService;

  @Test
  public void generate_sequence_number_return_long_value() {

    assertEquals(long.class, sequenceGeneratorService.generateSequence(NavigationMenuItem.SEQUENCE_NAME));

  }
}