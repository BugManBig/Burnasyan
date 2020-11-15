package com.company;

import java.util.HashSet;
import java.util.Set;

public class ElastoController {
    private ElastoView elastoView;

    public void setElastoView(ElastoView elastoView) {
        this.elastoView = elastoView;
    }

    public void start() {
        elastoView.create();
    }

    public void handleKeyRelease() {
        String metavir3 = getMetavir(elastoView.getElast3());
        elastoView.setMetavir3Label(metavir3);
        String metavir10 = getMetavir(elastoView.getElast10());
        elastoView.setMetavir10Label(metavir10);
        String metavirPq = getMetavir(elastoView.getElastPq());
        elastoView.setMetavirPqLabel(metavirPq);
        Set<String> set = new HashSet<>();
        set.add(metavir3);
        set.add(metavir10);
        boolean wasAdded = set.add(metavirPq);
        String resultMetavir = wasAdded ? metavir3 : metavirPq;
        if (resultMetavir.length() == 0) {
            return;
        }
        if (resultMetavir.length() > 2) {
            elastoView.setSelectedMetavir(0);
        } else {
            int id = Integer.parseInt(resultMetavir.substring(1));
            elastoView.setSelectedMetavir(id - 1);
        }
    }

    private String getMetavir(String input) {
        if (input.length() > 0) {
            double elast;
            try {
                elast = Double.parseDouble(input.replace(',', '.'));
            } catch (NumberFormatException e) {
                return "";
            }
            return getMetavirByValue(elast);
        }
        return "";
    }

    private String getMetavirByValue(double value) {
        if (value <= 7.1) {
            return "F0-F1";
        } else if (value > 7.1 && value <= 8.7) {
            return "F2";
        } else if (value > 8.7 && value <= 10.4) {
            return "F3";
        }
        return "F4";
    }

    public void handleNextButtonClick() {
        Task task = ModelSingleton.getModel().getTask();
        task.elastoQ3 = elastoView.getElast3();
        task.elastoQ10 = elastoView.getElast10();
        task.elastoPq = elastoView.getElastPq();
        task.elastoSQ3 = elastoView.getElastSelez();
        task.inaccuracy1 = elastoView.getInaccuracy1();
        task.inaccuracy2 = elastoView.getInaccuracy2();
        task.inaccuracy3 = elastoView.getInaccuracy3();
        task.inaccuracy4 = elastoView.getInaccuracy4();
        task.elastoMetavir = elastoView.getMetavir();

        BiohimView biohimView = new BiohimView();
        BiohimController biohimController = new BiohimController();
        biohimView.setBiohimController(biohimController);
        biohimController.setBiohimView(biohimView);
        biohimController.start();

        elastoView.close();
    }
}
