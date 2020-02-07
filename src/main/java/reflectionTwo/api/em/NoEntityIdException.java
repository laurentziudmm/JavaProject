package reflectionTwo.api.em;


public class NoEntityIdException extends RuntimeException {
    public NoEntityIdException(Class<?> entityClass) {
        super("Class " + entityClass.getSimpleName() + " must be annotated with @Table");
    }
}
