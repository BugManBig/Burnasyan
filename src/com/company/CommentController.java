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
        ModelSingleton.getModel().getTask().comment = commentView.getComment();

        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController();
        menuView.setMenuController(menuController);
        menuController.setMenuView(menuView);
        menuController.start();

        commentView.close();
    }
}
