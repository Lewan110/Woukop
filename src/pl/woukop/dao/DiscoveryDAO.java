package pl.woukop.dao;

import java.util.List;

import pl.woukop.model.Discovery;
 
public interface DiscoveryDAO extends GenericDAO<Discovery, Long>{
 
    List<Discovery> getAll();
    Discovery getDataForView(Long DiscoveryID);
     
}
