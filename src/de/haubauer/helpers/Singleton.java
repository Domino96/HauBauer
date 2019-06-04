package src.de.haubauer.helpers;

public abstract class Singleton {
    private Singleton instance;

    public Singleton getInstance() {
        if (instance == null) {
            try {
                this.instance = this.getClass().newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e.getCause());
            }
        }

        return instance;
    }
}
