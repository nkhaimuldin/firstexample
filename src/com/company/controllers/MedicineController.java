package com.company.controllers;

import com.company.data.interfaces.IDB;
import com.company.entities.Medicine;
import com.company.repositories.interfaces.IMedicineRepositories;

import java.util.Date;
import java.util.List;

public class MedicineController {
    private final IMedicineRepositories repo;

    public MedicineController(IMedicineRepositories repo){
    this.repo=repo;
    }
    public String createMedicine(String name, int price, String expiration, String manufacturer){
        Medicine medicine = new Medicine(name,price, expiration,manufacturer);
        boolean created = repo.createMedicine(medicine);
        return (created ? "Medicine was created!" : "Medicine creation is not done!");
    }

public String getMedicine(int id){
        Medicine medicine = repo.getMedicine(id);
        return (medicine == null ? "Medicine was not found!" : medicine.toString());
}
public String getAllMedicines(){
    List <Medicine> medicines = repo.getAllMedicine();
    return medicines.toString();
}
    public String getMedicineByName(String name){
        List<Medicine> medicine = repo.getMedicineByName(name);

        return (medicine.size() == 0 ? "Medicine was not found!" : medicine.toString());
    }
    public String removeMedicineByID(int id){
        boolean check = repo.removeMedicineByID(id);

        return (check ? "Medicine device was removed!" : "Medicine device by this ID was not found!");
    }
}

