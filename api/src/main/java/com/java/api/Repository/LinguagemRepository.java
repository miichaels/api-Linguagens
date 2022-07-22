package com.java.api.Repository;

import com.java.api.Linguagem.Linguagem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinguagemRepository extends MongoRepository<Linguagem,String> {

    public List<Linguagem> title (String title);
    public List<Linguagem> findByRanking (int ranking);
}
