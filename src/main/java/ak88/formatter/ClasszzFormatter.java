package ak88.formatter;

import ak88.model.Classzz;
import ak88.service.ClasszzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ClasszzFormatter implements Formatter<Classzz> {

    private final ClasszzService classzzService;
     @Autowired
    public ClasszzFormatter(ClasszzService classzzService) {
        this.classzzService = classzzService;
    }

    @Override
    public Classzz parse(String text, Locale locale) throws ParseException {
        Optional<Classzz> category = classzzService.findById(Long.parseLong(text));
        return category.get();
    }

    @Override
    public String print(Classzz object, Locale locale) {
        return null;
    }
}
