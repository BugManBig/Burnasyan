package com.company;

public class CommentController {
    private CommentView commentView;

    public void setCommentView(CommentView commentView) {
        this.commentView = commentView;
    }

    public void start() {
        commentView.create();
    }

    public void handleNextButtonClick() {
        Model model = ModelSingleton.getModel();
        model.getTask().comment = commentView.getComment();
        model.saveResearch();

        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController();
        menuView.setMenuController(menuController);
        menuController.setMenuView(menuView);
        menuController.start();

        commentView.close();
    }
}
