import java.util.Scanner;
import java.util.regex.Matcher;

public class InputProcessor {
    Manager manager;

    public InputProcessor(Manager manager) {
        this.manager = manager;
    }

    Scanner scan=new Scanner(System.in);
    Matcher matcher1,matcher2;
    public void login(){
        boolean exit=false;
        String input;
        System.out.println("login page:");
        while(!exit){
            input=scan.nextLine();
            if(InputCommands.SIGNUP.getMatcher(input).matches()){
                if((matcher1=InputCommands.USERNAME.getMatcher(input)).matches()){
                    if(!manager.foundUsername(matcher1.group(1))){
                        if((matcher2=InputCommands.PASSWORD.getMatcher(input)).matches()){
                            manager.creatAccountForUser(matcher1.group(1),matcher2.group(1));
                            login();
                        } else System.err.println("Invalid input for password!!");
                    } else System.out.println("this username already exist!!");
                }else System.err.println("Invalid input for username!!");
            }
            else if(InputCommands.LOGIN.getMatcher(input).matches()){
                if((matcher1=InputCommands.USERNAME.getMatcher(input)).matches()){
                    if(manager.foundUsername(matcher1.group(1))){
                        if((matcher2=InputCommands.PASSWORD.getMatcher(input)).matches()){
                            if(manager.foundPassword(matcher1.group(1),matcher2.group(1))){
                                menu();
                            }else System.out.println("wrong password!!");
                        }else System.err.println("Invalid input for password!!");
                    }else System.out.println("username was not found!!");
                }else System.err.println("Invalid input for username!!");
            }
            else if(InputCommands.EXIT.getMatcher(input).matches()){
                exit=true;
            }
            else
                System.err.println("Invalid input!!");
        }
    }
    private void menu(){
        boolean logout=false;
        String input;
        System.out.println("menu page:");
        while (!logout){
            input=scan.nextLine();
            if(InputCommands.START.getMatcher(input).matches()){

            }else if(InputCommands.SETTINGS.getMatcher(input).matches()){

            }else if(InputCommands.LOGOUT.getMatcher(input).matches()){
                logout=true;
            }else
                System.err.println("Invalid input!!");
        }
        login();
    }
    private void start(){
        String input;
        System.out.println("game page:");
        while (true){
            input=scan.nextLine();
            if((matcher1=InputCommands.BUY.getMatcher(input)).matches()){

            }else if((matcher1=InputCommands.PICKUP.getMatcher(input)).matches()){

            }else if(InputCommands.WELL.getMatcher(input).matches()){

            }else if((matcher1=InputCommands.PLANT.getMatcher(input)).matches()){

            }else if((matcher1=InputCommands.BUILD.getMatcher(input)).matches()){

            }else if((matcher1=InputCommands.WORK.getMatcher(input)).matches()){

            }else if((matcher1=InputCommands.CAGE.getMatcher(input)).matches()){

            }else if((matcher1=InputCommands.TURN.getMatcher(input)).matches()){

            }else if((matcher1=InputCommands.TRUCK_LOAD.getMatcher(input)).matches()){

            }else if((matcher1=InputCommands.TRUCK_UNLOAD.getMatcher(input)).matches()){

            }else if((matcher1=InputCommands.TRUCK_GO.getMatcher(input)).matches()){

            }else if(InputCommands.MENU.getMatcher(input).matches()){
                menu();
            }else
                System.err.println("Invalid input!!");
        }
    }
}
