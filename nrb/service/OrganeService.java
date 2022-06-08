/*
 * Creation : 21 Dec 2021
 */
package com.inetpsa.nrb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inetpsa.nrb.model.BmuEntity;
import com.inetpsa.nrb.model.HdataEntity;
import com.inetpsa.nrb.model.Module;
import com.inetpsa.nrb.model.OrganeEntity;
import com.inetpsa.nrb.model.Vin;

/**
 * The Interface OrganeService.
 */
@Service
public interface OrganeService {

    /**
     * Adds the update organe.
     *
     * @param dto the dto
     * @return the organe entity
     */
    OrganeEntity addUpdateOrgane(OrganeEntity dto);

    /**
     * Adds the update all organe.
     *
     * @param organeEntities the organe entities
     * @return the list
     */
    List<OrganeEntity> addUpdateAllOrgane(List<OrganeEntity> organeEntities);

    /**
     * Find by type organe and numero organe.
     *
     * @param typeOrgane the type organe
     * @param numeroOrgane the numero organe
     * @return the organe entity
     */
    OrganeEntity findByTypeOrganeAndNumeroOrgane(String typeOrgane, String numeroOrgane);

    /**
     * Find vin by type organe and numero organe.
     *
     * @param typeOrgane the type organe
     * @param numeroOrgane the numero organe
     * @return the vin
     */
    Vin findVinByTypeOrganeAndNumeroOrgane(String typeOrgane, String numeroOrgane);

    /**
     * Find bmu by type organe and numero organe.
     *
     * @param typeOrgane the type organe
     * @param numeroOrgane the numero organe
     * @return the bmu entity
     */
    BmuEntity findBmuByTypeOrganeAndNumeroOrgane(String typeOrgane, String numeroOrgane);

    /**
     * Adds the update all bmu.
     *
     * @param bmuEntities the bmu entities
     * @return the list
     */
    List<BmuEntity> addUpdateAllBmu(List<BmuEntity> bmuEntities);

    /**
     * Adds the update vin.
     *
     * @param vinList the vin list
     * @return the list
     */
    List<Vin> addUpdateVin(List<Vin> vinList);

    /**
     * Find hdata by type organe and numero organe.
     *
     * @param typeOrgane the type organe
     * @param numeroOrgane the numero organe
     * @return the hdata entity
     */
    HdataEntity findHdataByTypeOrganeAndNumeroOrgane(String typeOrgane, String numeroOrgane);

    /**
     * Adds the update all hdata.
     *
     * @param hdataEntities the hdata entities
     * @return the list
     */
    List<HdataEntity> addUpdateAllHdata(List<HdataEntity> hdataEntities);

    /**
     * Find module by unique key.
     *
     * @param typeOrgane the type organe
     * @param numeroOrgane the numero organe
     * @param typeMod the type mod
     * @param numeroMod the numero mod
     * @return the module
     */
    Module findModuleByUniqueKey(String typeOrgane, String numeroOrgane, String typeMod, String numeroMod);

    /**
     * Delete module.
     *
     * @param module the module
     */
    void deleteModule(Module module);

    /**
     * Adds the update all module.
     *
     * @param moduleList the module list
     * @return the list
     */
    List<Module> addUpdateAllModule(List<Module> moduleList);

    void historizedModule(Module newModul, String type);

}
