package rs.ac.bg.fon.silab.ru.validator;

/**
 *
 * @author user
 */
public class ValidatorFactory {
    public static Validator create(String className) {
        Validator command = null;
        
        if(className.equalsIgnoreCase("city")) {
            command = new CityValidator();
        } else if(className.equalsIgnoreCase("contact")) {
            command = new ContactValidator();
        } else if(className.equalsIgnoreCase("contact_type")) {
            command = new ContactTypeValidator();
        } else if(className.equalsIgnoreCase("country")) {
            command = new CountryValidator();
        } else if(className.equalsIgnoreCase("faculty")) {
            command = new FacultyValidator();
        } else if(className.equalsIgnoreCase("manager")) {
            command = new ManagerValidator();
        } else if(className.equalsIgnoreCase("manager_position")) {
            command = new ManagerPositionValidator();
        } else if(className.equalsIgnoreCase("management_period")) {
            command = new ManagementPeriodValidator();
        } else if(className.equalsIgnoreCase("rank")) {
            command = new RankValidator();
        } else if(className.equalsIgnoreCase("title")) {
            command = new TitleValidator();
        } else if(className.equalsIgnoreCase("university")) {
            command = new UniversityValidator();
        }
        
        return command;
    }
}
