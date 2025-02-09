import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    public static void main(String[] args) {
        ArrayList<String> todos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=== TODOアプリ ===");
            System.out.println("1: タスクを追加");
            System.out.println("2: タスク一覧表示");
            System.out.println("3: タスク削除");
            System.out.println("4: 終了");
            System.out.print("選択してください: ");

            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.print("追加するタスクを入力: ");
                    String task = scanner.nextLine();
                    todos.add(task);
                    System.out.println("タスクが追加されました。");
                    break;
                case "2":
                    System.out.println("=== タスク一覧 ===");
                    if (todos.isEmpty()) {
                        System.out.println("タスクはありません。");
                    } else {
                        for (int i = 0; i < todos.size(); i++) {
                            System.out.println((i + 1) + ": " + todos.get(i));
                        }
                    }
                    break;
                case "3":
                    if (todos.isEmpty()) {
                        System.out.println("削除するタスクがありません。");
                    } else {
                        System.out.println("=== タスク一覧 ===");
                        for (int i = 0; i < todos.size(); i++) {
                            System.out.println((i + 1) + ": " + todos.get(i));
                        }
                        System.out.print("削除するタスクの番号を入力してください: ");
                        try {
                            int index = Integer.parseInt(scanner.nextLine());
                            if (index > 0 && index <= todos.size()) {
                                todos.remove(index - 1);
                                System.out.println("タスクが削除されました。");
                            } else {
                                System.out.println("無効な番号です。");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("数値を入力してください。");
                        }
                    }
                    break;
                case "4":
                    running = false;
                    System.out.println("アプリを終了します。");
                    break;
                default:
                    System.out.println("無効な選択です。もう一度入力してください。");
                    break;
            }
            System.out.println();
        }
        scanner.close();
    }
}
