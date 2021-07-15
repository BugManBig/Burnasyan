package com.company;

import java.util.List;
import java.util.Properties;

public class MenuController {
    private MenuView menuView;

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void start() {
        menuView.create();
    }

    public void handleAddButtonClick() {
        AddView addView = new AddView();
        AddController addController = new AddController();
        addView.setAddController(addController);
        addController.setAddView(addView);
        addController.start();
        menuView.close();
    }

    public void handleSearchButtonClick() {
        SingleSearchView singleSearchView = new SingleSearchView();
        SingleSearchController singleSearchController = new SingleSearchController();
        singleSearchView.setSingleSearchController(singleSearchController);
        singleSearchController.setSingleSearchView(singleSearchView);
        singleSearchController.start();
    }

    public void handleExportButtonClick() {
        Model model = ModelSingleton.getModel();
        model.readDoctors();
        model.readPatients();
        Excel excel = new Excel();
        String[] types = Params.types;
        for (int i = 0; i < types.length; i++) {
            excel.setData(0, i, types[i]);
        }
        List<Properties> properties = ModelSingleton.getModel().getPropertiesListFromResearches();
        for (int j = 0; j < properties.size(); j++) {
            Properties prop = properties.get(j);
            int doctorId = Integer.parseInt(prop.getProperty(Task.getFieldNames()[0]));
            int patientId = Integer.parseInt(prop.getProperty(Task.getFieldNames()[1]));
            excel.setData(j + 1, 0, model.getDoctor(doctorId).getFio());
            excel.setData(j + 1, 1, model.getPatient(patientId).getFio());
            for (int i = 2; i < prop.size(); i++) {
                excel.setData(j + 1, i, prop.getProperty(Task.getFieldNames()[i]));
            }
        }
        excel.save(Params.get("EXCEL") + "/output.xls");
    }
}
