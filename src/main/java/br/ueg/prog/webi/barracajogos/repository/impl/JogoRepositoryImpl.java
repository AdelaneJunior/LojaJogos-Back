package br.ueg.prog.webi.barracajogos.repository.impl;

import br.ueg.prog.webi.barracajogos.model.Jogo;
import br.ueg.prog.webi.barracajogos.repository.JogoRepository;
import br.ueg.prog.webi.barracajogos.repository.JogoRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class JogoRepositoryImpl implements JogoRepositoryCustom {

    @Autowired
    private EntityManager em;

    @Override
    public List<Jogo> localizarPorJogo(Jogo jogo) {

        Map<String, Object> parametros = new HashMap<>();

        StringBuilder jpql = new StringBuilder();

        jpql.append(" SELECT jogo FROM Jogo jogo");

        jpql.append(" WHERE 1=1 ");

        if (Strings.isNotEmpty(jogo.getNomeJogo())) {

            jpql.append(" AND UPPER (jogo.getNomeJogo) LIKE UPPER('%' || :nomeJogo || '%')  ");
            parametros.put("nomeJogo", jogo.getNomeJogo());

        }

        if (Strings.isNotEmpty(jogo.getDesenvolvedora())){

            jpql.append(" AND UPPER (jogo.getDesenvolvedora) LIKE UPPER('% || :desenvolvedora || '%') ");
            parametros.put("desenvolvedora", jogo.getDesenvolvedora());

        }

        TypedQuery<Jogo> query = em.createQuery(jpql.toString(), Jogo.class);

        parametros.entrySet().forEach(parametro -> query.setParameter(parametro.getKey(), parametro.getValue()));

        return query.getResultList();
    }

}
