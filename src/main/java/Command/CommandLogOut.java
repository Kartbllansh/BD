package Command;

import File.CollectionManager;

public class CommandLogOut implements Command{
    private final CollectionManager collectionManager;

    public CommandLogOut(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        if(CheckUser.checkUsers()) {
            collectionManager.logOut();
        }else {
            System.out.println("Вы не авторизованы в программе");
        }
    }

    @Override
    public String getDescription() {
        return "Команда позволяет выйти из аккаунта";
    }
}
