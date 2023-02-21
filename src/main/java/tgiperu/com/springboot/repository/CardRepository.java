package tgiperu.com.springboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tgiperu.com.springboot.model.Card;

import java.util.List;
@Repository
public class CardRepository implements ICardRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Card> findAll() {
        String SQL="SELECT * FROM cards WHERE status=1";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Card.class));
    }

    @Override
    public int save(Card card) {
        String SQL="INSERT INTO cards VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(SQL,new Object[]{card.getName(),card.getNumber(),card.getType(),card.getCvv(),card.getStatus()});
    }

    @Override
    public int update(Card card) {
        String SQL="UPDATE cards SET name=?,number=?, type=?,cvv=? WHERE id_card=?";
        return jdbcTemplate.update(SQL,new Object[]{card.getName(),card.getNumber(),card.getType(),card.getCvv(),card.getId_card()});
    }

    @Override
    public int delete(int id) {
        String SQL="UPDATE cards SET status=0 WHERE id_card=?";
        return jdbcTemplate.update(SQL,new Object[]{id});
    }
}
