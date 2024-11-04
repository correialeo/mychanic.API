package com.mychanic.services;

import com.mychanic.dao.OficinaDAO;
import com.mychanic.models.Oficina;
import com.mychanic.models.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OficinaService {

    OficinaDAO oficinaDAO = new OficinaDAO();

    public ServiceResponse<Oficina> criarOficina(Oficina oficina) {
        try{
            oficinaDAO.insert(oficina);
            return ServiceResponse.success(oficina, "Oficina criada com sucesso");

        }catch (Exception e){
            return ServiceResponse.failure("Erro interno: "+e);
        }
    }

    public ServiceResponse<List<Oficina>> getAll() {
        try{
            List<Oficina> oficinas = oficinaDAO.read();
            return ServiceResponse.success(oficinas, "Oficinas buscadas com sucesso");
        }catch (Exception e){
            return ServiceResponse.failure("Erro interno: "+e);
        }
    }

    public ServiceResponse<List<Oficina>> getByCat(int categoria){
        List<Oficina> oficinas = oficinaDAO.getByCat(categoria);
        return ServiceResponse.success(oficinas, "Categoria buscada com sucesso");
    }

    public ServiceResponse<Boolean> delete(int id){
        try{
            boolean oficinaDeletada = oficinaDAO.delete(id);
            return ServiceResponse.success(oficinaDeletada, "Oficina deletada com sucesso");
        } catch (Exception e) {
            return ServiceResponse.failure("Erro interno");
        }
    }

    public ServiceResponse<Oficina> update(int id, Oficina updatedObj){
        try{
            oficinaDAO.update(id, updatedObj);
            return ServiceResponse.success(updatedObj, "Oficina alterada com sucesso");
        } catch (Exception e) {
            return ServiceResponse.failure("Erro interno");
        }
    }
}


