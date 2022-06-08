/*
 * Creation : 21 Dec 2021
 */
package com.inetpsa.nrb.serviceimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inetpsa.nrb.constant.CommonConstant;
import com.inetpsa.nrb.model.BmuEntity;
import com.inetpsa.nrb.model.HdataEntity;
import com.inetpsa.nrb.model.Module;
import com.inetpsa.nrb.model.ModuleHistory;
import com.inetpsa.nrb.model.OrganeEntity;
import com.inetpsa.nrb.model.Vin;
import com.inetpsa.nrb.repository.BmuRepository;
import com.inetpsa.nrb.repository.HdataRepository;
import com.inetpsa.nrb.repository.ModuleHistoryRepository;
import com.inetpsa.nrb.repository.ModuleRepository;
import com.inetpsa.nrb.repository.OrganeRepository;
import com.inetpsa.nrb.repository.VinRepository;
import com.inetpsa.nrb.service.OrganeService;

/**
 * The Class OrganeServiceImpl.
 */
@Service
public class OrganeServiceImpl implements OrganeService {

    /** The Constant logger. */
    public static final Logger logger = LoggerFactory.getLogger(OrganeServiceImpl.class);

    /** The mm set repository. */
    @Autowired
    private OrganeRepository organeRepository;

    /** The vin repository. */
    @Autowired
    private VinRepository vinRepository;

    /** The bmu repository. */
    @Autowired
    private BmuRepository bmuRepository;

    /** The hdata repository. */
    @Autowired
    private HdataRepository hdataRepository;

    /** The hdata repository. */
    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private ModuleHistoryRepository moduleHistoryRepository;

