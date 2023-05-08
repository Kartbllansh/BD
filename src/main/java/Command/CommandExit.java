package Command;

/**
 * Команда завершает работу программы
 */
public class CommandExit implements Command {
    /**
     * Пустой конструктор.
     */
    public CommandExit(){

    }
    /**Метод, запускающий работу команды*/
    @Override
    public void execute(){
        System.out.println("Программа устала и ушла спать");
        System.exit(0); // 0 - указывает, что программа заканчивается правильно
    }
    /**Метод, возвращающий описание команды*/
    @Override
    public String getDescription(){
        return "Команда завершает работу программы";
    }
}
