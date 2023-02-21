package tgiperu.com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tgiperu.com.springboot.model.Card;
import tgiperu.com.springboot.repository.ICardRepository;

import java.util.List;
@Service
public class CardService implements ICardService{
    @Autowired
    private ICardRepository iCardRepository;
    @Override
    public List<Card> findAll() {
        List<Card> list;
        try {
            list=iCardRepository.findAll();
        }
        catch (Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public int save(Card card) {
        int row;
        try {
            row=iCardRepository.save(card);
        }
        catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int update(Card card) {
       int row;
        try {
            row=iCardRepository.update(card);
        }
        catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int delete(int id) {
        int row;
        try {
            row=iCardRepository.delete(id);
        }
        catch (Exception ex){
            throw ex;
        }
        return row;
    }
}
