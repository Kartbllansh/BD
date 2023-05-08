package Command;

/**
 * Interface
 */
public interface Command {
    /**
     * Метод, execute. Его переопределяет каждый метод
     */
    void execute();

    /**
     * Возвращает описание команды
     *
     * @return the string
     */
    default String getDescription(){ //метод по умолчанию
        return "Описания у этой команды нет";
    }


}
