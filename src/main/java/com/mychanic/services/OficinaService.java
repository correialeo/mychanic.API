package com.mychanic.services;

import com.mychanic.dao.OficinaDAO;
import com.mychanic.models.Oficina;
import com.mychanic.models.ServiceResponse;
import java.util.List;

public class OficinaService {

    private OficinaDAO oficinaDAO;

    public OficinaService(OficinaDAO oficinaDAO) {
        this.oficinaDAO = oficinaDAO;
    }

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
            Boolean oficinaDeletada = oficinaDAO.delete(id);
            return ServiceResponse.success(oficinaDeletada, "Oficina deletada com sucesso");
        } catch (Exception e) {
            return ServiceResponse.failure("Erro interno");
        }
    }
}


