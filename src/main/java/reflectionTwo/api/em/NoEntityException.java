package reflectionTwo.api.em;


public class NoEntityException extends RuntimeException {
    public NoEntityException(Class<?> entityClass) {
        super("Class "+entityClass.getSimpleName()+" must be annotated with @Table");
    }
}
