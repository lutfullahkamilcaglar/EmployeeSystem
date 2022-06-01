package inputManager;

import java.util.Scanner;

public interface InputManager {

    Scanner scanner = new Scanner(System.in);

    int getInt();

    double getDouble();

    int getIntWithDescription(String description);


    double getDoubleWithDescription(String description);

    String getString();

    String getStringWithDescription(String description);
}
