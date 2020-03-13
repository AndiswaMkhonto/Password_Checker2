import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PasswordChecker {
    private static final Logger logger = LogManager.getLogger(PasswordChecker.class.getName());
    private static ArrayList<String> listOfErrors= new ArrayList<>();
    public static boolean isValid(String yourPassword ){
        Pattern specialCharPatten = Pattern.compile("[$&+,:;=?@#|'<>.^*()%!-]", Pattern.CASE_INSENSITIVE);
        Pattern UpperCasePatten = Pattern.compile("[A-Z]");
        Pattern lowerCasePatten = Pattern.compile("[a-z]");
        Pattern digitCasePatten = Pattern.compile("[0-9]");

        boolean flag = true;
        if(yourPassword.isEmpty()){
           logger.error("password does not exist ");
            flag = false;
            listOfErrors.add("password does not exist ");
        }

        if (yourPassword.length() < 8) {
            logger.error("Password length must have at least 8 character !!");
            flag = false;
            listOfErrors.add("Password length must have at least 8 character !!");
        }
        if (!specialCharPatten.matcher(yourPassword ).find()) {
            logger.error("Password must have at least one special character !!");
            flag = false;
            listOfErrors.add("Password must have at least one special character !!");
        }
        if (!UpperCasePatten.matcher(yourPassword ).find()) {
            logger.error("Password must have at least one uppercase character !!");
            flag = false;
            listOfErrors.add("Password must have at least one uppercase character !!");
        }
        if (!lowerCasePatten.matcher(yourPassword ).find()) {
            logger.error("Password must have at least one lowercase character !!");
            flag = false;
            listOfErrors.add("Password must have at least one lowercase character !!");
        }
        if (!digitCasePatten.matcher(yourPassword ).find()) {
           logger.error("Password must have atleast one digit character !!");
            flag = false;
            listOfErrors.add("Password must have atleast one digit character !!");
        }
        return flag;
    }
    public static boolean passwordIsOkay(String password){
        boolean flag = false;

        if(listOfErrors.size()<=3 && !password.isEmpty() && password.length() >= 8){
            flag = true;
            System.out.println("Password is okay");
        }else {
            System.out.println("Password never okay");
            flag=false;
        }
        return flag;

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            System.out.println("Please enter a  password : ");
            String yourPassword = in.nextLine();
            System.out.println();
            try{
                if(isValid(yourPassword )){
                    System.out.println("Password is valid");
                }
                if(passwordIsOkay(yourPassword)){
                    logger.debug("Password is okay");
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }

        }


    }


