package com.mycompany.electroniccomponentsproject.service;

import model.ElectronicComponent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ElectronicComponentService {

    // Lista estática que simula persistencia en memoria
    private static final List<ElectronicComponent> components = new ArrayList<>();

    // =========================
    // CREATE
    // =========================
    public static ElectronicComponent add(ElectronicComponent component) {

        if (component == null) {
            throw new IllegalArgumentException("Component cannot be null");
        }

        if (findComponentById(component.getId()) != null) {
            throw new IllegalArgumentException("Component with this ID already exists");
        }

        components.add(component);
        return component;
    }

    // =========================
    // READ
    // =========================
    public static ElectronicComponent findComponentById(int id) {

        return components.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // =========================
    // DELETE
    // =========================
    public static boolean deleteComponent(int id) {

        ElectronicComponent component = findComponentById(id);

        if (component == null) {
            return false;
        }

        return components.remove(component);
    }

    // =========================
    // FIND BY TYPE (GENERIC)
    // =========================
    public static <T extends ElectronicComponent> List<T> findComponentByType(Class<T> targetClass) {

        return components.stream()
                .filter(targetClass::isInstance)
                .map(targetClass::cast)
                .collect(Collectors.toList());
    }

    // =========================
    // POLYMORPHIC METHODS
    // =========================
    public static double calculateImpedanceById(int id) {

        ElectronicComponent component = findComponentById(id);

        if (component == null) {
            throw new IllegalArgumentException("Component not found");
        }

        return component.calculateImpedance();
    }

    public static double calculatePowerById(int id) {

        ElectronicComponent component = findComponentById(id);

        if (component == null) {
            throw new IllegalArgumentException("Component not found");
        }

        return component.calculatePower();
    }
}

