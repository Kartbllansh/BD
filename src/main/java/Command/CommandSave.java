package Command;

import File.CollectionManager;

/**
 * Команда сохраняет коллекцию в файл
 */
public class CommandSave implements CommandWithArguments {
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager..
     */
    CollectionManager collectionManager;
    /**
     * Поле, хранящее массив аргументов команды.
     */
    String[] arg;

    /**
     * Конструтор класса
     *
     * @param collectionManager the collection manager - хранит ссылку на объект
     */
    public CommandSave(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    /**Метод, запускающий работу команды
       */
    @Override
    public void execute() {

        try {
            if(CheckUser.checkUsers()) {
                collectionManager.save();
            } else { System.out.println("Вы не авторизованы в программе");}

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Не передан путь к файлу");
        }

    }
    /**Метод, возвращающий описание команды*/
    @Override
    public String getDescription() {
        return "Команда сохраняет коллекцию в файл";
    }
    /**Метод, возвращающий аргумент для команды*/
    @Override
    public void getArguments(String[] arg) {
    this.arg = arg;
    }
}
