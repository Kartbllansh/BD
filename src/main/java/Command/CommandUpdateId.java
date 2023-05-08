package Command;

import File.CollectionManager;

/**
 * Команда обновляет значение элемента коллекции, id которого равен заданному
 */
public class CommandUpdateId implements CommandWithArguments {
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager..
     */
    CollectionManager collectionManager;
    /**
     * Поле, хранящее массив аргументов команды.
     */
    String[] arg;

    /**
     * Конструктор класса
     *
     * @param collectionManager the collection manager - хранит ссылку на объект

     */
    public CommandUpdateId(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    /**Метод, запускающий работу команды
     * @see CollectionManager#updateId(long) */
    @Override
    public void execute() {
        try {
            if(CheckUser.checkUsers()) {
                collectionManager.updateId(Long.parseLong(arg[0]));
            } else {
                System.out.println("Вы не авторизованы в программе");
            }
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат аргумента");
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Не веден id");
        }
    }
    /**Метод, возвращающий описание команды*/
    @Override
    public String getDescription() {
        return "Команда обновляет значение элемента коллекции, id которого равен заданному";
    }
    /**Метод, возвращающий аргумент для команды*/
    @Override
    public void getArguments(String[] arg) {
    this.arg = arg;
    }
}
