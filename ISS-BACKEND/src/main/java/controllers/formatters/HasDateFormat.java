package controllers.formatters;

import java.time.format.DateTimeFormatter;

public interface HasDateFormat {
    public static final DateTimeFormatter dateFormat = DateTimeFormatter.ISO_LOCAL_DATE; //YYYY-MM-DD
}
