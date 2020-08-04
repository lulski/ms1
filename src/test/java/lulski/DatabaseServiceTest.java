package lulski;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;

import lulski.model.DatabaseSequence;
import lulski.model.NavigationMenuItem;
import lulski.repository.NavigationMenuItemRepository;
import lulski.service.DatabaseService;

public class DatabaseServiceTest extends AbstractTest {

  MongoOperations mockMongoOperations;
  MongoRepository mockMongoRepository;

  @Autowired
  NavigationMenuItemRepository navigationMenuItemRepository;

  @Autowired
  MongoOperations mongoOperations;

  @Before
  public void initMock() {

    mockMongoOperations = mock(MongoOperations.class);

    mockMongoRepository = mock(MongoRepository.class);
  }

  @Test
  public void generate_sequence_number_return_long_value_of_1() {

    DatabaseSequence mockDatabaseSequence = new DatabaseSequence();
    mockDatabaseSequence.setSeq(1);

    // findAndModify(Query query, UpdateDefinition update, FindAndModifyOptions
    // options, Class<T> entityClass);
    when(mockMongoOperations.findAndModify(any(Query.class), any(Update.class), any(FindAndModifyOptions.class), any()))
        .thenReturn(mockDatabaseSequence);

    DatabaseService sequenceGeneratorService = new DatabaseService(mockMongoRepository, mockMongoOperations);

    assertEquals(1, sequenceGeneratorService.generateSequence("random_sequence_name"));

  }

  @Test
  public void save_model_object_to_mock_database() {

    DatabaseSequence mockDatabaseSequence = new DatabaseSequence();
    mockDatabaseSequence.setSeq(1);

    // findAndModify(Query query, UpdateDefinition update, FindAndModifyOptions
    // options, Class<T> entityClass);
    when(mockMongoOperations.findAndModify(any(Query.class), any(Update.class), any(FindAndModifyOptions.class), any()))
        .thenReturn(mockDatabaseSequence);

    DatabaseService mockDatabaseService = new DatabaseService(mockMongoRepository, mockMongoOperations);
    NavigationMenuItem nav1 = new NavigationMenuItem("home", "/home");

    mockDatabaseService.saveObjectIntoDatabase(nav1);

    assertTrue(nav1.id > 0, "expected nav1.id is greater than");

  }

  @Test
  public void save_model_object_to_actual_database() {
    NavigationMenuItem nav1 = new NavigationMenuItem("home", "/home");
    NavigationMenuItem nav2 = new NavigationMenuItem("post", "/post");
    NavigationMenuItem nav3 = new NavigationMenuItem("photos", "/photos");

    DatabaseService databaseService = new DatabaseService(navigationMenuItemRepository, mongoOperations);
    navigationMenuItemRepository.save(nav1);
    // databaseService.saveObjectIntoDatabase(nav1);
    // databaseService.saveObjectIntoDatabase(nav2);
    // databaseService.saveObjectIntoDatabase(nav3);

  }

  public void update_existing_model_object_to_actual_database() {
    // TODO https://www.baeldung.com/spring-data-mongodb-tutorial#3-save---update

  }

}