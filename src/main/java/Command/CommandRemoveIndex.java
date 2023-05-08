package Command;

import File.CollectionManager;

/**
 * удаляет элемент, находящийся в заданной позиции коллекции (index)
 */
public class CommandRemoveIndex implements CommandWithArguments{
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
    public CommandRemoveIndex(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    /**Метод, запускающий работу команды
     * @see CollectionManager#removeIndex(int)  */
    @Override
    public void execute() {
        try {
            if(CheckUser.checkUsers()) {
                collectionManager.removeIndex(Integer.parseInt(arg[0]));
            }else {
                System.out.println("Вы не авторизованы в программе");
            }
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат аргумента");
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Не веден индекс");
        }
    }
    /**Метод, возвращающий описание команды*/
    @Override
    public String getDescription() {
        return "удаляет элемент, находящийся в заданной позиции коллекции (index)";
    }
    /**Метод, возвращающий аргумент для команды*/
    @Override
    public void getArguments(String[] arg) {
    this.arg = arg;
    }
}
