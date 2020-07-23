package lulski.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import lulski.model.db.DatabaseSequence;

@Service
public class DatabaseSequenceGeneratorService {

  @Autowired
  MongoOperations mongoOperations;

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


}