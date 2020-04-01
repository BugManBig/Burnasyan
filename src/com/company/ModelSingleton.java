package com.company;

public class ModelSingleton {
    private static Model model;

    public static Model getModel() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }
}
