package com.mychanic.controllers;

import com.mychanic.dao.OficinaDAO;
import com.mychanic.models.Oficina;
import com.mychanic.models.ServiceResponse;
import com.mychanic.services.OficinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oficina")
public class OficinaController {

    OficinaService oficinaService = new OficinaService();

    @PostMapping
    public ResponseEntity<Oficina> create (@RequestBody Oficina data){
        try{
            ServiceResponse<Oficina> response = oficinaService.criarOficina(data);

            if (response.isSuccess()){
                Oficina oficinaNova = response.getData();
                return ResponseEntity.status(HttpStatus.CREATED).body(oficinaNova);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Oficina>> getAll (){
        try{
            ServiceResponse<List<Oficina>> response = oficinaService.getAll();

            if (response.isSuccess()){
                List<Oficina> oficinas = response.getData();
                return ResponseEntity.status(HttpStatus.OK).body(oficinas);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<Oficina>> getByCat (@RequestParam int cat){
        try{
            ServiceResponse<List<Oficina>> response = oficinaService.getByCat(cat);

            if (response.isSuccess()){
                List<Oficina> oficinas = response.getData();
                return ResponseEntity.status(HttpStatus.OK).body(oficinas);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete (@PathVariable int id){
        try{
            ServiceResponse<Boolean> response = oficinaService.delete(id);
            if (response.isSuccess()){
                Boolean oficinaRemovida = response.getData();
                return ResponseEntity.status(HttpStatus.OK).body(oficinaRemovida);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Oficina> update (@PathVariable int id, @RequestBody Oficina updatedObj){
        try{
            ServiceResponse<Oficina> response = oficinaService.update(id, updatedObj);
            if (response.isSuccess()){
                return ResponseEntity.status(HttpStatus.OK).body(response.getData());
            } else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