    /** The em 1. */
    @Autowired
    private EntityManager em1;

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.OrganeService#addUpdateOrgane(com.inetpsa.nrb.model.OrganeEntity)
     */
    @Override
    public OrganeEntity addUpdateOrgane(OrganeEntity dto) {
        try {

            OrganeEntity org = organeRepository.save(dto);
            if (org != null) {
                return org;
            }

        } catch (

        Exception e) {
            logger.error(CommonConstant.EXCEPTION_ADDUPDATE_ORGANE.getConstValue(), e);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.OrganeService#addUpdateAllOrgane(java.util.List)
     */
    @Override
    public List<OrganeEntity> addUpdateAllOrgane(List<OrganeEntity> organeEntities) {
        try {
            logger.info("Entering addUpdateAllOrgane");
            List<OrganeEntity> org = (List<OrganeEntity>) organeRepository.saveAll(organeEntities);
            if (org != null) {
                return org;
            }

        } catch (

        Exception e) {
            logger.error(CommonConstant.EXCEPTION_ADDUPDATE_ORGANE.getConstValue(), e);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.OrganeService#addUpdateAllBmu(java.util.List)
     */
    @Override
    public List<BmuEntity> addUpdateAllBmu(List<BmuEntity> bmuEntities) {
        try {
            logger.info("Entering addUpdateAllBmu");
            List<BmuEntity> bmu = (List<BmuEntity>) bmuRepository.saveAll(bmuEntities);
            if (bmu != null) {
                return bmu;
            }

        } catch (

        Exception e) {
            logger.error("Exception in  addUpdateAllBmu {}", e);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.OrganeService#deleteModule(com.inetpsa.nrb.model.Module)
     */
    @Override
    public void deleteModule(Module module) {
        try {
            logger.info("Entering deleteModule");
            moduleRepository.delete(module);

            logger.info("Module Deleted");
        } catch (

        Exception e) {
            logger.error("Exception in  deleteModule {}", e);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.OrganeService#addUpdateAllHdata(java.util.List)
     */
    @Override
    public List<HdataEntity> addUpdateAllHdata(List<HdataEntity> hdataEntities) {
        try {
            logger.info("Entering addUpdateAllHdata");
            List<HdataEntity> hData = (List<HdataEntity>) hdataRepository.saveAll(hdataEntities);
            if (hData != null) {
                return hData;
            }

        } catch (

        Exception e) {
            logger.error("Exception in  addUpdateAllHdata {}", e);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.OrganeService#addUpdateVin(java.util.List)
     */
    @Override
    public List<Vin> addUpdateVin(List<Vin> vinList) {
        try {

            List<Vin> vin = (List<Vin>) vinRepository.saveAll(vinList);
            if (vin != null) {
                return vin;
            }

        } catch (

        Exception e) {
            logger.error(CommonConstant.EXCEPTION_ADDUPDATE_ORGANE.getConstValue(), e);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.OrganeService#findByTypeOrganeAndNumeroOrgane(java.lang.String, java.lang.String)
     */
    @Override
    public OrganeEntity findByTypeOrganeAndNumeroOrgane(String typeOrgane, String numeroOrgane) {
        OrganeEntity organeEntity = null;
        logger.info("Entering findByTypeOrganeAndNumeroOrgane");
        try {
            Query organeQuery = em1.createNamedQuery("Organe.findByBusinessKey", OrganeEntity.class);
            organeQuery.setParameter(CommonConstant.TYPEORGANE.getConstValue(), typeOrgane);
            organeQuery.setParameter(CommonConstant.NUMEROORGANE.getConstValue(), numeroOrgane);

            organeEntity = (OrganeEntity) organeQuery.getSingleResult();
            logger.info("Exiting findByTypeOrganeAndNumeroOrgane");
        } catch (NoResultException ex) {
            // do nothing. null will return
        } catch (Exception e) {
            logger.error("Exception in  findByTypeOrganeAndNumeroOrgane {}", e);
        }
        return organeEntity;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.OrganeService#findModuleByUniqueKey(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Module findModuleByUniqueKey(String typeOrgane, String numeroOrgane, String typeMod, String numeroMod) {
        Module module = null;
        logger.info("Entering findModuleByUniqueKey");
        try {
            Query moduleQuery = em1.createNamedQuery("Module.findByBusinessKey", Module.class);
            moduleQuery.setParameter(CommonConstant.TYPEORGANE.getConstValue(), typeOrgane);
            moduleQuery.setParameter(CommonConstant.NUMEROORGANE.getConstValue(), numeroOrgane);
            moduleQuery.setParameter("typeModule", typeMod);
            moduleQuery.setParameter("numeroModule", numeroMod);

            module = (Module) moduleQuery.getSingleResult();
            logger.info("Exiting findModuleByUniqueKey");
        } catch (NoResultException ex) {
            // do nothing. null will return
        } catch (Exception e) {
            logger.error("Exception in  findModuleByUniqueKey {}", e);
        }
        return module;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.OrganeService#findHdataByTypeOrganeAndNumeroOrgane(java.lang.String, java.lang.String)
     */
    @Override
    public HdataEntity findHdataByTypeOrganeAndNumeroOrgane(String typeOrgane, String numeroOrgane) {
        HdataEntity hdataEntity = null;
        logger.info("Entering findHdataByTypeOrganeAndNumeroOrgane");
        try {
            Query hdataQuery = em1.createNamedQuery("HdataEntity.findByBusinessKey", HdataEntity.class);
            hdataQuery.setParameter(CommonConstant.TYPEORGANE.getConstValue(), typeOrgane);
            hdataQuery.setParameter(CommonConstant.NUMEROORGANE.getConstValue(), numeroOrgane);

            hdataEntity = (HdataEntity) hdataQuery.getSingleResult();
            logger.info("Exiting findHdataByTypeOrganeAndNumeroOrgane");
        } catch (NoResultException ex) {
            // do nothing. null will return
        } catch (Exception e) {
            logger.error("Exception in  findByTypeOrganeAndNumeroOrgane {}", e);
        }
        return hdataEntity;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.OrganeService#findVinByTypeOrganeAndNumeroOrgane(java.lang.String, java.lang.String)
     */
    @Override
    public Vin findVinByTypeOrganeAndNumeroOrgane(String typeOrgane, String numeroOrgane) {
        Vin vin = null;
        try {
            Query vinQuery = em1.createNamedQuery("VIN.findByBusinessKey", Vin.class);
            vinQuery.setParameter(CommonConstant.TYPEORGANE.getConstValue(), typeOrgane);
            vinQuery.setParameter(CommonConstant.NUMEROORGANE.getConstValue(), numeroOrgane);

            vin = (Vin) vinQuery.getSingleResult();
        } catch (NoResultException ex) {
            // do nothing. null will return
        } catch (Exception e) {
            logger.error("Exception in  findVinByTypeOrganeAndNumeroOrgane {}", e);
        }
        return vin;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.OrganeService#findBmuByTypeOrganeAndNumeroOrgane(java.lang.String, java.lang.String)
     */
    @Override
    public BmuEntity findBmuByTypeOrganeAndNumeroOrgane(String typeOrgane, String numeroOrgane) {
        BmuEntity bmu = null;
        try {
            Query bmuQuery = em1.createNamedQuery("BmuEntity.findByBusinessKey", BmuEntity.class);
            bmuQuery.setParameter(CommonConstant.TYPEORGANE.getConstValue(), typeOrgane);
            bmuQuery.setParameter(CommonConstant.NUMEROORGANE.getConstValue(), numeroOrgane);

            bmu = (BmuEntity) bmuQuery.getSingleResult();
        } catch (NoResultException ex) {
            // do nothing. null will return
        } catch (Exception e) {
            logger.error("Exception in  findVinByTypeOrganeAndNumeroOrgane {}", e);
        }
        return bmu;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.OrganeService#addUpdateAllModule(java.util.List)
     */
    @Override
    public List<Module> addUpdateAllModule(List<Module> moduleList) {
        try {
            logger.info("Entering addUpdateAllModule");
            List<Module> mod = (List<Module>) moduleRepository.saveAll(moduleList);
            if (mod != null) {
                return mod;
            }

        } catch (

        Exception e) {
            logger.error("Exception in  addUpdateAllModule {}", e);
        }
        return null;
    }

    @Override
    public void historizedModule(Module newModules, String type) {
        ModuleHistory history = new ModuleHistory();
        history.setModId(newModules.getId());
        history.setTypeOrgane(newModules.getTypeOrgane());
        history.setNumeroOrgane(newModules.getNumeroOrgane());
        history.setTypeModule(newModules.getTypeModule());
        history.setNumeroModule(newModules.getNumeroModule());
        history.setDescription2(newModules.getDescription2());
        history.setTypeUpdate(type);
        moduleHistoryRepository.save(history);
    }

}
