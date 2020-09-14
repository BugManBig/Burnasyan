package com.company;

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
}
