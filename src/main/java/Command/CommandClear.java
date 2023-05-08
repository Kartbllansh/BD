package Command;

import File.CollectionManager;

/**
 * Команда  очищает коллекцию
 */
public class CommandClear implements Command  {
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager..
     */
    private final CollectionManager collectionManager;

    /**
     * Конструктор класса
     *
     * @param collectionManager the collection manager - хранит ссылку на объект класса CollectionManager
     */
    public CommandClear(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    /**Метод, запускающий работу команды
     * @see CollectionManager#clear()  */
    @Override
    public void execute() {
        try {
            if (CheckUser.checkUsers()) {
                collectionManager.clear();
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
        return "Команда  очищает коллекцию";
    }
}
