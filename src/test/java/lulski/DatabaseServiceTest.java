package lulski;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;

import lulski.model.NavigationMenuItem;
import lulski.model.db.DatabaseSequence;
import lulski.service.DatabaseService;

public class DatabaseServiceTest {

  MongoOperations mockMongoOperations;
  MongoRepository mockMongoRepository;

  @Before
  public void initMock() {

    mockMongoOperations = mock(MongoOperations.class);

    mockMongoRepository = mock(MongoRepository.class);
  }

  @Test
  public void generate_sequence_number_return_long_value_of_1() {

    DatabaseSequence mockDatabaseSequence = new DatabaseSequence();
    mockDatabaseSequence.setSeq(1);


    //findAndModify(Query query, UpdateDefinition update, FindAndModifyOptions options, Class<T> entityClass);
    when(mockMongoOperations.findAndModify(any(Query.class), any(Update.class), any(FindAndModifyOptions.class), any() ))
        .thenReturn(mockDatabaseSequence);

    DatabaseService sequenceGeneratorService = new DatabaseService(
        mockMongoOperations,mockMongoRepository);

    assertEquals(1, sequenceGeneratorService.generateSequence("random_sequence_name"));

  }

  @Test
  public void save_model_object_to_database(){

    DatabaseSequence mockDatabaseSequence = new DatabaseSequence();
    mockDatabaseSequence.setSeq(1);


    //findAndModify(Query query, UpdateDefinition update, FindAndModifyOptions options, Class<T> entityClass);
    when(mockMongoOperations.findAndModify(any(Query.class), any(Update.class), any(FindAndModifyOptions.class), any() ))
        .thenReturn(mockDatabaseSequence);

    DatabaseService sequenceGeneratorService = new DatabaseService(
        mockMongoOperations,mockMongoRepository);


    DatabaseService databaseService = new DatabaseService(mockMongoOperations,mockMongoRepository);
    NavigationMenuItem nav1 = new NavigationMenuItem("home", "/home");

    databaseService.saveObjectIntoDatabase(nav1);


  }
}