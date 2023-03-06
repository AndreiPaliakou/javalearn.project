package com.apaliakou.homework0801;

public interface MyList<E> {

    void add(E element);

    void add(int index, E newElement);

    E set(int index, E newElement);

    E get(int index);

    int indexOf(Object element);

    void addWithoutArrayExtension(E element);

    MyList<Object> subList(Integer fromIndex, Integer toIndex);

    int size();
}
