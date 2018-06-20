package model;


public interface ISPecification<T> {
    boolean isSatisfiedBy(T entity);
}
