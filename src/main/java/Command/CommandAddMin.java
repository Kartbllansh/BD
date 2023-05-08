package Command;

import File.CollectionManager;

/**
 * Команда добавляет новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
 */
public class CommandAddMin implements Command {
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager..
     */
    CollectionManager collectionManager;

    /**
     * Конструктор класса CommandAddMin
     *
     * @param collectionManager the collection manager
     */
    public CommandAddMin(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    /**Метод, запускающий работу команды
     * @see CollectionManager#addIfMin()  */
    @Override
    public void execute() {
        try {
            if (CheckUser.checkUsers()) {
                collectionManager.addIfMin();
            } else {
                System.out.println("Вы не авторизованы в программе");
            }
        } catch (Exception e) {
            System.err.println("EXception"+e.getMessage());
        }

    }
    /**Метод, возвращающий описание команды*/
    @Override
    public String getDescription() {
        return "Команда добавляет новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }

}
