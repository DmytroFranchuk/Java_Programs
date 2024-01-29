package org.loto;

import org.loto.controller.Controller;
import org.loto.model.ModelGame;
import org.loto.view.UserView;

import javax.swing.*;

public class LotoApplication {
    public static void main( String[] args ) {
        ModelGame model = new ModelGame();
        Controller controller = new Controller(model);
        UserView userView = new UserView(controller);
        SwingUtilities.invokeLater(userView::init);
    }
}
