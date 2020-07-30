package lulski.service;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lulski.model.BaseModel;

import lulski.model.db.DatabaseSequence;

@Service
@RequiredArgsConstructor
/*
 * Database service class, not sure why I need this anymore now that I can
 * override MongoRepository implementation : see
 * NavigationMenuItemRepositoryImpl, NavigationMenuItemCustomRepository
 */
public class DatabaseService {

  private final MongoRepository mongoRepository;
  private final MongoOperations mongoOperations;

  public long generateSequence(String seqName) {

    Criteria criteria = Criteria.where("_id").is(seqName);

    Query query = new Query(criteria);

    Update update = new Update().inc("seq", 1);

    FindAndModifyOptions options = new FindAndModifyOptions();
    options.upsert(true);
    options.returnNew(true);

    DatabaseSequence counter = mongoOperations.findAndModify(query, update, options, DatabaseSequence.class);

    return counter.getSeq();
  }

  public BaseModel saveObjectIntoDatabase(BaseModel model) {

    model.setId(generateSequence(model.SEQUENCE_NAME));

    try {
      mongoRepository.save(model);

    } catch (Exception e) {
      System.err.println(">>> failed to save model " + model.toString());
      e.printStackTrace();
    }
    return model;
  }

}