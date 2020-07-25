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
public class DatabaseService {

  private final MongoOperations mongoOperations;
  private final MongoRepository mongoRepository;

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

  public long saveObjectIntoDatabase(BaseModel model) {

    model.setId(generateSequence(model.SEQUENCE_NAME));

    mongoRepository.save(model);
    // TODO return positive int value when save is successful
    return 0;
  }

}