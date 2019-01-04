/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gasytube.dao;

import mg.gasytube.model.BaseModele;
import java.util.List;

/**
 *
 * @author MIORA
 */
public interface InterfaceDAO {
    public abstract void update(BaseModele arg);
    public abstract void delete(BaseModele arg);
    public abstract void create(BaseModele arg);
    public abstract List<BaseModele> findAll(BaseModele arg);
    public abstract List<BaseModele> findAllPagination(BaseModele arg ,int limit,int offset);
}
