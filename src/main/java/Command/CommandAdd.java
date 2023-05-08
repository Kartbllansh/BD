package Command;

import File.CollectionManager;


/**
 * Команда, добавляющая нового Dragon в коллекцию
 */
public class CommandAdd implements Command {
    private final CollectionManager collectionManager;

    /**
     * Instantiates a new Command add.
     *
     * @param collectionManager the collection manager
     */
    public CommandAdd(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
    /**Метод, запускающий работу команды
     * @see CollectionManager#add() */
    @Override
    public void execute() {
        try {
            if(CheckUser.checkUsers()) {
                collectionManager.add();
            } else {
                System.out.println("Вы не авторизованы в программе");
            }
        } catch (Exception e) {
            System.err.println("Ошибка"+e.getMessage());
        }
    }
    /**Метод, возвращающий описание команды*/
    @Override
    public String getDescription() {
        return "Команда добавляет новый элемент в коллекцию";
    }

}
