/**
 * Modules
 * @author Ole Kristian Dvergsdal
 * @version 1.0
 */
module no.ntnu.iir.wargames {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.elusive;
    requires MaterialFX;
    requires javafx.media;

    opens no.ntnu.iir.ui to javafx.fxml;
    opens no.ntnu.iir.logic to javafx.fxml;
    opens no.ntnu.iir.data to javafx.fxml;
    opens no.ntnu.iir.fileshandlers to javafx.fxml;

    exports no.ntnu.iir.data;
    exports no.ntnu.iir.logic;
    exports no.ntnu.iir.ui;
    exports no.ntnu.iir.fileshandlers;
    exports no.ntnu.iir;
    opens no.ntnu.iir to javafx.fxml;
}