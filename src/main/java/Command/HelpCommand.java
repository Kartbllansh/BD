package Command;


import java.util.HashMap;
import java.util.Map;

/**
 * Команда выводит  справку по доступным командам
 */
public class HelpCommand implements Command{
    /**
     * Поле, хранящее ссылку на коллекцию команд с аргументами..
     */
    private final HashMap<String, CommandWithArguments> commandWithArguments;
    /**
     * Поле, хранящее ссылку на коллекцию команд без аргументов..
     */
    private final HashMap<String, Command> commandWithoutArguments;

    /**
     * Конструктор класса
     *
     * @param commandWithArguments    the command with arguments - хранит ссылку на коллекцию
     * @param commandWithoutArguments the command without arguments - хранит ссылку на коллекцию
     */
    public HelpCommand(HashMap<String,CommandWithArguments> commandWithArguments, HashMap<String, Command> commandWithoutArguments) {
        this.commandWithArguments = commandWithArguments;
        this.commandWithoutArguments = commandWithoutArguments;
    }
    /**Метод, запускающий работу команды
     */
    @Override
    public void execute() {
        if(!CheckUser.checkUsers()){
            System.err.println("Так как вы не авторизовались вам недоступны команды, которые удаляют или добавляют объекты");
        }
        for (Map.Entry<String, Command> entry : commandWithoutArguments.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getDescription());
        }
        for (Map.Entry<String, CommandWithArguments> entry : commandWithArguments.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getDescription());
        }
        }
    /**Метод, возвращающий описание команды*/
    @Override
    public String getDescription(){
        return "Команда выводит  справку по доступным командам";
    }
}
