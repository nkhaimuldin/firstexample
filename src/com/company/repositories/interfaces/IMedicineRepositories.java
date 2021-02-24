package com.company.repositories.interfaces;

import com.company.entities.Medicine;

import java.util.List;

public interface IMedicineRepositories {
    boolean createMedicine(Medicine medicine);
    Medicine getMedicine(int id);
    List<Medicine> getAllMedicine();
    List<Medicine> getMedicineByName(String name);
    boolean removeMedicineByID(int id);
}
