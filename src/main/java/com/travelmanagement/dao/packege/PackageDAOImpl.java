package com.travelmanagement.dao.packege;

import com.travelmanagement.model.travelpackage.TravelPackageModel;
import com.travelmanagement.model.user.UsersModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PackageDAOImpl implements PackageDAO{
    private final SessionFactory sessionFactory;

    public PackageDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(UsersModel usersModel, TravelPackageModel travelPackageModel) {
        Session session = sessionFactory.getCurrentSession();
        UsersModel user=session.get(UsersModel.class,usersModel.getId());
        user.add(travelPackageModel);
        session.save(user);
    }

    @Override
    public List<TravelPackageModel> getAllTravelPackage() {
        Session session = sessionFactory.getCurrentSession();
        List<TravelPackageModel> travelPackageModels = session.createQuery("from TravelPackageModel",TravelPackageModel.class).list();
        return travelPackageModels;
    }

    @Override
    public TravelPackageModel getTravelPackage(int id) {
        Session session = sessionFactory.getCurrentSession();
        TravelPackageModel travelPackageModel = session.get(TravelPackageModel.class,id);
        return travelPackageModel;
    }

    @Override
    public List<TravelPackageModel> getTravelPackageByUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        List<TravelPackageModel> travelPackageModels = session.createQuery("from TravelPackageModel where user_id="+id,TravelPackageModel.class).list();
        return travelPackageModels;
    }

    @Override
    public void deleteTravelPackage(int id) {
        Session session = sessionFactory.getCurrentSession();
        TravelPackageModel travelPackageModel = session.get(TravelPackageModel.class,id);
        session.delete(travelPackageModel);
    }

    @Override
    public void updateTravelPackage(TravelPackageModel travelPackageModel) {
        Session session = sessionFactory.getCurrentSession();
        TravelPackageModel tempTravelPackageModel = session.get(TravelPackageModel.class,travelPackageModel.getId());
        tempTravelPackageModel.setPackageName(travelPackageModel.getPackageName());
        tempTravelPackageModel.setDescription(travelPackageModel.getDescription());
        tempTravelPackageModel.setPrice(travelPackageModel.getPrice());
        tempTravelPackageModel.setStartDate(travelPackageModel.getStartDate());
        tempTravelPackageModel.setEndDate(travelPackageModel.getEndDate());
        session.save(tempTravelPackageModel);
    }
}
