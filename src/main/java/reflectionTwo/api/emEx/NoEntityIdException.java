package reflectionTwo.api.emEx;


public class NoEntityIdException extends RuntimeException {
    public NoEntityIdException(Class<?> entityClass) {
        super("Class " + entityClass.getSimpleName() + " must be annotated with @Table");
    }
}
