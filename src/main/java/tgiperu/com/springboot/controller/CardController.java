package tgiperu.com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tgiperu.com.springboot.model.Card;
import tgiperu.com.springboot.model.ServiceResponse;
import tgiperu.com.springboot.service.ICardService;

import java.util.List;

@RestController
@RequestMapping("api/v1/card")
@CrossOrigin("*")
public class CardController {
    @Autowired
    private ICardService iCardService;
    @GetMapping("/list")
    public ResponseEntity<List<Card>> list(){
        var result  = iCardService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody Card card){
        ServiceResponse serviceResponse=new ServiceResponse();
        int result  = iCardService.save(card);
        if(result==1){
            serviceResponse.setMessage("Item saved with success");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Card card){
        ServiceResponse serviceResponse=new ServiceResponse();
        int result  = iCardService.update(card);
        if(result==1){
            serviceResponse.setMessage("Item updated with success");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id){
        ServiceResponse serviceResponse=new ServiceResponse();
        int result  = iCardService.delete(id);
        if(result==1){
            serviceResponse.setMessage("Item removed with success");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
