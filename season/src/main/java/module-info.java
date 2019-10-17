/**
 * @author Andrew Kearney
 */
module season {
    requires com.androsaces.buckaroo;
    requires hq;
    requires java.sql;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires org.slf4j;

    opens com.androsaces.formulaone.season.ui to javafx.graphics;
}