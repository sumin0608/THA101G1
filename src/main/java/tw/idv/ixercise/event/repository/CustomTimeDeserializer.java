package tw.idv.ixercise.event.repository;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomTimeDeserializer extends JsonDeserializer<Time> {
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

    @Override
    public Time deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String timeString = jsonParser.getText();
        try {
            Date date = TIME_FORMAT.parse(timeString);
            return new Time(date.getTime());
        } catch (ParseException e) {
            throw new IOException("Error parsing time", e);
        }
    }
}
