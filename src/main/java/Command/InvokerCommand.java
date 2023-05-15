package Command;

import DataBase.Users;
import File.CollectionManager;
import IO.IOUser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

/**
 * Главный класс для команд
 */
public class InvokerCommand {
    private Users users = new Users();
    /**
     * Поле, хранящее ссылку на коллекцию команд с аргументами..
     */
    private final HashMap<String, CommandWithArguments> commandWithArguments;
    /**
     * Поле, хранящее ссылку на коллекцию команд без аргументов..
     */
    private final HashMap<String, Command> commandWithoutArguments;
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager..
     */
    private final CollectionManager collectionManager;
    /**
     * Поле, хранящее ссылку на объект класса IOUser..
     */
    IOUser ioUser;
    /**
     * Поле, хранящее ссылку на объект класса Script..
     */
    CommandExecute.Script script;

    /**
     * Конструтор класса. Внутри вызываются методы addCommandWithArguments() и addCommandWithoutArguments()
     *
     * @param collectionManager the collection manager
     * @param ioUser            the io user
     */
    public InvokerCommand(CollectionManager collectionManager, IOUser ioUser){

        this.script = new CommandExecute.Script();
        this.ioUser = ioUser;
        this.collectionManager = collectionManager;
        commandWithArguments = new HashMap<>();
        commandWithoutArguments = new HashMap<>();
        this.addCommandWithArguments();
        this.addCommandWithoutArguments();
    }

    /**
     * Метод, добавляющий команды с аргументами в соответствующие им коллекции.
     */
    public void addCommandWithArguments(){
        commandWithArguments.put("update_id", new CommandUpdateId(collectionManager));
        commandWithArguments.put("remove_by_id", new CommandRemoveId(collectionManager));
        commandWithArguments.put("remove_by_type", new CommandRemoveType(collectionManager));
        commandWithArguments.put("remove_by_index", new CommandRemoveIndex(collectionManager));
        commandWithArguments.put("save", new CommandSave(collectionManager));
        commandWithArguments.put("execute_script", new CommandExecute(script, collectionManager));
        commandWithArguments.put("remove_greater", new CommandRemoveGreater(collectionManager));
    }

    /**
     * Метод, добавляющий команды без аргументов в соответствующие им коллекции..
     */
    public void addCommandWithoutArguments(){
        commandWithoutArguments.put("clear_data", new CommandDelData(collectionManager));
        commandWithoutArguments.put("authorization", new CommandAutorizate(users));
        commandWithoutArguments.put("logout", new CommandLogOut(collectionManager));
        commandWithoutArguments.put("add_if_min", new CommandAddMin(collectionManager));
        commandWithoutArguments.put("add", new CommandAdd(collectionManager));
        commandWithoutArguments.put("help", new HelpCommand(commandWithArguments, commandWithoutArguments));
        commandWithoutArguments.put("info", new InfoCommand(collectionManager));
        commandWithoutArguments.put("show", new CommandShow(collectionManager));
        commandWithoutArguments.put("clear", new CommandClear(collectionManager));
        commandWithoutArguments.put("exit", new CommandExit());
        commandWithoutArguments.put("print_age", new CommandPrintAge(collectionManager));
        commandWithoutArguments.put("print_type", new CommandPrintType(collectionManager) );
    }

    /**
     * Метод, который определяет из полученной строки команду, исполняет ее и передает ей необходимые аргументы.
     *   Если команда не распознана, то в стандартный поток вывода выводится соответствующее сообщение.
     *
     * @param commandLine the command line - первая строка команды, где хранится само ее название и переданные на этой же строке аргументы.
     */
    public void execute(String commandLine){
        String[] words = commandLine.trim().split("\\s+");
        String[] args = Arrays.copyOfRange(words, 1, words.length); // массив аргументов
        if (commandWithArguments.containsKey(words[0].toLowerCase(Locale.ROOT))){ //Locale.ROOT` указывает на использование стандартной локали, что означает, что преобразование будет выполнено в соответствии с правилами языка, используемого в системе
            CommandWithArguments command;
            command = commandWithArguments.get(words[0].toLowerCase(Locale.ROOT));
            command.getArguments(args);
            command.execute();
        } else if(commandWithoutArguments.containsKey(words[0].toLowerCase(Locale.ROOT))){
            Command command;
            command = commandWithoutArguments.get(words[0].toLowerCase(Locale.ROOT));
            command.execute();
        } else{
            System.err.println("Команда "+words[0]+" не найдена, для получения справки введите команду <help>");
        }
    }
}
