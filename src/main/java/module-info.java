module sit.tuvarna.bg.vaccine {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires log4j;
    requires org.hibernate.orm.core;
    requires java.persistence;


    exports sit.tuvarna.bg.vaccine.application;
    opens sit.tuvarna.bg.vaccine.application to javafx.fxml;


    exports sit.tuvarna.bg.vaccine.presentation.controllers;
    opens sit.tuvarna.bg.vaccine.presentation.controllers to javafx.fxml;
}