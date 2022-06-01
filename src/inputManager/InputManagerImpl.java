package inputManager;

public class InputManagerImpl implements InputManager {

    @Override
    public int getInt() {
        try {
            int value = scanner.nextInt();
            scanner.nextLine();
            return value;
        } catch (Exception exception) {
            System.out.println(exception.getLocalizedMessage());
            return -1;
        }
    }

    @Override
    public int getIntWithDescription(String description) {
        try {
            System.out.println(description);
            int value = scanner.nextInt();
            scanner.nextLine();
            return value;
        } catch (Exception exception) {
            System.out.println(exception.getLocalizedMessage());
            return -1;
        }
    }

    @Override
    public double getDouble() {
        try {
            return scanner.nextDouble();
        }
        catch (Exception exception){
            System.out.println(exception.getLocalizedMessage());
            return -1;
        }
    }
    @Override
    public double getDoubleWithDescription(String description){
        try {
            System.out.println(description);
            return scanner.nextDouble();
        }catch (Exception exception){
            System.out.println(exception.getLocalizedMessage());
            return -1;
        }
    }


    @Override
    public String getString() {
        return scanner.nextLine();
    }

    @Override
    public String getStringWithDescription(String description) {
        System.out.println(description);
        return scanner.nextLine();
    }
}
