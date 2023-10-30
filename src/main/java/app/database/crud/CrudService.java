package app.database.crud;

public interface CrudService <T> {

    public void save(T entity);

    public T findById(Object id);

    public void update(T entity);

    public void delete(T entity);
}
