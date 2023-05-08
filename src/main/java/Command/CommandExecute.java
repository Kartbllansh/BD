package Command;

import File.CollectionManager;
import IO.IOUser;
import MyException.ExecuteInExecuteException;
import MyException.NotRecoursiveException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Команда считает и исполняет скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
 */
public class CommandExecute implements CommandWithArguments {
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager..
     */
    CollectionManager collectionManager;
    /**
     * Поле, хранящее массив аргументов команды.
     */
    String[] arg;
    /**
     * Поле, хранящее путь к файлу скрипта
     */
        private String scriptFile;
    /**
     * Поле, хранящее ссылку на объект класса Script.
     */

    private final Script script;

    /**
     * Конструктор, содержащий ссылки на объекты
     *
     * @param script            the script - ссылка на объект
     * @param collectionManager the collection manager - ссылка на объект
     */
    public CommandExecute(Script script, CollectionManager collectionManager){
            this.script = script;
            this.collectionManager = collectionManager;

        }
    /**Метод, запускающий работу команды
     * @see Script#putScript(String)
      */
    @Override
    public void execute() {
        try {
            if(CheckUser.checkUsers()) {
                if (arg.length == 1) {
                    scriptFile = arg[0];
                    if (script.scriptPaths.contains(scriptFile)) throw new NotRecoursiveException();
                    else script.putScript(scriptFile);
                } else throw new IllegalArgumentException();
                File file = new File(scriptFile);
                if (!file.canWrite() || !file.isFile()) throw new IOException();
                FileInputStream fileInputStream = new FileInputStream(scriptFile);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                Scanner scanner = new Scanner(inputStreamReader);
                IOUser ioUser = new IOUser(scanner);
                InvokerCommand commandInvoker = new InvokerCommand(collectionManager, ioUser);
                while (scanner.hasNext()) {
                    String check = scanner.nextLine();
                    String[] words = check.trim().split("\\s+");
                    if (words[0].equals("execute_script")) throw new ExecuteInExecuteException();

                    commandInvoker.execute(check);

                }
            } else {
                System.out.println("Вы не авторизованы в программе");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Файл скрипта не найден");
        } catch (NullPointerException ex) {
            System.err.println("Не выбран файл, из которого читать скрипт");
        } catch(IOException ex){
            System.err.println("Доступ к файлу невозможен");
        }  catch (IllegalArgumentException ex) {
            System.err.println("скрипт не передан в качестве аргумента команды, либо кол-во аргрументов больше 1");
        }  catch (NotRecoursiveException ex) {
            System.err.println("Скрипт " + scriptFile + " уже существует (Рекурсивный вызов)");
        } catch (ExecuteInExecuteException ex){
            System.err.println("В скрипте команда execute, выполнение невозможно");
        }
        script.removeScript(scriptFile);
    }
    /**Метод, возвращающий описание команды*/
    @Override
    public String getDescription() {
        return "Команда считает и исполняет скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
    /**Метод, возвращающий аргументы для команды*/
    @Override
    public void getArguments(String[] arg) {
    this.arg =  arg;
    }

    /**
     * Вспомогательный класс защищающий от рекурсии
     */
    static class Script {

        private final ArrayList<String> scriptPaths = new ArrayList<>(); //final?

        /**
         * Добавляет строчку в коллекцию
         *
         * @param scriptPath the script path
         */
        public void putScript(String scriptPath) {
            scriptPaths.add(scriptPath);
        }

        /**
         * Удаляет объект из коллекции
         *
         * @param scriptPath the script path
         */
        public void removeScript(String scriptPath) {
            scriptPaths.remove(scriptPath);
        }
    }
}
