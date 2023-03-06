package com.apaliakou.homework0801;

import com.apaliakou.homework0801.exceptions.FullArrayException;
import com.apaliakou.homework0801.exceptions.GetNullCellException;
import com.apaliakou.homework0801.exceptions.IncorrectArgumentException;
import com.apaliakou.homework0801.exceptions.SetToNullCellException;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<E> implements MyList<E> {

    public static final int INITIAL_CAPACITY = 10;
    private Object[] listArray = new Object[INITIAL_CAPACITY];

    @Override
    public String toString() {
        return "MyArrayList{listArray=" + Arrays.stream(listArray).filter(Objects::nonNull).toList() + "}";
    }

    @Override
    public void add(E element) {
        if (checkIfListFull()) {
            increaseArray();
        }
        listArray[size()] = element;
    }

    @Override
    public void add(int index, E newElement) {
        if (size() + 1 > listArray.length) {
            increaseArray();
        }
        if (index <= size()) {
            for (int i = size(); i >= index; i--) {
                listArray[i] = listArray[i - 1];
            }
            listArray[index] = newElement;
        } else {
            String NULL_CELL_EXCEPTION = "It is prohibited to add the value to the null cell!!! Try again!!!";
            throw new SetToNullCellException(NULL_CELL_EXCEPTION);
        }
    }

    @Override
    public E set(int index, E newElement) {
        if (index > size()) {
            String SET_TO_NULL_CELL_EXCEPTION = "It is prohibited to set the value to the null cell!!! Try again!!!";
            throw new SetToNullCellException(SET_TO_NULL_CELL_EXCEPTION);
        }
        listArray[index] = newElement;
        return newElement;
    }

    @Override
    public int indexOf(Object element) {
        int elementIndex = -1;
        for (int i = 0; i < size(); i++) {
            if (element.equals(listArray[i])) {
                elementIndex = i;
            }
        }
        return elementIndex;
    }

    @Override
    public E get(int index) {
        if (index >= size()) {
            String GET_NULL_CELL_EXCEPTION = "It is forbidden to get a null cell!!! Try again!!!";
            throw new GetNullCellException(GET_NULL_CELL_EXCEPTION);
        }
        return (E) listArray[index];
    }

    @Override
    public void addWithoutArrayExtension(E element) {
        if (checkIfListFull()) {
            String FULL_ARRAY_EXCEPTION = "Warning!!!All cells are filled in!!!";
            throw new FullArrayException(FULL_ARRAY_EXCEPTION);
        } else {
            listArray[size() + 1] = element;
        }
    }

    @Override
    public MyList<Object> subList(Integer fromIndex, Integer toIndex) {
        if (fromIndex == null || toIndex == null) {
            String GET_NULL_CELL_EXCEPTION = "It is forbidden to check a null cell!!! Try again!!!";
            throw new GetNullCellException(GET_NULL_CELL_EXCEPTION);
        }
        checkIndexValue(fromIndex, toIndex);

        if (fromIndex.equals(toIndex)) {
            return new MyArrayList<>();
        }
        MyList<Object> subList = new MyArrayList<>();
        for (int i = fromIndex; i <= toIndex; i++) {
            subList.add(listArray[i]);
        }
        return subList;
    }

    private void checkIndexValue(Integer fromIndex, Integer toIndex) {
        if (fromIndex > size() || toIndex > size()) {
            String INCORRECT_ARGUMENT_EXCEPTION = "An index value exceeds the list size!!! Try again!!!";
            throw new IncorrectArgumentException(INCORRECT_ARGUMENT_EXCEPTION);
        }
        if (fromIndex > toIndex) {
            String INCORRECT_ARGUMENT_EXCEPTION = "First index must be less than second one!!! Try again!!!";
            throw new IncorrectArgumentException(INCORRECT_ARGUMENT_EXCEPTION);
        }
    }

    @Override
    public int size() {
        for (int i = 0; i < listArray.length; i++) {
            if (listArray[i] == null) {
                return i;
            }
        }
        return listArray.length;
    }

    private boolean checkIfListFull() {
        return this.size() == listArray.length;
    }

    private void increaseArray() {
        listArray = Arrays.copyOf(listArray, (int) (listArray.length * 1.5 + 1));
    }
}
