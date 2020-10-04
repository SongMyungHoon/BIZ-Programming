package test;

public interface Template<T, S, U> {
	public S func(U u, T t);
}
