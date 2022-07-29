package com.travelmanagement.services.packege;

import com.travelmanagement.dao.packege.PackageDAO;
import com.travelmanagement.model.travelpackage.TravelPackageModel;
import com.travelmanagement.model.user.UsersModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PackageServicesImpl implements PackageServices {
    private final PackageDAO packageDAO;

    public PackageServicesImpl(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
    }

    @Override
    public void save(UsersModel usersModel, TravelPackageModel travelPackageModel) {
        packageDAO.save(usersModel, travelPackageModel);
    }

    @Override
    public List<TravelPackageModel> getAllTravelPackage() {
        return packageDAO.getAllTravelPackage();
    }

    @Override
    public TravelPackageModel getTravelPackage(int id) {
        return packageDAO.getTravelPackage(id);
    }

    @Override
    public List<TravelPackageModel> getTravelPackageByUser(int id) {
        List<TravelPackageModel> travelPackageModelList=packageDAO.getTravelPackageByUser(id);
        return travelPackageModelList==null?new ArrayList<TravelPackageModel>():travelPackageModelList;
    }

    @Override
    public void deleteTravelPackage(int id) {
        packageDAO.deleteTravelPackage(id);
    }

    @Override
    public void updateTravelPackage(TravelPackageModel travelPackageModel) {
        packageDAO.updateTravelPackage(travelPackageModel);
    }
}
